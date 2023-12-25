package algo.Level2.stackQueue;
//https://school.programmers.co.kr/learn/courses/30/lessons/42587?language=java
import java.util.*;
//todo : 다시 보기

public class Process {

    public static void main(String[] args) {
        Process process = new Process();
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        int solution = process.solution(priorities, location);
        System.out.println("solution = " + solution);
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int num : priorities) {
            pq.add(num);
        }
        System.out.println("pq = " + pq);
        while(!pq.isEmpty()) {
            for(int i=0; i<priorities.length; i++) {
                System.out.println("priorities = " + priorities[i]);
                if(priorities[i] == pq.peek()) {
                    System.out.println("pq.peek() = " + pq.peek());
                    pq.poll();
                    answer++;
                    if(i == location)
                        return answer;
                }
            }
        }

        return answer;
    }
}
