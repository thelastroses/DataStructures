import java.util.HashSet;
import java.util.Random;

public class AllSortingAlgorithms {
    public static void main(String[] args) {
        int[] arr = generateRandomUnique(7, 110000, 100000);
        int lengthOfArray = arr.length;

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

        int[] intervals = {3, 2, 1};
        System.out.println();

        start = System.currentTimeMillis();
        shellSort(arr, intervals);
        finish = System.currentTimeMillis();
        long shellTimeElapsed = finish - start;
        System.out.println("Sorting a random array size of " + lengthOfArray + " took First Shell Sort " + shellTimeElapsed + "ms to complete.");
    
        start = System.currentTimeMillis();
        shellSort(arr);
        finish = System.currentTimeMillis();
        selectionTimeElapsed = finish - start;
        System.out.println("Sorting a random array size of " + lengthOfArray + " took Second Shell Sort " + selectionTimeElapsed + "ms to complete.");
        
        int[] result = new int[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = arr[i];
        }
        start = System.currentTimeMillis();
        quicksort(result, 0, result.length-1);
        finish = System.currentTimeMillis();
        long quickSortTimeElapsed = finish - start;
        System.out.println("Sorting a random array size of " + lengthOfArray + " took Quick Sort " + quickSortTimeElapsed + "ms to complete.");
    
        int[] diffResult = new int[arr.length];
        for (int i = 0; i < diffResult.length; i++) {
            diffResult[i] = arr[i];
        }
        start = System.currentTimeMillis();
        mergeSort(diffResult, 0, diffResult.length - 1);
        finish = System.currentTimeMillis();
        long mergeTimeElapsed = finish - start;
        System.out.println("Sorting a random array size of " + lengthOfArray + " took Merge Sort " + mergeTimeElapsed + "ms to complete.");
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

    public static int[] quicksort(int[] arr, int lowIndex, int highIndex) 
    {
        if(highIndex <= lowIndex) 
        {
            return arr;
        }

        int lowEndIndex = Partition(arr, lowIndex, highIndex);
        quicksort(arr, lowIndex, lowEndIndex -1);
        quicksort(arr, lowEndIndex + 1, highIndex);

        return arr;
    }

    public static int Partition(int[] arr, int lowIndex, int highIndex) 
    {
        int pivot = arr[lowIndex + (highIndex - lowIndex) / 2];

        while(lowIndex <= highIndex) 
        {
            while(arr[lowIndex] < pivot) 
            {
                lowIndex++;
            }
            while(pivot < arr[highIndex]) 
            {
                highIndex--;
            }
                if(lowIndex <= highIndex) 
                {
                int temp = arr[lowIndex];
                arr[lowIndex] = arr[highIndex];
                arr[highIndex] = temp;

                lowIndex++;
                highIndex--;
                }
            }

            return lowIndex -1;
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


