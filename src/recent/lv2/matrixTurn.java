package recent.lv2;

//https://school.programmers.co.kr/learn/courses/30/lessons/77485
public class matrixTurn {

    public int[] solution(int rows, int columns, int[][] queries) {

        int[][] board = new int[rows][columns];
        int cnt = 1;
        for (int i = 0; i < rows ; i ++){
            for (int j = 0 ; j < columns ; j++){
                board[i][j] = cnt;
                cnt++;
            }
        }
        // for (int i = 0; i < rows ; i ++){
        //     System.out.println(Arrays.toString(board[i]));
        // }
        int[] answer = new int[queries.length];
        for(int i = 0; i < queries.length ; i++){
            int lowNum = moveBoardAndGetLowNum(board,  queries[i]);
            answer[i] = lowNum;

        }

        return answer;
    }

    // 들어온 데이터를 변환 , 문제를 쪼개서
    public int moveBoardAndGetLowNum(int[][] board, int[] queries){

        int x1 = queries[0] -1;
        int y1 = queries[1] -1;
        int x2 = queries[2] -1;
        int y2 = queries[3] -1;
        int firstNum = board[x1][y2];

        int minNum = firstNum;

        // 가장 윗행
        for (int i = y2-1 ; y1 <= i ; i--){
            minNum = Math.min(board[x1][i],minNum);
            board[x1][i+1] = board[x1][i];
        }

        // 좌측열 y1 고정
        for(int i = x1+1 ;  i <= x2  ; i++ ){
            minNum = Math.min(board[i][y1],minNum);
            board[i-1][y1] = board[i][y1];
        }

        // 하단 행 x2 고정
        for (int i = y1+1 ; i <= y2 ;i++){
            minNum = Math.min(board[x2][i],minNum);
            board[x2][i-1] = board[x2][i];
        }

        // 우측 열 y2
        for (int i = x2-1 ; x1 <= i  ;i--){
            minNum = Math.min(board[i][y2],minNum);
            board[i+1][y2] = board[i][y2];
        }

        board[x1+1][y2] = firstNum;

        return minNum;

    }
}
