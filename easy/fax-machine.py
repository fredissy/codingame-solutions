w = int(input())
h = int(input())
instructions = [int(x) for x in input().split()]

out=''
colors=['*',' ']
color=1
for instruction in instructions:
    color=1-color
    out+=colors[color]*instruction

parts=[out[i:i+w] for i in range(0,w*h,w)]
print('|',end='')
print('|\n|'.join(parts),end='')
print('|')

