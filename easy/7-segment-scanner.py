import sys
import math

# Auto-generated code below aims at helping you parse
# the standard input according to the problem statement.


line1raw=' _     _  _     _  _  _  _  _ '
line2raw='| |  | _| _||_||_ |_   ||_||_|'
line3raw='|_|  ||_  _|  | _||_|  ||_| _|'
line1values={}
line2values={}
line3values={}

n=3
for k,v in enumerate([line1raw[i:i+n] for i in range(0, len(line1raw), n)]):
    if(v in line1values):
        line1values[v].append(str(k))
    else:
        line1values[v]=[str(k)]
for k,v in enumerate([line2raw[i:i+n] for i in range(0, len(line2raw), n)]):
    if(v in line2values):
        line2values[v].append(str(k))
    else:
        line2values[v]=[str(k)]
for k,v in enumerate([line3raw[i:i+n] for i in range(0, len(line3raw), n)]):
    if(v in line3values):
        line3values[v].append(str(k))
    else:
        line3values[v]=[str(k)]

line_1 = input()
line_2 = input()
line_3 = input()

out=[]
for i in range(0, len(line_1),3):
    possible1=line1values[line_1[i:i+3]]
    possible2=line2values[line_2[i:i+3]]
    possible3=line3values[line_3[i:i+3]]
    out.append(list(set(possible1)&set(possible2)&set(possible3))[0])
print(*out,sep='')
