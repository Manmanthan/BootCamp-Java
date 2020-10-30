package Questions.DynamicProgramming;

class BoardPath {
    public static int countBoardPathRS(int end, int curr, int[] strg){
        if (curr == end){
            return 1;
        }
        if (curr > end){
            return 0;
        }
        if (strg[curr] != 0){
            return strg[curr];
        }

        int count = 0;
        for (int dice = 1; dice <= 6; dice++){
            count = count + countBoardPathRS(end, curr+dice, strg);
        }
        strg[curr] = count;
        return count;
    }

    public static int countBoardPathIS(int end , int curr){
        int[] strg = new int[end+1];

        //seed
        strg[end] = 1;
        for (int i = end-1; i >= 0; i--){
            int count = 0;
            for (int dice = 1; dice <= 6 && dice+i < strg.length; dice++){
                count = count+strg[dice+i];
            }
            strg[i] = count;
        }
        return strg[curr];
    }
    public static void main(String[] args){
        int n = 10;
        int[] strg = new int[n+1];
        System.out.println(countBoardPathRS(n, 0, strg));
    }
}
