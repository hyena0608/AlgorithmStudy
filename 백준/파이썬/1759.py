from itertools import combinations

n, m = map(int, input().split())
alpha = combinations(sorted(list(input().split())), n)
vowel = ['a', 'e', 'i', 'o', 'u']

for pw in alpha:
    vowel_cnt, cons_cnt = 0, 0
    for i in pw:
        if i in vowel:
            vowel_cnt += 1
        else:
            cons_cnt += 1
    if vowel_cnt >= 1 and cons_cnt >= 2:
        print(''.join(pw))