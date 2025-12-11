public class DoublyLinkedList {
    public Node tail;
    public Node head;

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        System.out.println();

        //Tests Append Method
        System.out.println("Test Append with #'s: 9,4,2");
        list.append(9);
        list.append(4);
        list.append(2);
        list.print();

        System.out.println();
        System.out.println();

        //Tests Prepend Method
        System.out.println("Test Prepend with #'s: 10,5,6");
        list.prepend(10);
        list.prepend(5);
        list.prepend(6);
        list.print();

        System.out.println();
        System.out.println();

        //Tests InsertAfter Method
        System.out.println("Test Insert After with inserting 3 after 5");
        DoublyLinkedList.Node node5 = list.search(5);
        DoublyLinkedList.Node node3 = new DoublyLinkedList.Node(3);
        if(node5 != null)
        {
            list.insertAfter(node5,node3);
        }
        list.print();

        System.out.println();
        System.out.println();

        //Tests InsertBefore Method
        System.out.println("Test Insert Before with inserting 1 before 6");
        DoublyLinkedList.Node node6 = list.search(6);
        DoublyLinkedList.Node node1 = new DoublyLinkedList.Node(1);
        if(node6 != null)
        {
            list.insertBefore(node6,node1);
        }
        list.print();

        System.out.println();
        System.out.println();

        //Tests Search Method
        System.out.println("Test Search with finding 9");
        DoublyLinkedList.Node node9 = list.search(9);
        list.print();
        System.out.println();
        if(node9 != null)
        {
            System.out.println("Found!");
        }
        else
        {
            System.out.println("Not Found");
        }

        System.out.println();

        //Tests removeAfter Method
        System.out.println("Test Remove After for 3");
        DoublyLinkedList.Node node7 = list.search(3);
        list.removeAfter(node7);
        list.print();
        System.out.println();
        System.out.println();

        //Tests removeBefore Method
        System.out.println("Test Remove Before for 2");
        DoublyLinkedList.Node node2 = list.search(2);
        list.removeBefore( node2);
        list.print();
        System.out.println();

        System.out.println();

        //Tests Sort Method
        System.out.println("Test Sort");
        list.sort();
        list.print();
        System.out.println();
    }

    public static class Node{
        public Node next;
        public Object data;
        public Node prev;

        public Node(Object data)
        {
            this.next = null;
            this.data = data;
            this.prev = null;
        }
    }

    public void append(Object value)
    {
        Node node = new Node(value);

        if(head == null) 
        {
            head = node;
            tail = node;
        }
        else 
        {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }

    }

    public void prepend(Object value)
    {
        Node node = new Node(value);

        if(head == null) 
        {
            head = node;
            tail = node;
        }
        else
        {
            node.next = head;
            head.prev = node;
            head = node;
        }
        
    }

    public void insertAfter(Node curr, Node node)
    {
        if (head == null) {
            head = node;
            tail = node;
        }
        else if (curr == tail) {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        else {
            DoublyLinkedList.Node succ = curr.next;
            node.next = succ;
            node.prev = curr;
            curr.next = node;
            succ.prev = node;
        }
    }

    public void insertBefore(Node curr, Node node)
    {
        if(head == null) 
        {
            head = node;
            tail = node;
        }
        else if(curr == head) 
        {
            node.next = head;
            head.prev = node;
            head = node;
        }
        else 
        {
            DoublyLinkedList.Node pred = curr.prev;
            node.prev = pred;
            node.next = curr;
            pred.next = node;
            curr.prev = node;      
        }
    }

    public void removeAfter(Node node)
    {
        if(node == null || node.next == null)
        {
            return;
        }

        Node remove = node.next;
        node.next = remove.next;

        if(remove.next != null)
        {
            remove.next.prev = node;
        }
        else
        {
            tail = node;
        }
    }

    public void removeBefore(Node node)
    {
        if(node == null || node.prev == null)
        {
            return;
        }

        Node remove = node.prev;
        node.prev = remove.prev;

        if(remove.prev != null)
        {
            remove.prev.next = node;
        }
        else
        {
            head = node;
        }
    }

    public Node search(Object value) 
    {
        Node node = head;
        
        while(node != null)
        {
            if(node.data.equals(value))
            {
                return node;
            }
            node = node.next; 
        }

        return null;
    }

    public void sort() 
    {
       if (head == null) {
            return;
        }

        Node currNode = head.next;

        while (currNode != null) {
            Node node = currNode.prev;
            Object temp = currNode.data;
            
            while(node != null && (int)node.data > (int)temp){
                node.next.data = node.data;
                node = node.prev;
            }

            if(node == null){
                head.data = temp;
            } 
            else{
                node.next.data = temp;
            }

            currNode = currNode.next;
        }
    }

    public void print()
    {
        Node curr = head;
        System.out.print("Output: ");
        while(curr != null)
        {
            System.out.print(curr.data + ">");
            curr = curr.next;
        }
        System.out.print("null");
    }
}