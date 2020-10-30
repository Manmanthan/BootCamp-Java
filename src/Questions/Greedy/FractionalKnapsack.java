package Questions.Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

    public static void main(String[] args) {

        int[] wt = {10, 40, 20, 30};
        int[] val = {60, 40, 100, 120};
        int capacity = 50;

        double max = getMaxValue(wt, val, capacity);
        System.out.println(max);
    }

    static class ItemValue {

        Double cost;
        int wt, val, ind;

        public ItemValue(int wt, int val, int ind) {
            this.wt = wt;
            this.val = val;
            this.ind = ind;

            cost = (double) (val / wt);
        }
    }

    private static double getMaxValue(int[] wt, int[] val, int capacity) {

        ItemValue[] ival = new ItemValue[wt.length];

        for (int i = 0; i < wt.length; i++) {
            ival[i] = new ItemValue(wt[i], val[i], i);
        }

        Arrays.sort(ival, new Comparator<ItemValue>() {
            @Override
            public int compare(ItemValue itemValue, ItemValue t1) {
                return t1.cost.compareTo(itemValue.cost);
            }
        });

        double totalVal = 0d;

        for (ItemValue item : ival) {

            int curWt = item.wt;
            int curVal = item.val;

            if (capacity - curWt >= 0) {
                totalVal += curVal;
                capacity -= curWt;
            } else {

                double fraction = ((double) capacity / (double) curWt);
                totalVal += curVal * fraction;
                capacity = (int) (capacity - (curWt * fraction));
                break;
            }
        }
        return totalVal;
    }
}
