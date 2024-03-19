package hy.lv2;

import java.util.*;

//https://softeer.ai/practice/7628
public class YeonTanBig {

    public static void main(String[] args) {
        //n 개의 집에 각각 놓여 있는 난로의 반지름의 길이가 주어짐 -> 연탄의 반지름 길이를 잘 설정 -> 최대한 많은 집에서 이 연탄을 사용할 수 있도록
        // 난로의 반지름의 길이가 연탄의 반지름의 길이의 배수인 집만 사용 가능
        // 단, 연탄의 반지름은 1보다 커야함
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        // 각 집 난로 반지름 길이
        String[] homeR = sc.nextLine().split(" ");
        int[] homeRInt = new int[homeR.length];
        for (int i = 0; i < homeR.length ; i++){
            homeRInt[i] = Integer.parseInt(homeR[i]);
        }
        Arrays.sort(homeRInt);
        // 연탄 사용이 가능한 최대의 집수 출력
        int answer = 0;
        for (int i = 2; i <= homeRInt[homeRInt.length -1]; i++ ){
            int hap = 0;
            for (int j = 0 ; j < homeRInt.length ; j++){
                if (homeRInt[j] >= i && (homeRInt[j] % i) == 0 ) {
                    hap += 1;
                }
            }
            answer = Math.max(answer, hap);
        }


        System.out.println(answer);
    }
}
