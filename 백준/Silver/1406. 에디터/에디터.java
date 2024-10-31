import java.io.*;
import java.util.*;

// ListIterator {e0, e1, e2, e3};
// cursor       {|e0, e1, e2, e3|};

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		List<Character> l = new LinkedList<>();
		for (var c : br.readLine().toCharArray()) l.add(c);
		ListIterator<Character> cursor = l.listIterator(l.size());

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();

			if ("L".equals(cmd)) {
				if (cursor.hasPrevious())
					cursor.previous();
			} 
			else if ("D".equals(cmd)) {
				if (cursor.hasNext())
					cursor.next();
			}
			else if ("B".equals(cmd)) {
				if (cursor.hasPrevious()) {
					cursor.previous();
					cursor.remove();
					continue;
				}
			} 
			else {
				char c = st.nextToken().charAt(0);
				cursor.add(c);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (var c : l) {
			sb.append(c);
		}
		System.out.println(sb);
	}
}

