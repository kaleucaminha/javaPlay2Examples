package exemplo5;

import exemplo5.itens.Item;
import exemplo5.itens.MacaVenenosa;
import exemplo5.itens.MacaVerde;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javaPlay.GameStateController;
import javax.swing.JOptionPane;

public class Fase3 implements GameStateController {
  
  private Jogador jogador;
  private Inimigo inimigo1;
  private Inimigo inimigo2;
  private InimigoPerseguidor inimigoPerseguidor;
  private Chegada chegada;

  //Novidade
  //O poder do polimorfismo
  //Os dois tipos de ma��o s�o tambpem Itens,
  //Ent�o, posso armazen�-las todas no mesmo lugar.
  private ArrayList<Item> itens;

  public void load() {    
    this.jogador = new Jogador();

    this.inimigo1 = new Inimigo(200, 200);
    this.inimigo2 = new Inimigo(100, 400);
    
    this.inimigoPerseguidor = new InimigoPerseguidor();    
    this.chegada = new Chegada(750, 550);

    //Cria o array lista para os �tens
    this.itens = new ArrayList<Item>();
    //NOVIDADE -> Inicializa��o das ma��s
    //Vou utilizar um loop para gerar 40 �tens,
    //20 ma�as verdes e 20 vermelhas. O cen�rio vai ficar muito estranho
    for(int i = 0; i < 20; i++){
      this.itens.add( new MacaVerde() );
      this.itens.add( new MacaVenenosa() );
    }
    
  }

  public void step(long timeElapsed) {     
    this.jogador.step(timeElapsed);
    this.chegada.step(timeElapsed);   
    this.inimigo1.step(timeElapsed);
    this.inimigo2.step(timeElapsed);
    this.inimigoPerseguidor.persegue(this.jogador.getX(), this.jogador.getY());

    //NOVIDADE -> step dos �tens
    for(Item umItem : this.itens){
      umItem.step(timeElapsed);
    }

    //NOVIDADE -> verifica colis�o com os �tens
    this.verificaColisoesComItens();

    this.verificaColisoesComInimigos();

    if( this.jogador.temColisao( this.chegada.getRectangle() )){
      JOptionPane.showMessageDialog(null, "Voc� venceu, parab�ns.");
      System.exit(0);
    }

  }

  public void draw(Graphics g) {
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, 800, 600);

    this.chegada.draw(g);
    this.jogador.draw(g);

    this.inimigo1.draw(g);
    this.inimigo2.draw(g);
    this.inimigoPerseguidor.draw(g);

    //NOVIDADE -> desenha as ma��s
    for(Item item : this.itens){
      item.draw(g);
    }
  }
  
  public void start() { }
  public void unload() { }
  public void stop() {  }

  private void verificaColisoesComInimigos(){

    //Inimigo 1
    if(this.jogador.temColisao(this.inimigo1.getRectangle())){
        this.jogador.setX(50);
        this.jogador.setY(50);
    }

    //Inimigo 2
    if(this.jogador.temColisao(this.inimigo2.getRectangle())){
        this.jogador.setX(50);
        this.jogador.setY(50);
    }

    //Inimigo Perseguidor   
    if(this.jogador.temColisao(this.inimigoPerseguidor.getRectangle())){
      this.jogador.setX(50);
      this.jogador.setY(50);
    }
    
  }

  private void verificaColisoesComItens(){

    for(Item umItem : this.itens){
      if(this.jogador.temColisao(umItem.getRectangle())){
        //Essa � a grande m�gica.
        //Itens da lista que forem ma��s verdes executar�o um m�todo
        //Itens da lista que forem ma��s venenosas executar�o seu pr�prio m�todo para atrapalhar o jogador
        //SE voc� criar um novo �tem, bas inicializ�-lo l� no m�todo load, todos os demais c�digos ir�o trabalhar para voc�.
        umItem.encontrou(this.jogador);
      }
    }


  }

}
