import sys
import math

# Auto-generated code below aims at helping you parse
# the standard input according to the problem statement.

s = input().split('\\n')
change_count = int(input())
#print("initial:",s, file=sys.stderr, flush=True)

changes=[]

for i in range(change_count):
    raw=input()
    changes.append(raw)

# l'idée est d'appliquer les changements demandés en partant de la fin en revenant vers le début
# afin de ne pas avoir de perturbation :
changes=reversed(sorted(changes, key=lambda x: (int(x.split('|')[0]),int(x.split('|')[1]))))

for change in changes:
#    print("change:",change, file=sys.stderr, flush=True)
    l,c,toAdd= change.split('|')
    line=int(l)
    col=int(c)
    toAdd=toAdd.replace('\\n','#')
    updated=str(s[line])[:col]+toAdd+str(s[line][col:])
    s[line]=updated
#    print("  =>",s, file=sys.stderr, flush=True)


for line in s:
    print(line.replace('#','\n'))