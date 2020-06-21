package DynamicProgramming;

public class MinimumDivision {
    public static void main(String[] args){
        System.out.println(divsion(30));
    }
    public static int divsion(int n){
        if (n==1){
            return 0;
        }
        int n1=Integer.MAX_VALUE,n2=Integer.MAX_VALUE,n3=Integer.MAX_VALUE;
        n1 = divsion(n-1);
        if (n % 2 == 0){
            n2 = divsion(n / 2);
        }
        if (n % 3 == 0){
            n3 = divsion(n / 3);
        }
        return 1+Math.min(n1, Math.min(n2,n3));
    }
}
