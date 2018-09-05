package uva.volume117;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class TrustGroups implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n, m;
        while ((n = in.ni()) != 0 | (m = in.ni()) != 0) {
            reset(n);
            Map<Person, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String surname = in.next(), name = in.next();
                map.put(new Person(name, surname.substring(0, surname.length() - 1)), i);
            }
            for (int i = 0; i < m; i++) {
                int[] edge = new int[2];
                for (int j = 0; j < 2; j++) {
                    String surname = in.next(), name = in.next();
                    Person key = new Person(name, surname.substring(0, surname.length() - 1));
                    edge[j] = map.get(key);
                }
                graph.get(edge[0]).add(edge[1]);
                reverse.get(edge[1]).add(edge[0]);
            }
            for (int i = 0; i < n; i++) {
                if (!visited[i]) dfs1(i);
            }
            int components = 0;
            for (int i = n - 1; i >= 0; i--) {
                int node = order.get(i);
                if (visited[node]) {
                    dfs2(node);
                    components++;
                }
            }
            out.println(components);
        }
    }
    
    private class Person {
        private String name, surname;

        private Person(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Person person = (Person) o;

            return name.equals(person.name) && surname.equals(person.surname);
        }

        @Override
        public int hashCode() {
            int result = name.hashCode();
            result = 31 * result + surname.hashCode();
            return result;
        }
    }
    
    private List<List<Integer>> graph, reverse;
    private List<Integer> order;
    private boolean[] visited;
    
    private void reset(int n) {
        graph = new ArrayList<>();
        reverse = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
        }
        order = new ArrayList<>();
        visited = new boolean[n];
    }
    
    private void dfs1(int node) {
        visited[node] = true;
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfs1(next);
            }
        }
        order.add(node);
    }
    
    private void dfs2(int node) {
        visited[node] = false;
        for (int next : reverse.get(node)) {
            if (visited[next]) {
                dfs2(next);
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
        try (TrustGroups instance = new TrustGroups()) {
            instance.solve();
        }
    }
}
