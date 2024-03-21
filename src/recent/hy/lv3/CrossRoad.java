package recent.hy.lv3;

import java.util.*;

//https://softeer.ai/practice/6256
public class CrossRoad {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        Map<Integer, Queue<String>> roadMap = new HashMap<>();

        String[] road = {"A","B","C","D"};

        // 도로 셋팅
        for(int i = 0 ; i < N ; i++){

            String[] roadNameTime = sc.nextLine().split(" ");

            int time = Integer.parseInt(roadNameTime[0]);
            String roadName = roadNameTime[1];

            roadMap.put(time,new LinkedList<>());

            Queue<String> strings = roadMap.get(time);
            strings.add(roadName);
            ArrayList<Object> objects = new ArrayList<>();
        }

        // A ->D , D-> C ,C -> B , B -> A

    }
}
