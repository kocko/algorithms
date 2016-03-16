package codeforces.contests600_699.problemset644;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class HostnameAliases implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        int n = in.ni();
        Map<String, Set<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String next = in.next();
            String[] split = findHostAndPath(next);
            String host = split[0], path = split[1];
            if (path != null) {
                Set<String> value = map.getOrDefault(host, new TreeSet<>());
                value.add(path);
                map.put(host, value);
            }
        }
        Set<String> used = new HashSet<>();
        Set<String> keys = map.keySet();
        List<Set<String>> groups = new ArrayList<>();
        for (String a : keys) {
            if (!used.contains(a)) {
                Set<String> group = new TreeSet<>();
                group.add(a);
                for (String b : keys) {
                    if (!used.contains(b)) {
                        if (map.get(a).equals(map.get(b))) {
                            group.add(b);
                            used.add(b);
                        }
                    }
                }
                used.add(a);
                if (group.size() > 1) groups.add(group);
            }
        }
        int size = groups.size();
        out.println(size);
        if (size > 0) {
            for (Set<String> set : groups) {
                for (String s : set) {
                    out.print(s + " ");
                }
                out.println();
            }
        }
    }

    String[] findHostAndPath(String address) {
        String[] split = address.split("/");
        if (split.length == 3) {
            if (address.charAt(address.length() - 1) != '/') {
                return new String[]{"http://" + split[2], null};
            } else {
                return new String[]{"http://" + split[2], "/"};
            }
        } else {
            int count = 0, thirdSlash = 0;
            for (int i = 0; i < address.length(); i++) {
                if (address.charAt(i) == '/') count++;
                if (count == 3) {
                    thirdSlash = i;
                    break;
                }
            }
            return new String[]{"http://" + split[2], address.substring(thirdSlash)};
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
        new HostnameAliases().solve();
    }
}
