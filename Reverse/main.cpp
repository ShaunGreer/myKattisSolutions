#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int main(){
	int n;
	string s, c;
	cin >> n;
	for(int i = 0; i < (n-1); i++){
		cin >> c;
		reverse(c.begin(), c.end());
		s.append(c);
		s.append("\n");	
	}	
	cin >> c;
	reverse(c.begin(), c.end());
	s.append(c);
	reverse(s.begin(), s.end());
	cout << s;
	return 0;
}
