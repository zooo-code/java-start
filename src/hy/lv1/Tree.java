package hy.lv1;

import java.util.Scanner;

//https://softeer.ai/practice/7353
public class Tree {


    // 디테일한 조건 놓치지말자
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력 n 개의 위치
        String N = sc.nextLine();
        int n = Integer.parseInt(N);
        // FI  토양의 비옥한 정도
        String F = sc.nextLine();
        String[] FI = F.split(" ");

        int max = -100000;
        // 이부분 특히
        for(int i = 0 ; i< FI.length-1 ; i++){
            int start = Integer.parseInt(FI[i]);
            for(int j = i+1 ; j < FI.length ; j++ ){
                int nextValue = Integer.parseInt(FI[j]);

                max = Math.max(max,start*nextValue );
            }

        }
        System.out.println(max);


    }


}
