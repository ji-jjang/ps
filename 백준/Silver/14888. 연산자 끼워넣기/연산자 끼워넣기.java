import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] a = new int[14];
    static int[] oper = {0, 0, 0, 0};
    static int mx = Integer.MIN_VALUE;
    static int mn = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++)
            oper[i] = Integer.parseInt(st.nextToken());
        dfs(1, a[0]);
        System.out.println(mx);
        System.out.println(mn);
        br.close();
    }

    static void dfs(int depth, int sum) {
        if (depth == n) {
            mx = Math.max(mx, sum);
            mn = Math.min(mn, sum);
        }
        for (int i = 0; i < 4; ++i) {
            if (oper[i] == 0)
                continue;
            --oper[i];
            if (i == 0)
                dfs(depth + 1, sum + a[depth]);
            else if (i == 1)
                dfs(depth + 1, sum - a[depth]);
            else if (i == 2)
                dfs(depth + 1, sum * a[depth]);
            else
                dfs(depth + 1, sum / a[depth]);
            ++oper[i];
        }
    }
}
