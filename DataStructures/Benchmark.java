import java.util.HashSet;
import java.util.Random;

public class Benchmark {
    public static void main(String[] args) {
        int[] arr = generateRandomUnique(7, 110000, 100000);
        int lengthOfArray = generateRandomUnique(7, 110000, 100000).length;
        
        long start = System.currentTimeMillis();
        bubbleSort(arr);
        long finish = System.currentTimeMillis();
        long bubbleTimeElapsed = finish - start;
        System.out.println("Sorting a random array size of " + lengthOfArray + " took Bubble Sort " + bubbleTimeElapsed + "ms to complete.");

        start = System.currentTimeMillis();
        selectionSort(arr);
        finish = System.currentTimeMillis();
        long selectionTimeElapsed = finish - start;
        System.out.println("Sorting a random array size of " + lengthOfArray + " took Selection Sort " + selectionTimeElapsed + "ms to complete.");
    
        start = System.currentTimeMillis();
        insertionSort(arr);
        finish = System.currentTimeMillis();
        long insertionTimeElapsed = finish - start;
        System.out.println("Sorting a random array size of " + lengthOfArray + " took Insertion Sort " + insertionTimeElapsed + "ms to complete.");
    
    
    }

    public static int[] bubbleSort(int[] unsortedArr)
    {
        int[] result = new int[unsortedArr.length];
        for(int k = 0; k < unsortedArr.length;k++)
        {
            result[k] = unsortedArr[k];
        }

        for(int i = 0; i < result.length-1; i++)
        {
            for(int j = 0; j < result.length-1-i; j++)
            {
                if(result[j] > result[j+1])
                {
                    int temp = result[j];
                    result[j] = result[j+1];
                    result[j+1] = temp;
                }
            }
        }

        return result;
    }

    public static int[] selectionSort(int[] unsortedArr)
    {
        int[] result = new int[unsortedArr.length];
        for(int i = 0; i < unsortedArr.length;i++)
        {
            result[i] = unsortedArr[i];
        }


        for(int i = 0; i < result.length; i++)
        {
            int smallest = i;
            for(int j = i+1; j < result.length; j++)
            {
                if(result[smallest] > result[j])
                {
                    smallest = j;
                }
            }
            
            int temp = result[i];
            result[i] = result[smallest];
            result[smallest] = temp;
        }

        return result;
    }

    public static int[] insertionSort(int[] unsortedArr)
    {
        int[] result = new int[unsortedArr.length];
        for(int i = 0; i < unsortedArr.length;i++)
        {
            result[i] = unsortedArr[i];
        }


        for(int i = 1; i < result.length; i++)
        {
            int smallest = i;
            while(smallest > 0 && result[smallest] < result[smallest-1])
            {
                int temp = result[smallest];
                result[smallest] = result[smallest-1];
                result[smallest-1] = temp;  
                smallest--; 
            }
        }

        return result;
    }

    public static int[] generateRandomUnique(int start, int end, int total){
        if(total > (end - start) || start >= end)
        {
            System.out.println("Error: Invalid Input");
            return new int[0];
        }
        
        HashSet<Integer> set = new HashSet<>();

        while (set.size() < total)
        {
            int num = new Random().nextInt(start, end);
            set.add(num);
        }
        return set.stream().mapToInt(Number::intValue).toArray();
    }
}
