package recent.hy.lv3;

import java.util.*;

//https://softeer.ai/practice/6255
public class PlayPassword {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String abc = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
        String[] message = sc.nextLine().split("");
        String key = sc.nextLine()+ abc;

        String[] keyabc = key.split("");
        // 두글자 단위로 암호화 진행
        // 문자열 키가 필요
        // 키를 한글자씩 채운다.
        // 이전에 봤던 알파벳이 한번 더 등장하면 무시하고 다음 들자를 보면된다.
        // 1. 일단 5*5 를 채우는 과정이 필요
        Set<String> set = new LinkedHashSet<>(Arrays.asList(keyabc)); // 중복 제거
        String[] keySet =  set.toArray(new String[0]); // 배열로 변환하여 반환
        String[][] board = new String[5][5];

        Map<String,int[]> mapBoard = new HashMap<>();

        for(int i = 0; i < keySet.length ; i++ ){
            board[i/5][i%5] = keySet[i];
            mapBoard.put(keySet[i], new int[]{i/5,i%5});
        }

        // 암호화 두글자씩 나눈다.
        // 같은 두글자로 이루어진 쌍이 생기면 중간에 다른 글자를 넣어 쌍을 파괴한다.
        // 그 후 새롭게 쌍을 구성한다.
        StringBuilder br = new StringBuilder();
        for(int i = 0 ; i < message.length ; i++){
            String first;
            String second;
            if (i == message.length -1){
                first = message[i];
                second = "X";
            } else{
                first = message[i];
                second = message[i+1];
                if (first.equals(second)){

                    if(first.equals("X")){
                        second = "Q";
                    } else{
                        second = "X";
                    }
                } else{
                    i++;
                }
            }

            // 쌍을 만든 두 글자를 암호화
            // 1. 두글자가 표에서 샅은 행에 존재하는 경우 -> 오른쪽으로 한칸 이동한 클자 암호화
            // 2. 1. 만족 x 두글자가 같은 열에 존재하는 경우 -> 아래쪽으로 한칸 이동 암호화
            // 3. 1. 2. 만족 x 두글자 표에서 서로 다른행, 열에 존재하면, -> 두글자가 위치하는 칸의 열이 서로 교환된 위치에 적힌 글자로 암호


            int[] firstMap = mapBoard.get(first);
            int fRow = firstMap[0];
            int fCol = firstMap[1];
            int[] secondMap = mapBoard.get(second);
            int sRow = secondMap[0];
            int sCol = secondMap[1];



            if (firstMap[0] == secondMap[0]){
                fCol = (firstMap[1] + 1) % 5;
                sCol = (secondMap[1] + 1) %5;
            } else if(firstMap[1] == secondMap[1]){
                fRow = (firstMap[0]+1) %5;
                sRow = (secondMap[0]+1) %5;

            } else{
                int temp = firstMap[1];

                fCol = secondMap[1];
                sCol = temp;

            }
            String passOne = board[fRow][fCol];
            String passTwo = board[sRow][sCol];

            br.append(passOne).append(passTwo);
        }

        System.out.println(br.toString());

    }
}
