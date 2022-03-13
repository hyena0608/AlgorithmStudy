# 에라토스테네스의 체를 이용
import math

n = int(input())

arr = list(map(int, input().split()))

findList = [True for _ in range(arr[n - 1] + 1)]

for i in range(2, int(math.sqrt(arr[n - 1])) + 1):
  for j in arr:
    if findList[i]:
      k = 2
      while i * k <= arr[n-1]:
        findList[i * k] = False
        k += 1

count = 0
for a in arr:
  if a == 0 or a == 1:
    continue
  if findList[a]:
    count += 1

print(count)

# 1 3 5 7 9 11 12 13 14 15 -> 5