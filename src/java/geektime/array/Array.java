package edu.geektime.array;

/**
 * @Description:
 * @Auther: xiaoshude
 * @Date: 2019/8/19 10:33
 */
public class Array {
    // 定义整型数组保存数据
    public int data[];

    // 定义数组容量!
    private int n;

    // 定义实际元素个数
    private int count;

    // 构造方法，定义数组的大小
    public Array(int capacity) {
        this.data = new int[capacity];

        this.n = capacity;

        // 一开始元素个数为零
        this.count = 0;
    }

    // 根据索引，找到数组中的元素并返回
    public int find(int index) {
        if (index < 0 || index >= count) {
            return -1;
        }

        return data[index];
    }

    // 插入元素：头部插入，尾部插入
    public boolean insert(int index, int value) {
        // 数组中无元素
        if (index == count && count == 0) {
            data[index] = value;
            count++;

            return true;
        }

        // 数组空间已满
        if (count == n) {
            System.out.println("没有可插入位置");

            return false;
        }

        // 若count还没有满，那么就可以插入数据到数组中
        // 位置不合法
        if (index < 0 || index > count) {
            System.out.println("位置不合法");

            return false;
        }
        // 位置合法
        for (int i = count; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        count++;

        return true;
    }

    // 根据索引删除数组中的元素
    public boolean delete(int index) {
        if (index < 0 || index > count) {
            return false;
        }
        // 从删除位置开始，将后面的元素向前移动一位
        for (int i = index + 1; i < count; ++i) {
            data[i - 1] = data[i];
        }
        count--;

        return true;
    }

    public void printAll() {
        for (int i = 0; i < count; i++) {
            System.out.println(data[i] + " ");
        }
    }

    public static void main(String[] args) {
        Array array = new Array(5);
        array.printAll();
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        //array.insert(3, 11);
        array.printAll();
    }

}
