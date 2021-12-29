package redblacktree;

public class RBTree<K extends Comparable<K>, V> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;
    private int size;

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向红黑树中添加新元素
     *
     * @param key
     * @param value
     */
    public void add(K key, V value) {
        root = add(root, key, value);
        // 最终根节点为黑色节点
        root.color = BLACK;
    }

    /**
     * 向以 node 为根的红黑树中插入元素 (key, value), 递归算法
     * 返回插入新节点后红黑树的根
     */
    private Node add(Node node, K key, V value) {
        if(node == null){
            size ++;
            return new Node(key, value);
        }

        if(key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        }else if(key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        }else {
            node.value = value;
        }

        if (isRed(node.right) && !isRed(node.left)) {
            node = leftRotate(node);
        }
        if(isRed(node.left) && isRed(node.left.left)) {
            node = rightRotate(node);
        }
        if(isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }
        return node;
    }

    /**
     * <pre>
     *             node                                    x
     *           /     \      左旋转                       /  \
     *          T1     x    ------------->              node  T3
     *               /  \                              /    \
     *              T2  T3                           T1     T2
     * </pre>
     *
     * @param node
     * @return
     */
    private Node leftRotate(Node node) {
        Node x = node.right;
        x.left = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    /**
     * 颜色翻转
     *
     * @return
     */
    private void flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    /**
     * <pre>
     *             node                                    x
     *           /     \      右旋转                       /  \
     *          x      T3   ------------->              T1   node
     *        /  \                                          /   \
     *       T1  T2                                       T2     T3
     * </pre>
     */
    private Node rightRotate(Node node) {
        Node x = node.left;
        node.left = x.right;
        x.right = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    /**
     * 判断 node 的颜色
     *
     * @param node
     * @return
     */
    private boolean isRed(Node node) {
        if (node == null) {
            return BLACK;
        }
        return node.color;
    }

    private class Node {
        public K key;
        public V value;
        public Node left, right;
        public boolean color;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            color = RED;
        }
    }

}

