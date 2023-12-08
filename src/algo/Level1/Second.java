package algo.Level1;

import java.lang.reflect.Array;
import java.util.Arrays;
//https://school.programmers.co.kr/learn/courses/30/lessons/142086
public class Second {

    public static void main(String[] args) {
        Second second = new Second();
        String s = "banana";
        int[] solution = second.solution(s);

        System.out.println(Arrays.toString(solution));
    }

    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        //모든 문자열반복을 시작한다.
        //이중 반복문
        char[] chars = s.toCharArray();

        for (int i = 0; i< chars.length; i++ ){
            char a = chars[i];
            int now = -1;
            for (int j = 0 ; j < i ;j++){
                if (a == chars[j]){
                    now = i-j;
                }
            }
            answer[i] = now;
        }

        return answer;
    }
}
