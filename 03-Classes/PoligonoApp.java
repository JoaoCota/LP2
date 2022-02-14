public class PoligonoApp{
    public static void main (String[] args){
        Poligono p1 = new Poligono(7, 0.50000, 0.00000, 50, 50); //0.010<=propDoraio<=1
        p1.print();
    }
}

class Poligono{
    double propDoRaio, arredondamento;
    int x,y, cantos;
    Poligono(int cantos, double propDoRaio, double arredondamento, int x, int y){
        this.cantos = cantos;
        this.propDoRaio = propDoRaio;
        this.arredondamento = arredondamento;
        this.x = x;
        this.y = y;
    }
    void print(){
        System.out.format("Poligono com numero de canto (%d), proporcao do raio (%.3f), arredondamento (%.3f) na posicao (%d,%d).\n",
        this.cantos, this.propDoRaio, this.arredondamento, this.x, this.y);
    }
}