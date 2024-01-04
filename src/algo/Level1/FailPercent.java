package algo.Level1;
//https://school.programmers.co.kr/learn/courses/30/lessons/42889?language=java
import java.util.*;
//todo 정렬 compare
public class FailPercent {

    public static void main(String[] args) {

        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

        int[] solution = new FailPercent().solution(N, stages);
        System.out.println("solution = " + Arrays.toString(solution));
    }

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int total = stages.length;
        HashMap<Integer,Integer> stageHard= new HashMap<>();
        for (int i = 1; i <= N+1; i++) {
            stageHard.put(i,0);
        }
        //동적으로 게임 시간을 늘려서 난이도를 조절하기로 결정
        for (int stage : stages) {
            stageHard.replace(stage,stageHard.get(stage)+1);
        }
        HashMap<Integer,Float> percents = new HashMap<>();
        //실패율 :스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수/ 스테이지에 도달한 플레이어 수
        for (int i = 0; i <= N+1; i++) {
            int stage = i;
            if (stageHard.containsKey(stage)){
                float percent = (float) stageHard.get(stage)/total;
                percents.put(stage,percent);
                total = total - stageHard.get(stage);
            }
        }

        //전체 스테이지 수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages
        //실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담긴 배열을 return
        List<float[]> a = new ArrayList<>();
        for (Integer integer : percents.keySet()) {
            if(integer == N+1){
                break;
            }
            float[] b = {integer, percents.get(integer)};
            a.add(b);
        }
        a.sort(((o1, o2) -> Float.compare(-o1[1], -o2[1])));

        int count = 0;
        for (float[] floats : a) {
            answer[count] = (int) floats[0];
            count++;
        }
        return answer;
    }
}
