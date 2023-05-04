grid=[]

def checkrow():
    for row in grid:
        for idx,r in enumerate(sorted(row)):
            if idx+1!=r:return False
    return True
            
def checkcol():
    for x in range(len(grid[0])):
        col=[]
        for y in range(len(grid)):
            col.append(grid[y][x])
        #print(col,file=sys.stderr, flush=True)
        for idx,r in enumerate(sorted(col)):
            if idx+1!=r:return False
    return True

def subgrid():
    for x in range(0,len(grid[0]),3):
        for y in range(0,len(grid),3):
            subgrid=[]
            for xg in range(0,3):
                for yg in range(0,3):
                    subgrid.append(grid[y+yg][x+xg])
            for idx,r in enumerate(sorted(subgrid)):
                if idx+1!=r:return False
    return True

for i in range(9):
    grid.append([int(j) for j in input().split()])

print('true' if checkrow() and checkcol() and subgrid() else 'false')
