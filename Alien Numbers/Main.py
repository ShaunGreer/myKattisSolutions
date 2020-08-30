import sys
import math

def main():
    t = (int)(sys.stdin.readline())
    for i in range(t):
        line = sys.stdin.readline().rstrip()
        alien_number = line.split(" ")[0]
        source_language = line.split(" ")[1]
        target_language = line.split(" ")[2]
        #Generate number values for source values
        sourceMappings = {}
        for j in range(len(source_language)):
            sourceMappings[source_language[j]] = j
        base = len(source_language)
        total = 0
        j = (len(alien_number)) - 1
        k = 0
        while j >= 0:
            total += (math.pow(base, j) * sourceMappings[alien_number[k]])
            j-=1
            k+=1
        #We now have the value of alien number - now find mapping of target language
        targetMappings = {}
        for j in range(len(target_language)):
            targetMappings[j] = target_language[j]
        targetBase = len(target_language)
        lengthOfAnswer = 1
        counter = 0
        previousTotals = 0
        while True:
            if (math.pow(targetBase, counter) * (targetBase-1)) + previousTotals >= total:
                break
            counter+=1
            lengthOfAnswer+=1
            previousTotals += math.pow(targetBase, counter-1) * (targetBase-1)
        power = lengthOfAnswer - 1
        answer = ""
        for j in range(lengthOfAnswer):
            howManyOfThisPower = (int)(total/math.pow(targetBase, power))
            answer += targetMappings[howManyOfThisPower]
            total -= howManyOfThisPower * (math.pow(targetBase, power))
            power-=1
        print("Case #%d: %s" % (i+1, answer))

if __name__ == '__main__':
    main()
