#include <iostream>
#include <tuple>
using namespace std;

string get_card(tuple<string, int> cards[], int buying_power);

int main(){
    int g, s, c;
    cin >> g >> s >> c;

    //Calculate buying power
    int buying_power = (g * 3) + (s * 2) + (c * 1);

    //Create tuples with names of cards and cost
    tuple<string, int> victory_cards[3] = {
            make_tuple("Province",8),
            make_tuple("Duchy",5),
            make_tuple("Estate",2)
    };
    tuple<string, int> treasure_cards[3] = {
            make_tuple("Gold",6),
            make_tuple("Silver",3),
            make_tuple("Copper",0)
    };

    string best_victory = get_card(victory_cards, buying_power);
    string best_treasure = get_card(treasure_cards, buying_power);
    if (best_victory.empty())
        cout << best_treasure;
    else
        cout << best_victory + " or " + best_treasure;

    return 0;
}

string get_card(tuple<string, int> cards[], int buying_power){
    for(int i = 0; i < 3; i++){
        if (buying_power >= get<1>(cards[i]))
            return get<0>(cards[i]);
    }
    return "";
}