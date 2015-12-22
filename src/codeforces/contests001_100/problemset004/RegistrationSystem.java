package codeforces.contests001_100.problemset004;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RegistrationSystem {

    static Map<String, Integer> db = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            System.out.println(persist(name));
        }
        sc.close();
    }

    static String persist(String name) {
        if (db.containsKey(name)) {
            int count = db.get(name);
            db.put(name, count + 1);
            return name + (count + 1);
        } else {
            db.put(name, 0);
            return "OK";
        }
    }

}
