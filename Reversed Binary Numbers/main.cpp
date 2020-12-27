#include <iostream>
#include <bitset>
#include <string>
#include <algorithm>
using namespace std;

int main(){
    int n;
    cin >> n;
    string bin = bitset<30>(n).to_string();
    bin = bin.substr(bin.find_first_of('1'));
    reverse(bin.begin(), bin.end());
    cout << (stoi(bin, nullptr, 2)) << endl;
	return 0;
}
