def get_stars(star):
  graph = []
  for i in range(3 * len(star)):
    if i // len(star) == 1:
      graph.append(star[i % len(star)] + " " * len(star) + star[i % len(star)])
    else:
      graph.append(star[i % len(star)] * 3)
  return graph

n = int(input())

star = ["***", "* *", "***"]
k = 0

while n != 3:
  n = n // 3
  k += 1

for i in range(k):
  star = get_stars(star)
for i in star:
  print(i)