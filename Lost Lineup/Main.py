import fileinput

input = []

#Read input
for line in fileinput.input():
    input.append(line.rstrip())

length = int(input[0])
index = 0

#Split up second line
nums = input[1].split()

result = [1] * (len(nums) + 1)
for i in range(len(nums)):
    result[int(nums[i]) + 1] = i+2

print(str(result).strip('[]').replace(',',''))