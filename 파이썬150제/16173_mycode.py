# 시간초과

from collections import deque
import sys
input = sys.stdin.readline

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
      if now % n + 1 * jump <= n:
        q.append(now + 1 * jump)
    
    if now + n * jump <= n*n:
      q.append(now + n * jump)

    
if reached:
  print("HaruHaru")
else:
  print("Hing")