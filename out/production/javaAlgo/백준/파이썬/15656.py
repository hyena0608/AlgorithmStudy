n, m = map(int, input().split())
arr = list(map(int, input().split()))

arr.sort()
nums = []
def dfs():
    if len(nums) == m:
        print(' '.join(map(str, nums)))
        return
    
    for i in range(n):
        nums.append(arr[i])
        dfs()
        nums.pop()

dfs()