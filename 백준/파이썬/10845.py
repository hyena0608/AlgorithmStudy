from collections import deque
import sys
input = sys.stdin.readline
n = int(input())
q = deque([])

for _ in range(n):
    command = list(map(str, input().split()))

    if command[0] == 'push':
        q.append(command[1])
    
    elif command[0] == 'pop':
        if len(q) != 0:
            print(q.popleft())
        else:
            print(-1)

    elif command[0] == 'size':
        print(len(q))
    
    elif command[0] == 'empty':
        if len(q) != 0:
            print(0)
        else:
            print(1)
    
    elif command[0] == 'front':
        if len(q) != 0:
            print(q[0])
        else:
            print(-1)
    
    elif command[0] == 'back':
        if len(q) != 0:
            print(q[-1])
        else:
            print(-1)
    
    else:
        continue