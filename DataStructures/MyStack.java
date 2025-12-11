public class MyStack extends DoublyLinkedList implements Stack{
    public static void main(String[] args) {
        Stack stack = new MyStack();
        System.out.println();
        System.out.println("pushes 12,3,4,11,44");
        stack.push(12);
        stack.push(3);
        stack.push(4);
        stack.push(11);
        stack.push(44);
        stack.print();

        System.out.println();
        System.out.println();
        System.out.println("pop: " + stack.pop());
        stack.print();

        System.out.println();
        System.out.println();
        System.out.println("peek: " + stack.peek());
    }

    public void push(Object i)
    {
        append(i);
    }


    public Object pop()
    {
        if(tail == null)
        {
            return null;
        }   

        Object tailData = tail.data;

        if(tail.prev != null)
        {
            tail = tail.prev;
            tail.next = null;
        }
        else
        {
            head = null;
            tail = null;
        }


        return tailData;
    }


    public Object peek()
    {
        if(tail == null)
        {
            return null;
        }   

        Object tailData = tail.data;

        return tailData; 
        
    }
}
