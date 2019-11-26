package codeforces.contests301_400.problemset358;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class DimaAndContainers implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  private class Value {
    private int idx;
    private int value;

    private Value(int idx, int value) {
      this.idx = idx;
      this.value = value;
    }
  }

  public void solve() {
    int q = in.ni();
    ArrayDeque<Value> stack = new ArrayDeque<>(), queue = new ArrayDeque<>(), deque = new ArrayDeque<>();
    String[] result = new String[q];
    for (int i = 0; i < q; i++) {
      int v = in.ni();
      Value n = new Value(i, v);
      if (v == 0) {
        int count = 0;
        StringJoiner operations = new StringJoiner(" ");
        if (stack.size() > 0) {
          Value value = stack.pollLast();
          result[value.idx] = "pushStack";
          count++;
          operations.add("popStack");
        }
        if (queue.size() > 0) {
          Value value = queue.pollLast();
          result[value.idx] = "pushQueue";
          count++;
          operations.add("popQueue");
        }
        if (deque.size() > 0) {
          Value value = deque.pollFirst();
          result[value.idx] = "pushFront";
          count++;
          operations.add("popFront");
        }
        result[i] = (count + " " + operations.toString()).trim();
        stack.clear();
        queue.clear();
        deque.clear();
      } else {
        if (stack.size() == 0) {
          stack.addLast(n);
        } else {
          Value move;
          if (stack.peekLast().value <= n.value) {
            move = stack.pollLast();
            stack.addLast(n);
          } else {
            move = n;
          }
          if (queue.size() == 0) {
            queue.addLast(move);
          } else {
            if (queue.peekFirst().value <= move.value) {
              Value tmp = queue.pollFirst();
              queue.addLast(move);
              move = tmp;
            }
            if (deque.size() == 0) {
              deque.addFirst(move);
            } else {
              if (deque.peekFirst().value <= move.value) {
                deque.addFirst(move);
              } else {
                deque.addLast(move);
              }
            }
          }
        }
      }
    }
    for (int i = 0; i < q; i++) {
      if (result[i] == null) {
        out.println("pushBack");
      } else {
        out.println(result[i]);
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
    try (DimaAndContainers instance = new DimaAndContainers()) {
      instance.solve();
    }
  }
}
