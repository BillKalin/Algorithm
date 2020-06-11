package com.billkalin.geektime.chapters._36_AcTrie;
import java.util.LinkedList;
import java.util.Queue;

public class AcTrieTest {
    public static void main(String[] args) {
        AcTrieTest test = new AcTrieTest();
        String[] testString = {"h", "e","he", "hel","hell", "hello"};
        for(String item: testString) {
            test.insertChars(item.toCharArray());
        }
        test.buildFailueTree();

        String tStr = "ahellde";
        test.match(tStr.toCharArray());
    }


    private static class AcTrieNode {
        char ch;
        AcTrieNode[] children = new AcTrieNode[26];
        boolean isEndChar;
        AcTrieNode fail;
        int length;

        AcTrieNode(char ch) {
            this.ch = ch;
        }
    }

    AcTrieNode root = new AcTrieNode('/');

    void insertChars(char[] chars) {
        AcTrieNode p = root;
        for (char aChar : chars) {
            int index = aChar - 'a';
            if (p.children[index] == null) {
                AcTrieNode node = new AcTrieNode(aChar);
                p.children[index] = node;
            }
            p = p.children[index];
        }
        p.isEndChar = true;
        p.length = chars.length;
    }

    void buildFailueTree() {
        Queue<AcTrieNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            AcTrieNode p = queue.remove();
            for (int i = 0; i < 26; i++) {
                AcTrieNode node = p.children[i];
                if (node == null) continue;
                if (p == root) {
                    node.fail = root;
                } else {
                    AcTrieNode fail = p.fail;
                    while (fail != null) {
                        AcTrieNode qc = fail.children[node.ch - 'a'];
                        if (qc != null) {
                            node.fail = qc;
                            break;
                        }
                        fail = fail.fail;
                    }

                    if (fail == null) {
                        node.fail = root;
                    }
                }
                queue.add(node);
            }
        }
    }

    void match(char[] chars) {
        AcTrieNode p = root;
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            while (p.children[index] == null && p != root) {
                p = p.fail;
            }
            p = p.children[index];
            if (p == null)
                p = root;
            AcTrieNode tmp = p;
            while (tmp != root) {
                if (tmp.isEndChar) {
                    System.out.println("exists, start from : " + (i - p.length + 1));
                    return;
                }
                tmp = tmp.fail;
            }
        }
    }
}
