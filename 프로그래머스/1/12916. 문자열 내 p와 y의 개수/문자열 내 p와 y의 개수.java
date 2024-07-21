class Solution {
    boolean solution(String s) {
        boolean answer = true;

        s = s.toLowerCase();
        int pCnt = 0;
        int yCnt = 0;
        for (var c : s.toCharArray()) {
            if (c == 'p') ++pCnt;
            if (c == 'y') ++yCnt;
        }

        return pCnt == yCnt;
    }
}