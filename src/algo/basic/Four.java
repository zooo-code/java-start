package algo.basic;

import java.util.Scanner;

public class Four {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        char[] chars = a.toCharArray();
        int z = 'Z';
        int aa = 'a';
        System.out.println("aa = " + aa);
        System.out.println("z = " + z);
        for(char c : chars){
            System.out.println( c);
            int b = c;
            System.out.println(b);
        }
    }
}
