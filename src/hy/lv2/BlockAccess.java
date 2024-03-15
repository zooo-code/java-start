package hy.lv2;

import java.util.*;

//https://softeer.ai/practice/6282
public class BlockAccess {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[][] roadMap = new String[n][n];
        boolean[][] visited = new boolean[n][n];

        for (int i = 0 ; i < n ;i++){
            String[] wallMap = sc.nextLine().split("");
            roadMap[i] = wallMap;
        }


        int blocks = 0;

        List<Integer> blockCountArrayList = new ArrayList<>();
        for (int i = 0 ; i < n ;i++){
            for (int j= 0 ; j < n ; j++){
                if (roadMap[i][j].equals("1") && visited[i][j] == false){
                    visited[i][j] = true;

                    blocks++;
                    int blockCount = bfs(i,j,visited, roadMap);


                    blockCountArrayList.add(blockCount);
                }
            }

        }
        Collections.sort(blockCountArrayList);
        System.out.println(blocks);
        for(Integer i : blockCountArrayList){
            System.out.println( i);
        }

    }

    public static int bfs(int x, int y, boolean[][] visited, String[][] roadMap){
        int blockCount = 1;
        int n = visited.length;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        Queue<int[]> q = new LinkedList<>();
        int[] xy = {x,y};
        q.offer(xy);
        while(!q.isEmpty()){
            int[] pollXY = q.poll();
            x = pollXY[0];
            y = pollXY[1];
            for(int i = 0 ; i < 4 ; i++){

                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0<= nx && nx < n && 0<= ny && ny <n && visited[nx][ny] == false && roadMap[nx][ny].equals("1")){
                    visited[nx][ny] = true;
                    blockCount++;

                    int[] moveXY= {nx,ny};
                    q.offer(moveXY);
                }

            }
        }


        return blockCount;
    }


}
