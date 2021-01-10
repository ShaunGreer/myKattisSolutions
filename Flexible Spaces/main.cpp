#include <iostream>
using namespace std;

int main(){
    int w, p;
    cin >> w >> p;
    int ls[p];
    for(int i = 0; i < p; ++i){
        int l;
        cin >> l;
        ls[i] = l;
    }

    int room = 1;
    while(room <= w){
        bool proceed = false;

        //Check for 1 partition
        for(int i = 0; i < p; ++i){
            if(ls[i] == room || (w - ls[i] == room)){
                cout << room << ' ';
                proceed = true;
                room++;

                break;
            }
        }
        if(proceed)
            continue;

        //Check for multiple partitions
        for(int i = p - 1; i > 0; --i){
            int cur = ls[i], copy = ls[i];
            if(proceed)
                break;
            for(int j = i - 1; j >= 0; --j){
                if(cur - ls[j] == room || copy - ls[j] == room){
                    cout << room << ' ';
                    proceed = true;
                    break;
                } else {
                    cur -= ls[j];
                }
            }
        }
        room++;
    }
    cout << w;
    return 0;
}