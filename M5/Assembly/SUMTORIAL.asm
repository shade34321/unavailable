.orig x3000
     LD R0, N
     AND R1, R1, 0
LOOP ADD R1, R1, R0
     ADD R0, R0, #-1
     BRp LOOP
N .fill 2
ANS .fill 0
HALT
.end
