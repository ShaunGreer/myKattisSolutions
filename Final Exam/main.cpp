#include <iostream>
using namespace std;

int main(){
	int n,total=0;
	char current,next;
	cin >> n;
	cin >> current;	

	for(int i = 0; i < n-1; i++){
		cin >> next;
		if (current == next)
			total++;
		current = next;	
	}
	
	cout << total;
	return 0;
}
