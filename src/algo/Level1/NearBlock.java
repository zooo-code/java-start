package algo.Level1;

//https://school.programmers.co.kr/learn/courses/30/lessons/250125
public class NearBlock {
    public static void main(String[] args) {
        String[][] board = {{"blue", "red", "orange", "red"},
                    {"red", "red", "blue", "orange"},
                    {"blue", "orange", "red", "red"},
                    {"orange", "orange", "red", "blue"}};
        int h = 1;
        int w = 1;
        int solution = new NearBlock().solution(board, h, w);
        System.out.println("solution = " + solution);
    }


    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        return answer;
    }
}
