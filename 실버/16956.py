import sys
input = sys.stdin.readline

n, m = map(int, input().split())

graph = [list(input()) for _ in range(n)]

# 상 하 좌 우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
defense = True
for i in range(n):
  for j in range(m):

    if graph[i][j] == 'W':
      for k in range(4):
        a = i + dx[k]
        b = j + dy[k]
        if a < 0 or a >= n or b >= m or b < 0:
          continue
        if graph[a][b] == 'S':
          print(0)
          defense = False
          break
    elif graph[i][j] == '.':
      graph[i][j] = 'D'

if defense == True:
  print(1)
  for i in range(n):
    print(''.join(graph[i]), end='')
else:
  print(0)