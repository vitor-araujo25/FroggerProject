import java.util.HashSet;

public class Jogo {

    static Cor verde = new Cor("verde");
    Sapo sapo;
    Carro[] carros;
    static int score = 0;
    static int vidas = 5;
    static boolean pause = false;
    static boolean gameOver = false;
    /*
        carros 0 e 1: larg = 100, v = 5s, lin = 1 (topo)
        carros 2: larg = 150, v = 2s, lin = 2
        carros 3, 4 e 5: larg = 60, v = 8s, lin = 3
        carros 6, 7 e 8: larg = 60, v = 6s, lin = 4 (baixo)
    */


    public Jogo(){
        sapo = new Sapo(400.0,550.0,verde);
        carros = new Carro[9];
        carros[0] = new Carro(0.0,100.0,100,5.0);
        carros[1] = new Carro(250.0,100.0,100,5.0);
        carros[2] = new Carro(0.0,200.0,150,2.0);
        carros[3] = new Carro(0.0,300.0,60,8.0);
        carros[4] = new Carro(210.0,300.0,60,8.0);
        carros[5] = new Carro(420.0,300.0,60,8.0);
        carros[6] = new Carro(0.0,400.0,60,6.0);
        carros[7] = new Carro(210.0,400.0,60,6.0);
        carros[8] = new Carro(420.0,400.0,60,6.0);

    }

    public String getTitulo() {
	    return "Frogger";
	}
	
	public int getLargura() {
	    return 800;
	}
	
	public int getAltura() {
	    return 600;
	}
	
	public void tique(HashSet<String> teclas, double dt) {
        if (!pause) {
            for (Carro i : carros) {
                i.mover(dt, getLargura());
            }
            if (!gameOver) {
                sapo.mover(dt, getLargura(), getAltura());
                for (Carro i : carros) {
                    if (i.hb.intersecao(sapo.hb) > 0) {
                        sapo.x = 400.0;
                        sapo.y = 550.0;
                        sapo.dest_x = sapo.x;
                        sapo.dest_y = sapo.y;
                        vidas--;
                    }
                }
                if (vidas == 0 && !gameOver) {
                    gameOver = !gameOver;
                    sapo.mover(dt, getLargura(), getAltura());
                }
            }

        }
    }
	
	public void desenhar(Tela tela){
        tela.retangulo(0,500,getLargura(),100,new Cor(244,164,96));
        tela.retangulo(0,0,getLargura(),100,new Cor(244,164,96));
        tela.texto("Vidas: "+Integer.toString(vidas),620,65,30,new Cor("azul"));
        tela.texto("Pts: "+Integer.toString(score),60,65,30,new Cor("azul"));

        for(Carro car: carros) {
            car.desenhar(tela);
        //    tela.retangulo(car.x,car.y,car.larg,Carro.alt,new Cor("branco")); //teste hitbox
        }
        if(pause){
            tela.texto("PAUSE",280,280,70,new Cor("branco"));
        }
        if(!gameOver){
            sapo.desenhar(tela);
            tela.texto("Pressione \"P\" para pausar",280,30,20,new Cor("preto"));
        }else{
            tela.texto("GAME OVER",190,320,70,new Cor("branco"));
            tela.texto("Pressione \"espaço\" para jogar novamente",200,30,20,new Cor("preto"));
        }
    //    tela.retangulo(sapo.hb.x0,sapo.hb.y0,(int)(sapo.hb.x1-sapo.hb.x0),
     //           (int)(sapo.hb.y1-sapo.hb.y0),new Cor("branco")); //teste hitbox
    }
	
	public void tecla(String tecla){
        if(!pause){
            sapo.defDirecao(tecla);
        }
        if(tecla.equals("p")){
            pause = !pause;
        }
        System.out.println(tecla);
        if(gameOver){
            if(tecla.equals("space") || tecla.equals("espaço")){
                gameOver = !gameOver;
                vidas = 5;
                score = 0;
            }
        }
    }
	
    public static void main(String[] args) {

        new Motor(new Jogo());

    }
}
