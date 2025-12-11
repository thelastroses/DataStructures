public class SinglyLinkedList {
    public Node tail;
    public Node head;

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

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
        SinglyLinkedList.Node node5 = list.search(5);
        SinglyLinkedList.Node node3 = new SinglyLinkedList.Node(3);
        if(node5 != null)
        {
            list.insertAfter(node5,node3);
        }
        list.print();

        System.out.println();
        System.out.println();

        //Tests InsertBefore Method
        System.out.println("Test Insert Before with inserting 1 before 6");
        SinglyLinkedList.Node node6 = list.search(6);
        SinglyLinkedList.Node node1 = new SinglyLinkedList.Node(1);
        if(node6 != null)
        {
            list.insertBefore(node6,node1);
        }
        list.print();

        System.out.println();
        System.out.println();

        //Tests Search Method
        System.out.println("Test Search with finding 9");
        SinglyLinkedList.Node node9 = list.search(9);
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

        //Tests Delete Method
        System.out.println("Test Delete for 2");
        list.delete(2);
        list.print();
        System.out.println();
        System.out.println();

        //Tests Remove Method
        System.out.println("Test Remove last");
        list.remove();
        list.print();
        System.out.println();

        System.out.println();

        //Tests Length Method
        System.out.println("Test Length");
        list.print();
        System.out.println();
        System.out.println("Length: " + list.length());
        System.out.println();

        //Tests Empty Method
        System.out.println("Test Empty");
        list.print();
        System.out.println();
        System.out.println("Empty? " + list.isEmpty());
        System.out.println();

        //Tests Sort Method
        System.out.println("Test Sort with Bubble Sort: ");
        list.sort();
        list.print();
        System.out.println();
    }

    public static class Node{
        public Node next;
        public Object data;

        public Node(Object data)
        {
            this.next = null;
            this.data = data;;
        }
    }

    //Adds new node to end of list
    public void append(Object value)
    {
        Node node = new Node(value);

        if(head == null) //if empty, node becomes head and tail
        {
            head = node;
            tail = node;
        }
        else //else add node to end and update tail to that node
        {
            tail.next = node;
            tail = node;
        }

    }

    //Adds new node to start of list
    public void prepend(Object value)
    {
        Node node = new Node(value);

        if(head == null) //if empty, node becomes head and tail
        {
            head = node;
            tail = node;
        }
        else //else add node to start and update head to that node
        {
            node.next = head;
            head = node;
        }
        
    }

    //Inserts new node after given node
    public void insertAfter(Node curr, Node node)
    {
        if(head == null) //if empty, node becomes head and tail
        {
            head = node;
            tail = node;
        }
        else if(curr == tail) //if inserting after tail add a node after prev tail and update tail
        {
            tail.next = node;
            tail = node;
        }
        else{ //insterts node after given node
            node.next= curr.next;
            curr.next = node;
        }
        
    }

    //Inserts new node before given node
    public void insertBefore(Node curr, Node node)
    {
        if(head == null) //if empty, node becomes head and tail
        {
            head = node;
            tail = node;
        }
        else if(curr == head) //if inserting before head update head to next node and then add node to head
        {
            node.next = head;
            head = node;
        }
        else //finds node before curr then adds new node before
        {
            Node prev = head;
            while(prev != null && prev.next != curr)
            {
                prev = prev.next;
            }

            if(prev != null)
            {
                node.next = curr;
                prev.next = node;
            }        
        }
        
    }

    //Deletes first node that matches given
    public void delete(Object value)
    {
        if(head == null)
        {
            return;
        }

        Node curr = head.next;   
        Node prev = null;    
        
        if(head.data.equals(value)) //if deleting head make list empty
        {
            head = head.next;
            if(head == null)
            {
                tail = null;
            }
            return;
        }
        
        while(!curr.data.equals(value) && curr != null) //find value or till it reaches end
        {
            prev = curr;
            curr = curr.next;   
        }

        if(curr != null) //if found delete node
        {
            prev.next = curr.next;
        }

        if(curr == tail) //updates tail if deleted
        {
            tail = prev;
        }  
    }

    //Removes last node
    public void remove() 
    {
        Node curr =head;
        if(head == tail)
        {
            head = null;
            tail = null;
        }

        while(curr.next != tail) //finds node before the tail
        {
            curr = curr.next;
        }

        curr.next = null; //removes last node
        tail = curr;
    }

    //Finds first node that matches given 
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

    //Finds how many nodes there are in the list
    public int length()
    {
        Node node = head;
        int count = 0;
        
        while(node != null)
        {
            count++;
            node = node.next; 
        }

        return count;
    }

    //If empty returns true if not returns false
    public boolean isEmpty()
    {
        if(head == null)
        {
            return true;
        }

        return false;
    }

    //Sorts the list using bubble sort
    /* * This sort() function uses the Bubble Sort algorithm. 
    * Goes through list comparing the adjacent nodes, 
    * swaps data if it is out of order order. 
    * repeats until list is fully sorted. */
    public void sort()
    {
        if(head == null || head.next == null) //if it has 0 or 1 elements there is no reason to sort
        {
            return;
        }

        for(Node i = head; i != null; i= i.next)
        {
            for(Node j = head; j.next != null; j= j.next)
            {
                if((int) j.data > (int) j.next.data)
                {
                   Object temp = j.data;
                   j.data = j.next.data;
                   j.next.data = temp; 
                }
            }
        }
    }

    //Prints entire list
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