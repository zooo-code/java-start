package hy.lv2;

import java.util.Scanner;

//https://softeer.ai/practice/7374
public class HyoDo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] toilInt = new int[3][3];


        for(int i = 0 ; i < 3 ;i++){
            String toil = sc.nextLine();
            String[] a = toil.split(" ");
            for (int j = 0 ; j < a.length ; j++){
                toilInt[i][j] = Integer.parseInt(a[j]);
            }
        }
        int min = 10 ;
        for(int i = 1 ; i <= 3 ; i++){
            // 가로를 검사합니다.
            for (int j = 0 ; j < 3 ;j++){
                int rowHap = 0;
                for (int k = 0 ; k < 3 ; k++){
                    int gap = Math.abs(toilInt[j][k] - i);
                    rowHap += gap;
                }
                min = Math.min(min, rowHap);
            }
            //세로를 검사합니다.
            for (int j = 0 ; j < 3 ;j++){
                int colHap = 0;
                for (int k = 0 ; k < 3 ; k++){
                    int gap = Math.abs(toilInt[k][j] - i);
                    colHap += gap;
                }
                min = Math.min(min, colHap);
            }
        }

        System.out.println(min);

    }
}
