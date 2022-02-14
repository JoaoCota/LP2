public class RectApp {
    public static void main (String[] args) {
        Rect r1 = new Rect(1,1, 10,10);
        r1.print();
        r1.area();
        r1.drag(3,3);
    }
}
class Rect {
    int x, y;
    int w, h;
    Rect (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    void area(){
        if(this.w<0 || this.h<0){
            System.out.format("Valor inserido invalido.\n");
        }
        else{
            System.out.format("A area da figura eh (%d).\n", this.w*this.h);
        }
    }

    void drag(int dx, int dy){
        if(this.w<0 || this.h<0){
            System.out.format("Valor inserido invalido.\n");
        }
        else{
            System.out.format("A figura foi arrastada para (%d,%d)\n", dx+this.x, dy+this.y);
        }
    }

    void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }
}