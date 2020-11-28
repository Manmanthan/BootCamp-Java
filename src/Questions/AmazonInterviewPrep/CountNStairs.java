package Questions.AmazonInterviewPrep;

public class CountNStairs {

    static int countStairs(int n) {
        if (n == 0 || n == 1) return 1;
        return countStairs(n - 1) + countStairs(n - 2);
    }

    static int countStairsDP(int n) {
        if (n == 0 || n == 1) return 1;
        int arr[] = new int[n + 1];
        arr[0] = arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    public static void main(String[] args) {
        System.out.println(countStairs(4));
        System.out.println(countStairsDP(4));
    }
}
