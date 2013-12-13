import sys
#sys.stdin = open("B.in", "r")
 
N = int(input())
while(N>0):
    A = raw_input().split(" ")
    #print(A)
    M = A[0]
    W = A[1]
    wi=0
    for x in W:
        if(x==M[wi]):
            wi+=1;

    if(wi==len(M)):
        print "YES"
    else:
        print "NO"

    N -= 1