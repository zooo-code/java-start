package algo.Level1.greedy;
//https://school.programmers.co.kr/learn/courses/30/lessons/42862?language=java
import java.util.*;
//반례입니다.
//입력값 〉 5, [4, 5], [3, 4]
//기댓값 〉 4
public class GymSuit {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {4, 5};
        int[] reserve = {3, 4};

        GymSuit gymSuit = new GymSuit();
        int solution = gymSuit.solution(n, lost, reserve);

        System.out.println(solution);
    }

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        Arrays.sort(reserve);
        Arrays.sort(lost);

        boolean[] checkReserve = new boolean[reserve.length];
        boolean[] checkHave = new boolean[lost.length];
        for(int i = 0 ; i < lost.length ; i++){
            for(int j = 0 ; j < reserve.length ; j++){
                if (lost[i] == reserve[j] && checkReserve[j]== false){
                    checkReserve[j] =true;
                    checkHave[i] =true;
                    answer++;
                    break;
                }
            }
        }
        System.out.println("answer = " + answer);
        System.out.println("checkReserve = " + Arrays.toString(checkReserve));
        for(int i = 0 ; i < lost.length ; i++){
            for(int j = 0 ; j < reserve.length ; j++){
                if ((lost[i] == reserve[j] -1 ||lost[i] == reserve[j] +1) && checkReserve[j]==false && checkHave[i] == false){
                    System.out.println("checkReserve = " + Arrays.toString(checkReserve));
                    checkReserve[j] =true;
                    checkHave[i] = true;
                    System.out.println("lost[i] = " + lost[i] + " reserve = "+ reserve[j]);
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}
