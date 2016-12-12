#include<bits/stdc++.h>
using namespace std;

int query(int left, int right) {
    printf("%s", "Test");
    for(int i = left; i <= right; ++i) {
        printf(" %d", i);
    }
    putchar('\n');
    fflush(stdout);

    int result;
    scanf("%d", &result);
    return result;
}

int get_fake_coin(int left, int right) {
    for (int i = 0; i < 5; i++) {
		int size = right - left + 1, offset = size / 3;
		if (size % 3 == 1) {
			offset = size / 3;
		} else if (size % 3 == 2) {
			offset = size / 3 + 1;
		}
		int mid = left + 2 * offset - 1;
		int response = query(left, mid);
		if (response == 0) {
			left = mid + 1;
		} else if (response == 1) {
			right = left + offset - 1;
		} else if (response == -1) {
			left = mid - offset + 1;
			right = mid;
		}
		if (left == right) {
			return left;
		}
	}
	return -1;
}

void solve(int n) {
    printf("Answer %d\n", get_fake_coin(1, n));
    fflush(stdout);
}

int main() {
#ifndef ONLINE_JUDGE
    //freopen("E:\\IN.txt", "r", stdin);
    //freopen("E:\\OUT.txt", "w", stdout);
#endif
    int tests, n;
    scanf("%d", &tests);
    while(tests--) {
        scanf("%d", &n);
        solve(n);
    }
   
}