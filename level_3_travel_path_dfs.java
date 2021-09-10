import java.util.*;

class Solution {
    static String[][] ticketsInfo;
    static boolean[] used;
    static List<String> list = new ArrayList<String>();
    static String[] answer = {};


    public String[] solution(String[][] tickets) {
        used = new boolean[tickets.length];
        ticketsInfo = tickets;

        Arrays.sort(ticketsInfo, (o1,o2) -> {
            if(o1[0].equals(o2[0])){
                return o1[1].compareTo(o2[1]);
            }else{
                return o1[0].compareTo(o2[0]);
            }
        });

        list.add("ICN");
        dfs("ICN", 0);
        return answer;
    }
    private void dfs(String start, int cnt){
        if(answer.length>0) return; // 이미 정답이 나왔다면 dfs가 호출되면 return
        if(cnt == used.length){ // 모든 항공권을 사용했다면
            answer = new String[list.size()];
            for(int i = 0; i<list.size();i++){
                answer[i] = list.get(i); // answer에 list값 담기
            }
            return;
        }
        for(int i=0; i < ticketsInfo.length; i++){ // 항공권 전체
            // 출발지가 start이고 사용하지 않은 티켓이면
            if(!used[i] && ticketsInfo[i][0].equals(start)){
                used[i] = true; // i번째 티켓은 사용함.
                list.add(ticketsInfo[i][1]); //i번째 티켓의 도착지 방문
                dfs(ticketsInfo[i][1], cnt +1); // 도착지는 출발지가 됨.
                // return 후 초기화
                used[i] = false; // i번째 사용 여부 false로 바뀜
                list.remove(list.size()-1); // i번째 티켓의 도착지 제거
            }
        }
    }
}