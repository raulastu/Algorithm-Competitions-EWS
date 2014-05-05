           
import sys
import math
# sys.stdin = open("D.in","r")
 
N = int(input())
while(N>0):
	AX = raw_input().split(" ")
	A = int(AX[0])
	B = int(AX[1])
	C = int(AX[2])
	D = int(AX[3])
	AA = B*math.log(A)
	BB = D*math.log(C)
	if(AA<BB):
		print("Beta")
	elif(AA>BB):
		print("Alfa")
	else:
		print("-1")
	N-=1