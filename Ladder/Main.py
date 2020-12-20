import sys
import math

input = sys.stdin.read()
h = (int)(input.split(" ")[0])
v = (int)(input.split(" ")[1])
print(math.ceil(h/(math.sin(math.radians(v)))))