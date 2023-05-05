import sys
import math

program = input()
registres=[0,0,0]

def EXIT():
    print(*registres,sep=' ')
    quit()

def LD(k,nn):
    registres[k]=nn

def ADD(x,y):
    s=registres[x]+registres[y]
    registres[x]=s-256 if s>127 else s
    registres[2]=1 if s>255 else 0

def SUB(x,y):
    s=registres[x]-registres[y]
    registres[2]=1 if s<0 else 0
    registres[x]=s+256 if s<0 else s

def OR(x,y):
    registres[x]|=registres[y]

def AND(x,y):
    registres[x]&=registres[y]

def XOR(x,y):
    registres[x]^=registres[y]

def SE(k,nn):
    return 1 if registres[k] == nn else 0

def SNE(k,nn):
    return 1 if registres[k] != nn else 0

def SEXY(x,y):
    return 1 if registres[x] == registres[y] else 0

def SNEXY(x,y):
    return 1 if registres[x] != registres[y] else 0

instructions = [program[i:i+4] for i in range(0, len(program), 4)]

print(instructions, file=sys.stderr, flush=True)
pointer=0
while(True):
    instruction=instructions[pointer]
    op=int(instruction[0],16)
    print('instruction', instruction, '=>op',op, file=sys.stderr, flush=True)
    pointer+=1
    
    if op == 0:EXIT()
    elif op==1:LD(int(instruction[1]), int(instruction[2:4],16))
    elif op==2:ADD(int(instruction[2]), int(instruction[3]))
    elif op==3:SUB(int(instruction[2]), int(instruction[3]))
    elif op==4:OR(int(instruction[2]), int(instruction[3]))
    elif op==5:AND(int(instruction[2]), int(instruction[3]))
    elif op==6:XOR(int(instruction[2]), int(instruction[3]))
    elif op==7:pointer+=SE(int(instruction[1]), int(instruction[2:4],16))
    elif op==8:pointer+=SNE(int(instruction[1]), int(instruction[2:4],16))
    elif op==9:pointer+=SEXY(int(instruction[2]), int(instruction[3]))
    elif op==10:pointer+=SNEXY(int(instruction[2]), int(instruction[3]))