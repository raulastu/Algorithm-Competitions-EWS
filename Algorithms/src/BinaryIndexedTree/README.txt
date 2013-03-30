Also known as Fenwick tree.
http://community.topcoder.com/tc?module=Static&d1=tutorials&d2=binaryIndexedTrees

http://translate.google.com/translate?hl=en&sl=ru&u=http://e-maxx.ru/algo/&prev=/search%3Fq%3Dhttp://e-maxx.ru/algo/%26hl%3Den%26biw%3D1440%26bih%3D721&sa=X&ei=ehVTUZaeIoWE9QSp8YDgDw&ved=0CDMQ7gEwAA

If you have time: https://www.google.com.pe/url?sa=t&rct=j&q=&esrc=s&source=web&cd=2&ved=0CDYQFjAB&url=http%3A%2F%2Fciteseerx.ist.psu.edu%2Fviewdoc%2Fdownload%3Fdoi%3D10.1.1.14.8917%26rep%3Drep1%26type%3Dpdf&ei=-yhTUdfFMImy9gSb2IDABw&usg=AFQjCNEQAPcvJPkPkq4Wbr--eEnNLkCBmQ&bvm=bv.44342787,d.eWU&cad=rja

Difference between BIT and Segment Tree
http://codeforces.com/blog/entry/6847

Nice tricky catch worth mentioning:
Once you build the Fenwick-tree (acumulating from idx up to MAX) upd(idx,val), in order to get the specific value from the array, you have to do read(idx)-read(idx+1). (TC tutorial uses this)
But if you build the tree updating single values by upd(idx,val) and upd(idx+1,-val), in order to get the value from idx we need to cal only ONE read(idx). (http://ideone.com/Y6e5k4)

########## Problems:
#1: 
http://codeforces.com/contest/276/problem/C
sol: 
http://ideone.com/Y6e5k4

#2:
http://www.hsin.hr/coci/archive/2011_2012/contest3_tasks.pdf
Task PLAĆE

#3
http://codeforces.com/contest/284/problem/C
sol:
http://ideone.com/miWBFj