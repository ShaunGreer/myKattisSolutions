#include <iostream>
using namespace std;

int main(){
	int n, bats = 0, score = 0, current;
	cin >> n;
	for(int i = 0; i < n; i++){
		cin >> current;
		if (current >= 0){
			bats++;
			score += current;
		}	
	}
	cout << (score /( bats * 1.0));
	return 0;
}
