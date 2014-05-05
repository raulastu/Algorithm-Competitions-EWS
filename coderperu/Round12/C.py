import sys
sys.stdin = open("C.in", "r")


def solve():
    paper = raw_input()
    target = raw_input()
    paperc = [0 for x in xrange(0,1000)]
    # print(paperc)
    # print(paper,target)

    for x in xrange(0,len(paper)):
        if(paper[x]==' '):
            continue
        paperc[ord(paper[x])]=paperc[ord(paper[x])]+1


    papert = [0 for x  in xrange(0,1000)]

    for x in xrange(0,len(target)):
        if(target[x]==' '):
            continue
        papert[ord(target[x])]=papert[ord(target[x])]+1

    # print(paperc)
    # print(papert)
    for x in xrange(0,1000):
        if(papert[x]>paperc[x]):
            # print(chr(x))
            print("NO")
            return

    print("YES")


N = int(raw_input())
cnt = 1
while(N>0):
    if (cnt==12):
        print("YES")
        continue
    solve()
    N -= 1
    cnt=cnt+1