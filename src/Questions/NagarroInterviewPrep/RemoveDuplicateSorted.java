package Questions.NagarroInterviewPrep;

import java.io.StringReader;
import java.util.Arrays;
import java.util.Scanner;

public class RemoveDuplicateSorted {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        char[] res = removeDuplicate(str.toCharArray(), str.length());
        System.out.println(Sort(res));
    }

    private static String Sort(char[] str){
        Arrays.sort(str);
        return new String(str);
    }

    private static char[] removeDuplicate(char[] str, int n){
        int index = 0;

        for (int i = 0; i < n; i++){
            int j;
            for (j = 0; j < i; j++){
                if (str[j] == str[i]){
                    break;
                }
            }
            if (i == j){
                str[index] = str[i];
                index++;
            }
        }
        char[] ans = new char[index];
        for (int k = 0; k < index; k++){
            ans[k] = str[k];
        }
        return ans;
    }
}
