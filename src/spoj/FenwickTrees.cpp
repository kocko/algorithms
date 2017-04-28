#include <iostream>

using namespace std;

long long int query(long long int BIT[], int i){
	long long int sum = 0;
	for(int index = i; index > 0; index -= (index & -index)){
		sum += BIT[index];
	}
	return sum;
}

void update(int arr[],long long int BIT[], int i, int val, int n){
	for(int index = i; index <= n; index += (index & -index)){
		BIT[index] = BIT[index] + val;
	}
}

int main(){
	//For Fast IO
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int N,x,Q,a,b;
	char operation;
	//Array to store the input values
	int arr[1000001];
	//Array to hold the Fenwick Tree, long long to hold large sums
	long long int BIT[1000001];
	cin>>N;
	for(int i=1; i<=N; i++){
		cin>>x;
		arr[i] = x;
	}
	//Build the Fenwick Tree
	for(int i=1; i<=N; i++){
		update(arr,BIT,i,arr[i],N);
	}
	cin>>Q;
	for(int i=0; i<Q; i++){
		cin>>operation>>a>>b;
		if(operation == 'q'){
			//Sum of elements 4,5,6 means sum of first 6 - first 3
			cout<<query(BIT,b) - query(BIT,a-1)<<"\n";
		}
		else if(operation == 'u'){
			update(arr,BIT,a,b,N);
		}
	}
	return 0;
}