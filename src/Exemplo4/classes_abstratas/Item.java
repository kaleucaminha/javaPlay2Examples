package Exemplo4.classes_abstratas;

import Exemplo4.Jogador;
import Exemplo4.classes_abstratas.Inimigo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
import javaPlay.GameObject;

public abstract class Item extends GameObject {

  //Informa se o �tem ainda est� ativo
  private boolean active;
  //Informa o tamanho do quadrado do �tem
  private int lado;
  //Define a cor do �tem
  private Color cor;

  public Item(Color cor){
    this.cor = cor;
    this.lado = 20;
    this.active = true;

    //Sorteia posi��o aleat�ria para o �tem
    Random sorteador = new Random();
    this.x = sorteador.nextInt(780);
    this.y = sorteador.nextInt(580);
  }

  /**
   * M�todo que deve ser executado quando um jogador
   * encontrar um determninado �tem na fase
   */
  public abstract void encontrou(Jogador j);

  /**
   * M�todo que deve ser executado quando um inimigo
   * encontrar um determninado �tem na fase
   */
  public abstract void encontrou(Inimigo i);

  

  public void step(long timeElapsed) {
    //De tempos em tempos, reaparece em outro lugar
    Random sorteador = new Random();
    if(sorteador.nextInt(1000) == 200){
      this.x = sorteador.nextInt(780);
      this.y = sorteador.nextInt(580);
      this.setActive(true);
    }
  }

  public void draw(Graphics g) {
    if(this.isActive()){
      g.setColor(this.cor);
      g.fillRect(this.x, this.y, this.lado, this.lado);
    }
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean isActive) {
    this.active = isActive;
  }

  public Rectangle getRectangle(){
    return new Rectangle(this.x, this.y, this.lado, this.lado);
  }

}
