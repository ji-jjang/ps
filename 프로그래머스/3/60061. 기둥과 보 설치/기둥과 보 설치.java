import java.util.*;

class Solution {

    public boolean isValid(List<int[]> ret) {
        for (int[] e : ret) {
            int x = e[0];
            int y = e[1];
            int type = e[2];

            if (type == 0) {
                if (!canPlaceGidung(x, y, ret)) return false;
                continue;
            } 
		    if (type == 1) {
                if (!canPlaceBo(x, y, ret)) return false;
            }
        }
        return true;
    }

    public int[][] solution(int n, int[][] build_frame) {
        
        List<int[]> ret = new ArrayList<>();

        for (int[] frame : build_frame) {
            int x = frame[0];
            int y = frame[1];
            int type = frame[2];
            int cmd = frame[3];

            if (cmd == 1) {
                if (type == 0) {
                    if (canPlaceGidung(x, y, ret)) { 
                        ret.add(new int[]{x, y, type});
                        continue; 
                    }
                } 
				if (type == 1) { 
                    if (canPlaceBo(x, y, ret)) ret.add(new int[]{x, y, type});
                }
            } else if (cmd == 0) {
                ret.removeIf(e -> Arrays.equals(e, new int[]{x, y, type}));
                if (!isValid(ret)) ret.add(new int[]{x, y, type});
            }
        }

        ret.sort((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[2], b[2]);
        });

        return ret.toArray(new int[ret.size()][]);
    }

    boolean canPlaceGidung(int x, int y, List<int[]> ret) {
        return y == 0 || contains(ret, new int[]{x, y - 1, 0}) 
            || contains(ret, new int[]{x - 1, y, 1}) 
            || contains(ret, new int[]{x, y, 1});
    }

    boolean canPlaceBo(int x, int y, List<int[]> ret) {
        return contains(ret, new int[]{x, y - 1, 0}) 
            || contains(ret, new int[]{x + 1, y - 1, 0}) 
            || (contains(ret, new int[]{x - 1, y, 1}) 
                && contains(ret, new int[]{x + 1, y, 1}));
    }

    boolean contains(List<int[]> ret, int[] e) {
        for (int[] item : ret) {
            if (Arrays.equals(item, e)) return true;
        }
        return false;
    }
}
