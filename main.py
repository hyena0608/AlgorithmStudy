from collections import deque
n = int(input())

graph = [0]

for _ in range(n):
  graph += list(map(int, input().split()))

start = 1

q = deque([start])
reached = False
while q:
  now = q.popleft()
  if now == n*n:
    reached = True
    break
  else:
    jump = graph[now]
    if now % n != 0:
      if now // n == (now + 1 * jump) // n or (now + 1 * jump % n == 0):
      # if now + 1 * jump <= n*n:
        q.append(now + 1 * jump)
    
    if now + n * jump <= n*n:
      q.append(now + n * jump)

    
if reached:
  print("HaruHaru")
else:
  print("Hing")