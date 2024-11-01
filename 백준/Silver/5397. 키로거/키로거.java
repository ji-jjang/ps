import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {

			List<Character> l = new LinkedList<>();

			ListIterator<Character> cursor = l.listIterator();

			for (var c : br.readLine().toCharArray()) {

				if (c == '<') {
					if (cursor.hasPrevious())
						cursor.previous();
				} else if (c == '>') {
					if (cursor.hasNext()) 
						cursor.next();
				} else if (c == '-') {
					if (cursor.hasPrevious()) {
						cursor.previous();
						cursor.remove();
					}
				} else {
					cursor.add(c);
				}
			}
			for (var e : l)
				sb.append(e);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}

