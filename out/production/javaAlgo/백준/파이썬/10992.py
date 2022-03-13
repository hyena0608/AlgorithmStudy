n = int(input())

for i in range(1, n):
    print( ' ' * (n - i) + '*', end='')
    if i != 1:
        print(' ' * (2 * i - 3) + '*')
    else:
        print()
if n != 1:
    print('*' * (2 * n - 1))
else:
    print('*')
