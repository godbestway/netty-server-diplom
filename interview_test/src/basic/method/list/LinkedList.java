package basic.method.list;

/**
 * @Author: Chenglin Ding
 * @Date: 11.03.2021 10:07
 * @Description:
 */
public class LinkedList {
    class Node{
        int val;
        Node next;
        public Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }

    Node head;
    Node tail;
    int length;

    public LinkedList(){
        head = null;
        tail = null;
        length = 0;
    }

    public boolean isValid(int index){
        return index >= 0 && index < length;
    }

    public Node getNode(int index){
        Node curr = head;
        while(index != 0){
            curr = curr.next;
            index--;
        }
        return curr;
    }

    public int get(int index){
        if(isValid(index)){
            Node x = getNode(index);
            return x.val;
        }
        return -1;

    }

    public void addHead(int val){
        if(head == null){
            head = new Node(val, null);
            tail = head;
        }
        else{
            Node node = new Node(val, head);
            head = node;
        }

        length++;
    }

    public void addTail(int val){
        if(tail == null){
            head = new Node(val, null);
            tail = head;
        }else{
            Node node = new Node(val, null);
            tail.next = node;
            tail = tail.next;
        }
        length++;
    }

    public void addAtIndex(int index, int val){
        //System.out.println(length+"length");
        if(index < 0 || index > length){
            return;
        }
        if(index == 0){
            addHead(val);
        }else if(index == length){
            addTail(val);
        }else{
            Node beforeTarget = getNode(index -1);
            System.out.println(beforeTarget.val);
            Node node = new Node(val , beforeTarget.next);
            beforeTarget.next = node;
            length++;
        }
    }

    public void deleteAtIndex(int index){
        if(index < 0 || index >= length){
            return;
        }
        if(index == 0 && length == 1){
            head = tail = null;
        }
        else if(index == 0){
            head = head.next;
        }else{
            Node beforeTarget = getNode(index -1);
            Node Target = getNode(index);
            if(Target.next != null){
                beforeTarget.next = Target.next;
            }else{
                beforeTarget.next = null;
                tail  = beforeTarget;
            }
        }
        length--;
    }


    public void showLinkedList(Node head){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.val+ "->");
            curr = curr.next;
        }
        System.out.println(" ");
    }

   //["MyLinkedList","addAtHead","addAtIndex","get","addAtHead","addAtTail","get","addAtTail","get",
    // "addAtHead","get","addAtHead"]
    //[[],[5],[1,2],[1],[6],[2],[3],[1],[5],[2],[2],[6]]


    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList();
        myLinkedList.addHead(5);
        //myLinkedList.addHead(2);
        //myLinkedList.addHead(1);
        myLinkedList.showLinkedList(myLinkedList.head);
        //myLinkedList.addHead(7);
        //myLinkedList.addTail(3);
        myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
        myLinkedList.showLinkedList(myLinkedList.head);
        //int val = myLinkedList.get(1);              // return 2
        //System.out.println("val" + val);
        //myLinkedList.deleteAtIndex(2);    // now the linked list is 1->3
        //myLinkedList.addHead(6);
        //myLinkedList.addTail(4);
        //myLinkedList.addHead(1);
        int val = myLinkedList.get(1);              // return 3
        System.out.println("val" + val);
        myLinkedList.showLinkedList(myLinkedList.head);
        //myLinkedList.addHead(6);
        //myLinkedList.addAtIndex(5,0);
        //myLinkedList.addHead(6);
        //myLinkedList.showLinkedList(myLinkedList.head);
    }



}
