package codeforces.contests501_599.problemset546;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class SoldierAndCards implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    int fact(int n) {
        if (n == 1) return 1;
        else return n * fact(n - 1);
    }

    public void solve() {
        int n = in.ni();
        ArrayDeque<Integer> first = new ArrayDeque<>(), second = new ArrayDeque<>();
        int a = in.ni();
        for (int i = 0; i < a; i++) {
            first.addLast(in.ni());
        }
        int b = in.ni();
        for (int i = 0; i < b; i++) {
            second.addLast(in.ni());
        }
        int count = 0, limit = fact(n);
        while(true) {
            if (count > limit)  {
                out.println(-1);
                break;
            } else if (first.isEmpty()) {
                out.println(count + " " + 2);
                break;
            } else if (second.isEmpty()) {
                out.println(count + " " + 1);
                break;
            } else {
                int x = first.peekFirst(), y = second.peekFirst();
                if (x > y) {
                    first.addLast(second.pop());
                    first.addLast(x);
                    first.pop();
                } else {
                    second.addLast(first.pop());
                    second.addLast(y);
                    second.pop();
                }
                count++;
            }
        }
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
        new SoldierAndCards().solve();
    }
}
