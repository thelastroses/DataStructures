public class MyQueue extends DoublyLinkedList implements Queue{
    public static void main(String[] args) {
        Queue queue =  new MyQueue();

        System.out.println();
        System.out.println("enqueues 3,17,22,8,4");
        queue.enqueue(3);
        queue.enqueue(17);
        queue.enqueue(22);
        queue.enqueue(8);
        queue.enqueue(4);
        queue.print();

        System.out.println();
        System.out.println();
        System.out.println("dequeue: " + queue.dequeue());
        queue.print();

        System.out.println();
        System.out.println();
        System.out.println("front: " + queue.front());
    }

    public void enqueue(Object i)
    {
        append(i);
    }


    public Object dequeue()
    {
        if(head == null)
        {
            return null;
        }   

        Object headData = head.data;
        head = head.next;

        if(head != null)
        {
            head.prev = null;
            
        }
        else
        {
            tail = null;
        }
        return headData;
    }

    public Object front()
    {
        if(head == null)
        {
            return null;
        }   

        Object headData = head.data;

        return headData; 
    }

}
