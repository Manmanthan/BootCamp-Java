package DynamicProgramming;

class Fibonacci {
    public static void main(String[] args){
        int n = 45;
        int[] strg = new int[n+1];
        System.out.println(fibRS(n, strg));
    }

    public static int fibRS(int n, int[] strg){
        if (n == 0){
            return n;
        }
        if (n == 1){
            return n;
        }
        if (strg[n] != 0){
            return strg[n];
        }

        int fnm1 = fibRS(n-1, strg);
        int fnm2 = fibRS(n-2, strg);
        int fn = fnm1+fnm2;
        strg[n] = fn;
        return fn;
    }

    public static int fibIS(int n){
        int[] strg = new int[n+1];

        //seed
        strg[0] = 0;
        strg[1] = 1;

        for (int i = 2; i <= n; i++){
            strg[i] = strg[i-1]+strg[i-2];
        }
        return strg[n];
    }
}
