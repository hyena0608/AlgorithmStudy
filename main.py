def four(id):
    id = list(id)
    if id[0] == '.':
        id.pop(0)
    if len(id) >= 1 and id[-1] == '.':
        id.pop(len(id))
    return ''.join(id)

print(four('.'))