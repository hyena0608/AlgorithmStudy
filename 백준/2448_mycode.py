n = int(input())
first_blank = n

star = ['*', '* *', '*****']


def get_stars(star):
  blank = len(star) * 2 - 1
  for i in range(len(star)):
      star.append((star[i] + ' ' * blank + star[i]))
      blank -= 2


k = 0
while n != 3:
  n //= 2
  k += 1


for i in range(k):
  get_stars(star)
for i in star:
  print(' ' * (first_blank - 1) + i + ' ' * (first_blank - 1))
  first_blank -= 1