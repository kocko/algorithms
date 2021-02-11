package codeforces.contests1401_1500.problemset1481;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class FencePainting implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      read();
      solveCase();
    }
  }

  private int n, m;
  private int[] now, target, color;

  private void read() {
    n = in.ni();
    m = in.ni();
    now = new int[n];
    for (int i = 0; i < n; i++) {
      now[i] = in.ni();
    }
    target = new int[n];
    for (int i = 0; i < n; i++) {
      target[i] = in.ni();
    }
    color = new int[m];
    for (int i = 0; i < m; i++) {
      color[i] = in.ni();
    }
  }

  private void solveCase() {
    boolean possible = true;
    int plankForUnwanted = -1;
    for (int i = 0; i < n; i++) {
      if (target[i] == color[m - 1] && now[i] != target[i]) {
        plankForUnwanted = i;
        break;
      }
    }
    if (plankForUnwanted == -1) {
      for (int i = 0; i < n; i++) {
        if (target[i] == color[m - 1]) {
          plankForUnwanted = i;
          break;
        }
      }
      if (plankForUnwanted == -1) {
        print(false, null);
        return;
      }
    }

    Map<Integer, ArrayDeque<Integer>> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      if (i == plankForUnwanted) continue;
      if (now[i] != target[i]) {
        ArrayDeque<Integer> list = map.getOrDefault(target[i], new ArrayDeque<>());
        list.addLast(i);
        map.put(target[i], list);
      }
    }
    int[] result = new int[m];
    for (int i = 0; i < m - 1; i++) {
      int plank = plankForUnwanted;
      if (map.containsKey(color[i])) {
        ArrayDeque<Integer> queue = map.get(color[i]);
        plank = queue.poll();
        if (queue.size() == 0) {
          map.remove(color[i]);
        }
      }
      result[i] = plank;
      now[plank] = color[i];
    }
    result[m - 1] = plankForUnwanted;
    now[plankForUnwanted] = color[m - 1];

    for (int i = 0; i < n; i++) {
      possible &= now[i] == target[i];
    }
    print(possible, result);
  }

  private void print(boolean possible, int[] result) {
    if (possible) {
      out.println("YES");
      for (int idx : result) {
        out.print(idx + 1);
        out.print(' ');
      }
      out.println();
    } else {
      out.println("NO");
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
    try (FencePainting instance = new FencePainting()) {
      instance.solve();
    }
  }
}
