n = int(input())
for i in range(0,n):
	n = int(input())
	if n<=100:
		print ((n+1)//2)**2
	else:
		if n%2==1:
			n-=1
		print n*(n+1)/2 - (n/2)**2