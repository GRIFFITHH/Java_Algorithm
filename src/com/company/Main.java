package com.company;

import JavaProgrammingChapter1.*;
import JavaProgrammingChapter2.CaeserCipher;

public class Main {

    public static void main(String[] args) {


        CaeserCipher caeserCipher = new CaeserCipher();
        String result = caeserCipher.encrypted("Dear Owen,\n" +
                "  No matter what you may have heard, there is no cake\n" +
                "in the conference room.  The cake is a lie.  Please keep\n" +
                "working on Coursera videos.\n" +
                "   \n" +
                "Thanks,\n" +
                "Drew", 17);

        System.out.println(result);

        char ch = 'A';

        System.out.println(Character.toLowerCase(ch));

    }
}
