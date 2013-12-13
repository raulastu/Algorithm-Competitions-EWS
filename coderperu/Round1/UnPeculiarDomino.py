           
import sys
# sys.stdin = open("A.in","r")
 
N = int(input())
while(N>0):
	n = int(input())
	res=0
	a = 0
	for x in xrange(0,n):
		c = int(input())
		if c!=a:
			res+=1
		a=c
	print(res)
	N-=1