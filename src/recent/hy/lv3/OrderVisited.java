package recent.hy.lv3;
import java.io.*;
import java.util.*;

class Point {
    int x;
    int y;

    public Point(int x , int y){
        this.x = x;
        this.y = y;
    }
    public boolean equals(Point other){

        return this.x == other.x && this.y == other.y;
    }

}
public class OrderVisited {
    public static int[] dx ={0,0,-1,1};
    public static int[] dy ={1,-1,0,0};
    public static Point[] path;
    public static int cnt = 0;
    public static int m;
    public static int n;
    public static boolean[][] visited;
    public static int[][] board;

    public static void main(String[] args) {
        // 차량이 이동 가능한 시나리오

        Scanner sc = new Scanner(System.in);

        // 차량이 이동 가능한 서론 다른 가지 수를 구하는 프로그램을 작성
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n][n];
        visited = new boolean[n][n];
        for(int i = 0 ; i < n ;i++){

            for(int j = 0 ; j < n ; j++){
                board[i][j] = sc.nextInt();
            }
        }
        // for(int[] b : board){
        //     System.out.println(Arrays.toString(b));
        // }
        path = new Point[m];
        for (int i = 0 ; i < m ; i++){
            path[i] = new Point( sc.nextInt() -1,sc.nextInt() -1) ;
        }
        // for(int[] p : path){
        //     System.out.println(Arrays.toString(p));
        // }

        // 각 경로마다 새로운 방문 확인 map 을 주면됨
        int nextIdx = 1;
        dfs(path[0], nextIdx);
        System.out.println(cnt);
    }

    public static void dfs(Point now , int nextIdx){
        if(now.equals(path[nextIdx])){
            if(nextIdx == m-1){
                cnt++;
                return;
            }
            nextIdx++;
        }
        int x = now.x;
        int y = now.y;
        visited[x][y] = true;
        for(int i = 0 ; i < 4 ;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if( 0<=nx && nx < n && 0<=ny && ny < n && visited[nx][ny] == false && board[nx][ny] ==0){
                dfs(new Point(nx,ny) , nextIdx);
            }

        }
        visited[x][y] = false;
    }

}
