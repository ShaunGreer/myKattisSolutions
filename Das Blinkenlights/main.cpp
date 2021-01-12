#include <iostream>
using namespace std;

int main(){
    int p, q, s;
    cin >> p >> q >> s;
    int l1 = 0, l2 = 0;
    while(true) {
        l1 += p;
        l2 += q;
        if (l1 > s || l2 > s) {
            cout << "no";
            return 0;
        }
        while (l1 + p <= l2)
            l1 += p;
        while (l2 + q <= l1)
            l2 += q;
        if (l1 == l2) {
            cout << "yes";
            return 0;
        }
    }
}