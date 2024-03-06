package algo.Level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://school.programmers.co.kr/learn/courses/30/lessons/178870
public class hapContinue {


    public static void main(String[] args) {
        int[] a = {1, 1, 1, 2, 3, 4, 5};
        int k = 5;
        int[] solution = solution(a, k);
        System.out.println("solution = " + Arrays.toString(solution));
    }
    public static int[] solution(int[] sequence, int k) {
        int[] answer = {0,0};
        int gap = 10000000;

        //모든 루프를 돌면서 계산한다.
        for(int i = 0 ; i < sequence.length ; i++){
            int sum = 0;
            for(int j = i ; j < sequence.length ; j++){
                // j = i
                sum += sequence[j];
                if (sum == k){
                    if (gap > (j-i)){
                        gap = Math.min(gap, j - i);
                        answer[0] = i;
                        answer[1] = j;
                        if (gap==0 || gap ==1){
                            return answer;
                        }
                    }
                }
            }
        }

        return answer;
    }


    public static int[] test(int[] sequence, int k) {
        int[] answer = {0,0};
        int gap = 10000000;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>(); // 누적 합을 저장할 맵

        // 누적 합을 계산하면서 최소 길이의 구간을 찾는다.
        for (int i = 0; i < sequence.length; i++) {
            sum += sequence[i];

            // 현재까지의 누적 합이 k인 경우
            if (sum == k) {
                gap = Math.min(gap, i + 1); // 현재 인덱스까지의 길이를 계산하여 갱신
                answer[0] = 0;
                answer[1] = i;
            }

            // (현재까지의 누적 합 - k)가 맵에 존재하는 경우
            if (map.containsKey(sum - k)) {
                int startIndex = map.get(sum - k); // 해당 누적 합의 시작 인덱스
                int length = i - startIndex; // 현재 인덱스와 시작 인덱스의 차이가 길이가 됨

                // 현재까지의 길이가 더 짧은 경우에만 갱신
                if (gap > length) {
                    gap = length;
                    answer[0] = startIndex + 1;
                    answer[1] = i;
                }
            }

            // 현재까지의 누적 합을 맵에 저장
            if (!map.containsKey(sum))
                map.put(sum, i);
        }

        return answer;
    }

}
