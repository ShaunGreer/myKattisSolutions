import sys

numbers = sys.stdin.readline().split(" ")
print(max(int(numbers[0][::-1]), int(numbers[1][::-1])))
sys.stdin.close()