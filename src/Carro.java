/**
 * Created by vitor on 27/04/16.
 */

public class Carro {
    double x;
    double y;
    double vx;
    Cor cor = new Cor(Math.random(), Math.random(), Math.random());
    int larg;
    static int alt = 100;
    Hitbox hb;

    public Carro(double x, double y, int larg, double vx) {
        this.x = x;
        this.y = y;
        this.larg = larg;
        this.vx = vx;
        hb = new Hitbox(x,y,x+larg,y+alt);
    }

    public void desenhar(Tela t) {
        t.retangulo(x, y, larg, alt, cor);
    }

    public void mover(double dt, int largTela){
        x += largTela*(dt/vx);
        if(x > largTela){
            x = (-1)*(double)larg;
        }
    }
}
