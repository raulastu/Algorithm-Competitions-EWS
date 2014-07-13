import sys
sys.stdin = open("C.in", "r")


def solve():
    a = int(raw_input())
    minx = a-1
    for x in xrange(1,a):
        aa = a/x
        bb = a/aa
        # print(aa,bb)
        if(aa*bb==a):
            minx=min(minx,abs(aa-bb))
    print(minx)


N = int(raw_input())
cnt = 1
while(N>0):    
    solve()
    N -= 1