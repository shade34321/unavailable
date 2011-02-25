.orig x3000
     LD R0, NAME ; Loads first ASCII code from NAME's first address
     LEA R2, NAME ; Stores the NAME's first address in register 2
LOOP TRAP x21 ; Start of the loop and prints whatever is in register 0
     ADD R2, R2, #1 ; Adds one to register 2
     ST R2, Address ; Stores register 2 in Address 
     LDI R0, Address ; Loads contents of address into register 0
     BRzp LOOP ; Checks to see if loop end is reached

NAME .stringz "Nathanial Heard" ; Contains the string to be printed on screen
Address .fill 0 ; Holds the next address of the character in the string to be printed
TRAP x25 ; Halts program
.end
