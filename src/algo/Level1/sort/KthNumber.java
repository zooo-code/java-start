package algo.Level1.sort;
//https://school.programmers.co.kr/learn/courses/30/lessons/42748?language=java
import java.util.*;

import java.util.stream.*;

public class KthNumber {

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands ={{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] solution = new KthNumber().solution(array, commands);
        System.out.println(Arrays.toString(solution));
    }
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0 ; i < commands.length ; i++){
            int start = commands[i][0];
            int end = commands[i][1];
            int index = commands[i][2];
            ArrayList<Integer> IntArr = new ArrayList<>(end+1 -start);
            for (int j = start-1; j < end; j++ ){
                IntArr.add(array[j]);
            }
            List<Integer> collect = IntArr.stream().sorted().collect(Collectors.toList());
            Integer integer = collect.get(index - 1);
            answer[i] = integer;
        }

        return answer;
    }
    public int[] solution2(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
    }
}
