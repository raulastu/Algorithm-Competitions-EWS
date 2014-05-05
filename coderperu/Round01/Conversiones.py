import sys
sys.stdin = open("C.in", "r")
 
N = int(input())
while(N>0):
    A = raw_input()
    B = raw_input()
    _47 = 0
    _74 = 0
    n = len(A)
    r = 0
    for x in range(0,n):
        if(A[x]=='4' and B[x]=='7'):
            _47+=1
        if(A[x]=='7' and B[x]=='4'):
            _74+=1
    print(min(_47,_74)+abs(_47-_74))
    N -= 1