package topcoder.contests401_500.srm475;

import java.util.ArrayList;
import java.util.List;

public class RabbitStepping {

  public double getExpected(String field, int r) {
    int n = field.length();
    int rabbits = 0, total = 0;
    for (int mask = 0; mask < (1 << n); mask++) {
      int bits = Integer.bitCount(mask);
      if (bits == r) {
        rabbits += play(field.toCharArray(), mask);
        total++;
      }
    }
    return (double) rabbits / total;
  }

  private class Rabbit {
    private int lastPosition, currentPosition;

    private Rabbit(int currentPosition) {
      this.lastPosition = -1;
      this.currentPosition = currentPosition;
    }
  }

  private int play(char[] field, int mask) {
    int n = field.length;
    List<Rabbit> rabbits = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int bit = 1 << i;
      if ((mask & bit) != 0) {
        rabbits.add(new Rabbit(i));
      }
    }
    int size = n;
    while (size > 2) {
      for (Rabbit rabbit : rabbits) {
        int pos = rabbit.currentPosition;
        if (pos == 0) {
          rabbit.currentPosition = 1;
        } else if (pos == size - 1 || pos == size - 2) {
          rabbit.currentPosition = pos - 1;
        } else if (field[pos] == 'W') {
          rabbit.currentPosition = pos - 1;
        } else if (field[pos] == 'B') {
          rabbit.currentPosition = pos + 1;
        } else if (field[pos] == 'R') {
          if (rabbit.lastPosition != -1) {
            rabbit.currentPosition = rabbit.lastPosition;
          } else {
            rabbit.currentPosition = pos - 1;
          }
        }
        rabbit.lastPosition = pos;
      }
      List<Rabbit> next = new ArrayList<>();
      for (int i = 0; i < rabbits.size(); i++) {
        boolean shouldBeRemoved = false;
        for (int j = 0; j < rabbits.size(); j++) {
          if (i != j) {
            shouldBeRemoved |= rabbits.get(i).currentPosition == rabbits.get(j).currentPosition;
          }
        }
        if (!shouldBeRemoved) {
          next.add(rabbits.get(i));
        }
      }
      rabbits = next;
      size--;
    }
    return rabbits.size();
  }

}
