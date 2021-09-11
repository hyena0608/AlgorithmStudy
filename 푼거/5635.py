n = int(input())

inf_name = [0] * n
cal_age = [0] * n

for i in range(n):
  name, d, m, y = input().split()
  if len(d) == 1:
    d = '0' + d
  if len(m) == 1:
    m = '0' + m
  cal_age[i] = y + m + d
  inf_name[i] = name

high_age = int(cal_age[0])
high_name = inf_name[0]
low_age = int(cal_age[0])
low_name =  inf_name[0]

for i in range(n):
  if high_age > int(cal_age[i]):
    high_age = int(cal_age[i])
    high_name = inf_name[i]
  if low_age < int(cal_age[i]):
    low_age = int(cal_age[i])
    low_name = inf_name[i]

print(low_name)
print(high_name)