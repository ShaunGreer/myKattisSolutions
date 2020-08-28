import sys

n = (int)(sys.stdin.readline())
prices = []
total = 0
for i in range(n):
    cost = (int)(sys.stdin.readline())
    prices.append(cost)
    total += cost
prices.sort(reverse=True)
while (len(prices) % 3) != 0:
    prices.append(0)
for i in range(2, len(prices), 3):
    total-= prices[i]
print(total)