package exemplo5;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javaPlay.GameEngine;
import javaPlay.GameObject;
import javaPlay.Keyboard;

public class Jogador extends GameObject {

  private int velocidade = 5; //pixels por itera��o
  private int diametro = 20;
  
  public Jogador(){
    //O Construtor inicia o jogador em uma posi��o fixa
    this.x = 50;
    this.y = 50;

    this.diametro = 20;
  }
  
  public void step(long timeElapsed) {
    //pega o objeto respons�vel pelo teclado
    Keyboard k = GameEngine.getInstance().getKeyboard();

    //Verifica se uma tecla direcional est� pressionado
    //Em caso positivo, altera a posi��o do jogador
    if(k.keyDown(Keyboard.DOWN_KEY)){
      this.y += this.velocidade;
    }
    if(k.keyDown(Keyboard.UP_KEY)){
      this.y -= this.velocidade;
    }
    if(k.keyDown(Keyboard.LEFT_KEY)){
      this.x -= this.velocidade;
    }
    if(k.keyDown(Keyboard.RIGHT_KEY)){
      this.x += this.velocidade;
    }
  }

  public void draw(Graphics g) {   
    //Desenha um c�rculo com a cor verde.
    g.setColor(Color.GREEN);
    g.fillOval(this.x, this.y, this.diametro, this.diametro);
  }

  public boolean temColisao(Rectangle r2){
    return this.getRectangle().intersects(r2);
  }

  public Rectangle getRectangle(){
		return new Rectangle(this.x, this.y, this.diametro, this.diametro);
	}

  //Novidade - M�todos para manipular os atributos do jogador

  public void aumentaVelocidade(){
    this.velocidade += 3;
  }

  public void diminuiVelocidade(){
    this.velocidade -= 3;
  }

  public void diminuiDiametro(){
    this.diametro -= 10;
  }

  public void aumentaDiametro(){
    this.diametro -= 10;
  }

  public void inverteDirecao(){
    this.velocidade *= -1;
  }

  public void endireitaDirecao(){
    //Se estiver negativo, muda para positivo.
    if(this.velocidade < 0){
      this.velocidade *= -1;
    }
  }
  
}
