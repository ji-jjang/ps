import java.util.*;


public class Solution {
	public long solution(String expression) {
		List<Long> nums = new ArrayList<>();
		List<Character> ops = new ArrayList<>();
        
		StringBuilder number = new StringBuilder();
		for (char ch : expression.toCharArray()) {
			if (ch == '+' || ch == '-' || ch == '*') {
				ops.add(ch);
				nums.add(Long.parseLong(number.toString()));
				number = new StringBuilder();
			} else {
				number.append(ch);
			}
		}
		nums.add(Long.parseLong(number.toString()));

		List<Character> usedOps = new ArrayList<>();
		if (expression.contains("+")) usedOps.add('+');
		if (expression.contains("-")) usedOps.add('-');
		if (expression.contains("*")) usedOps.add('*');

		List<List<Character>> perms = new ArrayList<>();
		List<Character> cur = new ArrayList<>();
		boolean[] isVisited = new boolean[usedOps.size()];
		dfs(cur, usedOps, isVisited, perms);

		long ans = Long.MIN_VALUE;
		for (var perm : perms) {
			long ret = evaluate(new ArrayList<>(nums), new ArrayList<>(ops), perm);
			ans = Math.max(ans, Math.abs(ret));
		}
		return ans;
	}

	long evaluate(List<Long> nums, List<Character> ops, List<Character> perm) {
		for (var op : perm) {
			for (int i = 0; i < ops.size(); i++) {
				if (ops.get(i) == op) {
					long ret = apply(nums.get(i), nums.get(i + 1), op);
					nums.remove(i + 1);
					nums.set(i, ret);
					ops.remove(i);
					i--;
				}
			}
		}
		return nums.get(0);
	}

	long apply(long a, long b, char op) {
		if (op == '+') return a + b;
		if (op == '-') return a - b;
		if (op == '*') return a * b;
		return 0; 
	}

	void dfs(List<Character> cur, List<Character> usedOps, boolean[] isVisited, List<List<Character>> perms) {
		if (cur.size() == usedOps.size()) {
			perms.add(new ArrayList<>(cur));
			return;
		}
		for (int i = 0; i < usedOps.size(); ++i) {
			if (isVisited[i]) continue;
			isVisited[i] = true;
			cur.add(usedOps.get(i));
			dfs(cur, usedOps, isVisited, perms);
			cur.remove(cur.size() - 1);
			isVisited[i] = false;
		}
	}
}
