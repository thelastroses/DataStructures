import java.util.HashSet;
import java.util.Random;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = generateRandomUnique(7, 110000, 100000);
        int lengthOfArray = arr.length;

        int[] result = new int[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = arr[i];
        }
        long start = System.currentTimeMillis();
        mergeSort(result, 0, result.length - 1);
        long finish = System.currentTimeMillis();
        long mergeTimeElapsed = finish - start;
        System.out.println("Sorting a random array size of " + lengthOfArray + " took Merge Sort " + mergeTimeElapsed + "ms to complete.");
    
    }


    public static void mergeSort(int[] arr, int left, int right){
        if(left < right)
        {
            int middle = (right + left) / 2;
        
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);

            merge(arr, left, middle, right);
        }
    }

    public static void merge(int[] arr, int left, int middle, int right)
    {
        int[] mergedArr = new int[right-left+1];
        int leftAmt = left;
        int rightAmt = middle+1;
        int mergePos=0;


        while(leftAmt <= middle && rightAmt <= right)
        {
            if(arr[leftAmt] <= arr[rightAmt])
            {
                mergedArr[mergePos] = arr[leftAmt];
                leftAmt++;
                mergePos++;
            }
            else
            {
                mergedArr[mergePos] = arr[rightAmt];
                rightAmt++;
                mergePos++;
            }
        }

        while(leftAmt <= middle)
        {
            mergedArr[mergePos] = arr[leftAmt];
            leftAmt++;
            mergePos++;
        }

        while(rightAmt <= right)
        {
            mergedArr[mergePos] = arr[rightAmt];
            rightAmt++;
            mergePos++;
        }


        for(int i =0; i < mergedArr.length; i++)
        {
            arr[left+i] = mergedArr[i];
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
