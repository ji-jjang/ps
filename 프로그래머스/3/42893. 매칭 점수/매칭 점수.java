import java.util.*;

class Solution {
    
    public int solution(String word, String[] pages) {
        word = word.toLowerCase();
        Map<String, Integer> ps = new HashMap<>();
        List<String>[] externalLinks = new ArrayList[pages.length];
        int[] basicScores = new int[pages.length];
        double[] linkScores = new double[pages.length];

        for (int i = 0; i < pages.length; ++i) {
            externalLinks[i] = new ArrayList<>();
            String baseUrl = getBaseUrl(pages[i]);
            ps.put(baseUrl, i);
            basicScores[i] = getBasicScore(word, pages[i]);
            externalLinks[i] = getExternalLinks(pages[i]);
        }

        for (int i = 0; i < pages.length; ++i) {
            String page = pages[i];
            String baseUrl = getBaseUrl(page);
            for (var link : externalLinks[i]) {
                if (ps.containsKey(link)) {
                    int linkIndex = ps.get(link);
                    linkScores[linkIndex] += (double) basicScores[i] / externalLinks[i].size();
                }
            }
        }

        double[] totalScores = new double[pages.length];
        for (int i = 0; i < pages.length; ++i) {
            totalScores[i] = basicScores[i] + linkScores[i];
        }

        int ans = 0;
        for (int i = 1; i < pages.length; ++i) {
            if (totalScores[i] > totalScores[ans]) {
                ans = i;
            }
        }

        return ans;
    }

    private String getBaseUrl(String page) {
        String find = "<meta property=\"og:url\" content=\"";
        int st = page.indexOf(find) + find.length();
        int en = page.indexOf("\"", st);
        return page.substring(st, en);
    }

    int getBasicScore(String word, String page) {
        String lowerPage = page.toLowerCase();
        String body = lowerPage.substring(lowerPage.indexOf("<body>") + 7, lowerPage.indexOf("</body>"));
        int score = 0;
        String[] words = body.split("[^a-zA-Z]");
        for (var w : words) {
            if (w.equals(word)) {
                score++;
            }
        }
        return score;
    }

    List<String> getExternalLinks(String page) {
        List<String> links = new ArrayList<>();
        int pos = page.indexOf("<a href=\"");
        while (pos != -1) {
            int start = pos + "<a href=\"".length();
            int end = page.indexOf("\"", start);
            links.add(page.substring(start, end));
            pos = page.indexOf("<a href=\"", end);
        }
        return links;
    }
}