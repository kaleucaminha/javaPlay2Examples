package Exemplo4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javaPlay.GameEngine;
import javaPlay.GameObject;
import javaPlay.Keyboard;

public class Jogador extends GameObject {

  private int velocidade = 5; //pixels por itera��o
  
  public Jogador(){
    //O Construtor inicia o jogador em uma posi��o fixa
    this.x = 50;
    this.y = 50;
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
    g.setColor(Color.white);
    g.fillOval(this.x, this.y, 20, 20);
  }

  public boolean temColisao(Rectangle r2){
    return this.getRectangle().intersects(r2);
  }

  public Rectangle getRectangle(){
		return new Rectangle(this.x, this.y, 20, 20);
	}

  public void diminuiVelocidade(){
    this.velocidade--;
  }

  public void aumentaVelocidade(){
    this.velocidade++;
  }


}
