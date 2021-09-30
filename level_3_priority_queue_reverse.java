import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        // 최소 힙, 최대 힙
        PriorityQueue<Integer> minpq = new PriorityQueue<>();
        PriorityQueue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String op : operations){
            StringTokenizer st = new StringTokenizer(op);
            String judge = st.nextToken();
            int value = Integer.parseInt(st.nextToken());
            
            // 빈 큐에 삭제 요청하는 경우 무시
            if(minpq.size() < 1 && judge.equals("D")){
                continue;
            };
            
            // 삽입 시 최소 힙, 최대 힙에 value 넣기
            if(judge.equals("I")){
                minpq.offer(value);
                maxpq.offer(value);
                continue;
            }
            
            //D이면서 value가 -1,1인 경우
            //0보다 작을 경우에는 최소 힙에서 poll후 최대힙에서 해당 원소 삭제
            if(value < 0){
                int min = minpq.poll();
                maxpq.remove(min);
                continue;
            }
            
            // 최대 힙에서 poll후 최소힙에서 해당 원소 삭제
            int max = maxpq.poll();
            minpq.remove(max);
        }
        if(minpq.size() > 0){
            answer[0] = maxpq.poll();
            answer[1] = minpq.poll();
        }
        return answer;
    }
}