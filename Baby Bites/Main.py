import sys

def main():
    sys.stdin.readline();   #Ignore first number
    nums = sys.stdin.readline();
    count = 0
    for i in nums.split():
        if(i == "mumble" or (int)(i) == count + 1):
            count+=1
        elif((int)(i) != count + 1):
            print("something is fishy")
            return
    print("makes sense")


if __name__ == '__main__':
    main();