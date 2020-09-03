import sys

def main():
    n = (int)(sys.stdin.readline())
    scrambledParts = sys.stdin.readline().rstrip().split(" ")
    answer = []
    for i in range (n):
        scrambledDecimal = (int)(scrambledParts[i])
        scrambledBinary = decToBinary(scrambledDecimal)
        unscrambledBinary = getUnscrambled(scrambledBinary, False)
        if(unscrambledBinary[8] == '1'):
            unscrambledBinary = getUnscrambled(scrambledBinary, True)
        answer.append(binToDec(unscrambledBinary[:-1]))
    print(*(intList(answer)))

def intList(list):
    for i in range(len(list)):
        list[i] = (int)(list[i])
    return list

def binToDec(binary):
    decimal = 0
    value = 128
    for i in range(8):
        if (binary[i] == '1'):
            decimal += value
        value /= 2
    return decimal

def getUnscrambled(binary, type):
    x = ''
    xl = ''
    if type == False:
        if (binary[0] == '0'):
            x += '00'
            xl += '0'
        else:
            x += '10'
            xl += '0'
    else:
        if (binary[0] == '0'):
            x += '11'
            xl += '1'
        else:
            x += '01'
            xl += '1'
    for i in range (7):
        if(binary[i+1] == '0'):
            x += x[i+1]
            xl += x[i+1]
        else:
            inverse = opposite(x[i+1])
            x += inverse
            xl += inverse
    return x

def opposite(c):
    if c == '0':
        return '1'
    return '0'

def decToBinary(decimal):
    binary = ''
    value = 128
    for i in range(8):
        if (decimal - value) >= 0:
            binary += '1'
            decimal -= value
        else:
            binary += '0'
        value /= 2
    return binary

if __name__ == '__main__':
    main()