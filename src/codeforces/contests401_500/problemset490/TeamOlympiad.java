package codeforces.contests401_500.problemset490;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class TeamOlympiad implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    class Child {
        int index;
        int skill;

        Child(int index, int skill) {
            this.index = index;
            this.skill = skill;
        }

        @Override
        public String toString() {
            return String.valueOf(index);
        }
    }

    public void solve() {
        int n = in.ni();
        Stack<Child> one = new Stack<>(), two = new Stack<>(), three = new Stack<>();
        for (int i = 1; i <= n; i++) {
            int next = in.ni();
            Stack<Child> stack = next == 1 ? one : (next == 2 ? two : three);
            stack.add(new Child(i, next));
        }
        int result = Math.min(one.size(), Math.min(two.size(), three.size()));
        out.println(result);
        for (int i = 0; i < result; i++) {
            out.print(one.pop() + " " + two.pop() + " " + three.pop());
            out.println();
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
        new TeamOlympiad().solve();
    }
}
