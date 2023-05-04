n = int(input())
heights=[]
for i in input().split():
    heights.append(int(i))

max_amount=-1
for start in range(n-1):
    for end in range(1,n):
        h1=heights[start]
        h2=heights[end]
        amount=min(h1,h2)*(end-start)
        max_amount=max(max_amount,amount)
print(max_amount)
