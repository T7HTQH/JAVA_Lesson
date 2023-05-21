package com.t7h.Test06;


import java.io.*;


public class Test06 {
    public static class FileIO {
        // (1)使用字节流和字符流实现文件的copy
        public void byteStreamCopy() throws IOException {
            FileInputStream fis = new FileInputStream("D:\\Java\\JAVA_Lesson\\Lessson_test\\copyFile.java");
            FileOutputStream fos = new FileOutputStream("temp.txt");
            int b;
            while ((b = fis.read()) != -1) {
                fos.write(b);
            }
            fis.close();
            fos.close();
        }

        public void bufferedByteStreamCopy() throws IOException {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\Java\\JAVA_Lesson\\Lessson_test\\copyFile.java"));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("temp.txt"));
            int b;
            while ((b = bis.read()) != -1) {
                bos.write(b);
            }
            bis.close();
            bos.close();
        }

        public void charStreamCopy() throws IOException {
            FileReader fr = new FileReader("D:\\Java\\JAVA_Lesson\\Lessson_test\\copyFile.java");
            FileWriter fw = new FileWriter("temp.txt");
            int c;
            while ((c = fr.read()) != -1) {
                fw.write(c);
            }
            fr.close();
            fw.close();
        }

        public void bufferedCharStreamCopy() throws IOException {
            BufferedReader br = new BufferedReader(new FileReader("D:\\Java\\JAVA_Lesson\\Lessson_test\\copyFile.java"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("temp.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
            br.close();
            bw.close();
        }

        // (2) 列出当前目录下的文件
        public void listFiles() {
            File file = new File(".");
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (f.isFile()) {
                        System.out.println(f.getName());
                    }
                }
            }
        }

        // (3)批量修改文件名
        public void renameFiles() {
            File fileDir = new File(".");
            File[] files = fileDir.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (f.getName().matches("[A-Za-z0-9]+-[0-9]{1,10}-[A-Z].*")) {
                        String newName = f.getName().split("-")[1] + "." + f.getName().split("\\.")[1];
                        File newFile = new File(f.getParent(), newName);
                        f.renameTo(newFile);
                    }
                }
            }
        }

    }
    public static class Test {
        public static void main(String[] args) throws IOException {
            FileIO fileIO = new FileIO();
            try {
               fileIO.byteStreamCopy();           //调用byteStreamCopy方法
                fileIO.bufferedByteStreamCopy();   //调用bufferedByteStreamCopy方法
            } catch (IOException e) {
                e.printStackTrace();
            }
            fileIO.charStreamCopy();              //调用charStreamCopy方法
            fileIO.bufferedCharStreamCopy();      //调用bufferedCharStreamCopy方法

            fileIO.listFiles();                   //调用listFiles方法
            fileIO.renameFiles();                 //调用renameFiles方法

        }
    }
}
