package algo.Level2.DFSBFS;
//https://school.programmers.co.kr/learn/courses/30/lessons/1844?language=java
public class ShortCut {

    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},
                        {1,0,1,0,1},
                        {1,0,1,1,1},
                        {1,1,1,0,1},
                        {0,0,0,0,1}};
        int solution = new ShortCut().solution(maps);
        System.out.println("solution = " + solution);
    }

    public int solution(int[][] maps) {
        int answer = 0;
        return answer;
    }
}
