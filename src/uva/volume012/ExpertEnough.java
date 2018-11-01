package uva.volume012;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ExpertEnough implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class Type {
        private String name;
        private int left, right;

        private Type(String name, int left, int right) {
            this.name = name;
            this.left = left;
            this.right = right;
        }

        private boolean isWithin(int price) {
            return price >= left && price <= right;
        }
    }

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            int n = in.ni();
            List<Type> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new Type(in.next(), in.ni(), in.ni()));
            }
            int q = in.ni();
            while (q-- > 0) {
                int price = in.ni(), count = 0;
                String name = null;
                for (int i = 0; i < n; i++) {
                    if (list.get(i).isWithin(price)) {
                        count++;
                        name = list.get(i).name;
                    }
                    if (count == 2) {
                        break;
                    }
                }
                if (count == 0 || count >= 2) {
                    name = "UNDETERMINED";
                }
                out.println(name);
            }
            if (t >= 1) {
                out.println();
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
        try (ExpertEnough instance = new ExpertEnough()) {
            instance.solve();
        }
    }
}
