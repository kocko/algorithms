package codeforces.contests001_100.problemset081;

import java.io.IOException;
import java.util.Scanner;

public class SequenceFormatting {

    public void solve() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.replaceAll(" {2,}", " ")
             .replaceAll(" ,", ",")
             .replaceAll(", ", ",")
             .replaceAll(",", ", ")
             .replaceAll(" \\.\\.\\.", "...")
             .replaceAll("\\.\\.\\. ", "...")
             .replaceAll("\\.\\.\\.", " ...")
             .trim();
        System.out.println(s);
    }

    public static void main(String[] args) throws IOException {
        new SequenceFormatting().solve();
    }
}
