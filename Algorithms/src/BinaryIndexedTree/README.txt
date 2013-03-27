http://community.topcoder.com/tc?module=Static&d1=tutorials&d2=binaryIndexedTrees

Difference between BIT and Segment Tree
http://codeforces.com/blog/entry/6847

Nice tricky catch worth mentioning:
Once you build the Fenwick-tree (acumulating from idx up to MAX) upd(idx,val), in order to get the specific value from the array, you have to do read(idx)-read(idx+1). (TC tutorial uses this)
But if you build the tree updating single values by upd(idx,val) and upd(idx+1,-val), in order to get the value from idx we need to cal only ONE read(idx). (http://ideone.com/Y6e5k4)

########## Problems:
#1 
http://codeforces.com/contest/276/problem/C
sol: 
http://ideone.com/Y6e5k4

