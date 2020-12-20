import sys

input = sys.stdin.readline()
x = (int)(input.split(" ")[0])
y = (int)(input.split(" ")[1])
if y % 2 == 0:
    print("possible")
else:
    print("impossible")