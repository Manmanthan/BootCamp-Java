package Recursion;

import java.util.ArrayList;

public class WineProblem {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(1);
        list.add(5);
        list.add(2);

        System.out.println(wineProblem(0, list.size()-1, list));
    }

    public static int wineProblem(int be, int en, ArrayList<Integer> priceList) {

        if (be > en) {
            return 0;
        }

        int day = priceList.size() - (en - be + 1) + 1;

        return Math.max(wineProblem(be+1, en, priceList)+ day * priceList.get(be),
                wineProblem(be, en-1, priceList) + day * priceList.get(en));
    }
}
