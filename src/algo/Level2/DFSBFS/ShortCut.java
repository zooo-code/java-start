package algo.Level2.DFSBFS;
//https://school.programmers.co.kr/learn/courses/30/lessons/1844?language=java
import java.util.*;

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
        int answer;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        boolean[][] check = new boolean[maps.length][maps[0].length];
        int[] start= {0,0};
        check[0][0] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            for (int i = 0 ; i < 4 ; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0<=nx && nx< maps.length && 0<=ny && ny <maps[0].length && maps[nx][ny]==1 && !check[nx][ny]){
                    queue.offer(new int[]{nx, ny});
                    check[nx][ny] = true;
                    if (maps[nx][ny] ==1){
                        maps[nx][ny] = maps[x][y] +1;
                    } else if (maps[nx][ny] > maps[x][y]+1){
                        maps[nx][ny] = maps[x][y] +1;
                    }
                }
            }
        }
        if (maps[maps.length-1][maps[0].length-1] == 1 )return -1;

        answer = maps[maps.length-1][maps[0].length-1];

        return answer;
    }


}
