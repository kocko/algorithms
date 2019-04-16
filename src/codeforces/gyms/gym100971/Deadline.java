package codeforces.gyms.gym100971;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.util.Comparator.comparingLong;

public class Deadline implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);
  
  public void solve() {
    int n = in.ni();
    List<Integer> tasks = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }
    deadline = new long[n];
    time = new long[n];
    for (int idx = 0; idx < n; idx++) {
      deadline[idx] = in.nl();
      time[idx] = in.nl();
      tasks.add(idx);
      int depends = in.ni();
      for (int i = 0; i < depends; i++) {
        int dep = in.ni() - 1;
        graph.get(idx).add(dep);
      }
    }
    tasks.sort(comparingLong((Integer x) -> deadline[x]));
    color = new int[n];
    for (Integer task : tasks) {
      if (color[task] == 0) {
        complete(task);
      }
    }
    
    if (possible && order.size() == n) {
      out.println("YES");
      for (int vertex : order) {
        out.print(vertex + 1);
        out.print(' ');
      }
    } else {
      out.println("NO");
    }
  }

  private long[] deadline, time;
  private List<List<Integer>> graph = new ArrayList<>();
  private List<Integer> order = new ArrayList<>();
  private boolean possible = true;
  private int[] color;
  private int currentTime = 0;
  
  private void complete(int idx) {
    color[idx] = 1;
    for (int depend : graph.get(idx)) {
      if (color[depend] == 1) {
        possible = false;
        break;
      } else if (color[depend] == 0) {
        complete(depend);
      }
    }
    color[idx] = 2;
    if (currentTime + time[idx] <= deadline[idx]) {
      order.add(idx);
      currentTime += time[idx];
    } else {
      possible = false;
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
    try (Deadline instance = new Deadline()) {
      instance.solve();
    }
  }
}
