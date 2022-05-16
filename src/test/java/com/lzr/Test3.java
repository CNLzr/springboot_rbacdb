package com.lzr;

import java.util.Arrays;

public class Test3 {
    public static void main(String[] args) {
        String str = "1234";
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length/2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length-i-1];
            chars[chars.length-i-1] = temp;
        }
        System.out.println(Arrays.toString(chars));
    }
}
