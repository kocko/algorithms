package csadademy.problemset011;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class LongPressedName implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    class Pair {
        char c;
        int count;

        Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    public void solve() {
        String a = in.next(), b = in.next();
        List<Pair> x = count(a), y = count(b);
        if (x.size() != y.size()) {
            out.println(0);
        } else {
            int n = x.size();
            for (int i = 0; i < n; i++) {
                if (x.get(i).c != y.get(i).c){
                    out.println(0);
                    return;
                }
                if (x.get(i).count > y.get(i).count) {
                    out.println(0);
                    return;
                }
            }
            out.println(1);
        }
    }

    private List<Pair> count(String x) {
        char c = x.charAt(0);
        int current = 1;
        List<Pair> list = new ArrayList<>();
        for (int i = 1; i < x.length(); i++) {
            if (x.charAt(i) == c) {
                current++;
            } else {
                list.add(new Pair(c, current));
                current = 0;
                c = x.charAt(i);
            }
        }
        list.add(new Pair(c, current));
        return list;
    }

    private int check(String i) {
        char a = i.charAt(0);
        for (int x = 0; x < i.length(); x++) {
            if (i.charAt(x) != a) return 0;
        }
        return 1;
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
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
        new LongPressedName().solve();
    }
}
