package algo.Level1;

import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/92334
public class sinGO {
    public static void main(String[] args) {

        sinGO sinGO = new sinGO();
        String[] idList = {"muzi", "frodo", "apeach", "neo"};
        String[] report={"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        int[] solution = sinGO.solution(idList, report, k);
        System.out.println("solution = " + Arrays.toString(solution));
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String,Integer> sinGoCount =new HashMap<>();
        HashMap<String,Set> sinGOName = new HashMap<>();
        for(String s : id_list){
            sinGoCount.put(s,0);
            sinGOName.put(s,new HashSet<String>());
        }

        for(String s : report){
            String[] split = s.split(" ");
            sinGoCount.replace(split[0],sinGoCount.get(split[0])+1);

            sinGOName.get(split[0]).add(split[1]);
            System.out.println("sinGOName = " + sinGOName);
            System.out.println("sinGoCount = " + sinGoCount);
        }
        for(String s : id_list){
            String[] split = s.split(" ");
            if (sinGoCount.get(split[0]) >=k){
                Set set = sinGOName.get(split[0]);


            }
        }

        return answer;
    }
}
