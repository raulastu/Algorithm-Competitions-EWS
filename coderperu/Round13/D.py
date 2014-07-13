import sys
sys.stdin = open("D.in", "r")
 


def expo(a, b, MOD):
    if (b==1):
        return a%MOD;
    if (b==2):
        return (a*a)%MOD;

    if (b%2==0):
            return expo(expo(a%MOD,b/2,MOD),2,MOD)%MOD
    else:
         return a*expo(expo(a%MOD,(b-1)/2,MOD),2,MOD)%MOD;
    
def solve():

    A = raw_input().split(" ")
    a = int(A[0]);
    b = int(A[1]);
    k = int(A[2]);
    r = pow(a,b)
    # print(r)
    if(r<10000 and k >= 4):
        print(-1)
        return
    if(r<1000 and k >= 3):
        print(-1)
        return
    if(r<100 and k >= 2):
        print(-1)
        return
    if(r<10 and k >= 1):
        print(-1)
        return
    s=str(r%10000)
    if(k>=len(s)):
        print(0)
    else:
        print(s[len(s)-1-k])

N = int(raw_input())
while(N>0):
    A = raw_input().split(" ")
    a = int(A[0]);
    b = int(A[1]);
    k = int(A[2]);
    r = pow(a,b)
    # print(r)
    if(r<10000 and k >= 4):
        print(-1)
        continue
    if(r<1000 and k >= 3):
        print(-1)
        continue
    if(r<100 and k >= 2):
        print(-1)
        continue
    if(r<10 and k >= 1):
        print(-1)
        continue
    s=str(r%10000)
    if(k>=len(s)):
        print(0)
    else:
        print(s[len(s)-1-k])
    # print(r)
    N -= 1