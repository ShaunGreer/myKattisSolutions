#include <iostream>
using namespace std;

int main(){
    int n;
    string line;
    cin >> n;
    cin.ignore();
    while(getline(cin, line)){
        int numbers[3];
        for(int i = 0; i < 3; i++) {
            int pos_of_space = line.find(' ');
            numbers[i] = stoi(line.substr(0, pos_of_space));
            line.erase(0, pos_of_space + 1);
        }
        int a = numbers[0], b = numbers[1], c = numbers[2];
        if(a + b == c || a - b == c || b - a == c || a * b == c || a / (double)b == c || b / (double)a == c)
            cout << "Possible" << endl;
        else
            cout << "Impossible" << endl;
    }
    return 0;
}