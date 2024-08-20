class Solution {
	public int solution(int n, int[] cores) {
		if (n <= cores.length)
			return n;

		n -= cores.length;
		long st = 0;
		long en = Integer.MAX_VALUE;
		while (st < en) {
			long mid = (st + en) / 2;
			long capacity = 0;
			for (int c : cores) {
				capacity += mid / c;
			}
			if (capacity >= n) {
				en = mid;
			} else {
				st = mid + 1;
			}
		}
     
		for (int c : cores) {
			n -= (st - 1) / c;
		}

        int ans = 0;
		for (int i = 0; i < cores.length; i++) {
			if (st % cores[i] == 0) {
				n--;
				if (n == 0) {
                    ans = i + 1;
                    break;
				}
			}
		}
        return ans;
    }
}
