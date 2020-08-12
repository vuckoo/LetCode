package com.vucko.lt224;

import java.util.Stack;


/**
 * +2+4-2
 *
 * +2+22*30
 *
 * +2+(3*2-1)
 */

public class SimpleCalculator {


    private static int calc(String str) {

        Stack<Integer> stack = new Stack<>();

        int num = 0;
        char sign = '+';
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(isdigital(c)){
                num = num * 10 + (c - '0');
            }
            if(!isdigital(c) || i == str.length()-1){
                switch (sign){
                    case '+': stack.push(num); break;
                    case '-': stack.push(-num);break;
                    case '*':
                        int pre = stack.pop();
                        int t = num * pre;
                        stack.push(t);
                        break;
                    case '/':
                        pre = stack.pop();
                        t = pre / num;
                        stack.push(t);
                        break;
                }
                sign = c;
                num = 0;
            }
        }

        int result = 0;
        while (!stack.isEmpty()){
            result += stack.pop();
        }

        return result;
    }

    private static boolean isdigital(char c) {
        if(c >= '0' && c <= '9'){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {

        //System.out.println(calc("21+37-18"));
        //System.out.println(calc("21+10*18"));
        System.out.println(calc("21+10/2-9*1"));
    }


}
