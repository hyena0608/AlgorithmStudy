juice = list(map(int, input().split()))
rate = list(map(int, input().split()))

cup = min(juice[0]/rate[0], juice[1]/rate[1], juice[2]/rate[2])
print(juice[0] - cup * rate[0], juice[1] - cup * rate[1], juice[2] - cup * rate[2])