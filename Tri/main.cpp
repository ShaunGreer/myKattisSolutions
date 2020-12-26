#include <iostream>
using namespace std;

bool match(int a, int b, int c, char op);

int main(){
    string a,b,c;
    char ops[4] = {'+', '-', '*', '/'};
    cin >> a >> b >> c;
    for(int i = 0; i < 2; i++){
        for (int j = 0; j < 4; j++) {
            if(i == 1) {
                if(match(stoi(a), stoi(b), stoi(c), ops[j])){
                    cout << (a + ops[j] + b + '=' + c);
                    return 0;
                }
            }
            else {
                if(match(stoi(b), stoi(c), stoi(a), ops[j])){
                    cout << (a + '=' + b + ops[j] + c);
                    return 0;
                }
            }
        }
    }
	return 0;
}

bool match(int a, int b, int c, char op){
    switch (op) {
        case '+':
            return a + b == c;
        case '-':
            return a - b == c;
        case '*':
            return a * b == c;
        default:
            return a / b == c;
    }
}
