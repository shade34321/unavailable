.orig x3000
	LD R7, OVERDRIVE ; Sets register 7 to OVERDRIVE
	AND R0, R0, 0 ; Clears register 0
	ADD R0, R0, #-1 ; Subtracts -1 from register 0
	STI R0, NEGA ; Stores the contents of register 0 at the location contained by NEGA	
	LD R0, PRIMES ; Loads starting address into register 0	

LOOP	ST R0, ADDRESS ; Start of loop stores contents of register 0 into ADDRESS
	LDI R2, ADDRESS ; Stores contents of location stored by ADDRESS into register 2
	BRn JUMP ; Checks to see if loop needs to stop by checking for negative numbers
	STI R0, ADDRESS ; Stores contents of register 0 at location contained by ADDRESS
	ADD R0, R0, #1 ; Adds one to register 0
	BRzp LOOP ; Loops back to LOOP if no negative numbers appear

JUMP 	LD R2, NUM ; Loads NUM into register 2
	AND R0, R0, 0 ; Clears register 0
	AND R1, R1, 0 ; Clears register 1
	ADD R1, R1, #1 ; Sets register 1 to 1
	ST R1, ADDRESS ; Stores contents of register 1 in ADDRESS
	STI R0, ADDRESS ; Sets the address stored in ADDRESS to 0	
	AND R3, R3, 0 ; Clears register 3
	AND R4, R4, 0 ; Clears register 4	
	ADD R3, R3, #2 ; Sets register 3 to 2
	ADD R4, R4, R3 ; Sets register 4 to register 3

SIEVE	ADD R3, R3, R4 ; Adds register 4(a prime number) to register 3
	ST R3, ADDRESS ; Stores register 3 in ADDRESS
	ADD R6, R3, R7 ; Creates a negative number if R3 is greater than 3000
	BRn DONE ; Branches to DONE if number is negative
	STI R0, ADDRESS ; Sets the location stored in ADDRESS to zero
	BRzp SIEVE	; if no negative number appears than loop continues

DONE	ADD R4, R4, #1 ; Adds one to register 4	
	ST R4, ADDRESS ; Stores contents of register 4 in ADDRESS
	LDI R3, ADDRESS ; Loads contents stored at location in ADDRESS to register 3
	BRn KILL ; Stops the program if program has reached the end of PRIMES
	BRz DONE ; Branches back to DONE if location in ADDRESS is zero	
	AND R3, R3, 0 ; Clears register 3	
	ADD R3, R3, R4 ; Set register 3 to register 4	
	BRnzp SIEVE
	
KILL	HALT
OVERDRIVE .fill #29767
NEGA .fill x0BB9
ADDRESS .fill 0
NUM .fill #3000
PRIMES .BLKW x0BB8 ; Holds the array of integers from 0 to 3000

.end
