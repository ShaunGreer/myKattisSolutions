#include <iostream>
using namespace std;

bool isVowel(char c);

int main(){
    string sentence;
    getline(cin, sentence);
    for(int i = 0; i < sentence.length() - 1; i++){
        if(sentence[i] == 'p' && isVowel(sentence[i + 1])){
            sentence.erase(i, 2);
        }
    }
    cout << sentence;

    return 0;
}

bool isVowel(char c){
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
}