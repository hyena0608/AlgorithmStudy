from collections import deque
priorities = [5, 3, 1]
p = deque([(v, i) for i, v in enumerate(priorities)])
print(p)