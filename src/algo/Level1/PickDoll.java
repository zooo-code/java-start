package algo.Level1;
import java.util.*;
public class PickDoll {

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},
                        {0,0,1,0,3},
                        {0,2,5,0,1},
                        {4,2,4,4,2},
                        {3,5,1,3,1}};

        int[] moves = {1,5,3,5,1,2,1,4};
        int solution = new PickDoll().solution(board, moves);
        System.out.println("solution = " + solution);
    }

    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack =new Stack<>();

        int row = board.length;

        for (int move : moves) {
            int location = move-1;
            int now = 0;
            for(int i = 0 ; i < row ; i++){
                if (board[i][location] != 0){
                    now = board[i][location];
                    board[i][location] = 0;
                    break;
                }
            }

            if (now != 0 && !stack.isEmpty()){
                Integer i = stack.lastElement();
                if (i == now){
                    stack.pop();
                    answer +=2;
                } else{
                    stack.push(now);
                }
            } else if(stack.isEmpty()){
                stack.push(now);
            }

        }


        return answer;
    }
}
