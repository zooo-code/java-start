package recent.hy.lv1;

import java.util.Scanner;

//https://softeer.ai/practice/6295
public class APlusB {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 1 ; i <= n ;i++){
            String[] numList = sc.nextLine().split(" ");
            int num1 = Integer.parseInt(numList[0]);
            int num2 = Integer.parseInt(numList[1]);

            int hap = num1 + num2;

            System.out.println("Case "+"#"+i+": "+hap);
        }
    }
}
