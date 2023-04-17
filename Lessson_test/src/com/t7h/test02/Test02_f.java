package com.t7h.test02;

import java.util.Random;
import java.util.Scanner;

public class Test02_f {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        Random aout = new Random();
        int out =aout.nextInt(100)+1;
        System.out.println("Please:");
        while(true)
        {
            int check=scanner.nextInt();
            if(check<out)
            {
                System.out.println("太小了");
            }
            if(check>out)
            {
                System.out.println("太大了");
            }
            if(check==out)
            {
                System.out.println("猜对了");
                break;
             }
        }


    }
}
