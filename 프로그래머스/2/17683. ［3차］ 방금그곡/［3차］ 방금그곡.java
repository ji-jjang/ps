// 1. 기억한 멜로디 중 #이 안붙은 멜로디는 소문자로 변환
// 2. map{노래제목, 전체 멜로디}
// 3. m.get(노래제목).contains(기억한 멜로디) 라면 노래 길이 저장. 노래 길이가 더 길다면 노래 제목 갱신
import java.util.*;

class Solution {
    
    public String solution(String m, String[] musicinfos) {
        Map<Character, Character> map = new HashMap<>();
        Map<String, String> music = new HashMap<>();
        
        map.put('C', 'c');
        map.put('D', 'd');
        map.put('F', 'f');
        map.put('G', 'g');
        map.put('A', 'a');
        
        String melody = convertSharp(m, map);
        
        String ans = "";
        for (var infos : musicinfos) {
            StringBuilder sb = new StringBuilder();
            String[] info = infos.split(",");
            int en = convertMinutes(info[1]);
            int st = convertMinutes(info[0]);
            int time = en - st;
 
            int idx = 0;
            while (time > 0) {
                char c = info[3].charAt(idx % info[3].length());
                sb.append(c);
                ++idx;
                if (c == '#') continue;
                --time;
            }
            if (info[3].charAt(idx % info[3].length()) == '#') {
                sb.append('#');
            }
            
            String gasa = convertSharp(sb.toString(), map);
            music.put(info[2], gasa);
            if (gasa.contains(melody)) {
                if (!ans.isEmpty()) {
                    if (music.get(ans).length() < gasa.length())
                        ans = info[2];
                } else {
                    ans = info[2];
                }
            }
        }
        if (!ans.isEmpty())
            return ans;
        return "(None)";
    }
    
    String convertSharp(String m, Map<Character, Character> map) {
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < m.length(); ++i) {
            if (m.charAt(i) == '#') {
                continue;
            }
            if (map.containsKey(m.charAt(i)) && i != m.length() - 1 && m.charAt(i + 1) == '#') {
                tmp.append(map.get(m.charAt(i)));
                ++i;
                continue;
            }
            tmp.append(m.charAt(i));
        }
        return tmp.toString();
    }
    
    int convertMinutes(String str) {
        String[] s = str.split(":");
        int hour = Integer.parseInt(s[0]);
        int minutes = Integer.parseInt(s[1]);
        return hour * 60 + minutes;
    }
}