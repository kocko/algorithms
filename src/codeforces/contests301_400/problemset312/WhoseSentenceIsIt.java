package codeforces.contests301_400.problemset312;

import java.util.Scanner;

public class WhoseSentenceIsIt {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        while (n-- > 0) {
            String next = sc.nextLine();
            if (next.startsWith("miao.") && next.endsWith("lala.")) {
                System.out.println("OMG>.< I don't know!");
            } else if (next.startsWith("miao.")) {
                System.out.println("Rainbow's");
            } else if (next.endsWith("lala.")) {
                System.out.println("Freda's");
            } else {
                System.out.println("OMG>.< I don't know!");
            }
        }
    }
    
}
