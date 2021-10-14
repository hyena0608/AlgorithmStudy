n = int(input())
# VLR -> LRV
# 5 24 28 30 34 50 52 60 98
# 50 30 24 5 28 45 / 98 52 60
# 5 28 24 45 30 60 52 98 50
graph = [0]

for i in range(n):
    graph.append(int(input()))
# graph.sort()

visited = [False] * (n + 1)
center = graph[1]
index = [[] for _ in range(n + 1)]
# print(index)
def search(i, index):
    print(i)
    # print(visited)
    if not visited[i]:
        if graph[1] >= graph[i]:
            if graph[i] > graph[i + 1]:
                index[i].append(i + 1)
                index[i + 1].append(i)
                visited[i] = True
                return search(i + 1, index)
            else:
                if graph[i - 1] < graph[i + 1]:
                    index[i - 1].append(i + 1)
                    index[i + 1].append(i - 1)
                    return search(i + 1, index)
                else:


                # index[i + 1].append(i - 1)
                # visited[i + 1] = True
                # return search(i + 2, index)
        # else:
        #     if graph[i] > graph[i + 1]:
        #         index[i].append(i + 1)
        #         index[i + 1].append(i)
        #         visited[i] = True
        #         search(i + 1, index)
        #     else:
        #         visited[i] = True
        #         index[i + 1].append(i)
        #         index[i].append(i + 1)
search(1, index)
print(index)


# for i in range(2, n + 1):
#     if center > graph[i]:
        


visited = [False] * (n + 1)

# def LRV(graph, n, visited):
    