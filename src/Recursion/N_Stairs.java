package Recursion;

public class N_Stairs {

    public static int nstairs(int n) {
        if (n == 0) {
            return 1;
        }

        if (n < 0){
            return 0;
        }

        int ans = 0;
        ans = ans + nstairs(n - 1);
        ans = ans + nstairs(n - 2);
        ans = ans + nstairs(n - 3);
        return ans;
    }

    public static void main(String[] args){
        int n = 4;
        System.out.println(nstairs(n));
    }
}
