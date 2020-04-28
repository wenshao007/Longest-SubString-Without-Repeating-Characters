package com.swust.test;

import java.util.HashSet;
import java.util.Set;

/*
* 第一种未优化的解法则
* 始终保持滑动窗口里的字符是不重复的，有重复的就通过remove给移除掉
*
* 我们主要是获得滑动窗口里字符的长度
*
* 主要几个方法：
* String.charAt(index)  或者字符串指定索引处的值
* String.length()  获得字符串的长度
* int Math.man(a,b)   返回a，b之间的最大值
* Set 的remove 方法 可以移除对应的值
* */
/**
 * @author WENHAO
 * @date 2020/4/28-18:37
 */
public class LongestSWRC {
    public static int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        Set s1 = new HashSet();
        int res = 0;
        while (start<s.length()&&end<s.length()){
            if(!s1.contains(s.charAt(end))){
                s1.add(s.charAt(end++));
                res = Math.max(res,end-start);
            }else
                {
                s1.remove(s.charAt(start++));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aaabssicaoshc"));
    }
}
