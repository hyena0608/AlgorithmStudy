def solution(n, lost, reserve):
    arr = [True] * (n + 1)
    
    for i in lost:
        arr[i] = False
        
    for i in reserve:
        if i == 1:
            if arr[1] == False:
                arr[1] = True
            elif arr[2] == False:
                arr[2] = True
            continue
        if i == n:
            if arr[n] == False:
                arr[n] = True
            elif arr[n - 1] == False:
                arr[n - 1] = True
            continue
                
        if arr[i] == False:
            arr[i] = True
        elif arr[i - 1] == False:
            arr[i - 1] = True
        elif arr[i + 1] == False:
            arr[i + 1] = True
            
    answer = -1
    for i in arr:
        if i == True:
            answer += 1
    return answer