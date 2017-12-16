package codeforces.contests801_900.problemset898;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class PhoneNumbers implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        Map<String, List<String>> map = new HashMap<>();
        while (n-- > 0) {
            String name = in.next();
            int k = in.ni();
            List<String> list = map.getOrDefault(name, new ArrayList<>());
            for (int i = 0; i < k; i++) {
                list.add(in.next());
            }
            map.put(name, list);
        }
        out.println(map.size());
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            out.print(entry.getKey());
            out.print(' ');
            process(entry.getValue());
        }
    }

    private void process(List<String> list) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            boolean include = true;
            for (int j = 0; j < list.size(); j++) {
                if (i != j && isSuffix(list.get(i), list.get(j))) {
                    include = false;
                    break;
                }
            }
            if (include) {
                set.add(list.get(i));
            }
        }
        out.print(set.size());
        out.print(' ');
        for (String s : set) {
            out.print(s);
            out.print(' ');
        }
        out.println();
    }

    private boolean isSuffix(String a, String b) {
        return b.endsWith(a) && b.length() > a.length();
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
        try (PhoneNumbers instance = new PhoneNumbers()) {
            instance.solve();
        }
    }
}
