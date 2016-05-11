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
        dest_x = x;
        dest_y = y;
    }

    public void desenhar(Tela t) {
        t.circulo(this.x, this.y, raio, this.cor);
    }

    public void defDirecao(String tecla) {
        if(tecla.equals("up") || tecla.equals("w") || tecla.equals("acima")){
            dest_y -= 100;
        }else if(tecla.equals("left") || tecla.equals("a") || tecla.equals("esquerda")){
            dest_x -= 100;
        }else if(tecla.equals("right") || tecla.equals("d") || tecla.equals("direita")){
            dest_x += 100;
        }else if(tecla.equals("down") || tecla.equals("s") || tecla.equals("abaixo")){
            dest_y += 100;
        }
//        System.out.println("DX: "+dest_x+", DY: "+dest_y);
//        System.out.println("X: "+x+", Y: "+y);

    }

    public void mover(double dt ,int alt, int larg){
        if(x < dest_x){
            x += 300*dt;
            if(x > dest_x){
                x = dest_x;
            }
        }
        if(x > dest_x){
            x -= 300*dt;
            if(x < dest_x){
                x = dest_x;
            }
        }
        if(y < dest_y){
            y += 300*dt;
            if(y > dest_y){
                y = dest_y;
            }
        }
        if(y > dest_y){
            y -= 300*dt;
            if(y < dest_y){
                y = dest_y;
            }
        }
        if(y <= 50.0){
            x = 400.0;
            y = 550.0;
            dest_y = y;
            dest_x = x;
            Jogo.score += 100;
        }
        hb.mover(x-offset-5,y-offset,x+offset+5,y+offset);
    }
}
