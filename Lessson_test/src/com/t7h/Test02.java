package com.t7h;

import java.util.Random;
import java.util.Scanner;

public class Test02 {
    public static void main(String[] args)
    {
//        System.out.print("please:");
        Scanner scanner=new Scanner(System.in);
//        int n = scanner.nextInt();
//        System.out.println(n+1);

        //(1)由现象可得byte范围为-128-127
/*        byte CHECK=0;
        for (int i = 0; ; i++) {
            System.out.println(CHECK++);
        }*/

       //(2)判断闰年
/*       int number = scanner.nextInt();
       if(number%4==0&&number%100!=0) {
           System.out.println("闰年");
       }
       else if (number%400==0) {
           System.out.println("闰年");
       }
       else{
           System.out.println("NO");
       }*/

       //(3)
        /*System.out.println("please");
        System.out.println("1.剪刀");
        System.out.println("2.石头");
        System.out.println("3.布");
        int check=scanner.nextInt();
        Random aout = new Random();
        int out =aout.nextInt(2)+1;
        if(check == out) {
            System.out.println("No Win && No Lost");
        }
        else if(check>out&&check-out==1){
            System.out.println("Win "+out);
        } else if (check==1&&out==3) {
            System.out.println("Win.");
        }
        else {
            System.out.println("Lost.");
        }*/

        //(4)


    }
}
