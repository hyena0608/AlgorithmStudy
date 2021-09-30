# 홀 짝 1 3 7 15
# 2^n - 1

a = int(input())

graph = []
stars = []

def star(n):
    if n == 1:
        graph.append('*')
        stars.append('*')
    else:
        if n % 2 == 0:
            stars.append('*' + graph[len(graph) - 1] + '*' + graph[len(graph) - 1] + '*')
            for space in range((2**n - 3), 3, -2):  
                stars.append(' ' * space + '*' + ' ' * space + '*' + ' ' * space + '*')
            stars.append('*' + graph[len(graph) - 1] + '*')
            for space in range((2**n - 4), 2, -2):
                stars.append(' ' * space + '*' + ' ' * space + '*')     
        else:
            stars.append(' ' * (len(graph[0]) + 1) + '*')
            for space in range(1, (2**n - 1) // 2 + 1):
                stars.append(' ' * (len(graph[0]) + 1 - space) + '*' + ' ' * (2**space - 1) + '*')
            stars.append('*' + graph[0] + '*')
            for space in range(1, 2**n - 1):
                stars.append(' ' * space + '*' + ' ' * (2**space)  + graph[space] + ' ' * (2**space) + '*')
            stars.append('*' + graph[0] + '*' + graph[0] + '*')

for n in range(1, a + 1):
    print(n)
    star(n)
    graph = stars
    # print(graph)
    # print(stars)

for star in graph:
    print(star)


# print(len('            '))