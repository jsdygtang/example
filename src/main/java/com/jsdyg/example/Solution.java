package com.jsdyg.example;

import java.util.Stack;

public class Solution {
    // 定义节点类，存储字符和连续出现的次数
    static class Node {
        char ch;
        int count;
        Node(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public String removeDuplicates(String s) {
        Stack<Node> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && stack.peek().ch == c) {
                // 栈顶字符与当前字符相同，合并
                Node top = stack.pop();
                int newCount = top.count + 1;
                if (newCount < 3) {
                    stack.push(new Node(c, newCount));
                }
                // 若合并后连续次数>=3，则消除（不压栈）
            } else {
                // 栈为空或栈顶字符不同，压入新节点
                stack.push(new Node(c, 1));
            }
        }

        // 构建结果字符串
        StringBuilder sb = new StringBuilder();
        for (Node node : stack) {
            // 根据节点中的计数，重复字符
            for (int j = 0; j < node.count; j++) {
                sb.append(node.ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aabcccbbad";
        String s1 = solution.removeDuplicates(s);
        System.out.println(s1);
    }
}
