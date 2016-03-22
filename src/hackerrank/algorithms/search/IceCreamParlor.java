package hackerrank.algorithms.search;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class IceCreamParlor implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    static class Element {
        int value;
        int index;

        public Element(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            int m = in.ni(), n = in.ni();
            List<Element> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new Element(in.ni(), i + 1));
            }
            Collections.sort(list, new Comparator<Element>() {
                @Override
                public int compare(Element o1, Element o2) {
                    return Integer.compare(o1.value, o2.value);
                }
            });
            for (int i = 0; i < n; i++) {
                if (list.get(i).value < m) {
                    boolean ok = false;
                    int left = i + 1, right = n - 1, mid = -1;
                    while (left <= right) {
                        mid = (left + right) / 2;
                        int sum = list.get(mid).value + list.get(i).value;
                        if (sum == m) {
                            ok = true;
                            break;
                        } else if (sum > m) {
                            right = mid - 1;
                        } else {
                            left = mid + 1;
                        }
                    }
                    if (ok) {
                        int min = Math.min(list.get(i).index, list.get(mid).index);
                        int max = Math.max(list.get(i).index, list.get(mid).index);
                        out.println(min + " " + max);
                        break;
                    }
                }
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

    public static void main(String[] args) {
        new IceCreamParlor().solve();
    }
}
