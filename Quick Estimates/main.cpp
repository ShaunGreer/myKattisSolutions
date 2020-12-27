#include <iostream>
#include <string>

using namespace std;

int main() {
    int n;
    cin >> n;
    string j;
    for(int i = 0; i < n; i++){
        cin >> j;
        cout << j.length() << endl;
    }
    return 0;
}
