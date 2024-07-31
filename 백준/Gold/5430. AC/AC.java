import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            char[] cmds = br.readLine().toCharArray();
            br.readLine();

            String line = br.readLine();
            Deque<Integer> nums = toOnlyNum(line);

            boolean isError = false;
            boolean reversed = false;
            for (var cmd : cmds) {
                if (cmd == 'R') {
                    reversed = !reversed;
                } else {
                    if (nums.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if (reversed) {
                        nums.removeLast();
                    } else {
                        nums.removeFirst();
                    }
                }
            }
            if (isError) {
                ans.append("error\n");
                continue;
            }
            ans.append(toCommaNum(nums, reversed));
        }
        System.out.println(ans);
    }

    static Deque<Integer> toOnlyNum(String line) {
        String[] split = line.substring(1, line.length() - 1).split(",");
        Deque<Integer> deque = new LinkedList<>();
        for (String s : split) {
            if (!s.isEmpty()) {
                deque.add(Integer.parseInt(s));
            }
        }
        return deque;
    }

    static StringBuilder toCommaNum(Deque<Integer> nums, boolean reversed) {
        StringBuilder sb = new StringBuilder();
				Iterator<Integer> iterator = reversed ? nums.descendingIterator() : nums.iterator();

        sb.append('[');
				while (iterator.hasNext()) {
						sb.append(iterator.next());
						if (iterator.hasNext()) {
								sb.append(',');
						}
				}
        sb.append("]\n");
        return sb;
    }
}
