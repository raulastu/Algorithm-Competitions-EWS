import sys
sys.stdin = open("A.in", "r")
 
def solve():
	a = raw_input()
	if(len(a)%2!=1):
		LEN = (len(a)+1)/2
	else:
		LEN = (len(a))/2
	A = a[:LEN]

	B = a[len(a)-LEN:]
	LEN = len(a)/2
	ar = [0 for x in range(400)]
	ar2 = [0 for x in range(400)]
	# print(A,B,ar,ar2);
	for x in range(0,LEN):
		ar[int(ord(A[x]))]+=1
		ar2[ord(B[x])]+=1
	for x in range(0,400):
		if(ar2[x]!=ar[x]):
			print("NO")
			return
	print("YES")

N = int(raw_input())
while(N>0):
	solve()
	
	N-=1