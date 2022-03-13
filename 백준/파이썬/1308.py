import datetime
start = list(map(int, input().split()))
end = list(map(int, input().split()))

start_day = datetime.date(start[0], start[1], start[2])
start_after_1000 = datetime.date(start[0] + 1000, start[1], start[2])
end_day = datetime.date(end[0], end[1], end[2])

result_1000 = start_after_1000 - start_day
result = end_day - start_day
if result < result_1000:
  print("D-{}".format(result.days))
else:
  print("gg")