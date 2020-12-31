#include <iostream>
#include <ctgmath>

using namespace std;

bool dcmp(double a, double b);
int next_non_zero(double hands[], size_t size, int index);
int winner (double hands[], size_t size);

int main() {
    int s, n;
    cin >> s >> n;
    double player = 1.0;
    double hands[n * 2];
    for(int i = 0; i < n * 2; i+=2){
        hands[i] = player;
        hands[i+1] = 0.0;
        player++;
    }

    int index = 0;
    while(true){
        //One round of the rhyme
        for(int i = 0; i < (s - 1); i++){
            if(dcmp(hands[index], 0.0))
                i--;    //Skip turn
            index++;
            if(index == (n * 2))
                index = 0;
        }
        if(dcmp(hands[index], 0.0))
            index = next_non_zero(hands, n * 2, index);

        //Perform action on coconut
        if(dcmp(fmod(hands[index], 1.0), 0.0)) {
            hands[index] += 0.1;
            hands[index + 1] = hands[index];
        } else if(dcmp(fmod(hands[index], 1.0), 0.1)) {
            hands[index] += 0.1;
            index = next_non_zero(hands, n * 2, index);
        } else {
            hands[index] = 0;
            index = next_non_zero(hands, n * 2, index);
        }

        //If there is a winner
        int winner_index = winner(hands, n * 2);
        if(!dcmp(winner_index ,-1)){
            cout <<  winner_index / 2 + 1;
            return 0;
        }
    }
}

bool dcmp(double a, double b){
    return fabs(a - b) < 0.000001;
}

int next_non_zero(double hands[], size_t size, int index){
    for(int i = index + 1; i <= size; i++){
        if(i == size)
            i = 0;
        if(!dcmp(hands[i], 0.0))
            return i;
    }
    return 0;
}

int winner (double hands[], size_t size){
    int winner = -1;
    for(int i = 0; i < size; i++){
        if(!dcmp(hands[i], 0.0) && winner == -1)
            winner = i;
        else if(!dcmp(hands[i], 0.0) && winner != -1)
            return -1;
    }
    return winner;
}