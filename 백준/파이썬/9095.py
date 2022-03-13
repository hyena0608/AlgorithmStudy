nums = [int(input()) for _ in range(int(input()))]

numbers = []

def dfs(case):
    global answer
    if sum(numbers) == case:
        answer += 1
        return
    if sum(numbers) > case:
        return
    
    for i in range(3):  
        numbers.append(i+1)
        dfs(case)
        numbers.pop()

for case in nums:
    answer = 0
    dfs(case)
    print(answer)
