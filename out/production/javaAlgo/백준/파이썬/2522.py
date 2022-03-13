n = int(input())
for i in range(-n + 1, n):
    print(i)
    print((' ' * abs(i)).ljust(n, '*'))
