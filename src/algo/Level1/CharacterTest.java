package algo.Level1;
import java.util.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/118666
public class CharacterTest {


    public static void main(String[] args) {
        CharacterTest characterTest = new CharacterTest();
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices ={5, 3, 2, 7, 5};
        String solution = characterTest.solution(survey, choices);
        System.out.println("solution = " + solution);
    }

    public String solution(String[] survey, int[] choices) {

        HashMap<String, Integer> character = new HashMap<>();
        String[] chs = {"RT","CF","JM","AN"};
        for (String s : chs) {
            String[] split = s.split("");
            character.put(split[0],0);
            character.put(split[1],0);
        }

        for(int i = 0 ; i<survey.length; i++){
            String[] split = survey[i].split("");
            int choice = choices[i];
            if (choice>4){
                String s = split[1];
                character.replace(s,character.get(s) + (choice - 4));
            }else if(choice<4){
                String s = split[0];
                character.replace(s,character.get(s) + (4 - choice));
            }
        }
        StringBuilder s = new StringBuilder();
        for(String ch :chs){
            String[] split = ch.split("");
            Integer integer = character.get(split[0]);
            Integer integer1 = character.get(split[1]);
            if (integer>integer1){
                s.append(split[0]);
            } else if (integer == integer1) {
                s.append(split[0]);
            }else{
                s.append(split[1]);
            }
        }

        String answer = s.toString();
        return answer;
    }

}
