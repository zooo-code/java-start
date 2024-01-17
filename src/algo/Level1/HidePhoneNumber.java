package algo.Level1;
//https://school.programmers.co.kr/learn/courses/30/lessons/12948

import java.util.*;

public class HidePhoneNumber {


    public static void main(String[] args) {

        String phone_number = "01033334444";

        String solution = new HidePhoneNumber().solution(phone_number);
        System.out.println("solution = " + solution);
    }

    public String solution(String phone_number) {

        char[] charArray = phone_number.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        int length = charArray.length;
        for (int i = 0; i < length ;i++){
            if (i < length -4){
                stringBuilder.append("*");
            } else{
                stringBuilder.append(charArray[i]);
            }
        }
        return stringBuilder.toString();
    }
}
