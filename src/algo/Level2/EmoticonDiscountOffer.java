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

        int[] answer;
        list = new ArrayList<>();
        List<int[]> result = new ArrayList<>();
        com(0, emoticons.length, 0, new int[emoticons.length]);
        // 위의 메서드를 마치면 리스트에 모든 경우의 할인율이 저장된다.
        list.forEach(a -> System.out.println("a = " + Arrays.toString(a)));

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
        // 리스트를 소팅한다. 대전제 자바의 배열은 기본적으로 오름차순이다. 이제 두 배열을 비교할것이다.
        result.sort((o1, o2) -> {
            //두배열의 첫번째 인덱스 값이 같다면 뒤의 값을 기준으로 배열을 정렬하고,
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            } else {
                // 같지 않다면, 배열에 있는 [0] 번째 인덱스를 기준으로 음수이면 그대로 두고 결과가 양수이면 배열의 순서를 바꿔준다.
                return o2[0] - o1[0];
            }
        });

        result.forEach(b -> System.out.println("b = " + Arrays.toString(b)));
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
