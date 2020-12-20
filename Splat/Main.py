import sys
import math

def main():
    c = (int)(sys.stdin.readline())

    for i in range(c):
        n = (int)(sys.stdin.readline())
        canvas = []
        for j in range(n):
            line = (sys.stdin.readline()).split(" ")
            x = (float)(line[0])
            y = (float)(line[1])
            v = (float)(line[2])
            colour = line[3].rstrip()
            r = math.sqrt(v/math.pi)
            canvas.append((colour, x, y, r))
        m = (int)(sys.stdin.readline())
        for k in range(m):
            line = (sys.stdin.readline()).split(" ")
            x = (float)(line[0])
            y = (float)(line[1])
            l = len(canvas) - 1
            while(l >= 0):
                x2 = canvas[l][1]
                y2 = canvas[l][2]
                r = canvas[l][3]
                d = math.sqrt(math.pow((x-x2), 2) + math.pow((y-y2),2))
                if d <= r:
                    print(canvas[l][0])
                    break
                l-=1
            if l == -1:
                print("white")

    sys.stdin.close()


if __name__ == '__main__':
    main()
