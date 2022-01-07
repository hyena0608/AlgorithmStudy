import sys
input = sys.stdin.readline

n, m, k = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
visited = [[False] * m for _ in range(n) ]

ans = 0

dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]

def dfs(ay, ax, count, sum):
    if count == k:
        global ans
        if ans < sum:
            ans = sum
        return
    
    for y in range(ay, n):
        for x in range(ax if y == ay else 0, m):
            switch = True

            if visited[y][x]:
                continue
            
            for i in range(4):
                ny = y + dy[i]
                nx = x + dx[i]

                if 0 <= ny < n and 0 <= nx < m:
                    if visited[ny][nx]:
                        switch = False
                        break

            if switch:
                visited[y][x] = True
                dfs(y, x, count + 1, sum + arr[y][x])
                visited[y][x] = False

dfs(0, 0, 0, 0)
print(ans)