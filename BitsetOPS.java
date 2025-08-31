package com.hr.hackerrankproblems;

import java.util.BitSet;
import java.util.Scanner;

public class BitsetOPS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();     // Length of bitsets
        int ops = sc.nextInt();   // Number of operations
        sc.nextLine();

        BitSet B1 = new BitSet(l);
        BitSet B2 = new BitSet(l);

        for (int i = 0; i < ops; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");
            String operation = input[0];
            int setNumber = Integer.parseInt(input[1]);
            int index = Integer.parseInt(input[2]);

            BitSet target = (setNumber == 1) ? B1 : B2;
            BitSet other = (setNumber == 1) ? B2 : B1;

            switch (operation) {
                case "AND" -> target.and(other);
                case "OR" -> target.or(other);
                case "XOR" -> target.xor(other);
                case "SET" -> target.set(index);
                case "FLIP" -> target.flip(index);
            }

            System.out.println(B1.cardinality() + " " + B2.cardinality());
        }
    }
}

//5 4
//AND 1 2
//SET 1 4
//FLIP 2 2
//OR 2 1
