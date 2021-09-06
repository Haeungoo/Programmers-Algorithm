// 3진법 뒤집기
import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        String threeN = "";
        while(n>0){
            threeN += (n%3);
            n/=3;
        }
        for(int i=0 ; i < threeN.length() ; i++){
            answer += Math.pow(3,threeN.length()-1-i)*Character.getNumericValue(threeN.charAt(i));        
        }
        return answer;
    }
}