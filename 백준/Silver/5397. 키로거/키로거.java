import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			String str = br.readLine();
			List<Character> l = new LinkedList<>();
			ListIterator<Character> cursor = l.listIterator();
			for (var c : str.toCharArray()) {
				if (c == '<') {
					if (cursor.hasPrevious()) cursor.previous();
				}
				else if (c == '>') {
					if (cursor.hasNext()) cursor.next();
				}
				else if (c == '-') {
					if (cursor.hasPrevious()) {
						cursor.previous();
						cursor.remove();
					}
				}
				else {
					cursor.add(c);
				}
			}
			for (var c : l)
				bw.write(c);
			bw.write('\n');
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
