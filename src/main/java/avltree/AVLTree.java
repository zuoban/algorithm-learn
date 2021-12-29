package avltree;

import map.Map;

import java.util.ArrayList;

public class AVLTree<K extends Comparable<K>, V> implements Map<K, V> {
    private Node root;
    private int size;

    public static void main(String[] args) {
        AVLTree<String, Integer> map = new AVLTree<>();
        map.add("k1", 1);
        map.add("k2", 2);
        map.add("k3", 3);
        map.add("k4", 4);
        map.add("k5", 5);
        map.add("k6", 6);
        map.add("k7", 7);
        map.add("k8", 8);
        map.add("k9", 9);

        System.out.println(map.isBST());
        System.out.println(map.isBalance());

    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    @Override
    public V remove(K key) {
        Node removeNode = remove(root, key);
        return removeNode == null ? null : removeNode.value;
    }

    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }
        Node retNode;
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            retNode = node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            retNode = node;
        } else {
            // e == node.e
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                retNode = rightNode;
            } else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                retNode = leftNode;
            } else {
                // 待删除节点左右子树均不为空的情况
                // 找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
                // 用这个节点顶替删除节点的位置
                Node successor = minimum(node.right);
                successor.right = remove(node.right, successor.key);
                successor.left = node.left;
                node.left = node.right = null;
                retNode = successor;
            }
        }
        if (retNode == null) {
            return null;
        }

        // 更新 retNode 的高度
        retNode.height = Math.max(getHeight(retNode.left), getHeight(retNode.right)) + 1;

        // 计算平衡因子
        int balanceFactor = getBalanceFactor(retNode);

        // 平衡维护
        // LL
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) >= 0) {
            return rightRotate(retNode);
        }

        // RR
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) <= 0) {
            return leftRotate(retNode);
        }

        // LR
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) < 0) {
            retNode.left = leftRotate(retNode.left);
            return rightRotate(retNode);
        }
        // RL
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) > 0) {
            retNode.right = rightRotate(retNode.right);
            return leftRotate(retNode);
        }

        return retNode;
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + " doesn't exist!");
        }
        node.value = newValue;
    }

    private int getHeight(Node node) {
        return node == null ? 0 : node.height;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向以 node 为根的二分搜索树中插入元素 (key,k value)，递归算法
     * 返回插入新节点后二分搜索树的根
     */
    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }

        // 更新 height;
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        // 计算平衡因子
        int balanceFactory = getBalanceFactor(node);
        if (Math.abs(balanceFactory) > 1) {
            // 维护平衡性
            System.out.println("unbalanced: " + balanceFactory);
        }

        if (balanceFactory > 1 && getBalanceFactor(node.left) >= 0) {
            // LL 右旋转
            return rightRotate(node);
        }

        if (balanceFactory < -1 && getBalanceFactor(node.right) <= 0) {
            // RR 左旋转
            return leftRotate(node);
        }
        if (balanceFactory > 1 && getBalanceFactor(node.left) < 0) {
            // LR
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balanceFactory < -1 && getBalanceFactor(node.right) > 0) {
            // RL
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    ;

    /**
     * 对节点 y 进行向右旋转操作，返回旋转后新的根节点
     * <pre>
     *       y                                x
     *      / \                              /  \
     *     x   T4    向右旋转 (y)            z    y
     *    / \        ------------->       / \   / \
     *   z  T3                           T1 T2 T3 T4
     *  / \
     * T1   T2
     * </pre>
     *
     * @param y
     * @return
     */
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node t3 = x.right;

        x.right = y;
        y.left = t3;
        // 更新 height
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }

    /**
     * 对节点 y 进行向左旋转操作，返回旋转后新的根节点
     * <pre>
     *       y                                x
     *      / \                              /  \
     *     T1  x          向左旋转 (y)        y   z
     *        / \        ------------->    / \  / \
     *       T2  z                        T1 T2 T3 T4
     *          / \
     *        T3  T4
     * </pre>
     *
     * @param y
     * @return
     */
    private Node leftRotate(Node y) {
        Node x = y.right;
        Node t2 = x.left;

        x.left = y;
        y.right = t2;

        // 更新 height
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    /**
     * 获取节点 node 的平衡因子
     *
     * @param node
     * @return
     */
    private int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }

        return getHeight(node.left) - getHeight(node.right);
    }

    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) == 0) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    public boolean isBST() {
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root, keys);
        for (int i = 1; i < keys.size(); i++) {
            if (keys.get(i - 1).compareTo(keys.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    private void inOrder(Node node, ArrayList<K> keys) {
        if (node == null) {
            return;
        }

        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
    }

    public boolean isBalance() {
        return isBalance(root);
    }

    private boolean isBalance(Node node) {
        if (node == null) {
            return true;
        }

        int balanceFactor = getBalanceFactor(node);
        if (balanceFactor > 1) {
            return false;
        }

        return isBalance(node.left) && isBalance(node.right);
    }

    private class Node {
        public K key;
        public V value;
        public Node left, right;
        public int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.height = 1;
        }
    }
}
