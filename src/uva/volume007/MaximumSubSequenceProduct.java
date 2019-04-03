package uva.volume007;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaximumSubSequenceProduct implements Closeable {

  private Scanner in = new Scanner(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    while (in.hasNextInt()) {
      List<BigInteger> list = new ArrayList<>();
      while (true) {
        int next = in.nextInt();
        if (next == -999999) break;
        list.add(BigInteger.valueOf(next));
      }
      maximumProduct(list);
    }
  }
  
  private void maximumProduct(List<BigInteger> nums) {
    BigInteger max = nums.get(0), min = max, result = max;
    for (int i = 1; i < nums.size(); i++) {
      BigInteger num = nums.get(i), copy = max;
      
      BigInteger a = min.multiply(num), b = max.multiply(num);
      
      if (a.compareTo(b) > 0) {
        if (a.compareTo(num) > 0) {
          max = a;
        } else {
          max = num;
        }
      } else {
        if (b.compareTo(num) > 0) {
          max = b;
        } else {
          max = num;
        }
      }
      
      if (a.compareTo(b) > 0) {
        if (b.compareTo(num) > 0) {
          min = num;
        } else {
          min = b;
        }
      } else {
        if (a.compareTo(num) > 0) {
          min = num;
        } else {
          min = a;
        }
      }

      if (max.compareTo(result) > 0) {
        result = max;
      }
    }
    out.println(result);
  }

  @Override
  public void close() throws IOException {
    in.close();
    out.close();
  }

  public static void main(String[] args) throws IOException {
    try (MaximumSubSequenceProduct instance = new MaximumSubSequenceProduct()) {
      instance.solve();
    }
  }
}
