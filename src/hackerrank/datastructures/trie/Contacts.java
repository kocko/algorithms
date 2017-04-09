package hackerrank.datastructures.trie;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Contacts implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private class Trie {
        private class Node {
            private Map<Character, Node> children = new HashMap<>();
            private int childrenCount;
        }
        
        private Node root = new Node();
        
        private void insert(String word) {
            Node current = root;
            Map<Character, Node> children = current.children;
            for (char c : word.toCharArray()) {
                children.putIfAbsent(c, new Node());
                current = children.get(c);
                children = current.children;
                current.childrenCount++;
            }
        }
        
        private int findChildrenCount(String prefix) {
            Node node = root;
            for (char c : prefix.toCharArray()) {
                if (node.children.get(c) != null) {
                    node = node.children.get(c);
                } else {
                    return 0;
                }
            }
            return node.childrenCount;
        }
    }

    public void solve() {
        int q = in.ni();
        Trie trie = new Trie();
        while (q-- > 0) {
            String operation = in.next();
            if ("add".equals(operation)) {
                trie.insert(in.next());
            } else {
                out.println(trie.findChildrenCount(in.next()));
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

    public static void main(String[] args) throws IOException {
        try (Contacts instance = new Contacts()) {
            instance.solve();
        }
    }
}
