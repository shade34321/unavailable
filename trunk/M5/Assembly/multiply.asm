.orig x3000
     LD R0, OPA ; Loading symbol OPA into register 0
     LD R1, OPB ; Loading symbol OPB into register 1
     AND R2, R2, 0 ; Clearing register 2 incase there was something stored there

AGAIN ADD R2, R2, R1 ; Adding register 2 with register 1 and storing it into register 2
      ADD R0, R0, #-1 ; Decrementing OPA
      BRp AGAIN ; Looping will numbers are positive
      ST R2, OUTPUT ; Storing contents of register 2 into OUTPUT

OPA .fill 5 ; Symbol for holding number to be multiplied 
OPB .fill 5 ; Symbol for holding number to be multiplied 
OUTPUT .fill 0 ; Symbol for holding the answer to the multiplication of OPA and OPB
TRAP x25 ; Halts the program
.end
