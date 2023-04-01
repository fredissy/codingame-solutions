import sys
import math

# Auto-generated code below aims at helping you parse
# the standard input according to the problem statement.

lon = float(input().replace(',','.'))
lat = float(input().replace(',','.'))
coord_user= [lon,lat]
n = int(input())
min_dist=999999999
nom=''
for i in range(n):
    data=input().split(';')
    coord_defib= [float(x.replace(',','.')) for x in data[4:6]]
    dist=math.dist(coord_user, coord_defib)
    if dist<min_dist:
        nom=data[1]
        min_dist=dist
print(nom)