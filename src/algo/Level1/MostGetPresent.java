package algo.Level1;

import java.util.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/258712
public class MostGetPresent {


    public static void main(String[] args) {
        String[] friends = {"joy", "brad", "alessandro", "conan", "david"};
        String[] gifts = {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};
        int solution = new MostGetPresent().solution(friends, gifts);
        System.out.println("solution = " + solution);
    }

    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        HashMap<String, People> NameTag = new HashMap<>();

        for (String friend : friends) {
            HashMap<String, Integer> GiveMap = makeFriendsMap(friends);
            HashMap<String, Integer> GetMap = makeFriendsMap(friends);
            NameTag.put(friend,new People(friend,GetMap,GiveMap));

        }
        for (String gift : gifts) {
            String[] s = gift.split(" ");
            String GivePeople = s[0];
            String GetPeople = s[1];
            People GivePeopleClass = NameTag.get(GivePeople);
            People GetPeopleClass = NameTag.get(GetPeople);

            GivePeopleClass.GiveFriend.replace(GetPeople,GivePeopleClass.GiveFriend.get(GetPeople)+1);
            GetPeopleClass.GetFriend.replace(GivePeople,GetPeopleClass.GetFriend.get(GivePeople)+1);
        }

        for (String friend : friends) {
            People people = NameTag.get(friend);
            people.calPresentIdx();
        }
        for (String friend : friends) {
            People people = NameTag.get(friend);
            System.out.println("people = " + people);
        }
        for (String friend : friends) {
            int count = 0;
            People people = NameTag.get(friend);
            for (String s : friends) {
                if (s!= friend){
                    int GetS = people.GetFriend.get(s);
                    int GiveS = people.GiveFriend.get(s);
                    if (GiveS > GetS){
                        count++;
                    } else{
                        if (((GetS==0 && GiveS==0)||(GetS==GiveS))&&(people.PresentIdx > NameTag.get(s).PresentIdx)){
                            count++;
                        }
                    }
                }
            }
            answer = Math.max(count, answer);
        }


        return answer;

    }
    public HashMap<String,Integer> makeFriendsMap(String[] friends){
        HashMap<String, Integer> map = new HashMap<>();
        for (String friend : friends) {
            map.put(friend,0);
        }
        return map;
    }

    class People {
        String name;
        HashMap<String,Integer> GetFriend ;
        HashMap<String, Integer> GiveFriend;
        int PresentIdx;

        public People(String name, HashMap<String, Integer> getFriend, HashMap<String, Integer> giveFriend) {
            this.name = name;
            GetFriend = getFriend;
            GiveFriend = giveFriend;
        }
        //선물 지수 = 이번달까지 자신이 준 선물 - 이번달 받은 선물 수
        public int calPresentIdx(){
            int a = 0;
            int b = 0;
            for (Integer value : GetFriend.values()) {
                a += value;
            }
            for (Integer value : GiveFriend.values()) {
                b += value;
            }
            this.PresentIdx = b-a;
            return this.PresentIdx;
        }

        @Override
        public String toString() {
            return "People{" +
                    "name='" + name + '\'' +
                    ", GetFriend=" + GetFriend +
                    ", GiveFriend=" + GiveFriend +
                    ", PresentIdx=" + PresentIdx +
                    '}';
        }
    }
}
