
package leetcode_zj100.bank215;

import java.util.Arrays;
import java.util.Random;
/**
 * @author shengyi
 * @create 2021/8/27 - 4:14
 *medium
 */
class Solution {
        public int findKthLargest(int[] nums, int k) {
            return quickSort(nums, k - 1);
        }

        public int partition(int[] nums, int low, int high) {
            if (low == high) return low;
            int p =new Random().nextInt(high-low+1)+low;
            swap(nums, low, p);
            int pivot = nums[low];
            while (low < high) {
                while (low < high && nums[high] <= pivot) {
                    high--;
                }
                nums[low] = nums[high];
                while (low < high && nums[low] >= pivot) {
                    low++;
                }
                nums[high] = nums[low];
            }
            nums[low] = pivot;
            return low;
        }

        public int m_quickSort(int[] nums, int low, int high, int k) {
                int middle = partition(nums, low, high);
                if (middle == k) {
                    return nums[k];
                } else {
                    return middle > k ? m_quickSort(nums, low, middle - 1, k) : m_quickSort(nums, middle + 1, nums.length - 1, k);
                }
        }

        public int quickSort(int[] nums, int k) {
            return this.m_quickSort(nums, 0, nums.length - 1, k);
        }

        public void swap(int[] nums, int a, int b) {
            int tem = nums[a];
            nums[a] = nums[b];
            nums[b] = tem;
        }
        public static void main(String[] args) {
            long s = System.currentTimeMillis();
            int[] t = {3,2,3,1,2,4,5,5,6};
            leetcode_zj100.bank215.Solution solution = new leetcode_zj100.bank215.Solution();
            solution.m_quickSort(t, 0, t.length - 1, 4);
            System.out.println(Arrays.toString(t));
            System.out.println(solution.findKthLargest(t, 4));
            long e = System.currentTimeMillis();
            System.out.println("耗时：" + (e - s));
        }
    }


