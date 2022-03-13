n = int(input())

arr = []
for _ in range(n):
  arr.append(str(input()))

stack = []

for i in range(n):
  if arr[i][:3] == 'push':
    stack.append(int(arr[i][5:]))
  elif arr[i] == 'pop':
    if stack:
      print(stack.pop())
    else:
      print(-1)
  elif arr[i] == 'size':
    print(len(stack))
  elif arr[i] == 'empty':
    if len(stack) == 0:
      print(1)
    else:
      print(0)
  elif arr[i] == 'top':
    if stack:
      print(stack[len(stack)-1])
    else:
      print(-1)