package algo.basic;

import java.util.Scanner;

public class Three {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        StringBuilder stringBuilder = new StringBuilder();
        int a = sc.nextInt();
        for (int i = 0 ; i < a ; i++){
            stringBuilder.append(str);
        }
        System.out.println(stringBuilder.toString());
    }
}
