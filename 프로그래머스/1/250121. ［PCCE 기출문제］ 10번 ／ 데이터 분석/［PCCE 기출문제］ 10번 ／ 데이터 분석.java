import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> l = new ArrayList<>();
        for (var d : data) {
            if (ext.equals("code")) {
                if (d[0] < val_ext) {
                    l.add(d);
                }
            }
            else if (ext.equals("date")) {
                if (d[1] < val_ext) {
                    l.add(d);
                }
            } else if (ext.equals("maximum")) {
                if (d[2] < val_ext) {
                    l.add(d);
                }
            } else if (ext.equals("remain")) {
                if (d[3] < val_ext) {
                    l.add(d);
                }
            }
        }
        l.sort((a, b) -> {
            if (sort_by.equals("code")) {
                return Integer.compare(a[0], b[0]);
            } else if (sort_by.equals("date")) {
                return Integer.compare(a[1], b[1]);
            } else if (sort_by.equals("maximum")) {
                return Integer.compare(a[2], b[2]);
            } else {
                return Integer.compare(a[3], b[3]);
            }
        });
        
        int[][] ans = new int[l.size()][4];
        int idx = 0;
        for (var e : l) {
            ans[idx++] = e;
        }
        return ans;
    }
}