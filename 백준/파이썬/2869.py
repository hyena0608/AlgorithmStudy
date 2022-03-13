# 달팽이는 올라가고 싶다.

A, B, V = map(int, input().split())

if (V-A)%(A-B) == 0:
  result = (V-A)//(A-B) + 1
else:
  result = (V-A)//(A-B) + 2

print(result)
