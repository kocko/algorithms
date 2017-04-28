#include <cstdio>
#include <cstring>
using namespace std;

typedef long long ll;

ll ft[10005];

int N;

ll query(int idx)	{
	ll sum = 0;
	for (; idx; idx -= (idx & -idx)) {
		sum += ft[idx];
	}
	return sum;
}

void update(int idx, int value) {
	for (; idx <= N; idx += (idx & -idx)) {
		ft[idx] += value;
	}
}

void range_update(int i, int j, int v)	{
	update(i, v);
	update(j + 1, -v);
}

int main()  {
	int T, U, Q, i, l, r, val;

	scanf("%d", &T);
	while (T--)	{
		scanf("%d %d", &N, &U);
		memset(ft, 0, (N+1) * sizeof(ll));

		for (i = 0; i < U; i++)	{
			scanf("%d %d %d", &l, &r, &val);
			range_update(l + 1, r + 1, val);
		}
		scanf("%d", &Q);
		for (i = 0; i < Q; i++)	{
			scanf("%d", &val);
			printf("%lld\n", query(val + 1));
		}
	}

    return 0;
}
