package boj;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class J10814_나이순정렬 {
    static class Person {
        int age;
        String name;
        Person(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Person> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            list.add(i, new Person(age, name));
        }
        list.sort((a, b) -> {
            return a.age - b.age;
        });
        for (var e : list)
            bw.write(e.age + " " + e.name + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
