package com.lzr;

public class Test {
    public Node head; // 环形队列头指针
    public Node tail; // 环形队列尾指针

    // 节点
    class Node{
        public Integer data;
        public Node pre;
        public Node next;

        public Node(){

        }
        public Node(Integer data,Node pre, Node next) {
            this.data = data;
            this.pre = pre; // 前指针
            this.next = next; // 后指针
        }
    }

    public static void main(String[] args) {
        // 以下操作得出的数组为[1,2,3]
        Test test = new Test();
        test.head = test.new Node(1,null,null); // 头节点
        test.tail = test.head;
        test.head.next = test.new Node(2,test.head,test.head);
        test.head.pre = test.head;
        test.head.next.next = test.new Node(3,test.head.next,test.head);
        test.tail = test.head.next.next;
        Node temp = test.head;
        System.out.print("原数组:[");
        while(true){
            System.out.print(temp.data);
            if(temp == test.tail){
                break;
            }
            System.out.print(",");
            temp = temp.next;
        }
        System.out.print("]");
        System.out.println();
        System.out.print("右移一位后的数组:[");
        // 往右移1位,变为 312
        // 两个指针往前移1位,反之往后移
        test.head = test.head.pre; // 头指针指向它的前指针,往前移
        test.tail = test.tail.pre; // 尾指针指向它的前指针,往前移
        while(true){
            System.out.print(temp.data);
            if(temp == test.tail){
                break;
            }
            System.out.print(",");
            temp = temp.next;
        }
        System.out.print("]");
    }
}
