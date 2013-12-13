            
import sys
import math
# sys.stdin = open("E.in","r")
 
N = int(raw_input())
while(N>0):
	n = int(raw_input())
	AX = raw_input().split(" ")
	AB = [int(x) for x in AX]
	ar=[0 for x in range(0,1001)]
	# print(ar)
	# print(AB)
	for x in AB:
		ar[x]+=1
	ax = sorted(ar)
	# print(ax[1000])
	if(n-ax[1000]+1>=ax[1000]):
		print("YES")
	else:
		print("NO")
	N-=1