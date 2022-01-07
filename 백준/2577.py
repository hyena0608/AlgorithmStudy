a = int(input())
b = int(input())
c = int(input())
abc = str(a * b * c)
result = [0] * 10
for i in range(0, len(abc)):
  for j in range(0, 10):
    if abc[i] == str(j):
      result[j] += 1

for i in result:
  print(i)