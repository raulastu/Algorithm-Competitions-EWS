import sys
sys.stdin = open("A.in", "r")
 
N = int(raw_input())
while(N>0):
	a = raw_input()
	b = raw_input()[::-1]
	if(a==b):
		print("YES")
	else:
		print("NO")

	N-=1