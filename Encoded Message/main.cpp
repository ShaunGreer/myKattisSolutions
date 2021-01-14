#include <iostream>
#include <cmath>
using namespace std;

int main(){
    int n;
    cin >> n;

    for(int i = 0; i < n; i++){
        string message;
        cin >> message;
        int length = message.length(), size = sqrt(length), cut = size - 1;
        for(int j = 0; j < size; j++){
            int index = 0;
            for (int k = 0; k < size; k++) {
                cout << message[index + cut];
                index += size;
            }
            cut--;
        }
        cout << "\n";
    }

    return 0;
}