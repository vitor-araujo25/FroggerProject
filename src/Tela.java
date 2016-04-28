import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * Tela para desenho.
 * 
 */
public class Tela
{
    Graphics g;
    
    public Tela(Graphics g) {
        this.g = g;
        g.setColor(Color.white);
    }
    
    public void triangulo(int x1, int y1,
            int x2, int y2, int x3, int y3, Cor cor) {
        g.setColor(new Color(cor.r, cor.g, cor.b));
        g.fillPolygon(new int[] { x1, x2, x3 },
                new int[] { y1, y2, y3 },
                3);
    }

    public void triangulo(double x1, double y1,
            double x2, double y2, double x3, double y3, Cor cor) {
        triangulo((int)Math.round(x1),
                  (int)Math.round(y1),
                  (int)Math.round(x2),
                  (int)Math.round(y2),
                  (int)Math.round(x3),
                  (int)Math.round(y3), cor);
    }
    
    public void circulo(int cx, int cy, int raio, Cor cor) {
        g.setColor(new Color(cor.r, cor.g, cor.b));
        g.fillOval(cx - raio, cy - raio, raio*2, raio*2);
    }

    public void circulo(double cx, double cy, int raio, Cor cor) {
        circulo((int)Math.round(cx),
                (int)Math.round(cy),
                raio, cor);
    }

    public void quadrado(int x, int y, int lado, Cor cor) {
        g.setColor(new Color(cor.r, cor.g, cor.b));
        g.fillRect(x, y, lado, lado);
    }

    public void quadrado(double x, double y, int lado, Cor cor) {
        quadrado((int)Math.round(x), (int)Math.round(y),
                lado, cor);
    }

    public void retangulo(int x, int y, int largura, int altura, Cor cor) {
        g.setColor(new Color(cor.r, cor.g, cor.b));
        g.fillRect(x, y, largura, altura);
    }

    public void retangulo(double x, double y, int largura, int altura, Cor cor) {
        retangulo((int)Math.round(x), (int)Math.round(y),
                   largura, altura, cor);
    }

    public void texto(String texto, int x, int y, int tamanho, Cor cor) {
        g.setColor(new Color(cor.r, cor.g, cor.b));
        g.setFont(new Font("Arial", Font.BOLD, tamanho));
        g.drawString(texto, x, y);
    }
    
    public void texto(String texto, double x, double y, int tamanho, Cor cor) {
        texto(texto, (int)Math.round(x), (int)Math.round(y), tamanho, cor);
    }
}
