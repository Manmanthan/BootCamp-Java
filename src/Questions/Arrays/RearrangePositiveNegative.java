package Questions.Arrays;

import java.util.*;

public class RearrangePositiveNegative {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("First Input Choice");
        System.out.println("Display List (Select TV Model)");
        System.out.println("1. Samsung 10000");
        System.out.println("2. Onida 7000");
        System.out.println("3. HDLC 6000");
        System.out.println("Second Input Choice");
        int tv = scn.nextInt();
        System.out.println("Want to take Exchange Offer");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int ech = scn.nextInt();
        int cond = 0;
        if (ech == 1) {
            System.out.println("Third Input Choice");
            System.out.println("Current Condition of customer's old TV");
            System.out.println("1. Working");
            System.out.println("2. Not Working");
            cond = scn.nextInt();
        }

        double res = 0;
        if (tv == 1){
            res += 10000;
        }else if (tv == 2){
            res+= 7000;
        }else if (tv == 3){
            res+= 6000;
        }

        if (ech == 1){
            if (cond == 1){
                res = res - (0.2*res);
            }else {
                res = res - (0.02*res);
            }
        }
        System.out.println("Output "+res+" INR");
    }
}
