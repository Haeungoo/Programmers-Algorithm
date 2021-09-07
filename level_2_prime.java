import java.util.*;
class Solution {
    boolean[] visited;
    ArrayList<Integer> allNumbers;
    
    public int solution(String numbers) {
        int answer = 0;
        int n = numbers.length();
        String[] number = new String[n];
        visited = new boolean[n+1];
        allNumbers = new ArrayList<Integer>();
 
        for(int i = 0; i < n ;i++){
            number[i] = Character.toString(numbers.charAt(i));
        }
        
        for(int r = 0; r < n ;r++){
            permutation(number, "", r+1, 0);
        }
        
        answer = allNumbers.size();
        
        return answer;
    }
    public void permutation(String[] number, String str, int r, int depth){
        if(depth == r){
            int tmp = Integer.parseInt(str);
            // 소수이고 기존에 없던 수인 경우
            if(check(tmp) && !allNumbers.contains(tmp)){
                allNumbers.add(tmp);
            }
            return;
        }
        for(int i = 0; i < number.length; i++){
            if(!visited[i]){
                visited[i] = true;
                str = str + number[i];
                permutation(number, str, r, depth+1);
                str = str.substring(0, str.length()-1);
                visited[i] = false;
            }
        }
    }
    
    public boolean check(int num){
        if(num == 0 || num == 1) return false;
        if(num == 2 || num == 3) return true;
        for(int i=2 ; i < Math.sqrt(num)+1; i++){
            if(num%i == 0) return false;
        }
        return true;
    }
    
    
}