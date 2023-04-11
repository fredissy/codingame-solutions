import sys
import math
from math import radians, degrees, sin, cos, asin, acos, sqrt

messages=[]

def dist(l1, l2):
    return great_circle(l1[1], l1[0], l2[1], l2[0])

def great_circle(lon1, lat1, lon2, lat2):
    lon1, lat1, lon2, lat2 = map(radians, [lon1, lat1, lon2, lat2])
    return 6371 * (acos(sin(lat1) * sin(lat2) + cos(lat1) * cos(lat2) * cos(lon1 - lon2)))

def todegresLat(NDDMMSS):
     #degrés + (arcminutes/60) + (arcsecondes/3600)
    deg=NDDMMSS[1:3]
    amin=NDDMMSS[3:5]
    asec=NDDMMSS[5:7]
    mult=1 if NDDMMSS[0] == 'N' else -1
    return mult*(int(deg)+int(amin)/60+int(asec)/3600)

def todegresLon(NDDMMSS):
     #degrés + (arcminutes/60) + (arcsecondes/3600)
    deg=NDDMMSS[1:4]
    amin=NDDMMSS[4:6]
    asec=NDDMMSS[6:8]
    mult=1 if NDDMMSS[0] == 'E' else -1
    return mult*(int(deg)+int(amin)/60+int(asec)/3600)

def print_shortest(loc):
    print('------------', file=sys.stderr, flush=True)
    print(loc, file=sys.stderr, flush=True)
    shortest=-1
    for m in messages:
        current = math.ceil(dist(m['coord'], loc))
        print("message", m['message'], "dist=", current, file=sys.stderr, flush=True)
        if shortest == -1 or current <= shortest:
            shortest = current
    
    print("shortest found", shortest, file=sys.stderr, flush=True)
    message=[]
    for m in messages:
        current = math.ceil(dist(m['coord'], loc))
        if current == shortest:
            message.append(m['message'])

    print(*message)

n = int(input())  # number of capitals
m = int(input())  # number of geolocations for which to find the closest capital
for i in range(n):
    capital_name_geoloc = input()
    coords=capital_name_geoloc.split(" ")
    lat=todegresLat(coords[1])
    lon=todegresLon(coords[2])
    data={}
    data['coord'] = [lat,lon]
    messages.append(data)


for i in range(n):
    message = input()
    data=messages[i]
    data['message']=message
    #print(data)
for i in range(m):
    travel_geoloc = input().split()
    loc = [todegresLat(travel_geoloc[0]), todegresLon(travel_geoloc[1])]
    print_shortest(loc)
