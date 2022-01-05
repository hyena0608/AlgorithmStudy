import queue
import math

def solution(progresses, speeds):
    day = {}
    ans = []
    for i in range(len(progresses)):
        day_need = math.ceil((100 - progresses[i]) / speeds[i])
        if len(day) == 0:
            day[day_need] = 1
            ans.append(day_need)
            continue

        if ans[-1] >= day_need:
            day[day_need] += 1
        else:
            day[day_need] = 1
            ans.append(day_need)
    answer = []
    for i in ans:
        answer.append(day[i])
    return answer

print(solution([93, 30, 55], [1, 30, 5]))