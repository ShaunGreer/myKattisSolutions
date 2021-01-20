import sys

def main():
    k = (int)(sys.stdin.readline())
    n = (int)(sys.stdin.readline())
    time_elapsed = 0
    for i in range(n):
        #Organise input
        line = sys.stdin.readline().rstrip().split(' ')
        time = (int)(line[0])
        answer_type = line[1]

        #Game finished
        if time_elapsed + time >= 210:
            print(k)
            return
        
        time_elapsed += time        
        
        if answer_type == 'T':
            k += 1
        if k > 8:
            k = 1
    
if __name__ == '__main__':
    main()