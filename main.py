x = int(input())

stars = [[' ' for _ in range(x)] for _ in range(x)]

def all_star(n, x, y):
    if n == 1:
        stars[y][x] = '*'
        
    else:
        m = n // 3
        for dy in range(3):
            for dx in range(3):
                if dy != 1 or dx != 1:
                    all_star(m, x+dx*m, y+dy*m)
                    
all_star(x, 0, 0)
for i in stars:
    print(''.join(i))