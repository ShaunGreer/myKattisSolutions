#include <iostream>
using namespace std;

int main(){
	int t, x, y, total;
	cin >> t;
	for(int i = 0; i < t; i++){
		total = 0;
		cin >> x;
		while(x != 0){
			cin >> y;
			if(y > (x * 2)){
				total += (y - (x * 2));	
			}
			x = y;		
		}
		cout << total << endl;
	}
	return 0;
}
