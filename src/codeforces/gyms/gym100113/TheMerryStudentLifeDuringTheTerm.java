package codeforces.gyms.gym100113;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.util.Arrays.sort;

public class TheMerryStudentLifeDuringTheTerm implements Closeable {

  private InputReader in;
  private PrintWriter out;
  
  public TheMerryStudentLifeDuringTheTerm() throws IOException {
    in = new InputReader(new FileInputStream(new File("student.in")));
    out = new PrintWriter(new FileOutputStream(new File("student.out")));
  }

  private class Lab implements Comparable<Lab> {
    private int idx;
    private long weight, time;

    private Lab(int idx, long weight, long time) {
      this.idx = idx;
      this.weight = weight;
      this.time = time;
    }

    @Override
    public int compareTo(Lab other) {
      return Long.compare(time * other.weight, weight * other.time);
    }
  }

  private class Subject implements Comparable<Subject> {
    private Lab[] labs;
    private long time, weight;

    private Subject(Lab[] labs) {
      this.labs = labs;
      for (Lab lab : labs) {
        time += lab.time;
        weight += lab.weight;
      }
    }

    @Override
    public int compareTo(Subject other) {
      return Long.compare(time * other.weight, other.time * weight);
    }
  }

  public void solve() {
    int n = in.ni(), total = 0;
    int[] k = new int[n];
    for (int i = 0; i < n; i++) {
      k[i] = in.ni();
      total += k[i];
    }
    long[] time = new long[total];
    int idx = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < k[i]; j++) {
        time[idx++] = in.nl();
      }
    }
    long[] weight = new long[total];
    idx = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < k[i]; j++) {
        weight[idx++] = in.nl();
      }
    }
    idx = 0;
    Subject[] subjects = new Subject[n];
    for (int i = 0; i < n; i++) {
      Lab[] labs = new Lab[k[i]];
      for (int j = 0; j < k[i]; j++, idx++) {
        labs[j] = new Lab(idx + 1, weight[idx], time[idx]);
      }
      sort(labs);
      subjects[i] = new Subject(labs);
    }
    sort(subjects);
    long currentTime = 0;
    long result = 0;
    for (Subject subject : subjects) {
      Lab[] labs = subject.labs;
      for (Lab lab : labs) {
        currentTime += lab.time;
        result += currentTime * lab.weight;
      }
    }
    out.println(result);
    for (Subject subject : subjects) {
      Lab[] labs = subject.labs;
      for (Lab lab : labs) {
        out.print(lab.idx);
        out.print(' ');
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
    try (TheMerryStudentLifeDuringTheTerm instance = new TheMerryStudentLifeDuringTheTerm()) {
      instance.solve();
    }
  }
}
