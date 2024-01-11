package algo.Level2;

import java.util.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/150368?language=java

public class EmoticonDiscountOffer {

    public static void main(String[] args) {
        int[][] users = {{40, 10000},{25, 10000}};
        int[] emoticons ={7000,9000};
        int[] solution = new EmoticonDiscountOffer().solution(users, emoticons);

        System.out.println("solution = " + Arrays.toString(solution));
    }
    static List<int[]> list;
    static int[] dis = new int[] {10,20,30,40};
    public int[] solution(int[][] users, int[] emoticons) {

        int[] answer = new int[2];
        list = new ArrayList<>();
        List<int[]> result = new ArrayList<>();
        com(0, emoticons.length, 0, new int[emoticons.length]);

        int cnt = 0;
        while (cnt < list.size()) {
            int userPlus = 0;
            int userSum = 0;

            for (int i = 0; i < users.length; i++) {
                int sum = 0;
                int[] discount = list.get(cnt);
                for (int j = 0; j < emoticons.length; j++) {
                    if (users[i][0] <= discount[j]) {
                        sum += emoticons[j] - emoticons[j] * discount[j] / 100;
                    }
                }
                if (sum >= users[i][1]) {
                    userPlus++;
                    sum = 0;
                }
                userSum += sum;
            }

            cnt++;
            result.add(new int[]{userPlus, userSum});
        }

        result.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            } else {
                return o2[0] - o1[0];
            }
        });


        answer = result.get(0);

        return answer;
    }

    public void com(int idx, int size, int depth, int[] arr) {
        if (size == depth) {
            int[] temp = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                temp[i] = arr[i];
            }
            list.add(temp);
            return;
        }

        for (int i = 0; i < 4; i++) {
            arr[idx] = dis[i];
            com(idx + 1, size, depth + 1, arr);
        }
    }
}
