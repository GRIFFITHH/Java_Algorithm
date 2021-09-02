package com.company;

import JavaProgrammingChapter1.*;
import JavaProgrammingChapter2.CaeserCipher;

public class Main {

    public static void main(String[] args) {


        CaeserCipher caeserCipher = new CaeserCipher();
        String result = caeserCipher.encrypted("Hello ! my name is MOON KWANG HOON! ^^*", 8);
        String result2 = caeserCipher.encrypted(result, 21);

        System.out.println(result);

        System.out.println(result2);

    }
}
