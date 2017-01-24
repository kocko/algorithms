package hackerrank.datastructures.stacks;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class SimpleTextEditor implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private interface Command {
        void apply();
    } 
    
    private class Append implements Command {
        private char[] word;
        
        private Append(char[] word) {
            this.word = word;
        }

        @Override
        public void apply() {
            append(this.word);
        }

        @Override
        public String toString() {
            return "Append " + new String(word);
        }
    }
    
    private class Delete implements Command {
        private int k;
        
        private Delete(int k) {
            this.k = k;
        }

        @Override
        public void apply() {
            delete(k);
        }

        @Override
        public String toString() {
            return "Delete " + String.valueOf(k);
        }
    }
    
    private char[] text = new char[1000000];
    private int idx = 0;
    
    private Stack<Command> log = new Stack<>(); 

    public void solve() {
        int q = in.ni();
        while (q-- > 0) {
            int type = in.ni();
            switch (type) {
                case 1: { 
                    int n = append(in.next().toCharArray());
                    log.push(new Delete(n));
                    break; 
                }
                case 2: { 
                    char[] deleted = delete(in.ni()); 
                    log.add(new Append(deleted));
                    break; 
                } 
                case 3: { 
                    print(in.ni()); 
                    break; 
                }
                case 4: { 
                    undo(); 
                    break; 
                }
            }
        }
    }
    
    private int append(char[] w) {
        int n = w.length;
        System.arraycopy(w, 0, text, idx, n);
        idx += n;
        return n;
    }
    
    private char[] delete(int k) {
        idx -= k;
        char[] deleted = new char[k];
        System.arraycopy(text, idx, deleted, 0, k);
        return deleted;
    }
    
    private void print(int k) {
        out.println(text[k - 1]);
    }
    
    private void undo() {
        Command last = log.pop();
        last.apply();
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
        try (SimpleTextEditor instance = new SimpleTextEditor()) {
            instance.solve();
        }
    }
}
