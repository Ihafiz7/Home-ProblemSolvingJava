
package com.hr.hackerrankproblems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class SubArrayCountWithSlidingWindow {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.trim().split("\\s+");
        
        int l = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        
        int[] array = new int[l];
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }
        Map <Integer,Integer> feqMap = new HashMap<>();
        int maxNum = Integer.MIN_VALUE;
        
        for (int i = 0; i < array.length; i++) {
            feqMap.put(array[i], feqMap.getOrDefault(array[i], 0)+1);
            
            if(i >= k){
                int outElm = array[i - k];
                feqMap.put(outElm, feqMap.get(outElm) -1);
                if(feqMap.get(outElm) == 0){
                    feqMap.remove(outElm);
                }
            }
            if(i >= k-1){
                maxNum = Math.max(maxNum, feqMap.size());
            }
        }
        System.out.println(maxNum);
    }
    }

