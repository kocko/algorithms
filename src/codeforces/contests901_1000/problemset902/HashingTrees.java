package codeforces.contests901_1000.problemset902;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class HashingTrees implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int h = in.ni(), total = 0;
        int[] count = new int[h + 1];
        for (int i = 0; i < h + 1; i++) {
            count[i] = in.ni();
            total += count[i];
        }
        boolean ambiguous = false;
        int[] first = new int[total + 1], second = new int[total + 1];
        int firstParent = 1, lastParent = 1, next = 2;
        for (int i = 1; i <= h; i++) {
            if (count[i - 1] > 1 && count[i] > 1) {
                ambiguous = true;
                int nextF = -1, nextL = -1;
                for (int j = 0; j < count[i]; j++) {
                    if (j == 0) nextF = next;
                    if (j == count[i] - 1) nextL = next;
                    first[next] = firstParent;
                    second[next] = lastParent;
                    next++;
                }
                second[next - 1] = firstParent;
                firstParent = nextF;
                lastParent = nextL;
            } else if (count[i] == 1) {
                first[next] = firstParent;
                second[next] = firstParent;
                firstParent = lastParent = next;
                next++;
            } else if (count[i - 1] == 1) {
                int nextF = -1, nextL = -1;
                for (int j = 0; j < count[i]; j++) {
                    if (j == 0) nextF = next;
                    if (j == count[i] - 1) nextL = next;
                    first[next] = firstParent;
                    second[next] = firstParent;
                    next++;
                }
                firstParent = nextF;
                lastParent = nextL;
            }
        }
        if (ambiguous) {
            out.println("ambiguous");
            print(first);
            print(second);
        } else {
            out.println("perfect");
        }
    }

    private void print(int[] tree) {
        for (int i = 1; i < tree.length; i++) {
            out.print(tree[i]);
            out.print(' ');
        }
        out.println();
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
        try (HashingTrees instance = new HashingTrees()) {
            instance.solve();
        }
    }
}
