#include <bits/stdc++.h>

using namespace std;

#define endl '\n'

const int MAX_W = 200, MAX_N = 30000;
int bucket[MAX_W + 1]; 
int people[MAX_N];

int main() {
  int w, n;
  cin >> w >> n;
  for (int i = 0; i < n; i++) {
    int next;
    cin >> next;
    bucket[next]++;    
  }
  int idx = 0;
  for (int b = MAX_W; b >= 0; b--) {
    while (bucket[b]--) {
      people[idx++] = b;
    }
  }
  int i = 0, j = n - 1;
  while (i <= j) {
    if (people[i] + people[j] <= w) {
      j--;
    }
    i++;
  }
  cout << i << endl;
  return 0;
}
