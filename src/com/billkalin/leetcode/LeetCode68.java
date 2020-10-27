package com.billkalin.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ret = new ArrayList<>();
        int currIndex = 0;
        for (int index = 0; index < words.length; ) {
            StringBuilder stringBuilder = new StringBuilder();
            int count = words[index].length();
            //计算一行能容下的单词数量,为啥count + 1,因为两个单词中间最少要1个空格
            while (currIndex < words.length && count + 1 + words[currIndex].length() <= maxWidth) {
                count += (1 + words[currIndex].length());
                currIndex++;
            }

            int diff = currIndex - index - 1;//容下的单词数量为1，或者最后一行
            if (diff == 0 || currIndex == words.length) {
                for (int i = index; i < currIndex; i++) {//直接排布单词+空格
                    stringBuilder.append(words[i]).append(' ');
                }
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);//剩下的直接补充空格
                for (int i = stringBuilder.length() + 1; i <= maxWidth; i++) {
                    stringBuilder.append(' ');
                }
            } else {
                int evenSpace = (maxWidth - count) / diff;//算出平均的空格数量
                int leftSpace = (maxWidth - count) % diff;//如果不平均，那需要计算左边的空格数量
                for (int i = index; i < currIndex; i++) {
                    stringBuilder.append(words[i]);
                    if (i < currIndex - 1) {
                        for (int j = 0; j <= evenSpace + (i - index < leftSpace ? 1 : 0); j++) {
                            stringBuilder.append(' ');
                        }
                    }
                }
            }

            ret.add(stringBuilder.toString());
            index = currIndex;
        }

        return ret;
    }
}
