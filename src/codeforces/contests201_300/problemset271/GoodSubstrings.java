package codeforces.contests201_300.problemset271;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class GoodSubstrings implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private class Node {
        private int count;
        private boolean good;
        private Node[] children = new Node[26];
        
        private Node(int count) {
            this.count = count;
        }

        private Node insert(char c, int add) {
            int score = count + add;
            if (children[c - 'a'] == null) {
                children[c - 'a'] = new Node(score);
            }
            return children[c - 'a'];
        }
    }
    
    public void solve() {
        char[] x = in.next().toCharArray(), good = in.next().toCharArray();
        int k = in.ni(), n = x.length, result = 0;
        
        Node root = new Node(0);
        for (int i = 0; i < n; i++) {
            Node current = root;
            for (int j = i; j < n; j++) {
                int add = (good[x[j] - 'a'] - '0') ^ 1;
                current = current.insert(x[j], add);
                if (current.count > k) {
                    break;
                } else if (!current.good) {
                    current.good = true;
                    result++;
                }
            }
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
        try (GoodSubstrings instance = new GoodSubstrings()) {
            instance.solve();
        }
    }
}
