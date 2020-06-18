import sys

input = sys.stdin.read().split(" ");
citations = int(input[0]) * int(input[1])
print(citations - int(input[0]) + 1)