from re import match
import sys
import math

# Auto-generated code below aims at helping you parse
# the standard input according to the problem statement.
n = int(input())
m = int(input())

signals = {}
signals['_']=False
signals['-']=True
signals[False]='_'
signals[True]='-'


def operation(_type, i1, i2):
    v1 = signals[i1]
    v2 = signals[i2]

    #print("Operation=",_type,"v1=",v1,"v2=",v2, file=sys.stderr, flush=True)

    if _type == "AND":#AND
     #   print("  ==>",(v1==v2), signals[v1==v2], file=sys.stderr, flush=True)
        return signals[v1 and v2]
    if _type == 'OR':
        return signals[v1 or v2]
    if _type == 'XOR':
        return signals[v1 != v2]
    if _type == 'NAND':
        return signals[not (v1 and v2)]
    if _type == 'NOR':
        return signals[not (v1 or v2)]
    if _type == 'NXOR':
        return signals[not(v1 != v2)] #v1==v2 ?

inputs={}
for i in range(n):
    input_name, input_signal = input().split()
    inputs[input_name]=input_signal
for i in range(m):
    output_name, _type, input_name_1, input_name_2 = input().split()
    print(output_name, end=' ')

    for j in range(0, len(inputs[input_name_1])):
        i1 = inputs[input_name_1][j]
        i2 = inputs[input_name_2][j]
        print(operation(_type, i1, i2), end='')
    print()
