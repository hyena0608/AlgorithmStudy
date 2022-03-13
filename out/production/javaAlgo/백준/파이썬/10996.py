a = int(input())

graph = []

def stars(n):
    result = []

    if n == 1:
        return ['*']
    elif n == 2:
        for _ in range(2):
            result.append('*')
            result.append(' *')
        return result
    else:
        if n % 2 == 1:
            for i in range(0, len(graph), 2):
                graph[i] = graph[i] + ' *'
            graph.append(graph[len(graph) - 2])
            graph.append(graph[len(graph) - 2])
        else:
            for i in range(1, len(graph), 2):
                graph[i] = graph[i] + ' *'
            graph.append(graph[len(graph) - 2])
            graph.append(graph[len(graph) - 2])
        return graph

for i in range(1, a + 1):
    graph = stars(i)

print('\n'.join(graph))