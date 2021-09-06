n = int(input())

graph = [[0] * (n + 1) for _ in range(n + 1)]

for i in range(1, n + 1):
  a, b, c = map(int, input().split())
  graph[i][1] = a
  graph[i][2] = b
  graph[i][3] = c

# 아래 오른쪽 
dx = [1, 0]
dy = [0 ,1]
# 시작 위치
a = 1 
b = 1
# while a == 3 or b == 3:
def move(a, b):
  a 