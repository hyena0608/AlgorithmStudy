a = input()
# 알파벳 26 숫자 10
result = 1
pv = None
for ps in a:
  if pv != ps:
    if ps == 'd':
      result *= 10
    else:
      result *= 26
  else:
    if ps == 'd':
      result *= 9
    else:
      result *= 25
  
  pv = ps
print(result)