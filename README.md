# Risc Processor emulator

## Usage

### light version

light version folder contains 3 files
- `input.txt` program text
- `output.txt` program console output
- `processorEmulator.jap` double click to run program from input.txt and fill output file with program results

### Console

programm is written in program.txt file

you could use load.sh to load program (uses cat)

or any other text editor

```console
sh load.sh
OUT 1
^C
```

to execute program run run.sh script

```console
sh run.sh
```

to save program use save.sh

```console
sh save.sh myProgram.txt
```

program.txt will be saved to programs folder as programs/myProgram.txt

## Values

### raw data

just data typed with raw long value 

```console
JMP 0
```

jump to line 0 (creates infinite loop)

### register

8 registers age given to manipulate data

```console
MOV R0 1
JMP R0
```

set register 0 data to 1

jump to line from register 0 (1)

same infinite loop

### memmory

Stack has size of 50 values (of 8 bytes) and is shared between function calls and user values

user values start from 0 and up

call stack starts from last value and goes down

```console
MOV [0] 1
MOV R0 1
MOV [R0] 1
```

set memmory at location 0 to value 1

set register 1 to value 1

set memmory at location from register 1 to value 1 

memmory will look like this [ 1 1 0 0 0 ... 0]


## Functions

programs are compiled to use functions as text feature

functiond start with underline

```console
_infinite_loop
JMP _infinite_loop
```

compiler will change _infinite_loop to its line value (0) and remove non command lines

result will be

```console
JMP 0
```

same infinite loop

## Commands list

| Command| Format       | Description                                                                                    |
| ------ | ------------ | ---------------------------------------------------------------------------------------------- |
| MOV    | MOV V1 V2    | moves data from V1 to V2                                                                       |
| NOP    | NOP          | do nothing                                                                                     |
| DTL    | DTL V1       | converts data inside V1 from double to long                                                    |
| LTD    | LTD V1       | converts data inside V1 from long to double                                                    |
| CALL   | CALL V1      | calls a function, adds current line number to stack and sets command counter to V1             |
| RET    | RET          | function return, sets command counter to last value in stack and removes last value from stack |
| JE     | JE V1 V2 V3  | if V2 == V3 sets command counter to V1                                                         |
| JG     | JG V1 V2 V3  | if V2 > V3 sets command counter to V1                                                          |
| JGE    | JGE V1 V2 V3 | if V2 >= V3 sets command counter to V1                                                         |
| JMP    | JMP V1       | sets command counter to V1                                                                     |
| JNE    | JNE V1 V2 V3 | if V2 != V3 sets command counter to V1                                                         |
| JNZ    | JNZ V1 V2    | if V2 != 0 sets command counter to V1                                                          |
| JZ     | JZ V1 V2     | if V2 != 0 sets command counter to V1                                                          |
| AND    | AND V1 V2    | sets V1 value to Bitwise AND of V1 and V2 ( V1 = V1 & V2 )                                     |
| OR     | OR V1 V2     | sets V1 value to Bitwise OR of V1 and V2 ( V1 = V1 OR V2 )                                     |
| XOR    | XOR V1 V2    | sets V1 value to Bitwise XOR of V1 and V2 ( V1 = V1 ^ V2 )                                     |
| ADD    | ADD V1 V2    | sets V1 value to long sum of V1 and V2 ( V1 = V1L + V2L )                                      |
| SUB    | SUB V1 V2    | sets V1 value to long subtraction of V1 and V2 ( V1 = V1L - V2L )                              |
| MUL    | MUL V1 V2    | sets V1 value to long multiplication of V1 and V2 ( V1 = V1L * V2L )                           |
| DIV    | DIV V1 V2    | sets V1 value to long division of V1 and V2 ( V1 = V1L / V2L )                                 |
| DADD   | DADD V1 V2   | sets V1 value to double sum of V1 and V2 ( V1 = V1D + V2D )                                    |
| DSUB   | DSUB V1 V2   | sets V1 value to double subtraction of V1 and V2 ( V1 = V1D - V2D )                            |
| DMUL   | DMUL V1 V2   | sets V1 value to double multiplication of V1 and V2 ( V1 = V1D * V2D )                         |
| DDIV   | DDIV V1 V2   | sets V1 value to double division of V1 and V2 ( V1 = V1D / V2D )                               |
| SHL    | SHL V1 V2    | sets V1 value to shift of bits inside V1 on V2 bits to the left  ( V1 = V1 << V2 )             |
| SHR    | SHR V1 V2    | sets V1 value to shift of bits inside V1 on V2 bits to the right  ( V1 = V1 >> V2 )            |
| IN     | IN V1        | reads value from console input and saves it to V1                                              |
| OUT    | OUT V1       | prints data in V1                                                                              |

## Examples
- [fibonachi](https://github.com/vistemur/processorEmulator/blob/master/programs/fibonachi.txt)
- [bubble sort](https://github.com/vistemur/processorEmulator/blob/master/programs/sort.txt)
