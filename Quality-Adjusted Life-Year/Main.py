import sys

n = (int)(sys.stdin.readline())
qaly = 0.0
for i in range(n):
    line = sys.stdin.readline().split(" ")
    q = (float)(line[0])
    y = (float)(line[1])
    qaly += (q * y)
print("%.3f" % qaly)
