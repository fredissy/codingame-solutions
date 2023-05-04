number = input()
d = int(input())

#nothing :
if(int(number)%d==0):print(number);exit()

#1 digit :
found=[]
for i in range(len(number)):
    nbr=number[:i] + number[i + 1:]
    if(int(nbr)%d==0):
        found.append(int(nbr))

if len(found)>0:
    print(sorted(found,reverse=True)[0]);exit()

#2 digit :
found=[]
for i in range(len(number)-1):
    for j in range(i,len(number)):
        nbr=number[:i] + number[i + 1:j]+number[j+1:]
        if(int(nbr)%d==0):
            found.append(int(nbr))

if len(found)>0:
    print(sorted(found,reverse=True)[0]);exit()

#no solution
print(0)
