e, s, m = map(int, input().split())

n = 0
e_temp = 0
s_temp = 0
m_temp = 0
while True:
    n += 1
    if e_temp == 15:
        e_temp = 1
    else:
        e_temp += 1

    if s_temp == 28:
        s_temp = 1
    else:
        s_temp += 1

    if m_temp == 19:
        m_temp = 1
    else:
        m_temp += 1

    if e_temp == e and s_temp == s and m_temp == m:
        break
    
print(n)