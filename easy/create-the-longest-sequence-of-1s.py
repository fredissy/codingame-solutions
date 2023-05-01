b = input().split('0')
maxlen=0
for i in range(len(b)-1):maxlen=max(len(b[i])+len(b[i+1])+1,maxlen)
print(maxlen)
