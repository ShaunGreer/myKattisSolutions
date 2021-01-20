import sys

def main():
    instructions = sys.stdin.readline()
    nop_count, i = 0, 1
    while i < len(instructions):
        if instructions[i].isupper() and i % 4 != 0:
            nop_count += 1
            instructions = instructions[:i] + ' ' + instructions[i:]
        i += 1
    print(nop_count)
    
if __name__ == '__main__':
    main()