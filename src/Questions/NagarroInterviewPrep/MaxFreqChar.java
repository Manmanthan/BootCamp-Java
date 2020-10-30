package Questions.NagarroInterviewPrep;

public class MaxFreqChar {
    public static char getMaxOccuringChar(String str) {

        int[] count = new int[256];

        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }

        int max = -1;
        char res = ' ';

        for (int i = 0; i < str.length(); i++) {
            if (max < count[str.charAt(i)]) {
                max = count[str.charAt(i)];
                res = str.charAt(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "sample string";
        System.out.println("Max occurring character is " +
                getMaxOccuringChar(str));
    }
}
