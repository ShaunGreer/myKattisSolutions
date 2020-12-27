#include <iostream>
#include <string>
#include <math.h>
using namespace std;

bool validFlag(int i, int alt, int n);

int main(){
	int n, half;
	cin >> n;
	cout << (to_string(n) + ":") << endl;
	half = ceil(n / 2.0);
	
	for(int i = 2; i <= half; i++){
		if(validFlag(i, i-1, n))
			cout << (to_string(i) + "," + to_string(i-1)) << endl;
		if(validFlag(i, i, n))
			cout << (to_string(i) + "," + to_string(i)) << endl;
	
	} 

	return 0;
}

bool validFlag(int i, int alt, int n){
	int total = 0;
	bool alternateLine = false;
	while (total < n){
		if(alternateLine)
			total += alt;
		else
			total += i;
		alternateLine = !alternateLine;
	}
	if (total == n)
		return true;
	return false;
}
