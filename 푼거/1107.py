channel = int(input())
brokenCount = int(input())

if brokenCount != 0:
    brokenNum = input().split()
else:
    brokenNum = []
answer = abs(channel - 100)
for i in range(1000000):
    ok = True
    for thisNum in list(str(i)):
        if thisNum in brokenNum:
            ok = False
            break   
    if ok:
        answer = min(answer, abs(channel - i) + len(str(i)))

print(answer)