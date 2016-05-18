import java.util.HashSet;

/**
 * Created by vitor on 27/04/16.
 */
public class Sapo {
    double x;
    double y;
    double dest_x;
    double dest_y;
    Cor cor;
    static int raio = 45;
    Hitbox hb;
    double offset = (((double) raio * Math.sqrt(2)) / 2.0);

    public Sapo(double x, double y, Cor cor) {
        this.x = x;
        this.y = y;
        this.cor = cor;
        hb = new Hitbox(x-offset-5, y-offset, x+offset+5, y+offset);
        dest_x = x;
        dest_y = y;
    }

    public void desenhar(Tela t) {
        t.circulo(this.x, this.y, raio, this.cor);
    }

    public void defDirecao(String tecla) {
        if(y == dest_y && x == dest_x){
            if (tecla.equals("up") || tecla.equals("w") || tecla.equals("acima")) {
                dest_y -= 100;
            } else if (tecla.equals("left") || tecla.equals("a") || tecla.equals("esquerda")) {
                dest_x -= 100;
            } else if (tecla.equals("right") || tecla.equals("d") || tecla.equals("direita")) {
                dest_x += 100;
            } else if (tecla.equals("down") || tecla.equals("s") || tecla.equals("abaixo")) {
                dest_y += 100;
            }
        }

    }

    public void mover(double dt, int largTela, int altTela) {
        if (dest_y < altTela && dest_y > 0.0) {
            if (x < dest_x) {
                x += 300 * dt;
                if (x > dest_x) {
                    x = dest_x;
                }
            } else if (x > dest_x) {
                x -= 300 * dt;
                if (x < dest_x) {
                    x = dest_x;
                }
            } else if (y < dest_y) {
                y += 300 * dt;
                if (y > dest_y) {
                    y = dest_y;
                }
            } else if (y > dest_y) {
                y -= 300 * dt;
                if (y < dest_y) {
                    y = dest_y;
                }
            }
            if (x < 0.0) {
                x = (double) largTela;
                dest_x = (double) largTela - 100.0;
            }
            if (x > largTela) {
                x = 0.0;
                dest_x = 100.0;
            }
        }else{
            dest_y = y;
        }
        if (y <= 60.0) {
            x = 400.0;
            y = 550.0;
            dest_y = y;
            dest_x = x;
            Jogo.score += 100;
        }
        hb.mover(x-offset-5, y-offset, x+offset+5, y+offset);
    }
}




