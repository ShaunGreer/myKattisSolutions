import sys

cases = (int)(sys.stdin.readline().rstrip())
display = 0
actual = 0
for i in range(cases):
    line = sys.stdin.readline().split(" ")
    display += (int)(line[0])
    actual += (int)(line[1])
actual /= 60    #Convert to minutes
if actual/display <= 1:
    print("measurement error")
else:
    print(format((actual/display), ".9f"))