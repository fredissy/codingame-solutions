import sys
import math

def check10(isbn):
    sum,mult=0,10
    for c in isbn[0:9]:
        if(not c.isdigit()):
            return False
        sum+=(mult*int(c))
        mult-=1
    checksum=11-sum%11
    if(checksum==11):checksum=0
    if(checksum==10):checksum='X'
    return isbn[-1]==str(checksum)

def check13(isbn):
    sum=0
    for i,c in enumerate(isbn[0:12]):
        if(not c.isdigit()):
            return False
        sum+=(int(c)* (1 if i%2==0 else 3))
    checksum=10-sum%10
    if(checksum==10):checksum=0
    return str(isbn[-1])==str(checksum)

n = int(input())
invalid=[]
for i in range(n):
    isbn = input()
    if(len(isbn) not in [10,13]):
        invalid.append(isbn)
    elif(len(isbn)==10 and not check10(isbn)):
        invalid.append(isbn)
    elif(len(isbn)==13 and not check13(isbn)):
        invalid.append(isbn)

print(len(invalid),"invalid:")
print('\n'.join(invalid))