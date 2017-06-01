package codeforces.contests201_300.problemset265;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

public class EscapeFromStones implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private class Node {
        private Node next;
        private int idx;

        private Node(int idx) {
            this.idx = idx;
        }
    }

    public void solve() {
        char[] x = in.next().toCharArray();
        int n = x.length, INF = 10000005;
        Node head = new Node(-INF);
        Node tail = new Node(INF);
        head.next = tail;
        Node left = head, right = tail;
        for (int i = 0; i < n; i++) {
            char direction = x[i];
            Node node = new Node(i + 1);
            left.next = node;
            node.next = right;
            if (direction == 'l') {
                right = node;
            } else {
                left = node;
            }
        }
        while (head.next != null) {
            if (abs(head.idx) != INF) {
                out.println(head.idx);
            }
            head = head.next;
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

    public static void main(String[] args) throws IOException {
        try (EscapeFromStones instance = new EscapeFromStones()) {
            instance.solve();
        }
    }
}
