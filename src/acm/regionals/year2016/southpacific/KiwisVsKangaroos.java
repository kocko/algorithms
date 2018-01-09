package acm.regionals.year2016.southpacific;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class KiwisVsKangaroos implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        while (in.hasNext()) {
            char[] word = in.next().toLowerCase().toCharArray();
            determine(word);
        }
    }

    private void determine(char[] c) {
        int kangaroo = count("kangaroo".toCharArray(), c), kiwi = count("kiwibird".toCharArray(), c);
        if (kangaroo > kiwi) {
            out.println("Kangaroos");
        } else if (kangaroo == kiwi) {
            out.println("Feud continues");
        } else {
            out.println("Kiwis");
        }
    }

    private int count(char[] key, char[] word) {
        int result = 0;
        for (char x : word) {
            int a = 0;
            for (char y : key) {
                if (x == y) a++;
            }
            result += a;
        }
        return result;
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (KiwisVsKangaroos instance = new KiwisVsKangaroos()) {
            instance.solve();
        }
    }
}
