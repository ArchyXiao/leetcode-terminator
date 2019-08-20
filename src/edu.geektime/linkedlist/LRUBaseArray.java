package edu.geektime.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * 基于数组实现的LRU缓存
 * 1. 空间复杂度为O(n)
 * 2. 时间复杂度为O(n)
 * 3. 不支持null的缓存
 *
 * @Auther: xiaoshude
 * @Date: 2019/8/20 18:50
 */
public class LRUBaseArray<T> {

    private static final int DEAFAULT_CAPACITY = (1 << 3);

    private int capacity;

    private int count;

    private T[] value;

    private Map<T, Integer> holder;

    public LRUBaseArray() {
        this(DEAFAULT_CAPACITY);
    }

    public LRUBaseArray(int capacity) {
        this.capacity = capacity;
        value = (T[]) new Object[capacity];
        count = 0;
        holder = new HashMap<T, Integer>(capacity);
    }


    public void offer(T object) {
        if (object == null) {
            throw new IllegalArgumentException("该缓存容器不支持null");
        }
        Integer index  = holder.get(object);
        if (index == null) {
            if (isFull()) {

            } else {

            }
        } else {

        }
    }

    public boolean isFull() {
        return count == capacity;
    }

    /**
     * @Description:
     * 缓存满的情况，踢出后，再缓存到数组头部
     *
     * @param object
     * @return: void
     */
    public void removeAndCache(T object) {
        T key = value[--]
    }













}
