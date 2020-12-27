#include <iostream>
#include <string>

using namespace std;

int main(){
    int n;
    cin >> n;
    cin.ignore();
    for (int i = 0; i < n; i++) {
        string line;
        getline(cin, line);
        if(line.substr(0,5) == "Simon" && line.substr(6,4) == "says")
            cout << (line.substr(11)) << endl;

    }
	return 0;
}
