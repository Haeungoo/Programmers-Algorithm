// 같은 이름은 없음 -> 중복 없음 (Map 가능)
import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap <String, Integer> clothesMap = new HashMap<>();
        for(int i = 0 ; i < clothes.length; i++){
            String key = clothes[i][1];
            if(!clothesMap.containsKey(key)){
                clothesMap.put(key, 1);
            }else{
                clothesMap.put(key,clothesMap.get(key)+1);
            }
        }
        Iterator<Integer> it = clothesMap.values().iterator();
        while(it.hasNext()){
            answer*=it.next().intValue() +1;
        }
        return answer-1;
    }
}