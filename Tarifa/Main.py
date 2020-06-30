import fileinput

input = []

#Read input
for line in fileinput.input():
    input.append(line.rstrip())

total = 0
allowance = (int(input[0]))
index = 2
for i in range(int(input[1])):
    total += allowance - int(input[index])
    index+=1
print(total + allowance)
