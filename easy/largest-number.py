number = input()
d = int(input())
found=[]

#nothing :
if(int(number)%d==0):found.append(int(number))

#1 digit :
for i in range(len(number)):
    nbr=number[:i] + number[i + 1:]
    if(int(nbr)%d==0):
        found.append(int(nbr))

#2 digit :
for i in range(len(number)-1):
    for j in range(i,len(number)):
        nbr=number[:i] + number[i + 1:j]+number[j+1:]
        if(int(nbr)%d==0):
            found.append(int(nbr))

print(max(found) if len(found)>0 else 0)
