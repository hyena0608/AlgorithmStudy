n = int(input())
arr = list(map(int, input().split()))

for i in range(n - 1, 0, -1):
    if arr[i] > arr[i-1]:
        for j in range(n - 1, 0, -1):
            if arr[i-1] < arr[j]:
                arr[i-1], arr[j] = arr[j], arr[i-1]
                answer = arr[:i] + sorted(arr[i:])
                print(*answer)
                exit()
print(-1)