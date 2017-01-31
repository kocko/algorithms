package codeforces.contests701_800.problemset762;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class UsbVsPs2 implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private class Mouse implements Comparable<Mouse> {
        private long price;
        private String type;
        
        private Mouse(long price, String type) {
            this.price = price;
            this.type = type;
        }

        @Override
        public int compareTo(Mouse o) {
            return Long.compare(this.price, o.price);
        }
    }
    
    public void solve() {
        int a = in.ni(), b = in.ni(), c = in.ni();
        int m = in.ni();
        List<Mouse> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(new Mouse(in.nl(), in.next()));
        }
        Collections.sort(list);
        long count = 0, total = 0;
        for (Mouse mouse : list) {
            String type = mouse.type;
            if ("USB".equals(type)) {
                if (a > 0) {
                    a--;
                    count++;
                    total += mouse.price;
                } else if (a == 0) {
                    if (c > 0) {
                        c--;
                        count++;
                        total += mouse.price;
                    }
                }
            } else {
                if (b > 0) {
                    b--;
                    count++;
                    total += mouse.price;
                } else if (b == 0) {
                    if (c > 0) {
                        c--;
                        count++;
                        total += mouse.price;
                    }
                }
            }
        }
        out.printf("%d %d\n", count, total);
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
        try (UsbVsPs2 instance = new UsbVsPs2()) {
            instance.solve();
        }
    }
}
