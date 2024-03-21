package recent.hy.lv2;

import java.util.Scanner;

public class MakeMap {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int start = 2;

        for(int i = 1 ; i <= N; i++){
            start += (int) Math.pow(2,i-1);
        }

        System.out.println(start* start);
    }
}
