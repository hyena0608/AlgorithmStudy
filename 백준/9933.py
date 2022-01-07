n = int(input())

file = []

for i in range(n):
    file.append(input())

for pw in file:
    if pw[::-1] in file:
        print(len(pw), pw[len(pw)//2])
        break