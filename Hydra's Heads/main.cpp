#include <iostream>
using namespace std;

int main(){
    while(true){
        int h, t, moves = 0;
        cin >> h >> t;
        if(h == 0 && t == 0)
            return 0;

        while(h != 0 || t != 0) {
            if(h == 1 && t == 1){
                t++;    //Cut off 1 tail
            } else if (h == 1 && t == 0){
                moves = -1; //No solutions
                break;
            } else if(h == 0 && t < 4){
                t++;    //Don't cut the 2 tails or infiinte loop
            } else if(h == 0 && t >= 4){
                h++;    //Cut off 2 tails
                t-=2;
            } else if((h % 2 != 0) && t > 1){
                t-=2;   //Cut off 2 tails
                h++;
            } else if(h > 1){
                h-=2;   //Cut off 2 heads
            }

            moves++;
        }
        cout << moves << endl;
    }
}
