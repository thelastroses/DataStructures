public class ArrayBasedList {
    public static void main(String[] args) {
        ArrayBasedList list = new ArrayBasedList();

        System.out.println("appends: 2,3,0,23,8,7");
        list.append(2);
        list.append(3);
        list.append(0);
        list.append(23);
        list.append(8);
        list.append(7);
        list.print();
        System.out.println();
        System.out.println();

        System.out.println("prepends: 4,7,1");
        list.prepend(4);
        list.prepend(7);
        list.prepend(1);
        list.print();
        System.out.println();
        System.out.println();

        System.out.println("insert at index 1 to 5");
        list.insertAt(1, 5);
        list.print();
        System.out.println();
        System.out.println();

        System.out.println("remove number at index 4");
        list.removeAt(4);
        list.print();
        System.out.println();
        System.out.println();
        
        System.out.println("search for 5, returns index");
        int index = list.search(5);
        System.out.println("Index: " + index);
        list.print();
        System.out.println();
        System.out.println();

        System.out.println("sort array to ascending");
        list.sort(true);
        list.print();
        System.out.println();
        System.out.println();
    }

    private int[] data;
    private int arrayLength;

    public ArrayBasedList()
    {
        this(4);
    }

    public ArrayBasedList(int s)
    {
        this.data = new int[s];
        this.arrayLength = 0;
    }
    
    public void resize(int size)
    {
        int[] array = new int[size];

        for(int i = 0; i < arrayLength; i++)
        {
            array[i] = data[i];
        }

        data = array;
    }

    public void append(int e)
    {
        if(arrayLength == data.length)
        {
            resize(arrayLength*2);
        }

        data[arrayLength] = e;
        ++arrayLength;
    }


    public void prepend(int e)
    {
        if(arrayLength == data.length)
        {
            resize(arrayLength*2);
        }

        for(int i = arrayLength; i > 0; --i)
        {
            data[i] = data[i-1];
        }

        data[0] = e;
        ++arrayLength;
    }

    public void insertAt(int index, int e)
    {
        if(arrayLength == data.length)
        {
            resize(arrayLength*2);
        }

        for(int i = arrayLength; i > index; --i)
        {
            data[i] = data[i-1];
        }

        data[index] = e;
        arrayLength++;
    }

    public void removeAt(int index)
    {
        if(index >= 0 && index < arrayLength)
        {
            for(int i = index; i < arrayLength - 1; ++i)
            {
                data[i] = data[i+1];
            }
        }
        --arrayLength;
    }

    public int search(int e)
    {
        for(int i = 0; i < arrayLength; ++i)
        {
            if(data[i] == e)
            {
                return i;
            }
        }

        return -1;
    }


    public void sort(boolean ascending)
    {
        for (int i = 0; i < arrayLength - 1; i++) 
            {
			for (int j = 0; j < arrayLength - 1 - i; j++)
                {
                if(ascending == true){
                    if(data[j] > data[j+1])
                    {
                        int temp = data[j];
                        data[j] = data[j+1];
                        data[j+1] = temp;
                    }
                } 
			}
		}
    }

    public void print()
    {
         for(int i = 0; i < arrayLength; i++)
         {
            System.out.print(data[i] + ">");
         }
    }
}
