n = int(input())
packet = input()
out=[]
while len(packet)>0:
    instruction = packet[:3]
    length = int(packet[3:7],2)
    itemid = packet[7:7+length]
    packet = packet[7+length:]
    if(instruction=='101'):
        out.append(itemid)

for p in out:
    print('001', bin(len(p)).replace('0b','').zfill(4), p, end='' ,sep='')
