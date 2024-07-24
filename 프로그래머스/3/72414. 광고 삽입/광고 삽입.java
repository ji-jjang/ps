import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        
        int play = convertSecond(play_time);
        int ad = convertSecond(adv_time);
        
        long[] runnings = new long[play + 1];
        
        for (var log : logs) {
            String[] times = log.split("-");
            int start = convertSecond(times[0]);
            int end = convertSecond(times[1]);
            runnings[start]++;
            if (end < play) runnings[end]--;
        }
        
        for (int i = 1; i <= play; i++) runnings[i] += runnings[i - 1];
        
        for (int i = 1; i <= play; i++) runnings[i] += runnings[i - 1];
        
        long maxView = 0;
        long ans = 0;        
        for (int i = 0; i + ad <= play; i++) {
            long viewCnt = (i == 0) ? runnings[i + ad - 1] : runnings[i + ad - 1] - runnings[i - 1];         
            if (maxView < viewCnt) {
                maxView = viewCnt;
                ans = i;
            }
        }
        return convertTime(ans);
    }
    
    int convertSecond(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        int seconds = Integer.parseInt(parts[2]);
        return hours * 3600 + minutes * 60 + seconds;
    }
    
    String convertTime(long seconds) {
        long hours = seconds / 3600;
        seconds %= 3600;
        long minutes = seconds / 60;
        seconds %= 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}