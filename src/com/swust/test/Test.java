package com.swust.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author WENHAO
 * @date 2020/4/29-10:24
 *
 * 1.Map存放的使键值对，当存放同一key值时，后面的键值对会覆盖掉前面的键值对，包括value等
 *
 * 2.优化后的时间复杂度为O(n),右指针会不停的往右边走，会把每一个字符都存入map,并且不用删除map里的任何内容
 *
 * 3.在后位置如果出现了前位置重复的字符，也是会覆盖掉他的value值得
 *
 * 4.map存在主要作用是提供不停更新每个字符得最新位置信息，帮助start指针滑动
 *
 * 5.与讲数据存入set里面时，不同的是set里面存的是不重复的字符，通过判断set的长度来判断整体的长度
 * */
public class Test {
    public static int lengthOfLongestSubstring(String s) {
        int start =0;
        int end = 0;
        int res = 0;
        Map<Object,Integer>  map = new HashMap();

        while (end<s.length()){
            if(map.containsKey(s.charAt(end))){
                start = start > map.get(s.charAt(end)) + 1 ? start:map.get(s.charAt(end))+1;
            }
                map.put(s.charAt(end),end);
                end++;
                res = Math.max(res,end-start);

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("dd");
        System.out.println(lengthOfLongestSubstring("abcabdcbb"));
    }
}



