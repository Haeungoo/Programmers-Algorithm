class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers,0,0,target);
        return answer;
    }
    public void dfs(int[] num, int index, int value, int t){
        if(index==num.length){
            if(value==t) // 원하는 결과값이 되면 answer++
                answer++;
        }else{
            int minus = value-num[index];
            int plus = value+num[index];
            dfs(num,index+1,minus,t);
            dfs(num,index+1,plus,t);
        }
    }
}