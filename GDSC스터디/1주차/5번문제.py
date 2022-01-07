def solution(n, lost, reserve):
    now_lost = set(lost) - set(reserve)
    now_reserve = set(reserve) - set(lost)
         
    for i in now_lost:
        left = i - 1
        right = i + 1
        if left in now_reserve:
            now_reserve.remove(left)
        elif right in now_reserve:
            now_reserve.remove(right)
        else:
            n -= 1
    
    return n