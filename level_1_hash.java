// Hash는 검색하는 것에 탁월, Map으로 key, value
import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> hm = new HashMap<>();
        for(String name : participant){hm.put(name, hm.getOrDefault(name,0) + 1);}
        for(String name : completion){hm.put(name, hm.get(name)-1);}
        for(String key : hm.keySet()){
            if(hm.get(key) != 0){
                answer = key;
                break;
            }
        }
        return answer;
    }
}