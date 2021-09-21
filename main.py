juice = list(map(int, input().split()))
rate = list(map(int, input().split()))

cocktail = []
for i in range(len(juice)):
    cocktail.append(juice[i] // rate[i])

cup = min(cocktail)
for i in range(len(juice)):
    juice[i] -= rate[i] * cup

for i in range(len(juice) - 1):
    min_juice = juice[0]
    min_rate = rate[0]
    if min_juice > juice[i + 1]:
        min_juice = juice[i + 1]
        min_rate = rate[i + 1]

last = min_juice / min_rate

for i in range(len(juice)):
    juice[i] -= last * rate[i]
    if juice[i].is_integer():
        print(juice[i], end = ' ')
    else:
        print('{}'.format(round(juice[i],6)), end=' ')