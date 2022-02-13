n = int(input())
arr = ['']; arr += list(map(str, input().split()))
numbers = [i for i in range(10)]

a = []
max_ = 123456789
min_ = 9876543210
min_ok, max_ok = False, False
def dfs(idx):
    global max_
    global min_
    global ok
    if ok:
        return
    if len(a) == n + 1:
        temp = int(''.join(map(str, a)))
        if temp > max_:
            max_ok = True
            max_ = temp
        elif temp < min_:
            min_ok = True
            min_ = temp
        return

    for _ in range(idx, len(arr)):
        for num in numbers:
            if len(a) == 0:
                if str(min_) < (''.join(map(str, a))) + str(num) < str(max_):
                    return
                else:
                    a.append(num)
                    print(a)
                    dfs(idx + 1)
                    a.pop()
            else:
                if num not in a and compare(a[-1], num, arr[len(a)]):
                    if str(min_) < (''.join(map(str, a))) + str(num) < str(max_):
                        return
                    else:
                        a.append(num)
                        print(a)
                        dfs(idx + 1)
                        a.pop()               

def compare(a, b, str_):
    if str_ == '>':
        return a > b
    elif str_ == '<':
        return a < b

dfs(0)
print(max_)
print(min_)