package com.billkalin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 0, -1, 0, -2, 2};
		int target = 0;
		
		List<List<Integer>> ret = kSum(nums, target, 4);//fourSum(nums, target);
		System.out.println(ret);
	}

	public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 4)
            return ret;
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[nums.length - 1];
        if(4 * min > target || 4 * max < target)
            return ret;
        
        findSum(nums, target, ret);
        return ret;
    }
    
    private static void findSum(int[] nums, int target, List<List<Integer>> ret) {
        for(int i=0; i<nums.length-3; i++) {
            if(i > 0 && nums[i-1] == nums[i])
                continue;
            
            for(int j=i+1; j<nums.length-2; j++) {
                if(j > i+1 && nums[j] == nums[j-1])
                    continue;
                
                int t = target - nums[i] - nums[j];
                
                int left = j+1;
                int right = nums.length - 1;
                while(left < right) {
                    int twoSum = nums[left] + nums[right];
                    if(twoSum == t) {
                        List<Integer> ss = new ArrayList<>();
                        ss.add(nums[i]);
                        ss.add(nums[j]);
                        ss.add(nums[left]);
                        ss.add(nums[right]);
                        ret.add(ss);
                        
                        while(left < right && nums[left] == nums[left+1]) {
                            left++;    
                        }
                        
                        while(left < right && nums[right] == nums[right-1]) {
                            right--;    
                        }
                        
                        left++;
                    }  else if(twoSum > t) {
                        while(left < right && nums[right] == nums[right-1]) {
                            right--;    
                        }
                        right --;
                    } else {
                         while(left < right && nums[left] == nums[left+1]) {
                            left++;    
                        }
                        left ++;
                    }
                }
                
            }
        }
    }
	
    
    public static List<List<Integer>> kSum(int[] nums, int target, int k) {
    	List<List<Integer>> ret = new ArrayList<>();
    	if(nums == null || nums.length < k || nums.length < 2)
    		return ret;
    	//先排序
    	Arrays.sort(nums);
    	
    	getSum(nums, target, k, 0, ret, new ArrayList<Integer>());
    	
    	return ret;
    }
    
    private static void getSum(int[] nums, int target, int k, int start, 
    		List<List<Integer>> result, List<Integer> path) {
    	int max = nums[nums.length - 1];
    	if(nums[start] * k > target || max * k < target)//如果最小值*k 都大于target or 最大值*k都小于，则可以直接返回
    		return;
    	
    	if(k == 2) {
    		int left = start;
    		int right = nums.length - 1;
    		while(left < right) {
    			int sum = nums[left] + nums[right];
    			if(sum == target) {
    				result.add(new ArrayList<Integer>(path));
    				result.get(result.size() - 1).addAll(Arrays.asList(nums[left], nums[right]));
    				
    				left ++;
    				right --;
    				while(left < right && nums[left] == nums[left - 1]) left++;
    				while(left < right && nums[right] == nums[right + 1]) right--;
    			} else if(sum > target) {
    				right --;
    			} else {
    				left ++;
    			}
    		}
    	} else {
    		for(int i=start; i<nums.length - k + 1; i++) {
    			if(i > start && nums[i] == nums[i - 1])//重复计算忽略
    				continue;
    			
    			if(nums[i] * k > target)//最小值都大于目标值，不计算了
    				break;
    			
    		
    			if(nums[i] + max*(k - 1) < target)//如果最小值加上最大值*（k-1）都小于目标值也不用计算了
    				continue;
    			
    			if(nums[i] * k == target) {//k个最小值之和等于target，则需要看之后的几个数值是否都是相同数字，不是的话，也不用计算了
    				if(nums[i + k - 1] == nums[i]) {
    					result.add(new ArrayList<Integer>(path));
    					List<Integer> tmp = new ArrayList<Integer>();
    					for(int x=0;x<k;x++) tmp.add(nums[i]);
    					result.get(result.size() - 1).addAll(tmp);
    				}
    				break;
    			}
    			
    			path.add(nums[i]);
    			//计算下一个数字
    			getSum(nums, target - nums[i], k - 1, i + 1, result, path);//回溯法
    			path.remove(path.size() - 1);
    		}
    	}
    }
}
