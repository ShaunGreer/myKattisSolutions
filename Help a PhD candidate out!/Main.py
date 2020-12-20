import sys

testcases = sys.stdin.readline()

for i in range(int(testcases)):
    line = sys.stdin.readline()
    line = line.strip()
    if line == 'P=NP':
        print("skipped")
    else:
        print(eval(line))