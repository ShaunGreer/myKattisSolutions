#include <iostream>
#include <cmath>
using namespace std;

int main(){
    int b, k, g;
    cin >> b >> k >> g;

    int search_parties = k/g;
    int bridges_to_search = b - 1;
    cout << ceil(bridges_to_search/(double)search_parties) << endl;

    return 0;
}