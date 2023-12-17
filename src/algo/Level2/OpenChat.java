package algo.Level2;


import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/42888
public class OpenChat {

    public static void main(String[] args) {

        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String[] solution = new OpenChat().solution(record);
        System.out.println("solution = " + Arrays.toString(solution));
    }

    public String[] solution(String[] record) {

        HashMap<String, User> stringUserHashMap = new HashMap<>();
        ArrayList<UserRecord> records = new ArrayList<>();
        for(String r : record){
            String[] s = r.split(" ");
            if (s[0].equals("Enter")){
                String state = "not Change";
                if(stringUserHashMap.get(s[1]) == null) {
                    User user = new User(s[2], s[1], s[0],state);
                    stringUserHashMap.put(s[1],user);
                    UserRecord userRecord = new UserRecord(s[1],s[0], user);
                    records.add(userRecord);
                } else{
                    User user = stringUserHashMap.get(s[1]);
                    user.NicChange(s[2],"Change");
                    stringUserHashMap.put(s[1],user);
                    UserRecord userRecord = new UserRecord(s[1],s[0], user);
                    records.add(userRecord);
                }

            }else if (s[0].equals("Leave")){
                User user = stringUserHashMap.get(s[1]);
                user.changeState(s[0]);
                stringUserHashMap.put(s[1],user);
                UserRecord userRecord = new UserRecord(s[1],s[0], user);
                records.add(userRecord);
            } else {
                User user = stringUserHashMap.get(s[1]);
                String userNicChange = s[0];
                String newNic = s[2];
                user.NicChange(newNic,userNicChange);

            }
        }
        int count = 0;
        String[] answer = new String[records.size()];
        for (UserRecord userRecord : records) {
            if (userRecord.state.equals("Enter")){
                answer[count] = userRecord.user.nickName+"님이 들어왔습니다.";
            } else {
                answer[count] = userRecord.user.nickName+"님이 나갔습니다.";
            }
            count++;
        }

        return answer;
    }
    class User {
        String nickName;
        private final String uId;
        String state;
        String userNicChange;

        public User(String nickName, String uId, String state, String userNicChange) {
            this.nickName = nickName;
            this.uId = uId;
            this.state = state;
            this.userNicChange = userNicChange;
        }
        public void changeState(String state){
            this.state = state;
        }
        public void NicChange(String newNic,String userNicChange){
            this.nickName = newNic;
            this.userNicChange = userNicChange;
        }

    }

    class UserRecord{
        String uid;
        String state;
        User user;

        public UserRecord(String uid, String state, User user) {
            this.uid = uid;
            this.state = state;
            this.user = user;
        }
    }
}
