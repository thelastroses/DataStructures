import java.util.HashSet;
import java.util.Random;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = generateRandomUnique(7, 110000, 100000);
        int lengthOfArray = generateRandomUnique(7, 110000, 100000).length;
        
        int[] intervals = {3, 2, 1};
        System.out.println();

        long start = System.currentTimeMillis();
        shellSort(arr, intervals);
        long finish = System.currentTimeMillis();
        long selectionTimeElapsed = finish - start;
        System.out.println("Sorting a random array size of " + lengthOfArray + " took First Shell Sort " + selectionTimeElapsed + "ms to complete.");
    
        start = System.currentTimeMillis();
        shellSort(arr);
        finish = System.currentTimeMillis();
        selectionTimeElapsed = finish - start;
        System.out.println("Sorting a random array size of " + lengthOfArray + " took Second Shell Sort " + selectionTimeElapsed + "ms to complete.");
        
        start = System.currentTimeMillis();
        insertionSort(arr, 1);
        finish = System.currentTimeMillis();
        long insertionTimeElapsed = finish - start;
        System.out.println("Sorting a random array size of " + lengthOfArray + " took Insertion Sort " + insertionTimeElapsed + "ms to complete.");
    }

    public static int[] shellSort(int[] arr, int[] intervals)
    {       
        int[] result = new int[arr.length];
        for(int i = 0; i < arr.length;i++)
        {
            result[i] = arr[i];
        }

        for(int i = 0; i < intervals.length; i++)
        {
            insertionSort(result, intervals[i]);
        }

        return result;
    }

    public static int[] shellSort(int[] arr)
    {
        int[] result = new int[arr.length];
        for(int i = 0; i < arr.length;i++)
        {
            result[i] = arr[i];
        }
        
        int power = 1;

        while(power * 2 < result.length)
        {
            power = power * 2;
        }
        while(power >= 1)
        {
            insertionSort(result, power);
            power = power/2;
        }

        return result;
    }

    public static void insertionSort(int[] arr, int span)
    {
        int[] result = new int[arr.length];
        for(int i = 0; i < arr.length;i++)
        {
            result[i] = arr[i];
        }

        for(int j = 0; j < span; j++) 
        {
            for(int i = j; i < result.length; i = i + span) 
            {
                int smallest = i;
                while((smallest - span) >= 0 && result[smallest] < result[smallest-span]) 
                {
                    int temp = result[smallest];
                    result[smallest] = result[smallest-span];
                    result[smallest-span] = temp;  
                    smallest = smallest - span; 
                }
            }
        }
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

        //creates a stream that converts the Integers into the int primitive and then .toArray takes all the elements and puts it in an int[] array 
        return set.stream().mapToInt(Number::intValue).toArray(); //line found on stackoverflow to convert HashSet<Integer> to int[] cause had no idea before but now I know :)
    }
}
