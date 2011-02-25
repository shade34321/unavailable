.orig x2600
	ADD R0, R0, R1 ; Adds register 0 and register 1 and puts the resualt into register 0
	ADD R0, R0, R2 ; Adds register 0 and register 2 and puts the resualt into register 0
	RET
.end

.orig x0030
	.fill x2600
.end

.orig x3000
	LD R0, NUM 
	LD R1, NUM
	LD R2, NUM
	TRAP x0030
HALT
NUM .fill #1
.end
