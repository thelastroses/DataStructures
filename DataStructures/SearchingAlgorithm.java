import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class SearchingAlgorithm {
    public static void main(String[] args) {
        
        int[] arr = generate_random_unique(7, 22, 9);
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        int target = 11;
        System.out.println("Scan: " + Scan(arr, target));
        System.out.println("Stor: " + Stor(arr, target));
    }

    public static int[] generate_random_unique(int start, int end, int total){
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

    public static boolean Scan(int[] input, int target)
    {
        for(int i = 0; i < input.length; i++)
        {
            if(input[i] == target)
            {
                return true;
            }
        }

        return false;
    }

    public static boolean Stor(int[] input, int target)
    {
        int max = 0;
        for(int i = 0; i < input.length; i++)
        {
            if(input[i] > max)
            {
                max = input[i];
            }
        }

        int[] store = new int[max + 1];

        for(int i = 0; i < input.length; i++)
        {
            store[input[i]] = 1;
        }

        System.out.println("Stor Output:" + Arrays.toString(store));

        if(target <= max && store[target] == 1)
        {
            return true;
        }

        return false;
    }
}