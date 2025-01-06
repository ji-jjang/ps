import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        String ans = (n % 2 == 0) ? n + " is even" : n + " is odd";
        System.out.println(ans);
    }
}