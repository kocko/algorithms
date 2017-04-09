package hackerearth.datastructures.advanced.trie;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SearchEngine implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private class Trie {
        private class Node {
            private Node[] children = new Node[26];
            private int score;
            
            private Node() {}
        }
        
        private Node root = new Node();
        
        private void insert(String word, int score) {
            Node[] children = root.children;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                Node next;
                if (children[idx] == null) {
                    next = new Node();
                    next.score = score;
                    children[idx] = next;
                } else {
                    next = children[idx];
                    next.score = Math.max(next.score, score);
                }
                children = next.children;
            }
        }
        
        private int findScore(String prefix) {
            Node node = search(prefix);
            return (node != null) ? node.score : -1;
        }
        
        private Node search(String prefix) {
            Node result = null;
            Node[] children = root.children;
            for (char c : prefix.toCharArray()) {
                int idx = c - 'a';
                if (children[idx] != null) {
                    result = children[idx];
                    children = result.children;
                } else {
                    return null;
                }
            }
            return result;
        }
    }

    public void solve() {
        int n = in.ni(), q = in.ni();
        Trie trie = new Trie();
        while (n-- > 0) {
            trie.insert(in.next(), in.ni());
        }
        while (q-- > 0) {
            out.println(trie.findScore(in.next()));
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
        try (SearchEngine instance = new SearchEngine()) {
            instance.solve();
        }
    }
}
