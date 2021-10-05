n, m = map(int, input().split())

graph = []
for _ in range(n):
    graph.append(list(map(int, input())))
print(graph)

biggest = 0

if n >= m: 
    biggest = n 
else: 
    biggest = m
# a b
# c d
a = graph[0][0]
b = graph[0][m-1]
c = graph[n-1][0]
d = graph[n-1][m-1]

find = False

# [a][b]        [a][b+i]
# [a+i][b]    [a+i][b+i]

# q w
# e r

q, w, e, r = 0, 0, 0, 0
        