package leetcode_zj100.bank3;

import java.util.ArrayList;


/**
 * @author shengyi
 * @create 2021/8/20 - 21:23
 * ok
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        ArrayList<Character> array = new ArrayList<>() {
        };
        char f;
        int N = 0;
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i == 0) {
                array.add(chars[i]);
                N++;
                result = N;
            } else if (i == chars.length - 1) {
                if (!array.contains(chars[i])) {
                    array.add(chars[i]);
                }
                int n =array.size();
                if (n > result) {
                    result = n;
                }
            } else {
                if (!array.contains(chars[i])) {
                    array.add(chars[i]);
                    N++;
                } else {
                    N = array.size();
                    if (N > result) {
                        result = N;
                    }
                    while (array.contains(chars[i])){
                        array.remove(0);
                        N--;
                    }
                    array.add(chars[i]);
                    N++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("OK");
    }
}
