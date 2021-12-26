package trie;

import java.util.TreeMap;

public class Trie {

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
    }

    /**
     * 获取 trie 中存储的单词数量
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 向 trie 中添加单词
     */
    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    /**
     * 查询 word 是 否在 Tire 中
     */
    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Node next = cur.next.get(c);
            if (next == null) {
                return false;
            }
            cur = next;
        }

        return cur.isWord;
    }

    /**
     * 查询是否在 Trie 中有单词以 prefix 为前缀
     */
    public boolean isPrefix(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            Node next = cur.next.get(c);
            if (next == null) {
                return false;
            }
            cur = next;
        }
        return true;
    }

    private class Node {
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }
}
