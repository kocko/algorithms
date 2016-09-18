package csadademy.problemset012;

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

public class IndependentRectangles implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class Rectangle implements Comparable<Rectangle> {
        int w;
        int h;
        
        Rectangle(int w, int h) {
            this.w = w;
            this.h = h;
        }

        @Override
        public boolean equals(Object obj) {
            Rectangle p = (Rectangle) obj;
            return (w == p.w && h == p.h);
        }
        
        @Override
        public int compareTo(Rectangle o) {
            if (o.w == w) {
                return Integer.compare(o.h, h);
            }
            return Integer.compare(w, o.w);
        }
    }
    
    public void solve() {
        int n = in.ni();
        List<Rectangle> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = in.ni(), b = in.ni();
            list.add(new Rectangle(a, b));
        }
        Collections.sort(list);
        
        int count = 0, h = 0;;
        for (int i = n - 1; i >= 0; i--) {
            if (list.get(i).h >= h) {
                count++;
                h = list.get(i).h;
            }
        }
        out.println(count);
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
        try (IndependentRectangles instance = new IndependentRectangles()) {
            instance.solve();
        }
    }
}
