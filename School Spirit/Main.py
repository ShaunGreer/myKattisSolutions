import sys
import math

def calculate_group_score(scores):
    total, const, index = 0, 4/5, 0
    for i in range(len(scores)):
        if(scores[i] == -1):
            continue
        total += (scores[i] * math.pow(const, index))
        index += 1
    return 1/5 * total

def main():
    n = (int)(sys.stdin.readline())
    scores = []
    for i in range(n):
        si = (int)(sys.stdin.readline())
        scores.append(si)

    current_group_score = calculate_group_score(scores)
    total = 0
    for i in range(n):
        student_left = scores[i]
        scores[i] = -1
        total += calculate_group_score(scores)
        scores[i] = student_left
    print(current_group_score)
    print(total / n)
    
if __name__ == '__main__':
    main()