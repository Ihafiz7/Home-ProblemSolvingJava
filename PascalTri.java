package com.hr.hackerrankproblems.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PascalTri {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if (numRows == 0) {
            return list;
        }

        list.add(new ArrayList<>());
        list.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            List<Integer> prow = list.get(i - 1);
            List<Integer> row = new ArrayList<>();

            row.add(1);

            for (int j = 1; j < i; j++) {
                row.add(prow.get(j - 1) + prow.get(j));
            }
            row.add(1);
            list.add(row);
        }
        return list;

    }

//    public int maxProfit(int[] prices) {
//        int[] cln = prices.clone();
//        Arrays.sort(cln);
//        int buy = cln[0];
//        int sell = Integer.MIN_VALUE;
//        int n = 0 ;
//        for(int i = 0; i < prices.length;i++){
//            if(prices[i] == buy){
//                n = i; 
//            }
//        }
//        for(int i = n ; i< prices.length;i++){
//            if(prices[i] > sell){
//                sell = prices[i];
//            }
//        }
//        int out = sell - buy;
//        return out;
//    }
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                res = entry.getKey();
            }
        }
        return res;
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int start = nums[0];
        int end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == end + 1) {
                end = nums[i];
            } else {
                if (start == end) {
                    list.add(String.valueOf(start));
                } else {
                    list.add(start + "->" + end);
                }
                start = nums[i];
                end = nums[i];
            }

        }
        if (start == end) {
            list.add(String.valueOf(start));
        } else {
            list.add(start + "->" + end);
        }
        return list;
    }
}
