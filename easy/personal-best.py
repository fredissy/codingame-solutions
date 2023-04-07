
gymnasts = input().split(',')
categories = input().split(',')
max_points={}

n = int(input())
for i in range(n):
    row = input().split(',')
    bars=float(row[1])
    beam=float(row[2])
    floor=float(row[3])

    if row[0] in max_points:
        points = max_points[row[0]]
        points['bars'] = row[1] if bars>float(points['bars']) else points['bars']
        points['beam'] = row[2] if beam>float(points['beam']) else points['beam']
        points['floor'] = row[3] if floor>float(points['floor']) else points['floor']
        max_points[row[0]] = points
    else:
        points = {}
        points['bars']=row[1]
        points['beam']=row[2]
        points['floor']=row[3]
        max_points[row[0]] = points


for gymnast in gymnasts:
    v=[]
    for k in categories:
        v.append(max_points[gymnast][k])
    print(*v,sep=',')
