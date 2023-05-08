import sys
import math

# Auto-generated code below aims at helping you parse
# the standard input according to the problem statement.

SCISSORS='C'
ROCK='R'
PAPER='P'
LIZARD='L'
SPOCK='S'

def get_winner(n1, s1, n2, s2):
    if s1==s2: return min(n1,n2)
    if s1 == SCISSORS and (s2 == PAPER or s2==LIZARD):return n1
    if s2 == SCISSORS and (s1 == PAPER or s1==LIZARD):return n2
    if s1 == PAPER and (s2==ROCK or s2==SPOCK): return n1
    if s2 == PAPER and (s1==ROCK or s1==SPOCK): return n2
    if s1 == ROCK and (s2==SCISSORS or s2==LIZARD): return n1
    if s2 == ROCK and (s1==SCISSORS or s1==LIZARD): return n2
    if s1 == LIZARD and (s2==SPOCK or s2==PAPER): return n1
    if s2 == LIZARD and (s1==SPOCK or s1==PAPER): return n2
    if s1 == SPOCK and (s2==SCISSORS or s2==ROCK): return n1
    if s2 == SPOCK and (s1==SCISSORS or s1==ROCK): return n2

def turn(players):
    winners={}
    for x, y in zip(*[iter(players)]*2):
        p1=players[x]
        p2=players[y]
        winner=get_winner(x,p1['sign'],y,p2['sign'])
        loser=x if winner==y else y
        players[winner]['oponents'].append(loser)
        winners[winner]=players[winner]
    return winners

players={}

n = int(input())
for i in range(n):
    inputs = input().split()
    numplayer = int(inputs[0])
    signplayer = inputs[1]
    player={}
    player['sign']=signplayer
    player['oponents']=[]

    players[numplayer]=player

while(len(players)>1):
    players=turn(players)

for i in players:
    print(i)
    print(*players[i]['oponents'])
