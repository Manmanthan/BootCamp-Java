package DynamicProgramming;

public class LargestCommonSubsequence {
    public static void main(String[] args){
        String str1 = "abbg", str2 = "agbg";
        System.out.println(lcs(str1, str2));
    }
    public static int lcs(String str1, String str2){
        if (str1.length() == 0 || str2.length() == 0){
            return 0;
        }
        int count = 0;
        String ros1 = str1.substring(1);
        String ros2 = str2.substring(1);
        if (str1.charAt(0) == str2.charAt(0)){
            count = 1 + lcs(ros1, ros2);
        }
        else {
            int f1 = lcs(ros1, str2);
            int f2 = lcs(str1, ros2);
            count = Math.max(f1, f2);
        }
        return count;
    }
}
