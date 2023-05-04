import sys
import math

# Auto-generated code below aims at helping you parse
# the standard input according to the problem statement.

n = int(input())
for i in range(n):
    card = input().replace(' ','')
    #step 1 :
    s1=sum([a-9 if a>9 else a for a in [(int(i)*2) for i in card[0:15:2]]])
    #step 3 :
    s2=sum([int(i) for i in card[1:16:2]])
    print('YES' if (s1+s2)%10==0 else 'NO')
