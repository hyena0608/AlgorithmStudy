n = int(input())
dp_ = [0]
dp_ += list(map(int, input().split()))

for i in range(n+1):
    for j in range(i):
        dp_[i] = max(dp_[i-j] + dp_[j], dp_[i])

print(dp_[n])