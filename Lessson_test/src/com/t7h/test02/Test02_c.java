package com.t7h.test02;
import java.util.Random;
import java.util.Scanner;
public class Test02_c
{
    public static void main(String[] args)
    {
        System.out.println("please");
        System.out.println("1.剪刀");
        System.out.println("2.石头");
        System.out.println("3.布");
        Scanner scanner=new Scanner(System.in);
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
        }
    }
}
