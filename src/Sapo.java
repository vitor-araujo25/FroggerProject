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

    public Sapo(double x, double y, double vx, double vy, Cor cor) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.cor = cor;
    }

    public void desenhar(Tela t) {
        t.circulo(this.x, this.y, this.raio, this.cor);
    }

    public void mover(String tecla, int largTela, double dt){
        switch(tecla){
            case "up":
            case "w":
            case "acima":
                y -= largTela*(dt/vy);
                break;
            case "left":
            case "a":
            case "esquerda":
                x -= largTela*(dt/vx);
                break;
            case "right":
            case "d":
            case "direita":
                x += largTela*(dt/vx);
                break;
            case "down":
            case "s":
            case "abaixo":
                y += largTela*(dt/vy);
                break;
            default:
                break;
        }
    }
}
