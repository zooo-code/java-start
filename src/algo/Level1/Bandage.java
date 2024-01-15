package algo.Level1;
//https://school.programmers.co.kr/learn/courses/30/lessons/250137
import java.util.*;
public class Bandage {

    public static void main(String[] args) {
        Bandage bandage = new Bandage();

        int[] bandages = {1, 1, 1};
        int health = 5;
        int[][] attacks ={{1, 2},{3, 2}};
        int solution = bandage.solution(bandages, health, attacks);
        System.out.println("solution = " + solution);

    }

    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int maxHealth = health;
        //bandage ={기술 시전 시간, 1초당 회복량, 추가 회복량}
        int count = 0; //붕대감기 연속수
        int lastRow = attacks.length - 1;
        int attackTime = attacks[lastRow][0];
        HashMap<Integer, Integer> attackMap = new HashMap<>();
        for (int[] attack : attacks) {
            attackMap.put(attack[0],attack[1]);
        }
        int attackDamage = 0;
        for(int i = 1 ; i <= attackTime ;i++){
            // 이번 턴에 공격이 있다면 공격 데미지를 받고 다음 턴으로 간다.
            if (attackMap.containsKey(i)){
                attackDamage = attackMap.get(i);
                health -= attackDamage;
                if (health <= 0){
                    return -1;
                }
                System.out.println("health 123= " + health);
                count =0;
                continue;
            }
            count++;
            //만약에 연속 성공하면 count == bandage[0] 추가 에너지를 받는다.
            if (count == bandage[0]){
                if (health + bandage[2] > maxHealth){
                    health = maxHealth;
                }else {
                    health += bandage[2];
                }
                count = 0;
            }
            //아무일도 없으면 그냥 에너지를 채운다.
            if (health + bandage[1]> maxHealth){
                health = maxHealth;
            } else{
                health += bandage[1];
            }
            System.out.println("health = " + health);

        }
        answer = health;
        return answer;
    }

}
