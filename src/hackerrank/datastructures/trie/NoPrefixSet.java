package hackerrank.datastructures.trie;

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

public class NoPrefixSet implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class Trie {
        private class Node {
            private char c;
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
                    if (current.isLeaf) throw new Exception(word);
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
                    if (existing) throw new Exception(word);
                    next.isLeaf = true;
                }
            }
        }
    }

    public void solve() {
        int n = in.ni();
        Trie trie = new Trie();
        while (n-- > 0) {
            String next = in.next();
            try {
                trie.insert(next);
            } catch (Exception e) {
                out.println("BAD SET");
                out.println(e.getMessage());
                return;
            }
        }
        out.println("GOOD SET");
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
        try (NoPrefixSet instance = new NoPrefixSet()) {
            instance.solve();
        }
    }
}
