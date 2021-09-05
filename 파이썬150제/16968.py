a = input()
# 알파벳 26 숫자 10
result = 1
if a[0] == 'c':
  result *= 26
else:
  result *= 10
  
for i in range(len(a) - 1):
  if a[i] == a[i + 1]:
    if a[i + 1] == 'c':
      stack = result
      result *= 26
      result -= stack
    else:
      stack = result
      result *= 10 
      result -= stack
  else:
    if a[i + 1] == 'c':
      result *= 26
    else:
      result *= 10
print(result)