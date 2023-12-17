package algo.Level1.stackQueue;

import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/12906
public class IDontLikeSameNumber {

    public static void main(String[] args) {
        IDontLikeSameNumber iDontLikeSameNumber = new IDontLikeSameNumber();
        int[] arr = {1,1,3,3,0,1,1};
        int[] solution = iDontLikeSameNumber.solution(arr);
        System.out.println("solution = " + solution);
    }
    public int[] solution(int []arr) {

        Stack<Integer> stack = new Stack<>();
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.

        for (int a : arr){
            if (stack.size() == 0){
                stack.add(a);
                continue;
            }
            Integer peek = stack.peek();
            if (peek == a){
                continue;
            }
            stack.add(a);
        }
        int[] answer = new int[stack.size()];

        ArrayList<Integer> arrayList = new ArrayList<>();

        int[] ints = stack.stream().mapToInt(i -> i).toArray();

        return ints;
    }
}
