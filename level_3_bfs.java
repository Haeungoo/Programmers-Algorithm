// 가장 짧은 변환 과정을 찾는 것 -> bfs
import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean[] memo = new boolean[words.length];
        return bfs(begin, target, words, memo);
    }
    public int bfs(String begin, String target, String[] words, boolean[] memo){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(begin,0));

        while(!q.isEmpty()){
            Node node = q.poll();
            if(node.word.equals(target)) return node.count;
            for(int i = 0; i < words.length; i++){
                // word가 words[i]로 변환될 수 있다면
                if(memo[i] == false && check(node.word, words[i])){
                    memo[i] = true;
                    q.offer(new Node(words[i], node.count+1));
                }
            }
        }
        return 0;
    }
    public boolean check(String s1, String s2){
        int count = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)) count++;
        }
        if(count == 1) return true;
        return false;
    }
    public class Node{
        String word;
        int count;

        public Node(String word, int count){
            this.word = word;
            this.count = count;
        }
    }
}