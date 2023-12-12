package algo.Level1;

import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/135808
public class FruitMarket {


    public static void main(String[] args) {
        int k = 3;
        int m = 4;
        int[] score = {1,2,3,1,2,3,1};

        FruitMarket fruitMarket = new FruitMarket();
        int solution = fruitMarket.solution(k, m, score);
        System.out.println(solution);
    }

    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int[] ints = Arrays.stream(score).sorted().toArray();
        System.out.println(Arrays.toString(ints));
        int count = 0;
        for (int i = score.length -1 ; i>=0 ; i--){
            System.out.println(ints[i]);
            count++;
            if (count==m){
                answer += ints[i] * m;
                count = 0;
            }
        }


        return answer;
    }
}
