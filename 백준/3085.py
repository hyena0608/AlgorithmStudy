n = int(input())
arr = [[] for _ in range(n)]
for i in range(n):
    line = input()
    for t in line:
        arr[i].append(t)

# 인접한 두 칸 DOWN y + 1, RIGHT x + 1
dy = [1, 0]
dx = [0, 1]

# 탐색 (가로, 세로)
def search(arr):
    longest = 0

    for i in range(n):

        count = 1
        for j in range(1, n):
            if arr[i][j] == arr[i][j-1]:
                count += 1
            else:
                count = 1

            if count > longest:
                longest = count


        count = 1
        for j in range(1, n):
            if arr[j][i] == arr[j - 1][i]:
                count += 1
            else:
                count = 1
                
            if count > longest:
                longest = count
    
    return longest


# 스왑 + 탐색
ans = 0
for y in range(n):
    for x in range(n):
        for i in range(2):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= n or ny >= n:
                continue
            else:
                arr[y][x], arr[ny][nx] = arr[ny][nx], arr[y][x]
                ans_temp = search(arr)
                
                if ans_temp > ans:
                    ans = ans_temp
                arr[ny][nx], arr[y][x] = arr[y][x], arr[ny][nx]

print(ans)