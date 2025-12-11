public class LinearProbingHW {
    public int isOccupied = 1;
    public int emptyFromStart = 0;
    public int emptyAfterRemoval = 2;
    public int[] k;
    public int[] b;
    public String[] w;

    public LinearProbingHW(int s)
    {
        k = new int[s];
        b = new int[s];
        w = new String[s];

        for(int i = 0; i < s; i++)
        {
            b[i] = emptyFromStart;
        }
    }

    public static void main(String[] args) {
        LinearProbingHW hashTable = new LinearProbingHW(9);

        System.out.println()
        ;
        System.out.println("inserting key 1,2,7");
        hashTable.hashInsert(1, "test1");
        hashTable.hashInsert(2, "test2");
        hashTable.hashInsert(7, "test7");
        hashTable.display();

        System.out.println();

        System.out.println("inserting key 10");
        hashTable.hashInsert(10, "tests collision");
        hashTable.display();

        System.out.println();

        System.out.println("removes key 2");
        hashTable.hashRemove(2);
        hashTable.display();

        System.out.println();

        System.out.println("gets key 2");
        System.out.println("key 2: " + hashTable.hashGet(2));

        System.out.println();

        System.out.println("resize hash table to 18");
        hashTable.hashResize(18);
        hashTable.display();
    }

    public int getHashing(int key)
    {
        return key % k.length;
    }

    public boolean hashInsert(int key, String value)
    {
        for(int i = 0; i < k.length; i++)
        {
            int bucketIndex = probing(key, i);

            if(b[bucketIndex] == isOccupied && k[bucketIndex] == key)
            {
                w[bucketIndex] = value;
                return true;
            }

            if(b[bucketIndex] == emptyFromStart || b[bucketIndex] == emptyAfterRemoval)
            {
                k[bucketIndex] = key;
                w[bucketIndex] = value;
                b[bucketIndex] = isOccupied;
                return true;
            }
        }

        return false;
    }

    public boolean hashRemove(int key)
    {
        for(int i = 0; i < k.length; i++)
        {
            int bucketIndex = probing(key, i);

            if(b[bucketIndex] == emptyFromStart)
            {
                return false;
            }

            if(b[bucketIndex] == isOccupied && k[bucketIndex] == key)
            {
                b[bucketIndex] = emptyAfterRemoval;
                return true;
            }
        }

        return false;
    }
    
    public String hashGet(int key)
    {
        for(int i = 0; i < k.length; i++)
        {
            int bucketIndex = probing(key, i);

            if(b[bucketIndex] == emptyFromStart)
            {
                return null;
            }

            if(b[bucketIndex] == isOccupied && k[bucketIndex] == key)
            {
                return w[bucketIndex];
            }    
        }

        return null;
    }

    public void hashResize(int newSize)
    {
        int[] oldK = k;
        int[] oldB = b;
        String[] oldW = w;

        k = new int[newSize];
        b = new int[newSize];
        w = new String[newSize];

        for(int i = 0; i < newSize; i++)
        {
            b[i] = emptyFromStart;
        }

        for(int i = 0; i < oldK.length; i++)
        {
            if(oldB[i] == isOccupied)
            {
                hashInsert(oldK[i], oldW[i]);
            }
        }
    }


    public int probing(int key, int i)
    {
        return (getHashing(key) + i) % k.length;
    }

    public void display()
    {
        for(int i = 0; i < k.length; i++)
        {
            if(b[i] == isOccupied)
            {
                System.out.println("Bucket " + i + " Key " + k[i] + " String " + w[i]);
            }
            else if (b[i] == emptyAfterRemoval)
            {
                System.out.println("Bucket " + i + " empty after removal");
            }
            else
            {
                System.out.println("Bucket " + i + " empty from start");
            }
        }
    }
}
