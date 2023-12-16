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
        HashMap<String,HashSet> sinGOName = new HashMap<>();
        HashMap<String,HashSet> bySinGO = new HashMap<>();
        for(String s : id_list){
            sinGoCount.put(s,0);
            sinGOName.put(s,new HashSet<String>());
            bySinGO.put(s,new HashSet<String>());
        }

        for(String s : report){
            String[] split = s.split(" ");
            sinGOName.get(split[0]).add(split[1]);
            bySinGO.get(split[1]).add(split[0]);

        }
        System.out.println("sinGOName = " + sinGOName);
        System.out.println("bySinGO = " + bySinGO);
        for(String s : id_list){
            if (bySinGO.get(s).size() >=k){
                System.out.println("bySinGO = " +s +" "+ bySinGO.get(s));
                HashSet<String> hashSet = bySinGO.get(s);
                for (String value : hashSet) {
                    sinGoCount.replace(value,sinGoCount.get(value)+1);
                }
            }

        }
        System.out.println("sinGoCount = " + sinGoCount);
        int count = 0;
        for (String s : id_list) {
            Integer integer = sinGoCount.get(s);
            answer[count] = integer;
            count++;
        }
        System.out.println("sinGoCount = " + sinGoCount);
        return answer;
    }
}
