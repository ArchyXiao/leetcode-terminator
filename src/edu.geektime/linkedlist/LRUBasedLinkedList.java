package edu.geektime.linkedlist;

import java.util.Scanner;

/**
 * @Description: 基于单链表的LRU算法
 * @Auther: xiaoshude
 * @Date: 2019/8/21 17:45
 */
public class LRUBasedLinkedList<T> {

    // 默认链表容量
    private final static Integer DEFAULT_CAPACITY = 10;

    // 头结点
    private SNode<T> headNode;

    // 链表长度
    private Integer length;

    // 链表容量
    private Integer capacity;

    class  SNode<T> {
        private T element;

        private SNode next;

        public SNode(T element) {
            this.element = element;
        }

        public SNode(T element, SNode next) {
            this.element = element;
            this.next = next;
        }

        public SNode() {
            this.next = null;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public SNode getNext() {
            return next;
        }

        public void setNext(SNode next) {
            this.next = next;
        }


    }

    public LRUBasedLinkedList() {
        this.headNode = new SNode<>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public LRUBasedLinkedList(Integer capacity) {
        this.headNode =  new SNode<>();
        this.capacity = capacity;
        this.length = 0;
    }

    public void add(T data) {
        SNode preNode = findPreNode(data);

        // 链表中存在，删除原数据，再插入到链表的头部
        if (preNode != null) {
            deleteElemOptim(preNode);
            insertElemAtBegin(data);
        } else {
            if (length >= this.capacity) {
                //删除尾结点
                deleteElemAtEnd();
            }
            insertElemAtBegin(data);
        }
    }

    /**
     * @Description: 删除preNode结点下一个元素
     * @param preNode
     * @return: void
     */
    private void deleteElemOptim(SNode preNode) {
        SNode temp = preNode.getNext();
        preNode.setNext(temp.getNext());
        temp = null;
        length--;
    }

    /**
     * @Description: 链表头部插入结点
     * @return: void
     */
    private void insertElemAtBegin(T data) {
        SNode next = headNode.getNext();
        headNode.setNext(new SNode(data, next));
        length++;
    }

    /**
     * @Description: 获取查找到元素的前一个结点
     * @param data
     * @return: edu.geektime.linkedlist.LRUBasedLinkedList<T>.SNode
     */
    private SNode findPreNode(T data) {
        SNode node = headNode;
        while (node.getNext() != null) {
            if (data.equals(node.getNext().getElement())) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    private void deleteElemAtEnd() {
        SNode ptr = headNode;
        // 空链表直接返回
        if (ptr.getNext() == null) {
            return;
        }
        // 倒数第二个结点
        while (ptr.getNext().getNext() != null) {
            ptr = ptr.getNext();
        }

        SNode tmp = ptr.getNext();
        ptr.setNext(null);
        tmp = null;
        length--;
    }

    private void printAll() {
        SNode node = headNode.getNext();
        while (node != null) {
            System.out.print(node.getElement() + " , ");
            node = node.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUBasedLinkedList list = new LRUBasedLinkedList();
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.add(sc.nextInt());
            list.printAll();
        }
    }
}
