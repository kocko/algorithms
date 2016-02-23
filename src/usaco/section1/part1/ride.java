package usaco.section1.part1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
ID: <your-id-here>
LANG: JAVA
TASK: ride
*/

public class ride implements Closeable {

    private InputReader in = new InputReader();
    private PrintWriter out;

    public ride() {
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void solve() {
        String comet = in.next();
        String group = in.next();
        out.println(score(comet) == score(group) ? "GO" : "STAY");
    }

    int score(String word) {
        int result = 1;
        for (char c : word.toCharArray()) {
            result *= (c - 'A' + 1);
            result %= 47;
        }
        return result;
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader() {
            try {
                reader = new BufferedReader(new FileReader("ride.in"), 32768);
                tokenizer = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int ni() {
            return Integer.parseInt(next());
        }

        public long nl() {
            return Long.parseLong(next());
        }

        public void close() throws IOException {
            reader.close();
        }
    }

    public static void main(String[] args) {
        new ride().solve();
    }
}
