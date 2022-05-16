package com.lzr;

import java.util.ArrayList;
import java.util.List;

public class Test4 {
    public static void main(String[] args) {
        String string = "12345";
        List<Character> list = new ArrayList<>();
        char[] chars = string.toCharArray();
        for (int i = 2; i < chars.length; i++) {
            list.add(chars[i]);
        }
        for (int i = 0; i < chars.length-(chars.length-2); i++) {
            list.add(chars[i]);
        }
        System.out.println(list);
    }
}
