package topcoder.contests601_700.srm627;

public class HappyLetterDiv1 {

  public String getHappyLetters(String letters) {
    StringBuilder result = new StringBuilder();
    for (char ch = 'a'; ch <= 'z'; ch++) {
      int[] cnt = new int[26];
      int count = 0;
      for (char c : letters.toCharArray()) {
        if (c != ch) {
          cnt[c - 'a']++;
        } else {
          count++;
        }
      }
      int remaining = play(cnt);
      if (remaining < count) {
        result.append(ch);
      }
    }
    return result.toString();
  }
  
  private int play(int[] cnt) {
    while (true) {
      int different = 0;
      for (int i = 0; i < 26; i++) {
        if (cnt[i] > 0) different++;
      }
      if (different == 0) return 0;
      if (different == 1) {
        for (int i = 0; i < 26; i++) {
          if (cnt[i] > 0) return cnt[i];
        }
      }
      int max = 0, min = Integer.MAX_VALUE;
      int maxIdx = -1, minIdx = -1;
      for (int i = 0; i < 26; i++) {
        if (cnt[i] > 0 && cnt[i] < min) {
          min = cnt[i];
          minIdx = i;
        }
      }
      for (int i = 0; i < 26; i++) {
        if (cnt[i] > 0 && cnt[i] > max && i != minIdx) {
          max = cnt[i];
          maxIdx = i;
        }
      }
      cnt[minIdx]--;
      cnt[maxIdx]--;
    }
  }
  
}
