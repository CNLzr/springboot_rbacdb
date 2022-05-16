package com.lzr;

import java.util.Stack;

public class Test2 {
    private static boolean fun1(String string){
        boolean flag = false;
        Stack<Character> stack = new Stack<>();
        char[] chars = string.toCharArray();
        Character pop = null;
        for (char aChar : chars) {
            switch (aChar){
                case '(':
                    stack.push(aChar);
                    break;
                case '{':
                    stack.push(aChar);
                    break;
            }
        }
        for (char aChar : chars) {
            if(stack.isEmpty()){
                return false;
            }
            switch (aChar){
                case ')':
                    pop = stack.pop();
                    if(pop != aChar){
                        return false;
                    }
                    break;
                case '}':
                    pop = stack.pop();
                    if(pop != aChar){
                        return false;
                    }
                    break;
            }

        }
        if(stack.isEmpty()){
            flag = true;
        }
        return flag;
    }

    public static void main(String[] args) {
        boolean flag = fun1("(())");
        System.out.println(flag);
    }
}
