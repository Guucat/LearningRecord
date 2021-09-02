package leetcode_zj100.bank121;

/**
 * @author shengyi
 * @create 2021/8/24 - 21:43
 * easy
 */
public class Solution {
    //暴力 n*2
//    public int maxProfit(int[] prices) {
//        int max = 0;
//        for (int i = 0; i < prices.length; i++) {
//            for (int j = i + 1; j < prices.length; j++) {
//                if (prices[j] - prices[i] > max) {
//                    max = prices[j] - prices[i];
//                }
//
//            }
//        }
//        return max;
//    }
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
}
