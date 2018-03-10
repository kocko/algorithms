package codeforces.contests001_100.problemset016;

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

public class BurglarAndMatches implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        List<Container> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(new Container(in.ni(), in.ni()));
        }
        list.sort(Comparator.naturalOrder());
        int current = 0, matches = 0;
        for (Container container : list) {
            if (current + container.boxes <= n) {
                current += container.boxes;
                matches += container.boxes * container.count;
            } else {
                int diff = n - current;
                current += diff;
                matches += diff * container.count;
            }
        }
        out.println(matches);
    }
    
    private class Container implements Comparable<Container> {
        private int boxes, count;

        private Container(int boxes, int count) {
            this.boxes = boxes;
            this.count = count;
        }

        @Override
        public int compareTo(Container o) {
            return Integer.compare(o.count, this.count);
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
        try (BurglarAndMatches instance = new BurglarAndMatches()) {
            instance.solve();
        }
    }
}
