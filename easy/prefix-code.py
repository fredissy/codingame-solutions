letters={}
n = int(input())
for i in range(n):
    inputs = input().split()
    b = inputs[0]
    c = int(inputs[1])
    letters[b]=c

s = input()
idx=0
out=''
while len(s)>0:
    found=False
    for k in letters:
        if s[:len(k)]==k:
            out+=chr(letters[k])
            s=s[len(k):]
            found=True
            idx+=len(k)
            break
    if not found:
        print("DECODE FAIL AT INDEX",idx)
        exit()
print(out)
