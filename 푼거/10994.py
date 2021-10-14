# 별 찍기 19
a = int(input())

graph = []

def stars(graph, n):
    result = []
    if n != 1:
        result.append('*' * (4 * n - 3))
        result.append('*' + ' ' * (4 * n - 5) + '*')
        for star in graph:
            result.append('* ' + star + ' *')
        result.append('*' + ' ' * (4 * n - 5) + '*')
        result.append('*' * (4 * n - 3))
        graph = result
        return graph
    else:
        return ['*']

for i in range(1, a + 1):
    graph = stars(graph, i)

print('\n'.join(graph))