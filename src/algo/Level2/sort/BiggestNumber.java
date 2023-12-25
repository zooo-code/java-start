package algo.Level2.sort;
//https://school.programmers.co.kr/learn/courses/30/lessons/42746?language=java
import java.util.*;
//todo : sort compareTo 사전 순 비교
public class BiggestNumber {

    public static void main(String[] args) {

        int[] numbers = {6, 10, 2};
        String solution = new BiggestNumber().solution(numbers);
        System.out.println("solution = " + solution);
    }

    public String solution(int[] numbers) {

        String[] str = new String[numbers.length];
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0 ; i<numbers.length; i++){
            String s = Integer.toString(numbers[i]);
            str[i] = s;
        }
        Arrays.sort(str,(a,b) ->(b+a).compareTo(a+b));
        if (str[0].equals("0")) return "0";

        for (String s : str) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
}
