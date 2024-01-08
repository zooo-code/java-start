package algo.Level1;
import java.util.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/250125
//todo equals 스트링 비교
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
        int answer;
        int n = board.length;
        int count = 0;
        int[] dh = {0,1,-1,0};
        int[] dw = {1,0,0,-1};
        String color = board[h][w];
        for(int i =0; i <4 ; i++){
            int NowH = h + dh[i];
            int NowW = w +dw[i];
            if(0<= NowH && NowH <n && 0<=NowW &&NowW<n){
                if (board[NowH][NowW].equals(color)){
                    count++;
                }
            }

        }
        System.out.println("count = " + count);
        answer = count;
        return answer;
    }
}
