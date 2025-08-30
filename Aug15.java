package com.hr.hackerrankproblems.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Aug15 {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    public static void backTrack(int[] candidates, int target, int start, List<Integer> current,
            List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            backTrack(candidates, target - candidates[i], i, current, result);
            current.remove(current.size() - 1);
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generatePermutation(nums,0, result);
        return result;
    }
    private void generatePermutation(int[] nums, int index, List<List<Integer>> result) {
        if(index == nums.length){
            List<Integer> list = new ArrayList<>();
            for (int integer : nums) {
                list.add(integer);
            }
            result.add(list);
            return;
        }
        
        for (int i = index; i < nums.length; i++) {
            swap(nums,index, i);
            generatePermutation(nums, i + 1, result);
            swap(nums, index, i);
            
        }
        
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                List<Integer> sub = new ArrayList<>();
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sub.add(nums[k]);
                    
                }
                for (Integer integer : sub) {
                     sum += integer;
                }
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }
    public int maxSubArr(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int num : nums) {
            currentSum =Math.max(num, currentSum+num);
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }
    public String largestNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str, (a,b) -> (b+a).compareTo(a+b));
        if(str[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (String string : str) {
            sb.append(string);
        }
        return sb.toString();
    }
    public static void plusMinus(List<Integer> arr) {
        double positive = 0;
        double negative = 0;
        double zero = 0;
        int n = arr.size();
        for (Integer integer : arr) {
            if(integer > 0) positive++;
            else if(integer < 0) negative++;
            else zero++;
        }
        System.out.println(positive / n);
        System.out.println(negative / n);
        System.out.println(zero /n);

    }
     public static void miniMaxSum(List<Integer> arr) {
        Integer minSum = 0;
        Integer maxSum = 0;
        arr.sort(null);
        List<Integer> min = arr.subList(0, 4);
         System.out.println(min);
        for (Integer integer : min) {
            minSum += integer;
        }
        List<Integer> max = arr.subList(1, 5);
         System.out.println(max);
        for (Integer integer : max) {
            maxSum += integer;
        }
        System.out.println(minSum +" "+ maxSum);

    }
     
     public int minimumTotal(List<List<Integer>> triangle) {
         if(triangle == null || triangle.isEmpty()) return 0;
         int l = triangle.size();
         int[] mt = new int[l];
         for (int i = 0; i < l; i++) {
             mt[i] = triangle.get(l -1).get(i);
         }
         for (int i = l - 2; i >= 0; i--) {
             for (int j = 0; j <= i; j++) {
                 mt[j] = triangle.get(i).get(j) + Math.min(mt[j], mt[j+1]);
             }
         }
         return mt[0];
         
    }
     
     public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        List<Integer> list = new ArrayList<>();
         for (int i = 0; i < queries.size(); i++) {
             int sum = 0;
             if(strings.contains(queries.get(i))) sum ++;
             list.add(sum);
         }
        
        return list;
    }
    
    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        int target = 7;
        
//        combinationSum(nums, target);
        Aug15 a = new Aug15();
//        System.out.println(a.maxSubArr(nums));
//        System.out.println(a.largestNumber(nums));
//        List<Integer> arr = new ArrayList<>(Arrays.asList(-4,3,0,9,1,4));
//        a.miniMaxSum(arr);
        List<String> strings= new ArrayList<>(Arrays.asList("ab","abc","ab"));
        List<String> queries= new ArrayList<>(Arrays.asList("ab","bc","abc"));
        System.out.println(a.matchingStrings(strings, queries));
    }

    
}
