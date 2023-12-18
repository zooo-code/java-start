package algo.Level2.stackQueue;

import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/42586?language=java
public class NewDevelop {

    public static void main(String[] args) {
        NewDevelop newDevelop = new NewDevelop();
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        int[] solution = newDevelop.solution(progresses, speeds);
        System.out.println("solution = " + Arrays.toString(solution));
    }

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> a = new ArrayList<>();
        final int FULL = 100;
        Deque<Integer> queue = new LinkedList<>();
        for(int i = 0; i < progresses.length ; i++){
            int res = FULL - progresses[i];
            int count = res / speeds[i];
            if(res%speeds[i] != 0){
                count++;
            }
            queue.add(count);
        }

        int cnt = 1;
        Integer first = queue.removeFirst();
        while (queue.size() != 0){
            Integer next = queue.removeFirst();
            if (first >= next){
                cnt++;
            }else {
                a.add(cnt);
                cnt = 1;
                first = next;
            }
        }
        a.add(cnt);
        int[] answer = a.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}
