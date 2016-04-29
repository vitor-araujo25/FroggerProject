import java.util.HashSet;

public class Jogo {

    static Cor verde = new Cor("verde");
    Sapo sapo;
    Carro[] carros;
    static int score = 0;
    static int vidas = 3;
    /*
        carros 0 e 1: larg = 100, v = 5s, lin = 1
        carros 2: larg = 150, v = 2s, lin = 2
        carros 3, 4 e 5: larg = 60, v = 8s, lin = 3
        carros 6, 7 e 8: larg = 60, v = 6s, lin = 4
    */


    public Jogo(){
        sapo = new Sapo(400.0,550.0,0.6,1.0,verde);
        carros = new Carro[9];
        carros[0] = new Carro(0.0,100.0,100,5.0);
        carros[1] = new Carro(200.0,100.0,100,5.0);
        carros[2] = new Carro(0.0,200.0,150,2.0);
        carros[3] = new Carro(0.0,300.0,60,8.0);
        carros[4] = new Carro(160.0,300.0,60,8.0);
        carros[5] = new Carro(320.0,300.0,60,8.0);
        carros[6] = new Carro(0.0,400.0,60,6.0);
        carros[7] = new Carro(160.0,400.0,60,6.0);
        carros[8] = new Carro(320.0,400.0,60,6.0);

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
	
	public void tique(HashSet<String> teclas, double dt){
        for(Carro i: carros){
            i.mover(dt,getLargura());
        }
    }
	
	public void desenhar(Tela tela){
        tela.retangulo(0,500,this.getLargura(),100,new Cor(244,164,96));
        tela.retangulo(0,0,this.getLargura(),100,new Cor(244,164,96));
        tela.texto(Integer.toString(vidas),700,575,50,new Cor("azul"));
        tela.texto(Integer.toString(score),60,575,50,new Cor("azul"));
        sapo.desenhar(tela);
        for(int i = 0; i < this.carros.length; i++){
            carros[i].desenhar(tela);
        }
    }
	
	public void tecla(String tecla){
        sapo.mover(tecla);
    }
	
    public static void main(String[] args) {

        new Motor(new Jogo());

    }
}
