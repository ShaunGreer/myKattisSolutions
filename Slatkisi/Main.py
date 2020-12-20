import sys

def main():
    input = sys.stdin.readline()
    c = (int)(input.split(" ")[0])
    k = (int)(input.split(" ")[1])
    print(round(c, -k))

if __name__ == '__main__':
    main()