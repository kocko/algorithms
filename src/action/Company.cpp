#include <cstdio>
#include <vector>
#include <algorithm>

#define MAX 200001

int main() {
  FILE* in = stdin; FILE* out = stdout;
  
  int n;
  fscanf(in, "%d", &n);
  
  std::vector<int> graph[MAX];
  
  for (int i = 0; i < n - 1; i++) {
    int u, v;
    fscanf(in, "%d %d", &u, &v);
    graph[u].push_back(v);
  }
  
  for (int node = 0; node < n; node++) {
    std::sort(graph[node].rbegin(), graph[node].rend());
  }
  
  static int ans[MAX], ansSize = 0;
  static int index[MAX] = {0};
  static int stack[MAX], stackSize = 0;
    
  stack[stackSize++] = 1;
  while (stackSize) {
    int node = stack[stackSize - 1];
    if (index[node] < graph[node].size())
      stack[stackSize++] = graph[node][index[node]++];
    else ans[ansSize++] = stack[--stackSize];
  }
	
  for (int i = ansSize - 1; i >= 0; i--)
    fprintf(out, "%d%c", ans[i], i == 0 ? '\n' : ' ');
  
  return 0;
}
