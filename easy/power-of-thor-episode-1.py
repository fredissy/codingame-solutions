a,b,c,d=[int(i)for i in input().split()]
while 1:
 input();s=""
 if d>b:d-=1;s="N"
 elif d<b:d+=1;s="S"
 if c>a:c-=1;s+="W"
 elif c<a:c+=1;s+="E"
 print(s)