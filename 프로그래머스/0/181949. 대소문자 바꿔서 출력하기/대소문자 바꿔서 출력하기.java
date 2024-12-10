import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        StringBuilder sb = new StringBuilder();
        for (var c : a.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                c = (char)(c - 'a' + 'A');
            }
            else {
                c = (char)(c - 'A' + 'a');
            }
            sb.append(c);
        }
        System.out.println(sb);
    }
}