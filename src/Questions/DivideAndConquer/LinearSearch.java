package Questions.DivideAndConquer;

public class LinearSearch {
    public static void main(String[] arg) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++){
            arr[i] = i;
        }
        System.out.println(linearSearch(arr, 5));
    }

    public static int linearSearch(int[] arr, int item) {
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == item){
                return i;
            }
        }
        return -1;
    }
}
