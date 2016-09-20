import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum {


    //时间复杂度为 O(n^2)
    public List<List<Integer>> sum_2(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] + arr[j] == 0) {
                    list.add(Arrays.asList(arr[i], arr[j]));
                }
            }
        }
        return list;
    }

    //2sum 优化
    public List<List<Integer>> sum_2_update(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 2) {
            return null;
        }

        Arrays.sort(nums);
        for (int left = 0; left < nums.length - 1; left++) {
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[left], nums[right]));
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return list;
    }

    //3sum
    public List<List<Integer>> sum_3(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 3) {
            return null;
        }

        //对传入数组排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i],
                            nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left - 1] == nums[left]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return list;
    }

    //4sum continue..
    public List<List<Integer>> sum_4(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 4) {
            return list;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i!=0 && nums[i-1]==nums[i])
                continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int medium = left + 1;
                while (left < medium && medium < right) {
                    int sum = nums[i] + nums[left] + nums[medium] + nums[right];
                    if (sum == target) {
                        list.add(Arrays.asList(nums[i], nums[left], nums[medium], nums[right]));
                        medium++;
                        //improve performance
                        while (left < medium && medium < right && nums[medium - 1] == nums[medium]) {
                            medium++;
                        }
                        while (left < medium && medium < right && nums[right + 1] == nums[right]) {
                            right--;
                        }
                    } else if (sum > target) {
                        right--;
                    } else {
                        medium++;
                    }
                }
                left++;
                while (left < right && nums[left-1]==nums[left]) {
                    left++;
                }
                //reset
                right = nums.length - 1;
            }
        }
        return list;
    }

    //递归 传入的n等于1时 return 1 终止递归
    public long dg(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * dg(n - 1);
        }
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums.length < 2) {
            return result;
        }
        for (int j = 0; j < nums.length - 1; j++) {
            for (int i = nums.length - 1; i > j; i--) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1,-5,-5,-3,2,5,0,4};
        Sum sum = new Sum();
        //sum.sum_3(arr);
        //sum.sum_2(arr);
        //sum.sum_2_update(arr);
        System.out.println(sum.sum_4(arr, -7));
    }
}
