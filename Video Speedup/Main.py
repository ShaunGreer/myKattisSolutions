import sys

def main():
    first_line = sys.stdin.readline().rstrip().split(' ')
    n, p, k = (int)(first_line[0]), (int)(first_line[1]), (int)(first_line[2])
    second_line = sys.stdin.readline().rstrip().split(' ')
    second_line.append(k)
    speed, time = 1.0, (int)(second_line[0])
    for i in range(1, n + 1):
        speed += p / 100.0
        time += speed * ((int)(second_line[i]) - (int)(second_line[i-1]))
    print(time)

if __name__ == '__main__':
    main()