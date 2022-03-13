n = int(input())

person = []

for i in range(n):
  a, d, m, y = input().split()
  if len(d) == 1: d = '0' + d
  if len(m) == 1: m ='0' + m
  person.append((int(y + m + d), a))

person.sort()
print(person[-1][1])
print(person[0][1])