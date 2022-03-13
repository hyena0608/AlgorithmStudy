arr = []
for _ in range(9):
    arr.append(int(input()))

for i in range(len(arr) - 1):
    for j in range(i + 1, len(arr)):
        if arr[i] + arr[j] == sum(arr) - 100:
            arr.pop(j)
            arr.pop(i)
            arr.sort()
            break

for i in arr:
    print(i)