import sys
input = sys.stdin.readline
n, m = map(int, input().split())

arr = []

for _ in range(n):
    arr.append(list(map(int, input().split())))

shape1Y = [[0, 0, 0, 0], [0, 1, 2, 3], [0, 1, 0, 1], [0, 1, 2, 2], [1, 1, 1, 0], [0, 0, 1, 2], [0, 1, 0, 0], [0, 1, 1, 2], [1, 1, 0, 0], [0, 0, 0, 1], [0, 1, 1, 2], [0, 1, 1, 1], [1, 0, 1, 2], [0, 1, 2, 2], [0, 1, 1, 1], [0, 1, 2, 0], [0, 0, 0, 1], [1, 2, 0, 1], [0, 0, 1, 1]]
shape1X = [[0, 1, 2, 3], [0, 0, 0, 0], [0, 0, 1, 1], [0, 0, 0, 1], [0, 1, 2, 2], [0, 1, 1, 1], [0, 0, 1, 2], [0, 0, 1, 1], [0, 1, 1, 2], [0, 1, 2, 1], [0, 0, 1, 0], [1, 0, 1, 2], [0, 1, 1, 1], [1, 1, 1, 0], [0, 0, 1, 2], [0, 0, 0, 1], [0, 1, 2, 2], [0, 0, 1, 1], [0, 1, 1, 2]]

maxSum = 0
sum = 0

for i in range(len(shape1Y)):
    lenX = max(shape1X[i]) - min(shape1X[i])
    lenY = max(shape1Y[i]) - min(shape1Y[i])
    for y in range(n):
        keepY = True
        for x in range(m):
            keepX = True
            if lenX + x >= m:
                    sum = 0
                    keepX = False
                    break
            elif lenY + y >= n:
                    sum = 0
                    keepY = False
                    break
            else:
                for j in range(4):
                    sum += arr[shape1Y[i][j] + y][shape1X[i][j] + x]
            if keepX == False:
                break
            if maxSum < sum:
                maxSum = sum
            sum = 0
        if keepY == False:
            break
print(maxSum)