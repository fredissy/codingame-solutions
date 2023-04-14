def find_people(root, found):
    if( not root in links):
        return found
    relations=[ str(c) for c in links[str(root)] if c not in found]
    if len(relations)==0:
        return found
    else:
        found.extend(relations)
        for r in relations:
            find_people(r, found)
    return found

npeople = int(input())
nlinks = int(input())

people=[str(i) for i in range(npeople)]
people_found_in_clusters=[]
links={}
clusters=[]

for i in range(nlinks):
    link = input().split()
    a=str(link[0])
    b=str(link[1])
    if a in links:
        links[a].append(b)
    else:
        links[a]=[b]

    if b in links:
        links[b].append(a)
    else:
        links[b]=[a]

for p in people:
    if not p in people_found_in_clusters:
        cluster = find_people(p, [p])
        people_found_in_clusters.extend(cluster)
        clusters.append(cluster)
#    else:
#        print(p,'déjà dans un cluster, on ne fait rien')

clusters=sorted(clusters, key=len, reverse=True)

largest=len(clusters[0])
for size in range(largest,0,-1):
    items=len([x for x in clusters if len(x)==size])
    if items>0:
        print(size, items)
        
