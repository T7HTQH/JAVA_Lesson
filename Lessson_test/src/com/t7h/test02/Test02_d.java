package com.t7h.test02;

public class Test02_d {
    public static void main(String[] args)
    {
        int n1=1,n2=1;
        while(n1!=10)
        {
            while(n2!=10)
            {
                System.out.print(""+n1+"*"+n2+"="+(n1*n2)+" ");
                n2++;
            }
            System.out.print("\n");
            n1++;
            n2=n1;
        }
    }
}

