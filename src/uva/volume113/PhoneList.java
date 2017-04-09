package uva.volume113;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutionException;

public class PhoneList implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class Trie {
        private class Node {
            private Map<Character, Node> children = new HashMap<>();
            private boolean isLeaf;
        }

        private Node root = new Node();

        private void insert(String word) throws Exception {
            Node current = root;
            Map<Character, Node> children = current.children;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                Node next;
                boolean existing = false;
                if (children.get(c) == null) {
                    if (current.isLeaf) throw new Exception();
                    else {
                        next = new Node();
                        children.put(c, next);
                    }
                } else {
                    next = children.get(c);
                    existing = true;
                }

                current = next;
                children = current.children;
                if (i == word.length() - 1) {
                    if (existing) throw new Exception();
                    next.isLeaf = true;
                }
            }
        }
    }

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            int n = in.ni();
            Trie trie = new Trie();
            boolean ok = true;
            while (n-- > 0) {
                String next = in.next();
                try {
                    trie.insert(next);
                } catch (Exception e) {
                    ok = false;
                }
            }
            out.println(ok ? "YES" : "NO");
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
        try (PhoneList instance = new PhoneList()) {
            instance.solve();
        }
    }
}
