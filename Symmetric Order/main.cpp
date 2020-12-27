#include <iostream>
#include <string>
#include <cmath>
using namespace std;

void reverseArray(string arr[], size_t size);
void printArray(string arr[], size_t size);

int main(){
    int n, set = 1;
    while (true){
        cin >> n;
        cin.ignore();
        if(n == 0)
            return 0;
        cout << "SET " + to_string(set) << endl;
        string first[(int)(ceil(n/2.0))], second[n/2];
        for (int i = 0; i < (n/2); i++) {
            string p1, p2;
            getline(cin, p1);
            getline(cin, p2);
            first[i] = p1;
            second[i] = p2;
        }
        if(n % 2 != 0){
            string last;
            getline(cin, last);
            first[(int)(ceil(n/2.0)) - 1] = last;
        }
        size_t size_of_first = sizeof(first)/sizeof(first[0]);
        size_t size_of_second = sizeof(second)/sizeof(second[0]);
        reverseArray(second, size_of_second);
        printArray(first, size_of_first);
        printArray(second, size_of_second);

        set++;
    }
}

void reverseArray(string arr[], size_t size){
    for(int low = 0, high = size - 1; low < high; low++, high--){
        swap(arr[low], arr[high]);
    }
}

void printArray(string arr[], size_t size){
    for (size_t i = 0; i < size; i++) {
        cout << arr[i] << endl;
    }
}