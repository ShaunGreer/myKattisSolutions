import sys

def main():
    n = (int)(sys.stdin.readline())
    list = 1
    while n != 0:
        animal_count = {}
        for i in range(n):
            animal = sys.stdin.readline().rstrip().split(' ')
            breed = animal[len(animal) - 1].lower()
            if(breed in animal_count):
                animal_count[breed] += 1
            else:
                animal_count[breed] = 1
                
        print("List {}:".format(list))
        for a in sorted(animal_count.keys()):
            print("{} | {}".format(a, animal_count[a]))
        n = (int)(sys.stdin.readline())
        list += 1


if __name__ == '__main__':
    main();