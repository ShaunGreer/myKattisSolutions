#include <stdio.h>

int main(){
    int n;
    scanf("%d", &n);
    for(int i = 0; i < n; i++){
        int b;
        double p;
        scanf("%d %lf", &b, &p);
        double minABPM = 60 / (p / (b - 1));
        double bpm = (60 * b) / p;
        double maxAbpm = 60 / (p / (b + 1));
        printf("%0.4lf %0.4lf %0.4lf\n", minABPM, bpm, maxAbpm);
    }
    return 0;
}