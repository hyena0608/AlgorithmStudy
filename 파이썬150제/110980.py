import sys
input = sys.stdin.readline

for _ in range(int(input())):
  m = int(input())
  
  player = [[] for _ in range(m)]
  
  for i in range(m):
    a, b = list(input().split())
    player[i].append((int(a), b))

  selected_player = max(player)
  print(selected_player[0][1])