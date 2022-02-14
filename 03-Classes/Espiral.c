#include <stdio.h>

typedef struct {
	float voltas, diverg, raioInt;
	int x,y;
}Espiral;

void print(Espiral* e){
	printf("Espiral com numero de voltas (%.2f), divergencia (%.3f) e raio interno (%.3f) na posicao (%d,%d).\n", e->voltas, e->diverg, e->raioInt,e->x, e->y);
}

void main(void){
	Espiral e1 = {3.20000, 1.02000, 0.60000, 50,50}; //0<=raioInt<=0.999
	print(&e1);
}