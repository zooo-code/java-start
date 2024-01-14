package algo.Level1;
//https://school.programmers.co.kr/learn/courses/30/lessons/250137
import java.util.*;
public class Bandage {

    public static void main(String[] args) {
        Bandage bandage = new Bandage();

        int[] bandages = {5, 1, 5};
        int health = 30;
        int[][] attacks ={{2, 10},{9, 15},{10, 5},{11, 5}};
        int solution = bandage.solution(bandages, health, attacks);
        System.out.println("solution = " + solution);

    }

    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        return answer;
    }
}
