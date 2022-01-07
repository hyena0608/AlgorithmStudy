# 명령 프롬프트

import sys

n = int(sys.stdin.readline().rstrip())

arr = []
for _ in range(n):
  arr.append(str(sys.stdin.readline().rstrip()))

answer = []
for i in range(len(arr[0])):
  answer += (arr[0][i])

x = []
for j in range(n-1):
  for i in range(len(arr[0])):
    if arr[0][i] != arr[j+1][i]:
      answer[i] = '?'

for i in answer:
  print(i, end='')