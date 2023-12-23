package algo.Level2.stackQueue;
//https://school.programmers.co.kr/learn/courses/30/lessons/42587?language=java
import java.util.*;

public class Process {

    public static void main(String[] args) {
        Process process = new Process();
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        int solution = process.solution(priorities, location);
        System.out.println("solution = " + solution);
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int num : priorities) {
            pq.add(num);
        }
        while(!pq.isEmpty()) {
            for(int i=0; i<priorities.length; i++) {
                if(priorities[i] == pq.peek()) {
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
