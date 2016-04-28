/**
 * Created by vitor on 27/04/16.
 */
public class Sapo {
    double x;
    double y;
    double vx;
    double vy;
    Cor cor;
    int raio = 45;

    public Sapo(double _x, double _y, double _vx, double _vy, Cor _cor) {
        x = _x;
        y = _y;
        vx = _vx;
        vy = _vy;
        cor = _cor;
    }

    public void desenhar(Tela t) {
        t.circulo(this.x, this.y, this.raio, this.cor);
    }
}
