package com.t7h.test02;

public class Test02_e {
    public static void main(String[] args)
    {
        int[] arr = new int []{0,1,2,3,4,5,6,7,8,9,10};
        for(int i=5;i<10;i++)
        {
            arr[i]++;
        }
        System.out.print("{");
        for(int i=0;i<10;i++)
        {
            System.out.print(" "+arr[i]);
        }
        System.out.print("}");
    }
}
