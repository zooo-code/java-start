package algo.Level2;

import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/60057?language=java
public class StringPress {


    public static void main(String[] args) {
        String s = "aabbaccc";
        int solution = new StringPress().solution(s);

        System.out.println("solution = " + solution);
    }

    /**
     * 문자열 압축
     * @param s
     * @return
     */
    public int solution(String s) {
        int answer = s.length();
        int count = 1;
        /**
         * 어떤 방식으로 압축을 진행해야할까?
         * 반복되는 문자를 활용하자.
         * 자르는 단위의 숫자를 1,2,3 ... s.length() 까지 늘려가며 진행해보자.
         */

        int length = s.length();

        for (int i = 1; i <= length/2 ; i++){
            StringBuilder stringBuilder = new StringBuilder();
            String substring = s.substring(0, i);
            for (int j = i; j <= length ;j +=i ){
                int endIdx = Math.min(j +i ,s.length());// 인덱스의 길이를 넘을 수 없음
                String compare = s.substring(j,endIdx);
                if (substring.equals(compare)){
                    count++;
                } else{
                    if(count >= 2){
                        stringBuilder.append(count);
                    }
                    stringBuilder.append(substring);
                    substring = compare;
                    count = 1;
                }
            }
            stringBuilder.append(substring);
            answer = Math.min(answer, stringBuilder.length());


        }


        return answer;
    }
}
