n, m = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()

nums = []
def dfs():
    if len(nums) == m:
        print(' '.join(map(str, nums)))
        return

    for i in range(n):
        if len(nums) >= 1 and nums[-1] >= arr[i]:
            continue
        else:
            nums.append(arr[i])
            dfs()
            nums.pop()

dfs()