import sys
# sys.stdin = open("B.in","r")
 
N = int(input())
ar = {}
while(N>0):
	color = raw_input()
	if(ar.has_key(color)):
		ar[color]=ar[color]+1;
	else :
		ar[color]=1
	if(ar[color]==1):
		print (color + " " +str(ar[color]) +" vez")
	else:
		print (color + " " +str(ar[color]) +" veces")
	N-=1