def convertBin(val):
    return bin(val).replace('0b','')

def convertDec(temp):
    return int(temp,2)

out=[]
temp=''

w, h = [int(i) for i in input().split()]
for i in range(h):
    for j in input().split():
        pixel = int(j)
        binPixel=convertBin(pixel)
        bit=binPixel[-1]
        temp+=bit
        if len(temp)==8:
            out.append(chr(convertDec(temp)))
            temp=''

print(''.join(out))
