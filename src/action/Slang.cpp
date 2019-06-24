#include <bits/stdc++.h>

using namespace std;

#define endl '\n'

int main() {
  int t;
  cin >> t;
  
  unordered_set<string> set;
  while (t--) {
    string word;
    cin >> word;
    set.clear();
    int n = word.length();
    for (int i = 0; i <= n; i++) {
      string prefix = word.substr(0, i);
      set.insert(prefix);
      for (int j = i; j <= n; j++) {
        string temp = prefix + word.substr(j, n);
        set.insert(temp);
      }
    }
    cout << set.size() - 2 << endl;
  }

  return 0;
}
