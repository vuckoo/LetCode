package com.vucko.other;

import sun.nio.cs.ext.IBM037;

public class CalcTest {


    public static void main(String[] args) {

        //System.out.println(1/0);  //java.lang.ArithmeticException: / by zero
        //System.out.println(1/0.0);  //Infinity

//        System.out.println((0+15)/2);   //7
//        System.out.println(2.0e-6 * 100000000.1);
//
//        System.out.println(true && false || true && true);
//
//        System.out.println((1+2.236)/2);
//
//        System.out.println(1+2+3+4.0);
//
//        System.out.println(4.1>=4);
//
//        System.out.println(1+2+"3");


        //System.out.println((1+999)*999/2);

        //test2();

//        System.out.println('b');
//        System.out.println('b'+'c');
//        System.out.println((char)('a'+4));

//        System.out.println(9/2);
//        System.out.println(9%2);

//        System.out.println(test3(123));
//        System.out.println(Integer.toBinaryString(123));

        String s = "458";
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            n = 10*n+ (c - '0');
        }

        System.out.println(Integer.parseInt(s));
        System.out.println(n);

   }

    private static String test3(int n) {
        String s = "";
        for(int i=n; i>0;i = i/2){
            s = i%2 + s;
        }
        return s;
    }

    private static void test2() {

        int sum = 0;
        for (int i = 1; i < 1000; i++) {
            for(int j = 0; j < i; j++){
                sum++;
            }

        }

        System.out.println(sum);
    }


}
