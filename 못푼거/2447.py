n = int(input())

graph = [[' '] * n for _ in range(n)]

def re_graph(n, x, y):
  if n == 1:
    graph[x][y] = '*';
  else:
    m = n // 3
    for dx in range(3):
      for dy in range(3):
        if dx != 1 or dy != 1:
          re_graph(m, x + dx * m, y + dy * m)

re_graph(n, 0, 0)
for i in graph:
  print(''.join(i))