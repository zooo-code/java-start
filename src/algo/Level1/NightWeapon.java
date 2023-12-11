package algo.Level1;

import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/136798
public class NightWeapon {


    public static void main(String[] args) {
        int number = 5;
        int limit = 3;
        int power = 2;
        NightWeapon nightWeapon = new NightWeapon();
        int solution = nightWeapon.solution(number, limit, power);
        System.out.println(solution);
    }
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for (int i = 1 ; i <= number ; i++){
            int cnt = 0;
            for (int j= 1 ; j*j <= i ; j++){
                if (j*j ==i ){
                    cnt++;
                }else if(i%j == 0) {
                    cnt+=2;
                }
            }
            if (cnt > limit){
                cnt = power;
            }
            answer+= cnt;
        }
        return answer;
    }
}
