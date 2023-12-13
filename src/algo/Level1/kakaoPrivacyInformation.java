package algo.Level1;

import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/150370?language=java
public class kakaoPrivacyInformation {


    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        int[] solution = new kakaoPrivacyInformation().solution(today, terms, privacies);
        System.out.println(Arrays.toString(solution));
    }
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        return answer;
    }
}
