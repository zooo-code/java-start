package algo.Level2.DFSBFS;
//https://school.programmers.co.kr/learn/courses/30/lessons/43165?language=java

import java.util.*;

public class TargetNum {
    static int answer = 0;
    public static void main(String[] args) {

        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        int solution = new TargetNum().solution(numbers, target);
        System.out.println("solution = " + solution);
    }


    public int solution(int[] numbers, int target) {
        dfs(numbers,target,0,0);
        return answer;
    }

    public void dfs(int[] numbers, int target, int idx, int sum){
        if (idx == numbers.length){
            if (sum == target) answer++;
        }else{
            dfs(numbers,target,idx+1,sum+numbers[idx]);
            dfs(numbers,target,idx+1,sum-numbers[idx]);
        }
    }

}
