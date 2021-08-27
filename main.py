n, m = map(int, input().split())

graph = [[0] * m for _ in range(n)]

# print(graph)
for i in range(n):
  graph[i] = input() 

for i in range(n):
  for j in range(n):
    
# # # 상 하 좌 우
# dx = [-1, 1, 0, 0]
# dy = [0, 0, -1, 1]

# for