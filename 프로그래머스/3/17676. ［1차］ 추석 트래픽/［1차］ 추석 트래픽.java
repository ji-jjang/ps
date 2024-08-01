import java.util.*;

class Solution {
                
    public int solution(String[] lines) {
               
        List<int[]> logs = new ArrayList<>();

        for (String line : lines) {
            int[] ret = convertToMile(line);
            int en = ret[0];
            int st = en - (ret[1] - 1);
            logs.add(new int[]{st, 1});
            logs.add(new int[]{en + 1000, -1});
        }

        logs.sort((a, b) -> Integer.compare(a[0], b[0]));

        int ans = 0;
        int count = 0;
        for (var log : logs) {
            count += log[1];
            ans = Math.max(ans, count);
        }

        return ans;
    }

    
    int[] convertToMile(String time) {
        String[] split = time.split(" ");
        String[] times = split[1].split(":");
        String[] mileAndSec = times[2].split("\\.");
        
        int range = (int)(Double.parseDouble(split[2].substring(0, split[2].length() - 1)) * 1000);
        
        int hour = Integer.parseInt(times[0]);
        int minute = Integer.parseInt(times[1]);
        int secAndMile = (int)(Double.parseDouble(times[2]) * 1000.0);
        
        return new int[]{hour * 60 * 60 * 1000 + minute * 60 * 1000 + (int)secAndMile, range};
    }
}