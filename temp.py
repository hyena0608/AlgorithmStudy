s = list(input())

index = 0
s_list = []
result = []
repeated_count = 1
arr = []


for count in range(1, len(s)//2 + 1):
    for i in range(count, len(s) + count, count):
        if s[index:i] == s[i:i + count]:
            repeated_count += 1
            index = i
        else:
            if repeated_count != 1:
                arr.append(str(repeated_count))
                arr.append(s[index:i])
            else:
                arr.append(s[index:i])
            index = i
            repeated_count = 1
    for a in arr:
        for n in a:
            s_list += n
    
    result.append(len(s_list))
    s_list = []
    arr = []
    index = 0
    repeated_count = 1

print(min(result))