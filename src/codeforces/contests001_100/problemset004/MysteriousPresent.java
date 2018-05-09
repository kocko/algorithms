package codeforces.contests001_100.problemset004;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.util.Comparator.comparing;

public class MysteriousPresent implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class Envelope {
        private int idx, width, height;

        private Envelope(int idx, int width, int height) {
            this.idx = idx;
            this.width = width;
            this.height = height;
        }

        private int getWidth() {
            return width;
        }

        private int getHeight() {
            return height;
        }
    }

    public void solve() {
        int n = in.ni(), width = in.ni(), height = in.ni();
        List<Envelope> list = new ArrayList<>();
        for (int idx = 1; idx <= n; idx++) {
            list.add(new Envelope(idx, in.ni(), in.ni()));
        }
        list.sort(comparing(Envelope::getWidth).thenComparing(Envelope::getHeight));
        int[] next = new int[n], size = new int[n];
        int longest = 0, idx = -1;
        for (int i = n - 1; i >= 0; i--) {
            Envelope current = list.get(i);
            if (current.width > width && current.height > height) {
                int nxt = -1, w = current.width, h = current.height, chain = -1;
                for (int j = i + 1; j < n; j++) {
                    Envelope e = list.get(j);
                    if (e.width > w && e.height > h && size[j] > chain) {
                        nxt = j;
                        chain = size[j];
                    }
                }
                if (nxt != -1) {
                    next[i] = nxt;
                    size[i] = size[nxt] + 1;
                } else {
                    size[i] = 1;
                }
                if (size[i] > longest) {
                    longest = size[i];
                    idx = i;
                }
            }
        }

        out.println(longest);
        for (int i = 0; i < longest; i++) {
            out.print(list.get(idx).idx);
            out.print(' ');
            idx = next[idx];
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
        try (MysteriousPresent instance = new MysteriousPresent()) {
            instance.solve();
        }
    }
}
