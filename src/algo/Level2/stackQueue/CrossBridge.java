package algo.Level2.stackQueue;
//https://school.programmers.co.kr/learn/courses/30/lessons/42583?language=java
import java.util.*;

public class CrossBridge {

    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};
        int solution = new CrossBridge().solution(bridge_length, weight, truck_weights);
        System.out.println("solution = " + solution);
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Integer> queue = new LinkedList<>();
        int sum =0 ;
        int time = 0;
        for (int i = 0 ; i < truck_weights.length;i++){
            int truck = truck_weights[i];
            while (true){
                if(queue.isEmpty()){
                    queue.add(truck);
                    sum+= truck;
                    time++;
                    break;
                }else if( queue.size() == bridge_length){
                    sum -= queue.poll();
                }else {
                    if (sum+truck <=weight){
                        queue.offer(truck);
                        sum+= truck;
                        time++;
                        break;
                    }else {
                        queue.add(0);
                        time++;
                    }
                }
            }
        }

        return time+bridge_length;
    }
}
