package maxheap;

import array.Array;

import java.util.Random;

public class MinHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MinHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MinHeap() {
        data = new Array<>();
    }

    public MinHeap(E[] arr) {
        data = new Array<>(arr);
        if (arr.length != 1) {
            for (int i = parent(arr.length - 1); i >= 0; i--) {
                shiftDown(i);
            }
        }
    }

    /**
     * 返回堆中元素个数
     */
    public int size() {
        return data.getSize();
    }


    /**
     * 返回一个布尔值表示堆中是否为空
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的父节点的索引
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent");
        }
        return (index - 1) / 2;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
     */
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
     */
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    public void add(E e) {
        data.addLast(e);
        shiftUp(data.getSize() - 1);
    }

    private void shiftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) > 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    public E findMin() {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("heap is empty");
        }
        return data.getFirst();
    }

    public E extractMin() {
        E ret = findMin();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        shiftDown(0);
        return ret;
    }

    private void shiftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) < 0) {
                j++;
            }

            if (data.get(k).compareTo(data.get(j)) <= 0) {
                break;
            }
            data.swap(k, j);
            k = j;
        }
    }

    /**
     * 取出堆中的最小元素，并且替换成元素 e
     */
    public E replace(E e) {
        E ret = findMin();
        data.set(0, e);
        shiftDown(0);
        return ret;
    }

    public static void main(String[] args) {
        int n = 100000;
        MinHeap<Integer> minHeap = new MinHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            minHeap.add(random.nextInt(Integer.MAX_VALUE));
        }

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = minHeap.extractMin();
        }

        for (int i = 1; i < n; i++) {
            if(arr[i-1] > arr[i]) {
                throw  new IllegalArgumentException("Error");
            }
        }

        System.out.println("Test MinHeap complete");
    }
}
