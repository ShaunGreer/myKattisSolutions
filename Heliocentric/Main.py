import sys

def main():
    lines = sys.stdin.readlines()
    case = 1
    for line in lines:
        days = line.rstrip().split(' ')
        e_days, m_days = (int)(days[0]), (int)(days[1])
        e, m, count = e_days, m_days, 0
        while (e != 0 or m != 0):
            m += 1
            e += 1
            if e == 365:
                e = 0
            if m == 687:
                m = 0
            count += 1
        print("Case {}: {}".format(case, count))
        case += 1
if __name__ == '__main__':
    main()