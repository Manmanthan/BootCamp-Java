package Recursion;

import java.util.*;
public class countPermutations {
    static Set<String> hash_Set = new HashSet<>();

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String str=s.nextLine();
        printP(str,"");
        List<String> list = new ArrayList<String>(hash_Set);
        Collections.sort(list);
        list.forEach((n) -> System.out.println(n));
    }

    public static void printP(String str,String res) {
        if(str.length()==0) {
            hash_Set.add(res);
            return;
        }

        for(int i=0;i<str.length();i++) {
            char cc=str.charAt(i);
            String ros=str.substring(0,i)+str.substring(i+1);
            printP(ros, res+cc);
        }
    }

}