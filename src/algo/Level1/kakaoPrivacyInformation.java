package algo.Level1;

import java.util.*;


//https://school.programmers.co.kr/learn/courses/30/lessons/150370?language=java
public class kakaoPrivacyInformation {


    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        List<Integer> solution = new kakaoPrivacyInformation().solution(today, terms, privacies);
        System.out.println(solution);
    }
    public List<Integer> solution(String today, String[] terms, String[] privacies) {

        List<Integer> answer = new ArrayList<>();
        HashMap<String,Integer> promise =new HashMap<>();
        for(String term :terms){
            String[] s = term.split(" ");
            promise.put(s[0],Integer.valueOf(s[1]));
        }
        int count = 1;
        String[] split1 = today.split("\\.");
        int yearDay = Integer.parseInt(split1[0]) *12* 28 ;
        int monthDay = Integer.parseInt(split1[1])*28;
        int day = Integer.parseInt(split1[2]);
        int totalToday = yearDay +monthDay+day;

        for(String privacy :privacies){
            String[] s = privacy.split(" ");
            String[] split = s[0].split("\\.");
            Integer integer = promise.get(s[1]);
            int privacyYearDay = Integer.parseInt(split[0]) *12* 28 ;
            int privacyMonthDay = Integer.parseInt(split[1])*28;
            int privacyDay = Integer.parseInt(split[2]);
            int privacyTotalToday = privacyYearDay +privacyMonthDay+privacyDay +(integer*28);

            if (privacyTotalToday <= totalToday){
                answer.add(count);
            }
            count++;
        }

        return answer;
    }
}
