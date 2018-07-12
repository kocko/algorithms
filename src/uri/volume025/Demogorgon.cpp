#include <bits/stdc++.h>
using namespace std;

int n, p, dp[1005][2005], damage[2005], cost[2005];
const int oo = (int) 5e7;

int recurse(int idx, int remaining) {
    if (remaining <= 0) return 0;
    if (idx == n) return oo;
    
    if (dp[idx][remaining] != -1) return dp[idx][remaining];
    
    return dp[idx][remaining] = min(cost[idx] + recurse(idx + 1, remaining - damage[idx]), recurse(idx + 1, remaining));
}

int main() {
    while (cin >> n >> p) {
        memset(dp, -1, sizeof dp);
        
        for (int i = 0; i < n; i++) cin >> damage[i] >> cost[i];
        
        int ans = recurse(0, p);
        if (ans != oo) cout << ans << endl;
        else cout << "-1\n";
    }
    return 0;
}