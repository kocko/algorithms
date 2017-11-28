package codeforces.contests501_600.problemset558;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class LalaLandAndAppleTrees implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private class Tree {
        private int x, a;

        private Tree(int x, int a) {
            this.x = x;
            this.a = a;
        }
    }

    public void solve() {
        int n = in.ni();
        List<Tree> left = new ArrayList<>(), right = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = in.ni(), a = in.ni();
            Tree tree = new Tree(x, a);
            if (x < 0) {
                left.add(tree);
            } else {
                right.add(tree);
            }
        }
        left.sort(Comparator.comparingInt(t -> -t.x));
        right.sort(Comparator.comparing(t -> t.x));
        int a = left.size(), b = right.size(), result = 0;
        if (a == b) {
            for (int i = 0; i < a; i++) {
                result += left.get(i).a;
                result += right.get(i).a;
            }
        } else {
            int min = Math.min(a, b);
            int i;
            for (i = 0; i < min; i++) {
                result += left.get(i).a;
                result += right.get(i).a;
            }
            if (a > b) result += left.get(i).a;
            else result += right.get(i).a;
        }
        out.println(result);
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

    public static void main(String[] args) throws IOException {
        try (LalaLandAndAppleTrees instance = new LalaLandAndAppleTrees()) {
            instance.solve();
        }
    }
}
