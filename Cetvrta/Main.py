import sys

def main():
    line1 = sys.stdin.readline().split(" ")
    line2 = sys.stdin.readline().split(" ")
    line3 = sys.stdin.readline().split(" ")
    x = ''
    if line1[0] == line2[0]:
        x = line3[0]
    elif line2[0] == line3[0]:
        x = line1[0]
    else:
        x = line2[0]
    y = ''
    if line1[1] == line2[1]:
        y = line3[1]
    elif line2[1] == line3[1]:
        y = line1[1]
    else:
        y = line2[1]
    print(x,y)

if __name__ == '__main__':
    main()