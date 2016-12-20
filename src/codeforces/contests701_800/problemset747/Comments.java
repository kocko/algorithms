package codeforces.contests701_800.problemset747;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Comments implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class Comment {
        private String content;
        private int children;
        
        private Comment(String content, int children) {
            this.content = content;
            this.children = children;
        }
    }
    
    public void solve() {
        String[] next = in.next().split(",");
        int n = next.length;
        comments = new Comment[n / 2];
        for (int i = 0; i < n; i += 2) {
            comments[i / 2] = new Comment(next[i], Integer.parseInt(next[i + 1]));   
        }
        levels = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            levels.add(new ArrayList<>());
        }
        while (++index < n / 2) {
            recurse(0);
        }
        out.println(maxLevel + 1);
        for (int i = 0; i <= maxLevel; i++) {
            List<String> list = levels.get(i);
            for (String s : list) {
                out.print(s + " ");
            }
            out.println();
        }
    }
    
    private Comment[] comments;
    private int index = -1;
    private int maxLevel = -1;
    private List<List<String>> levels;
    
    private void recurse(int level) {
        Comment c = comments[index];
        levels.get(level).add(c.content);
        maxLevel = Math.max(level, maxLevel);
        for (int i = 0; i < c.children; i++) {
            index++;
            recurse(level + 1);
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
        try (Comments instance = new Comments()) {
            instance.solve();
        }
    }
}
