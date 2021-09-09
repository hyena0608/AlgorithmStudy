arr = list(map(int, input()))
half = int(len(arr)/2)
a = sum(arr[0:half])
b = sum(arr[half:])

if a == b:
  print("LUCKY")
else:
  print("READY")