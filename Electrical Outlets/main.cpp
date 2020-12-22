#include <iostream>
using namespace std;

int main() {
	int n, k, current, total;
	cin >> n;
	for(int i = 0; i < n;i++){
		total = 0;
		cin >> k;
		for(int j = 0; j < k; j++){
			cin >> current;
			total += current;
		}
		total += (1 - k);
		cout << total << endl;	
	}
	return 0;
}
