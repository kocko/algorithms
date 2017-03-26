package uva.volume007;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class AnagramsByStack implements Closeable {

    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() throws IOException {
        String source;
        while ((source = in.readLine()) != null) {
            target = in.readLine();
            String stack = "";
            max = 2 * source.length();
            out.println('[');
            if (source.length() == target.length()) {
                recurse(source, "", "", stack, 0);
            }
            out.println(']');
        }
    }

    private int max;
    private String target;
    
    private void recurse(String source, String current, String path, String stack, int count) {
        if (count == max) {
            if (target.equals(current)) {
                out.println(path.trim());
                return;
            }
        }
        
        if (source.length() > 0) {
            recurse(source.substring(1), current, path + " i", stack + source.charAt(0), count + 1);
        }
        int size = stack.length();
        if (size > 0 && stack.charAt(size - 1) == target.charAt(current.length())) {
            recurse(source, current + stack.charAt(size - 1), path + " o", stack.substring(0, size - 1), count + 1);
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
        try (AnagramsByStack instance = new AnagramsByStack()) {
            instance.solve();
        }
    }
}
