package com.hspedu.debug_;

import java.util.Arrays;

public class Debug03 {
    public static void main(String[] args) {
        int [] arr = {-1, 2 , -10 , 20, 10 };
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println("======1======");
        System.out.println("======2======");
        System.out.println("======3======");
        System.out.println("======4======");
        System.out.println("======5======");
    }
}
