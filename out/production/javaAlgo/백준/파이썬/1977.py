### 모범 코드
M=int(input())
N=int(input())
r=[i*i for i in range(101)if M<=i*i<=N]
print("%d\n%d"%(sum(r),r[0])if r else"-1")







### 밑에 내 코드
# import math
# n = int(input())
# m = int(input())

# arr = []

# for i in range(n, m + 1):
#   if math.sqrt(i).is_integer():
#     arr.append(i)

# if arr == []:
#   print(-1)
# else:  
#   print(sum(arr))
#   print(min(arr))