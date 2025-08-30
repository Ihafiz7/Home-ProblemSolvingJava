package com.hr.hackerrankproblems.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Aug10 {

    public void moveZeroes(int[] nums) {
//        int end = nums.length;
//        for (int i = 0; i < end - 1; i++) {
//            for (int j = i; j < end; j++) {
//               if(nums[i] == 0 && nums[j] != 0){
//                   int temp = nums[i];
//                   nums[i] = nums[j];
//                   nums[j] = temp;
//               } 
//            }   
//        }
        int n = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[n++] = num;
            }
        }
        while (n < nums.length) {
            nums[n++] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }
    public int thirdMax(int[] nums) {
       Integer max1 = null,max2 =null,max3=null;
        for (Integer num : nums) {
            if(max1.equals(max2) || max2.equals(max3) || max3.equals(max1)) continue;
            if(max1 == null || num > max1){
                max3 = max2;
                max2 =max1;
                max1 = num;
            }if(max2 == null || num > max2){
                max3 = max2;
                max2 = num;
            }if(max3 == null || num > max3){
                max3 = num;
            }
        }
        return (max3 == null) ? max1 : max3;
    }
    
    public List<Integer> findDisappearedNumbers(int[] nums) {
       List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i])) list.add(nums[i] +1);
        }
        return list;
    }
    
//    public int maxArea(int[] height) {
//        int maxArea = 0;
//        int area = 0;
//        int l = 0;
//        int maxheight = 0;
//        for(int i = 0; i < height.length;i++){
//            if(height[i] > maxheight) {
//                maxheight = height[i];
//                l = i;
//            }
//            if(l > i){
//               area = Math.min(maxheight,height[i]) * (l -i);
//            }else{
//                area = Math.min(maxheight,height[i]) * (i -l);
//            }
//            maxArea = Math.max(maxArea, area);
//        }
//        return maxArea;
//    }
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length -1;
        
        while(left < right){
            int width = right -left;
            int currHeight = Math.min(height[left],height[right]);
            maxArea = Math.max(width*currHeight, maxArea);
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
    
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length -2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int left = i + 1;
            int right = nums.length -1;
            
            
            while(left < right){
                int sum = nums[i] +nums[left] +nums[right];
                if(sum == 0){
                    List<Integer> sub = new ArrayList<>();
                    sub.add(nums[i]);
                    sub.add(nums[left]);
                    sub.add(nums[right]);
                    list.add(sub);
                    
                    while (left < right && nums[left] == nums[left+1]) {                        
                        left++;
                    }
                    while (left < right && nums[right] == nums[right-1]) {                        
                        right--;
                    }
                    left++;
                    right--;
                }else if(sum > 0){
                    right--;
                }else{
                    left++;
                }  
            }
        }
        return list;
    }
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length -3; i++) {
            if(i > 0 && nums[i] == nums[i -1]) continue;
            for (int j = i+1; j < nums.length -2; j++) {
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int left = j+1,right = nums.length -1;
                while (left < right) {                    
                    long sum = (long)nums[i]+nums[j]+nums[left]+ nums[right];
                    if(sum == target){
                        list.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while(left < right && nums[left] == nums[left +1]) left++;
                        while(left < right && nums[right] == nums[right -1]) right--;
                        left++;
                        right--;
                    }else if(sum > target){
                        right--;
                    }else{
                        left++;
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Aug10 a = new Aug10();
//        a.moveZeroes(new int[]{0, 1, 0, 3, 12});
//        System.out.println(a.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
//        System.out.println(a.threeSum(new int[]{-1,0,1,2,-1,-4}));
          System.out.println(a.fourSum(new int[]{1000000000,1000000000,
              1000000000,1000000000},-294967296 ));
    }
}

class NumArray {

    private int[] n;

    public NumArray(int[] nums) {
        n = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            n[i + 1] = n[i]+nums[i];
        }
    }

    public int sumRange(int left, int right) {    
        return n[right+1] - n[left];
    }
}
