package MemoryAlgo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: Chenglin Ding
 * @Date: 17.04.2021 20:56
 * @Description: 添加要加一个容量，如果超过这个容量，就要删除最不常用的一个元素
 * 这就是为什么要使用一个链表的原因，要利用链表的特制，把上一次用过的元素放到开头
 * 链表存取key value类型，设计时最好有个Map做辅助，否则通过key查找value就得一个一个比对key
 * 因为key不一定是链表的顺序
 * 2
 * put 1 1
 * put 2 2
 * get 1
 * put 3 3
 * get 1
 * output
 * 3 3
 * 1 1
 *
 */
public class LRUMapList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int capacity = sc.nextInt();
        LRUCache lru = new LRUCache(capacity);
        while(sc.hasNextLine()) {
            String[] ss = sc.nextLine().split(" ");
            if (ss.length == 3) {
                int key = Integer.parseInt(ss[1]);
                int value = Integer.parseInt(ss[2]);
                lru.put(key,value);
            } else if (ss.length == 2) {
                int key = Integer.parseInt(ss[1]);
                lru.get(key);
            }
        }
        lru.print();

    }


}
class LRUCache{
    public class Node{
        int key;
        int value;
        Node pre;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    private int capacity;
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;

    public LRUCache(int capacity){
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public void put(int key, int value){
        Node node = map.get(key);
        //对Node进行更新
        if(node != null){
            node.value = value;
            remove(node);
        }
        else{
            node = new Node(key, value);
            if(map.size() >= capacity){
                remove(tail);
            }
        }
        addToHead(node);

    }

    public int get(int key){
        Node node = map.get(key);
        if(node == null){return -1;}
        remove(node);
        addToHead(node);
        return node.value;
    }



    public void remove(Node node){
        if(node == head)
            head = head.next;
        if(node == tail)
            tail = tail.pre;
        if(node.next != null){
            node.next.pre = node.pre;
        }
        if(node.pre != null){
            node.pre.next = node.next;
        }
        node.next = null;
        node.pre = null;
        map.remove(node.key);

    }

    public void addToHead(Node node){
        if(head == null)
            head = tail = node;
        else{
            node.next = head;
            head.pre = node;
            head = node;
        }
        map.put(node.key,node);

    }
    public void print(){
        Node p = tail;
        while(p != null){
            System.out.println(p.key+""+p.value);
            p = p.pre;
        }
    }


}

















