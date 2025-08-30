package com.hr.hackerrankproblems.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Fixed {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int comp = target - nums[i];
            if (map.containsKey(comp)) {
                return new int[]{map.get(comp), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public int removeDuplicates(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//        for (int num : nums) {
//           set.add(num);
//       }
//        
//        return set.size();
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public int[] plusOne(int[] digits) {
//        StringBuilder sb = new StringBuilder();
//        for (int digit : digits) {
//            sb.append(digit);
//        }
//        int res = Integer.parseInt(sb.toString()) + 1;
//        String str = String.valueOf(res);
//
//        int[] r = new int[str.length()];
//        for (int i = 0; i < str.length(); i++) {
//            r[i] = str.charAt(i) - '0';
//        }
//        return r;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
    
    //merge sorted array
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m -1 ;//2,1,0              //{1,2,3,0,0,0}
        int j = n -1 ;//2,1,0,              //{2,4,5}
        int k = m + n -1;//5,4,3,2,1,0
        while (i >= 0 && j >= 0){
            if(nums1[i] > nums2[j]){
                System.out.println("111" + Arrays.toString(nums1));
                nums1[k--] = nums1[i--];
                System.out.println(Arrays.toString(nums1));
            }else{
                nums1[k--] = nums2[j--];
                System.out.println(Arrays.toString(nums1));
            }
            
        }
        while(j >= 0){
            nums1[k--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        Fixed x = new Fixed();
//        int[] nums  = {2,7,11,15};
//        System.out.println(Arrays.toString(x.twoSum(nums, 9)));
//        String[] strs = {"flower", "flow", "flight"};
//        System.out.println(x.longestCommonPrefix(strs));
          int[] nums1 = {1,2,3,0,0,0};
          int[] nums2 = {2,5,6}; 
          
          System.out.println();
          int m = 3,n = 3;
          x.merge(nums1, m, nums2, n);
    }
}
