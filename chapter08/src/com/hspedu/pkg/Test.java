package com.hspedu.pkg;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = {-1 , 3 ,35, 9,40};
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"\t");
        }
    }
}
