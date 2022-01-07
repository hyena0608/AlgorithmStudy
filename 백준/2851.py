arr = []
for _ in range(10):
  arr.append(int(input()))

sum = 0
for i in range(10):
    if abs(100 - sum) < abs(100 - (sum + arr[i])):
      break
    else:
      sum += arr[i]

print(sum)