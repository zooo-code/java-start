package algo.basic;

import java.util.Scanner;

public class Four {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        char[] chars = a.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        for(char c : chars){
            if (Character.isUpperCase(c)) {
                char c1 = Character.toLowerCase(c);
                stringBuilder.append(c1);
            }else{
                char c1 = Character.toUpperCase(c);
                stringBuilder.append(c1);
            }
        }
        System.out.println(stringBuilder.toString());
    }
}
