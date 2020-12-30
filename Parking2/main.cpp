#include <iostream>
#include <algorithm>
using namespace std;

int main(){
    int t;
    cin >> t;
    for(int i = 0; i < t; i++){
        int n;
        cin >> n;
        int arr[n];
        for(int i = 0; i < n; i++){
            int c;
            cin >> c;
            arr[i] = c;
        }
        sort(arr, arr + n);
        int total = 0;
        for(int j = 0; j < n - 1; j++){
            total += arr[j + 1] - arr[j];
        }
        cout << total * 2 << endl;
    }

    return 0;
}