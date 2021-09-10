class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] check = new boolean[n]; // false로 초기화
        for(int i = 0 ; i < n ; i++){
            if(!check[i]){ // check[i]가 false인 경우
                dfs(computers, i, check);
                answer++;
            }
        }
        return answer;
    }
    boolean[] dfs(int[][] computers, int i, boolean[] check){
        check[i] = true;
        for(int j = 0; j < computers.length; j++){
            if(i != j && computers[i][j] == 1 && check[j] == false){
                // 자기 자신이 아니고 해당 위치의 check 값이 false이고 값이 1인 것
                check = dfs(computers,j,check);
            }
        }
        return check;
    }
}