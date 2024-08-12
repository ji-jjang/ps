import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> pg = new HashMap<>();
        HashMap<String, List<int[]>> s = new HashMap<>();
        for (int i = 0; i < genres.length; ++i) {
            pg.put(genres[i], pg.getOrDefault(genres[i], 0) + plays[i]);
            s.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new int[]{i, plays[i]});
        }
        var pgList = new ArrayList<>(pg.entrySet());
        pgList.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        for (var song : s.values()) {
            song.sort((a, b) -> {
                if (a[1] == b[1])
                    return Integer.compare(a[0], b[0]);
                return Integer.compare(b[1], a[1]);
            });
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (var genre : pgList) {
            int jdx = 0;
            for (var song : s.get(genre.getKey())) {
                if (jdx >= 2) break;
                ans.add(song[0]);
                ++jdx;
            }
        }
        int[] answer = new int[ans.size()];
        int idx = 0;
        for (var e : ans)
            answer[idx++] = e;
        return answer;
    }
}