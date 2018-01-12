package codeforces.contests301_400.problemset305;

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

import static java.lang.Math.*;

public class IvanAndPowersOfTwo implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(in.nl());
        }
        while (true) {
            List<Long> next = go(list);
            if (next.size() == list.size()) break;
            list = next;
        }
        int k = list.size();
        list.sort(Comparator.naturalOrder());
        long result = list.get(0);
        for (int i = 1; i < k; i++) {
            result += list.get(i) - list.get(i - 1) - 1;
        }
        out.println(result);
    }
    
    private List<Long> go(List<Long> list) {
        List<Long> result = new ArrayList<>();
        int n = list.size();
        for (int i = n - 1; i >= 0;) {
            long current = list.get(i);
            if (i > 0) {
                long previous = list.get(i - 1);
                if (current == previous) {
                    result.add(current + 1);
                    i -= 2;
                } else {
                    result.add(current);
                    i--;
                }
            } else {
                result.add(current);
                i--;
            }
        }
        return result;
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
        try (IvanAndPowersOfTwo instance = new IvanAndPowersOfTwo()) {
            instance.solve();
        }
    }
}
