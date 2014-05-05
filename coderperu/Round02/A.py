import sys
#sys.stdin = open("A.in", "r")
 
#N = int(input())
#while(N>0):
nk = raw_input().split(" ")
NK = [int(x) for x in nk]

n = int(nk[0])
k = int(nk[1])
res = 0
for x in range(0,n):
    xx = int(raw_input())
    if(xx%k==0):
        res+=1
print(res)
#N-=1