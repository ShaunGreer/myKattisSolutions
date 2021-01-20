import sys

def main():
    t = (int)(sys.stdin.readline())
    for i in range(t):
        noises = sys.stdin.readline().rstrip().split()
        line = sys.stdin.readline().rstrip()
        while line != "what does the fox say?":
            noise = line.split(' ')[2]
            noises = [n for n in noises if n != noise]
            line = sys.stdin.readline().rstrip()
        print(' '.join(noises))
if __name__ == '__main__':
    main()