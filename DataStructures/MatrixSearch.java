public class MatrixSearch {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, 
                       {5, 6, 7, 8}, 
                       {9, 10, 11, 12}};

        int target = 5;
        int[] result = search(arr, target);
        System.out.println(target);
        System.out.println(result[0] + "," + result[1]);
    }

    public static int[] search(int[][] arr, int key){
        int low = 0;
        int high = arr.length-1;
        int middle = (low + high)/2;

        while(low <= high){
            if(arr[middle][0] == key){
                return new int[]{middle, 0};
            } else if(arr[middle][0] < key){
                low = middle + 1;
            } else{
                high = middle - 1;
            }
            middle = (low + high) / 2;
        }

        int row = high;
        low = 0;
        high = arr.length-1;
        middle = (low + high)/2;

        while(low <= high){
            if(arr[row][middle] == key){
                return new int[]{row, middle};
            } else if(arr[row][middle] < key){
                low = middle + 1;
            } else{
                high = middle - 1;
            }
            middle = (low + high) / 2;
        }

        return new int[]{-1, -1};
    }
}
