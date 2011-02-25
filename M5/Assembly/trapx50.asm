.orig x2700
	LD R1, NUM
NEWTASK
START	LDI R0, A
	BRzp START
	LDI R0, B
	BRnzp NEWTASK	
	ADD R0, R0, R1
		
	RET
NUM .fill #32
A .fill xFE00
B .fill xFE02
.end

.orig x50
	.fill x2700
.end

.orig x3000
	TRAP x50
HALT
.end
