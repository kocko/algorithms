package uva.volume007;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class FourEightSeven implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private final Map<Character, Integer> map = new HashMap<Character, Integer>() {{
       put('A', 2); put('B', 2); put('C', 2); 
       put('D', 3); put('E', 3); put('F', 3); 
       put('G', 4); put('H', 4); put('I', 4); 
       put('J', 5); put('K', 5); put('L', 5); 
       put('M', 6); put('N', 6); put('O', 6); 
       put('P', 7); put('R', 7); put('S', 7); 
       put('T', 8); put('U', 8); put('V', 8); 
       put('W', 9); put('X', 9); put('Y', 9);
    }};
    
    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            int n = in.ni();
            TreeMap<String, Integer> directory = new TreeMap<>();
            while (n-- > 0) {
                char[] next = in.next().toCharArray();
                StringBuilder key = new StringBuilder();
                for (char c : next) {
                    if (c == '-') continue;
                    if (c >= '0' && c <= '9') key.append(c);
                    else key.append(map.get(c));
                }
                directory.put(key.toString(), directory.getOrDefault(key.toString(), 0) + 1);
            }
            boolean duplicates = false;
            for (Map.Entry<String, Integer> entry : directory.entrySet()) {
                if (entry.getValue() > 1) {
                    duplicates = true;
                    out.println(standardForm(entry.getKey()) + " " + entry.getValue());
                }
            }
            if (!duplicates) {
                out.println("No duplicates.");
            }
            if (t > 0) out.println();
        }
    }
    
    private String standardForm(String x) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            result.append(x.charAt(i));
        }
        result.append('-');
        for (int i = 3; i < x.length(); i++) {
            result.append(x.charAt(i));
        }
        return result.toString();
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
        try (FourEightSeven instance = new FourEightSeven()) {
            instance.solve();
        }
    }
}
