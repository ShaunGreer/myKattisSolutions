#include <iostream>
#include <cmath>
#include <cstring>

#define PI 3.14159265

using namespace std;

int main(){
    string line;
    double r, x, y;

    while (getline(cin, line)) {
        //READ INPUT
        double input[3];
        for(int i = 0; i < 3;i++){
            int pos = line.find(' ');
            input[i] = stod(line.substr(0, pos));
            line.erase(0, pos + 1);
        }
        r = input[0], x = input[1], y = input[2];

        //PERFORM CALCULATION
        double distance = sqrt((x * x) + (y * y));
        if(distance > r)
            cout << "miss" << endl;
        else {
            double opp = sqrt((r * r) - (distance * distance));
            double seg_angle = asin(opp / r) * (180.0 / PI) * 2;
            double area_of_sector = (seg_angle / 360) * PI * (r * r);
            double area_of_triangle = opp * distance;
            double area_of_cookie = PI * r * r;
            double a1 = area_of_sector - area_of_triangle;
            double a2 = area_of_cookie - a1;
            if(a1 > a2)
                cout << a1 << ' ' << a2 << endl;
            else
                cout << a2 << ' ' << a1 << endl;

        }

    }
    return 0;
}