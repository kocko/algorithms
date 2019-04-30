package codeforces.gyms.gym100971;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

import static java.lang.Math.abs;

public class LayingCables implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  private class City {
    private int idx, coordinate, people;

    private City(int idx, int coordinate, int people) {
      this.idx = idx;
      this.coordinate = coordinate;
      this.people = people;
    }
  }

  public void solve() {
    int n = in.ni();
    List<City> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list.add(new City(i, in.ni(), in.ni()));
    }
    list.sort(Comparator.comparingInt((City x) -> x.people).reversed());
    TreeSet<City> bigger = new TreeSet<>(Comparator.comparingInt(x -> x.coordinate));
    final int oo = Integer.MAX_VALUE;
    int[] parent = new int[n];
    for (City city : list) {
      int parentDist = oo;
      City p = null;
      City a = bigger.higher(city);
      if (a != null) {
        int dist = abs(city.coordinate - a.coordinate);
        if (dist < parentDist) {
          parentDist = dist;
          p = a;
        }
      }
      
      City b = bigger.lower(city);
      if (b != null) {
        int dist = abs(city.coordinate - b.coordinate);
        if (dist < parentDist) {
          p = b;
        } else if (dist == parentDist) {
          if (b.people > p.people) {
            p = b;
          }
        }
      }
      parent[city.idx] = p != null ? p.idx + 1: -1; 
      bigger.add(city);
    }
    for (int p : parent) {
      out.print(p);
      out.print(' ');
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
    try (LayingCables instance = new LayingCables()) {
      instance.solve();
    }
  }
}
