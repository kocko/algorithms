package codeforces.contests1401_1500.problemset1468;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Berpizza implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = 1;
    while (t-- > 0) {
      int q = in.ni();
      int time = 0, idx = 1;
      TreeMap<Integer, int[]> monocarp = new TreeMap<>();
      TreeMap<Integer, TreeSet<int[]>> polycarp = new TreeMap<>();
      while (q-- > 0) {
        int type = in.ni();
        if (type == 1) {
          int money = in.ni();
          monocarp.put(time, new int[]{idx, money});

          TreeSet<int[]> set = polycarp.getOrDefault(money, new TreeSet<>(Comparator.comparingInt(x -> x[0])));
          set.add(new int[]{idx, time});
          polycarp.put(money, set);
          idx++;
        } else if (type == 2) {
          int key = monocarp.firstKey();
          int[] client = monocarp.get(key);
          polycarp.remove(client[1]);
          monocarp.remove(key);
          out.print(client[0]);
          out.print(' ');
        } else {
          int key = polycarp.lastKey();
          TreeSet<int[]> clients = polycarp.get(key);
          int[] first = clients.first();

          monocarp.remove(first[1]);
          clients.remove(clients.first());
          if (clients.size() > 0) {
            polycarp.put(key, clients);
          } else {
            polycarp.remove(key);
          }
          out.print(first[0]);
          out.print(' ');
        }
        time++;
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
    try (Berpizza instance = new Berpizza()) {
      instance.solve();
    }
  }
}
