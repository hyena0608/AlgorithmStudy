import sys

INF = 9999999
N = input()
brokenCount = int(input())
if brokenCount != 0:
    brokenNum = list(map(int, input().split()))


channel = []
for ch in N:
    channel.append(int(ch))


minus_ch = []
plus_ch = []
def count():

    # 첫 시작이 brokenNum 일 때
    if channel[0] in brokenNum:

        # minus_ch[0]
        temp_ch = channel[0]
        while True:
            temp_ch -= 1
            # 방어 코드
            if temp_ch < 0:
                minus_ch.append(INF)
                break
            # append minus_ch
            if temp_ch not in channel:
                minus_ch.append(temp_ch)
                break

        # plus_ch[0]
        temp_ch = channel[0]
        while True:
            temp_ch += 1
            # 방어 코드
            if temp_ch > 9:
                plus_ch.append(INF)
                break
            # append plus_ch
            if temp_ch not in channel:
                plus_ch.append(temp_ch)
        # minus_ch
        for num in range(9, 0, -1):
            if num not in brokenNum:
                for _ in range(len(N) - 1):
                    minus_ch.append(num)
                break
    
        # plus_ch
        for num in range(9):
            if num not in brokenNum:
                for _ in range(len(N) - 1):
                    plus_ch.append(num)
                break
    
    # 첫 시작이 정상 작동 할 때
    else:
        # 정상 작동이 끝날 때 까지
        while True:
            for ch in channel:
                if ch not in brokenNum:
                    minus_ch.append(ch)
                    plus_ch.append(ch)
                else:
                    break
            break

        # minus_ch
        for num in range(9):
            if num not in brokenNum:
                for _ in range(len(channel) - len(minus_ch)):
                    minus_ch.append(num)
                break
    
        # plus_ch
        for num in range(9, 0, -1):
            if num not in brokenNum:
                for _ in range(len(channel) - len(plus_ch)):
                    plus_ch.append(num)
                break


    # make list to int
    min_ch = ''
    max_ch = ''
    for ch in minus_ch:
        min_ch += str(ch)
    for ch in plus_ch:
        max_ch += str(ch)
    min_ch = int(min_ch)   
    max_ch = int(max_ch)


    # compare counts
    if abs(min_ch - int(N)) > abs(max_ch - int(N)):
        print(abs(max_ch - int(N)) + len(N))
    else:
        print(abs(min_ch - int(N)) + len(N))

if N != '100':
    if brokenCount == 0:
        sys.exit
    else:
        count()
else:
    print(0)