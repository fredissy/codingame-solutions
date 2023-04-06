import sys
import math

def is_digit(n):
    try:
        int(n)
        return True
    except ValueError:
        return  False

def getValue(val):
    if is_digit(val):
        return int(val)
    else:
        return globals()[val]

def setValue(val, dest):
    globals()[dest]=val


a, b, c, d = [int(i) for i in input().split()]

instructions=[]
n = int(input())
for i in range(n):
    ins = input().split()
    instructions.append(ins)

exec=0
while(exec < len(instructions)):
    ins = instructions[exec]
    print(exec, ins, file=sys.stderr, flush=True)
    exec+=1

    if ins[0] == 'MOV':
        dest=ins[1]
        src=getValue(ins[2])
        setValue(src, dest)
    elif ins[0] == 'ADD':
        dest=ins[1]
        src1=getValue(ins[2])
        src2=getValue(ins[3])
        setValue(src1+src2, dest)
    elif ins[0] == 'SUB':
        dest=ins[1]
        src1=getValue(ins[2])
        src2=getValue(ins[3])
        setValue(src1-src2, dest)
    elif ins[0] == 'JNE':
        dest=ins[1]
        src1=getValue(ins[2])
        src2=getValue(ins[3])
        if(src1 != src2):
            exec=int(dest)

print(a,b,c,d, sep=' ')
