import sys
import math

# clé = numéro de la piste, valeur = départ
tracks = {}

def track_swap(idx1, idx2):
    tmp = tracks[idx1]
    tracks[idx1] = tracks[idx2]
    tracks[idx2] = tmp

w, h = [int(i) for i in input().split()]
depart=input().split()
for i in range(len(depart)):
    tracks[i] = depart[i]

#print(tracks, file=sys.stderr, flush=True)

for i in range(h-2):
    line = input()
    parts = line.split()
#    print('------------', file=sys.stderr, flush=True)
#    print(line,"  =>  ",parts,'\n', file=sys.stderr, flush=True)
    idx=0
    trackIdx=0
    while(idx < len(parts)):
        part = parts[idx]
        if part=='|--|':
            track_swap(trackIdx, trackIdx+1)
            trackIdx+=1
        idx+=1
        trackIdx+=1
#    print(tracks, file=sys.stderr, flush=True)

arrivees=input().split()

for d in depart:
    key_list = [key for key, val in tracks.items() if val == d]
    arrivee_index = key_list[0]

    print(d, arrivees[arrivee_index], sep='')
