import java.util.*;
import java.io.*;

public class Main {

	static int[] trucks;
	static int n, w, l;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tokens = br.readLine().split(" ");
		n = Integer.parseInt(tokens[0]);
		w = Integer.parseInt(tokens[1]);
		l = Integer.parseInt(tokens[2]);
		tokens = br.readLine().split(" ");
		trucks = new int[n];

		for (int i = 0; i < n; ++i) {
			trucks[i] = Integer.parseInt(tokens[i]);
		}

		Queue<Integer> bridge = new LinkedList<>();
		int curWeight = 0;
		int time = 0;
		for (var truck : trucks) {
			while (true) {
				if (bridge.size() == w) {
					curWeight -= bridge.poll();
				}
				if (curWeight + truck <= l) {
					bridge.add(truck);
					curWeight += truck;
					++time;
					break;
				} else {
					bridge.add(0);
					++time;
				}
			}
		}
		time += w;
		System.out.println(time);
	}
}
