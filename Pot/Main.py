import fileinput
import math

input = []

for line in fileinput.input():
    input.append(line.rstrip())

total = 0
for i in range (int(input[0])):
    current = input[i+1]
    power = int(current[len(current) - 1])
    value = int(current[:-1])
    total += math.trunc(math.pow(value, power))
print(total)