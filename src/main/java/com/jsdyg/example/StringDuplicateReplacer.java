package com.jsdyg.example;

public class StringDuplicateReplacer {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder(s);
        boolean changed = true;

        while (changed) {
            changed = false;
            int i = 0;
            int n = sb.length();

            while (i < n) {
                int j = i;
                // 找到从i开始连续相同字符的结束位置
                while (j < n && sb.charAt(j) == sb.charAt(i)) {
                    j++;
                }
                int length = j - i;

                if (length >= 3) {
                    if (i > 0) {
                        // 用前一个字符替换整个连续段
                        char prevChar = sb.charAt(i - 1);
                        sb.delete(i, j);         // 删除连续段
                        sb.insert(i, prevChar);   // 插入前一个字符
                        changed = true;
                        break; // 退出内层循环，重新扫描字符串
                    } else {
                        // 开头无前字符，直接删除连续段
                        sb.delete(i, j);
                        changed = true;
                        break; // 退出内层循环，重新扫描字符串
                    }
                } else {
                    i = j; // 移动指针到下一个不同字符的起始位置
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = new StringDuplicateReplacer().removeDuplicates("abcccbad");
        System.out.println(str);
    }
}
