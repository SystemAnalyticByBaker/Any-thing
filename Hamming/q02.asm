section .data
    vet : dw 16385, -32767, 8
    vetL : equ $ - vet
    
    msg01 : db "Erro de capacidade para DW", 10
    msgln : equ $ - msg01 

section .bss
    prod : resw vetL
    
section .text
    global _start
    
_start:
   
    xor rax, rax
    xor rdx, rdx
    
    mov r13, vetL
    shr r13, 1
    
    xor r12, r12
    
    mov r15, 0x1
    
mut:
    xor rdx, rdx
    mov r14w, [vet + 2*rcx]
    imul r15, r14
s:
    inc rcx 
    cmp rcx, r13
    jl mut
    
    mov r12, r15
    shr r12, 32
    cmp r12, 0x0
	jne erro
	cmp r15d, 0
	jl neg
	cmp r15d, 0x7FFFFFFF
	jg erro
	jmp cont
neg:
	cmp r15d, 0x8FFFFFFF
	jg erro
cont:
    mov [prod], r15d
    jmp _fim
    
erro:
	mov [prod], r15d
	mov rax, 1
	mov rdi, 1
	lea rsi, [msg01]
	mov edx, msgln
	syscall

_fim:
    mov rax, 60
    mov rdi, 0
    syscall
    
