package edu.geektime.linkedlist;

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
        this.length = 10;
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
     * @Description: 链表
     * @return: void
     */
    private void insertElemAtBegin(T data) {

    }
























}
