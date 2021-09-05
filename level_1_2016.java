// 2016년 문제
class Solution {
    public String solution(int a, int b) {
        int daySum = 0;
        for(int m=1; m<a; m++){
            if(m == 2){
                daySum += 29;
            }else if(m<=7){
                if(m%2 != 0){
                    daySum += 31;
                }else{
                    daySum += 30;
                }
            }else if(m>=8){
                if(m%2 != 0){
                    daySum += 30;
                }else{
                    daySum += 31;
                }
            }
        }
        daySum += b;
        String answer = "";
        switch(daySum%7){
            case 1: answer="FRI"; break;
            case 2: answer="SAT"; break;
            case 3: answer="SUN"; break;
            case 4: answer="MON"; break;
            case 5: answer="TUE"; break;    
            case 6: answer="WED"; break;
            case 0: answer="THU"; break;
        }
        return answer;
    }
}