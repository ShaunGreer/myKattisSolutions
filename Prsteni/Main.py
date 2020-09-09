import sys

def main():
    n = (int)(sys.stdin.readline())
    line = sys.stdin.readline().rstrip().split(" ")
    firstRing = (int)(line[0])
    for i in range(n - 1):
        currentRing = (int)(line[i+1])
        gcd = findGCD(firstRing, currentRing)
        print("{}/{}".format((firstRing//gcd), (currentRing//gcd)))

def findGCD(numerator, denominator):
    gcd = 1
    for i in range(1, min(numerator, denominator) + 1):
        if (numerator % i) == 0 and (denominator % i) == 0:
            gcd = i
    return gcd

if __name__ == '__main__':
    main()