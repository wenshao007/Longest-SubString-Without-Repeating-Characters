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
*
* 那么为什么说是未优化的?
* 因为当发现end指针的内容和窗口里的重复时，start的指针要逐个往end靠拢，时间复杂度为O(2n)
* 优化后的，把位置存入每个字符的位置信息存入滑动窗口中，当发现end重复后，直接可以按内容去除掉该重复，并把start指针移动到它的位置上
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

        while (start<s.length()&&end<s.length()){//该条件判断窗口是否滑完整个字符串
            if(!s1.contains(s.charAt(end))){  //看当前指针指向的字符，在窗口字符里是否包含
                //如果不包含，把当前指针指向的字符添加到滑动窗口里
                s1.add(s.charAt(end++));
                //统计滑动窗口里的字符数量，并把他存进去
                res = Math.max(res,end-start);
            }else//如果包含，移除掉当前start指针指向的字符，并且start指针右移
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
