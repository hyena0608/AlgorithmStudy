while True:
    try:
        a = int(input())
    except EOFError:
        break
    index = 0
    
    while True:
        index += 1
        if int('1' * index) % a == 0:
            print(index)
            break