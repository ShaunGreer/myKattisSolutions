import sys

def main():
    encryptedMessage = sys.stdin.readline().rstrip()
    left, right = encryptedMessage[:(int)(len(encryptedMessage)/2)], encryptedMessage[(int)(len(encryptedMessage)/2):]
    #Get rotation values
    leftRotation = 0
    rightRotation = 0
    for i in range (len(left)):
        leftRotation += ord(left[i]) - 65
    for i in range (len(right)):
        rightRotation += ord(right[i]) - 65
    #Rotate the words
    newLeft = ""
    newRight = ""
    for i in range (len(left)):
        newLeft += rotate(left[i], leftRotation % 26)
    for i in range(len(right)):
        newRight += rotate(right[i], rightRotation % 26)
    decryptedMessage = ''
    for i in range(len(left)):
        decryptedMessage += rotate(newLeft[i], ((ord(newRight[i])) - 65)%26)
    print(decryptedMessage)

#Increase chars ascii value by a given number
def rotate(letter, value):
    for i in range(value):
        letter = chr(ord(letter) + 1)
        if ord(letter) > 90:
            letter = 'A'
    return letter

if __name__ == '__main__':
    main()