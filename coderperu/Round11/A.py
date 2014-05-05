import sys
sys.stdin = open("A.in", "r")
 
N = int(raw_input())
while(N>0):
	# nk = raw_input().split(" ")
	n = int(raw_input())
	
	nk = raw_input().split(" ")
	ar = [0 for x in range(3001)];
	NK = [int(x) for x in nk]
	ar[0]=1
	# n = int(nk[0])
	# k = int(nk[1])
	
	for x in NK:
	    ar[x]=1

	# print(ar)

	for x in range(0,3001):
		# print(x)
		if(ar[x]==0):
			print(x)
			break
	N-=1