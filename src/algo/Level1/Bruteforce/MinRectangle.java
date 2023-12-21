package algo.Level1.Bruteforce;


public class MinRectangle {


    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        int solution = new MinRectangle().solution(sizes);
        System.out.println("solution = " + solution);
    }

    public int solution(int[][] sizes) {
        int answer = 0;
        int maxRow = 0;
        int maxCol = 0;
        // 모든 배열을 돌면서 가장 긴 가로와 세로를 찾는다. 일단 가로세로 구분 x
        for(int i = 0 ; i < sizes.length ; i++){
            int[] rec = sizes[i];
            int row = rec[0];
            int col = rec[1];
            if (rec[0] < rec[1]){
                row = rec[1];
                col = rec[0];
            }
            if (maxRow < row){
                maxRow =row;
            }
            if (maxCol < col){
                maxCol = col;
            }
        }
        answer = maxCol* maxRow;
        return answer;
    }


}
