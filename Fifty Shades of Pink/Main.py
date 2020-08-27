import sys

bags = (int) (sys.stdin.readline())
count = 0
for i in range (bags):
    word = sys.stdin.readline()
    if "pink" in word.lower() or "rose" in word.lower():
        count += 1
if count == 0:
    print("I must watch Star Wars with my daughter")
else:
    print(count)