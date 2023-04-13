correspondances={')':'(',']':'[','}':'{'}
stack=[]

for c in input():
    if c in '([{':
        stack.append(c)
    elif c in ')]}':
        if len(stack)>0 and stack[-1] == correspondances[c]:
            stack.pop()
        else:
            print("false")
            quit()

print("true" if len(stack)==0 else "false")
