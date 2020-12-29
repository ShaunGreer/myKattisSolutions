#include <iostream>
using namespace std;

int main(){
    string a,b;
    char op;
    cin >> a >> op >> b;

    if(op == '*'){
        cout << a + b.substr(1);
    } else {
        string smaller = (a.length() < b.length()) ? a : b;
        string bigger = (a.length() < b.length()) ? b : a;
        string sub_bigger = bigger.substr(bigger.length() - smaller.length());
        string result;
        for (int i = 0; i < smaller.length(); i++) {
            if(smaller[i] == '1' && sub_bigger[i] == '1')
                result += '2';
            else if(smaller[i] == '1' || sub_bigger[i] == '1')
                result += '1';
            else
                result += '0';
        }
        cout << bigger.substr(0, bigger.size() - smaller.size()) + result;
    }

    return 0;
}