package recent.lv2;

import java.util.ArrayList;
import java.util.List;

//https://school.programmers.co.kr/learn/courses/30/lessons/42586?language=java
public class DevelopMethod {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        // 남은 작업이 얼마나 남은지 각 진도마다 구하자.
        int[] work = new int[progresses.length];

        for(int i = 0; i < progresses.length ; i++){
            int res = 100 - progresses[i];
            int resDay = res / speeds[i];
            int resPro = res % speeds[i];
            if (resPro != 0){
                resDay++;
            }
            work[i] = resDay;
        }


        int nowWork = work[0];
        int cnt = 1;
        List<Integer> ls = new ArrayList<>();
        for(int i =1 ; i < work.length ; i++){

            if (nowWork < work[i]){
                ls.add(cnt);
                cnt = 1;
                nowWork = work[i];
            } else{
                cnt++;
            }
        }
        ls.add(cnt);

        answer = new int[ls.size()];

        for (int i = 0 ; i < ls.size() ; i++){
            answer[i] = ls.get(i);
        }
        return answer;
    }

}
