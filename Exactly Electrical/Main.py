import sys

def main():
    #Read input
    first_line = sys.stdin.readline().rstrip().split(' ')
    second_line = sys.stdin.readline().rstrip().split(' ')
    t = (int)(sys.stdin.readline())
    a, b = (int)(first_line[0]), (int)(first_line[1]) 
    c, d = (int)(second_line[0]), (int)(second_line[1])
    
    difference = abs(a - c) + abs(b - d)
    left = t - difference
    if left < 0 or left % 2 != 0:
        print("N")
    else:
        print("Y")
        
    
if __name__ == '__main__':
    main()