.orig x3000
    LD R0, A ; Loading variable A into register 0
    LD R1, B ; Loading variable B into register 1

    ADD R2, R0, R1 ; Adding variables A and B and storing the data in register 2
    STI R2, Address0 ; Storing contents of register 2 at x3100

    AND R3, R0, R1 ; Anding variables A and B and storing it into register 3
    STI R3, Address1 ; Storing contents of register 3 at x3101
   
    NOT R4, R3 ; Fliping all bits of register 3 and storing it into register 4
    AND R5, R4, R1 ; Anding register 4 with B and storing it in register 5
    ADD R6, R5, R0 ; Adding register 5 with A and storing it into register 6
    STI R6, Address2 ; Storing contents of register 6 at x3102

    NOT R4, R1 ; Fliping bits of variable A and storing it into register 4
    ADD R4, R4, 1 ; Adding one to register 4 and storing it into register 4
    ADD R7, R0, R4 ; Adding variable A with register 4 and storing it into register 7
    STI R7, Address3 ; Storing contents of register 7 at x3103

A .fill 27 ; Declarig symbol A to be 27
B .fill 169 ; Declaring symbol B to be 169
Address0 .fill x3100 ; Holding address number for contents of ADD
Address1 .fill x3101 ; Holding address number for contents of AND 
Address2 .fill x3102 ; Holding address number for contents of OR
Address3 .fill x3103 ; Holding address number for contents of SUB
.end
