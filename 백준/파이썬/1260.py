from collections import deque

n, m, v = map(int, input().split())

dfs_graph = [[] for _ in range(n + 1)]
bfs_graph = [[] for _ in range(n + 1)]

dfs_visited = [False] * (n + 1)
bfs_visited = [False] * (n + 1)

for i in range(m):
  a, b = map(int, input().split())
  dfs_graph[a].append(b)
  dfs_graph[b].append(a)
  bfs_graph[a].append(b)
  bfs_graph[b].append(a)

for i in range(1, n + 1):
  dfs_graph[i].sort()
  bfs_graph[i].sort()


def dfs(dfs_graph, v, dfs_visited):
  dfs_visited[v] = True
  print(v, end = ' ')
  for i in dfs_graph[v]:
    if not dfs_visited[i]:
      dfs(dfs_graph, i, dfs_visited)


def bfs(bfs_graph, v, bfs_visited):
  q = deque([v])
  bfs_visited[v] = True
  while q:
    now = q.popleft()
    print(now, end = ' ')
    for i in bfs_graph[now]:
      if not bfs_visited[i]:
        bfs_visited[i] = True
        q.append(i)
        

dfs(dfs_graph, v, dfs_visited)
print()
bfs(bfs_graph, v, bfs_visited)