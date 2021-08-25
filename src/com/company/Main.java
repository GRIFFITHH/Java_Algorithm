package com.company;

import Chapter1.AllCodons;
import Chapter1.FindGeneSimpleAndTest;
import Chapter1.FindGeneWhile;

public class Main {

    public static void main(String[] args) {
	// write your code here


        String dna = "TCGATCGAATGCTAGCATGCATGTACTTTAATCGATGCTAGCTAGCTAGCTAGCTAG";
        String str = new AllCodons().findGene(dna);
        System.out.println(str);
    }
}
