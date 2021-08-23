import math

n = int(input())
arr = list(map(int, input().split()))
sum = 0
is_prime = False
for i in range(n):
  for j in range(2, int(math.sqrt(arr[i])) + 1):
    print(arr[i], j)
    if arr[i] % j == 0:
      is_prime = False
      break
    else:
      is_prime = True
  if is_prime == True: 
    sum += 1
  is_prime = False

print(sum)