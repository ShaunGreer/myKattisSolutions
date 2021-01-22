import sys

def main():
    lines = sys.stdin.readlines()
    j = 0
    for i in range(lines.count('\n') + 1):
        index, trailing = 0, 0
        while True:
            line = lines[j].rstrip()
            asterik_count = line.count('*')
            output = '.' * (len(line) - index - asterik_count)
            output += ('*'*asterik_count)
            output += ('.'*trailing)
            print(output)
            trailing += asterik_count
            index += asterik_count
            j += 1
            if j == len(lines):
                break
            elif lines[j] == '\n':
                print("")
                j += 1
                break
            
    
if __name__ == '__main__':
    main()