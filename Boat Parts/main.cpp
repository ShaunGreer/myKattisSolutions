#include <iostream>
#include <algorithm>

int main(){
    int p, n;
    std::cin >> p >> n;
    std::string parts[p];
    int index = 0, count = 0;
    for(int i = 0; i < n; ++i){
        std::string word;
        std::cin >> word;
        std::string* found = std::find(parts, parts + p, word);
        if(found == parts + p){
            parts[index] = word;
            index++;
            count++;
        }
        if(count == p){
            std::cout << std::to_string(i + 1);
            return 0;
        }
    }
    std::cout << "paradox avoided";
    return 0;
}