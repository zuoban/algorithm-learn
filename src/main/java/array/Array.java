package array;

public class Array {
    private int[] data;
    private int size;

    /**
     * 构造函数，传入数组的容量 capacity 构造 Array
     */
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    /**
     * 参数构造器，默认数组容量 10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取 index 索引位置的元素
     */
    int get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed, Index is illegal");
        }
        return data[index];
    }

    /**
     * 数组中是否包含 e
     */
    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    /**
     * 删除 index 位置
     */
    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed, Index is illegal");
        }
        int ret = data[index];
        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return ret;
    }

    /**
     * 删除第一个元素
     */
    public int removeFirst() {
        return remove(0);
    }

    /**
     * 从数组中删除元素e
     */
    public boolean removeElement(int e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
            return true;
        } else {
            return false;
        }
    }

    /**
     * 删除最后一个元素
     */
    public int removeLast() {
        return remove(size - 1);
    }

    /**
     * 查找 e 的位置
     */
    public int find(int e) {

        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 设置 index 索引位置的元素
     */
    void set(int index, int e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed, Index is illegal");
        }
        data[index] = e;
    }

    /**
     * 获取数组中元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 判断是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在所有元素后添加新元素
     */
    public void addLast(int e) {
        add(size, e);
    }

    /**
     * 在所有元素前不加新元素
     */
    public void addFirst(int e) {
        add(0, e);
    }

    /**
     * 在第 index 个位置插入一个新元素
     */
    public void add(int index, int e) {
        if (size == data.length) {
            throw new IllegalArgumentException("Add failed, Array is full");
        }

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, Require index >=0 and index <= size");
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d \n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }
}
