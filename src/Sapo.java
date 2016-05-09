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
    double offset = (((double)raio*Math.sqrt(2))/2.0);

    public Sapo(double x, double y, Cor cor) {
        this.x = x;
        this.y = y;
        this.cor = cor;
        hb = new Hitbox(x-offset-5,y-offset,x+offset+5,y+offset);
    }

    public void desenhar(Tela t) {
        t.circulo(this.x, this.y, raio, this.cor);
    }

    public void mover(HashSet<String> teclas, int largTela, double dt) {
        if(teclas.contains("up") || teclas.contains("w") || teclas.contains("acima")){
//            y -= 300*dt;
        }else if(teclas.contains("left") || teclas.contains("a") || teclas.contains("esquerda")){
//            if(x > 0.0){
//                x -= 300*dt;
//            }else{
//                x = largTela + raio;
//            }
        }else if(teclas.contains("right") || teclas.contains("d") || teclas.contains("direita")){
//            if(x < largTela){
//                x += 300*dt;
//            }else{
//                x = -raio;
//            }
        }else if(teclas.contains("down") || teclas.contains("s") || teclas.contains("abaixo")){
//            if(y <= 550.0){
//                y += 300*dt;
//            }
        }
        System.out.println("X: "+x+", Y: "+y);
        hb.mover(x-offset-5,y-offset,x+offset+5,y+offset);
    }
}
