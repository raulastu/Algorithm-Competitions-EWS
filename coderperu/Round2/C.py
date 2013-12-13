import sys
sys.stdin = open("C.in", "r")


def primes_sieve(limit):
    limitn = limit+1
    primes = range(2, limitn)

    for i in primes:
        factors = range(i, limitn, i)
        for f in factors[1:]:
            if f in primes:
                primes.remove(f)
    return primes

sieve = primes_sieve(10000);
#print(sieve)

N = int(input())
while(N>0):
    NM = raw_input().split(" ");
    n = int(NM[0])
    m = int(NM[1])
    #print(n,m)
    matr = [[0 for x in range(m)] for y in range(n)]
    #print(mat)
    for i in range(0,n):
        raw = raw_input().split()
        for j in range(m):
            matr[i][j] = int(raw[j])

    #print(matr)
    matc = [[0 for x in range(n)] for y in range(m)]
    #print(matc)
    for i in range(0,n):
        raw = matr[i]
        for j in range(0,m):
            matc[j][i] = raw[j]

    for i in range(0,n):
        matr[i]=sorted(matr[i])

    for i in range(0,n):
        matc[i]=sorted(matc[i])

    mini = 1<<30

    for i in range(0,n):
        sii=0;
        acc=0
        for j in range(0,m):
            while(sieve[sii]<matr[i][j]):
                sii+=1;
            dif = sieve[sii]-matr[i][j]
            acc+=dif;
        mini=min(mini,acc)

    for i in range(0,m):
        sii=0;
        acc=0
        for j in range(0,n):
            while(sieve[sii]<matc[i][j]):
                sii+=1;
            dif = sieve[sii]-matc[i][j]
            acc+=dif;
        mini=min(mini,acc)
    print(mini)
    #print(matc)
    #print(n,m)
    N -= 1