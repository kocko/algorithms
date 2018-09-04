#include <bits/stdc++.h>
 
typedef long long hyper;
 
#define endl '\n'
 
using namespace std;
 
const int MAX_N = 100000;
 
vector<int> graph[MAX_N], rev[MAX_N], order;
int degree[MAX_N], component[MAX_N];
bool visited[MAX_N];
 
void dfs1(int node) {
  visited[node] = true;
  for (auto next : graph[node]) {
    if (!visited[next]) {
      dfs1(next);
    }
  }
  order.push_back(node);
}
 
void dfs2(int node, int c) {
  visited[node] = false;
  component[node] = c;
  for (auto next : rev[node]) {
    if (visited[next]) {
      dfs2(next, c);
    }
  }
}
 
int main() {
  int n, m;
  cin >> n >> m;
  for (int i = 0; i < m; i++) {
    int u, v;
    cin >> u >> v;
    rev[u - 1].push_back(v - 1);
    graph[v - 1].push_back(u - 1);
  }
  for (int i = 0; i < n; i++) {
    if (!visited[i]) {
      dfs1(i);
    }
  }
  int count = 0;
  for (int i = n - 1; i >= 0; i--) {
    int node = order[i];
    if (visited[node]) {
      dfs2(node, count);
      count++;
    }
  }
  for (int u = 0; u < n; u++) {
    for (auto v : graph[u]) {
      if (component[u] != component[v]) {
        degree[component[v]]++;
      }
    }
  }
  int leaves = 0;
  for (int i = 0; i < count; i++) {
    if (degree[i] == 0) {
      leaves++;
    }
  }
  if (leaves > 1) {
    cout << 0 << endl;
  } else {
    vector<int> result;
    for (int i = 0; i < n; i++) {
      if (degree[component[i]] == 0) { 
        result.push_back(i + 1); 
      }
    }
    cout << result.size() << endl;
    for (auto vertex : result) {
      cout << vertex << ' ';
    }
  }
  return 0;
}