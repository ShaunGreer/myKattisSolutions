import sys

input = sys.stdin.readline().rstrip()
a = input.split(" ")[0]
b = input.split(" ")[1]
crossword = []
for i in range(len(b)):
    crossword.append([])
commonChar = ''
for i in range (len(a)):
    if (a[i]) in b:
        commonChar = a[i]
        break
horizontalIndex = b.find(commonChar)
verticalIndex = a.find(commonChar)
crossword[horizontalIndex] = list(a)
for i in range(len(b)):
    for j in range(len(a)):
        if i == horizontalIndex:
            continue
        elif j == verticalIndex:
            crossword[i].append(b[i])
        else:
            crossword[i].append('.')
for i in range (len(crossword)):
    print(''.join(crossword[i]))