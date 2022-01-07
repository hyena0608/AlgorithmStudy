N = int(input())

tri = ['  *  ', ' * * ', '*****']

N //= 3

def makeTri(tri):
  L = len(tri)
  for i in range(L):
    tri.append(tri[i] + " " + tri[i])
    tri[i] = ' ' * L + tri[i] + ' ' * L

  return tri

cnt = 0
while N > 1:
  N //= 2
  cnt += 1

for i in range(cnt):
  makeTri(tri)

for t in tri:
  print(t)