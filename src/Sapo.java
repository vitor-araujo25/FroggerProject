import java.util.HashSet;

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
    Hitbox hb;

    public Sapo(double x, double y, double vx, double vy, Cor cor) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.cor = cor;
//        hb = new Hitbox();
    }

    public void desenhar(Tela t) {
        t.circulo(this.x, this.y, this.raio, this.cor);
    }

    public void mover(HashSet<String> teclas, int largTela, double dt) {
        if(teclas.contains("up") || teclas.contains("w") || teclas.contains("acima")){
            y -= largTela * (dt / vy);
        }else if(teclas.contains("left") || teclas.contains("a") || teclas.contains("esquerda")){
            if(x > 0.0){
                x -= largTela * (dt / vx);
            }else{
                x = largTela + raio;
            }
        }else if(teclas.contains("right") || teclas.contains("d") || teclas.contains("direita")){
            if(x < largTela){
                x += largTela * (dt / vx);
            }else{
                x = -raio;
            }
        }else if(teclas.contains("down") || teclas.contains("s") || teclas.contains("abaixo")){
            if(y <= 550.0){
                y += largTela * (dt / vy);
            }
        }
        System.out.println("X: "+x+", Y: "+y);
//            switch (tecla) {
//                case "up":
//                case "w":
//                case "acima":
//                    y -= largTela * (dt / vy);
//                    break;
//                case "left":
//                case "a":
//                case "esquerda":
//                    if(x > 60.0){
//                        x -= largTela * (dt / vx);
//                    }
//                    break;
//                case "right":
//                case "d":
//                case "direita":
//                    if(x < 740.0){
//                        x += largTela * (dt / vx);
//                    }
//                    break;
//                case "down":
//                case "s":
//                case "abaixo":
//                    if(y < 540.0){
//                        y += largTela * (dt / vy);
//                    }
//                    break;
//                default:
//                    break;
//            }
    }
}
