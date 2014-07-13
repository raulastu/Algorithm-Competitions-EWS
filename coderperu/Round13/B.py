import sys
from numpy import ndarray


def solve():
    strx = raw_input()
    a = strx.split(" ")
    N = int(a[0])
    Q = int(a[1])
    # ma = [[0 for x in range(0,N)] for y in range(0,N)]
    ma = [[0]*N for x in range(0,N)]
    # ma = ndarray.empty((N,),int)
    # ma = arange(10)


    # print(ma)
    # print(ma[1][1])
    for x in xrange(0,Q):
        print(ma)
        str1 = raw_input()
        str2 = str1.split(" ")
        RC = int(str2[1])-1
        X = int(str2[2])
        # print(RC)
        if(str1[3]=='R'):
            for x in range(0,N):
                ma[RC][x]+=X
        else:
            for x in range(0,N):
                ma[x][RC]+=X
    print(ma)
    maxx = 0
    for x in xrange(0,N):
        for y in xrange(0,N):
            maxx=max(maxx,ma[x][y])    
    print(maxx);
    


sys.stdin = open("B.in", "r")
N = int(raw_input())

while(N>0):

    solve();
    N -= 1
    