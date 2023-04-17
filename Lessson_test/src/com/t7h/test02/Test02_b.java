package com.t7h.test02;
import java.util.Scanner;
public class Test02_b
{
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int number = scanner.nextInt();
        if(number%4==0&&number%100!=0) {
            System.out.println("闰年");
        }
        else if (number%400==0) {
            System.out.println("闰年");
        }
        else{
            System.out.println("NO");
        }
    }
}
