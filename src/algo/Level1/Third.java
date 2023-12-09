package algo.Level1;
//https://school.programmers.co.kr/learn/courses/30/lessons/134240
public class Third {


    public static void main(String[] args) {
        int[] food = {1,3,4,6};
        String solution = new Third().solution(food);
        System.out.println(solution);
    }


    public String solution(int[] food) {
        String answer = "";
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1 ; i< food.length ; i++ ){
            if (food[i]%2 == 0){
                int a = food[i]/2;
                for (int j = 0 ; j < a ; j ++){
                    stringBuilder.append(i);
                }
            } else if (food[i] >1 && food[i]%2==1) {
                int a = food[i]/2;
                for (int j = 0 ; j < a ; j ++){
                    stringBuilder.append(i);
                }
            }
        }
        StringBuilder c = new StringBuilder(stringBuilder);

        StringBuilder b = stringBuilder.reverse();
        answer = c+ "0"+b;
        return answer;
    }
}
