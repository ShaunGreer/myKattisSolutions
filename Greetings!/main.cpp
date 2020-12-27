#include <iostream>
#include <string>
using namespace std;

int main(){
	string x,es;
	cin >> x;
		
	es = x.substr(1,x.length()-2);	
	cout << 'h'+es+es+'y';
	return 0;
}

