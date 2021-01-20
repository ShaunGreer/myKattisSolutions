import sys

def main():
    r = (int)(sys.stdin.readline())
    sven = list(sys.stdin.readline().rstrip())
    n = (int)(sys.stdin.readline())
    actual_score = 0
    friends = []
    for i in range(n):
        friend = list(sys.stdin.readline().rstrip())
        friends.append(friend)
        for j in range(r):
            if sven[j] == friend[j]:
                actual_score += 1
            elif (
                    sven[j] == 'R' and friend[j] == 'S' or
                    sven[j] == 'S' and friend[j] == 'P' or
                    sven[j] == 'P' and friend[j] == 'R'
                 ):
                    actual_score += 2
    print(actual_score)
    
    possible_score = 0
    for i in range(r):
        r_count, s_count, p_count = 0, 0, 0
        for j in range(n):
            #Find the most picked hand
            if friends[j][i] == 'R':
                r_count += 1
            elif friends[j][i] == 'S':
                s_count += 1
            else:
                p_count += 1
        rock_picked = 2 * s_count + r_count
        scissors_picked = 2 * p_count + s_count
        paper_picked = 2 * r_count + p_count
        possible_score += max(rock_picked, paper_picked, scissors_picked)     

    print(possible_score)
        
if __name__ == '__main__':
    main()