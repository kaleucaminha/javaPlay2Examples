package exemplo1;
//Importa��o do Java
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
//Importa��o do javaPlay
import javaPlay.GameEngine;
import javaPlay.GameStateController;
import javaPlay.Keyboard;

/**
 * Executa as opera��es essenciais de um jogo como inicializa��o, rodada e desenho
 * para a fase 1.
 */
public class Fase1Controle implements GameStateController {

  Bola jogador;
  BolaQuatroDirecoes jogador2;
  

  // Carrega todos os objetos e recursos que ser�o necess�rios para o jogo
  public void load() {
    this.jogador = new Bola();
    this.jogador2 = new BolaQuatroDirecoes();
  }

  //M�todo executado a cada itera��o do jogo.
  public void step(long timeElapsed) {

    Keyboard k = GameEngine.getInstance().getKeyboard();
    if (k.keyDown(Keyboard.RIGHT_KEY)) {
      jogador.aumentaVelocidadeHorizontal();
    }
    if (k.keyDown(Keyboard.LEFT_KEY)) {
      jogador.diminuiVelocidadeHorizontal();
    }
    if (k.keyDown(Keyboard.SPACE_KEY)) {
      jogador.mudaCor();
    }
    if (k.keyDown(KeyEvent.VK_P)) {
      jogador.para();
    }
    
    
    if (k.keyDown(KeyEvent.VK_D)) {
      jogador2.aumentaVelocidadeHorizontal();
    }
    if (k.keyDown(KeyEvent.VK_A)) {
      jogador2.diminuiVelocidadeHorizontal();
    }
    if (k.keyDown(KeyEvent.VK_S)) {
      jogador2.aumentaVelocidadeVertical();
    }
    if (k.keyDown(KeyEvent.VK_W)) {
      jogador2.diminuiVelocidadeVertical();
    }

    jogador.step(timeElapsed);
    jogador2.step(timeElapsed);
  }

  //Realiza o desenho desta fase e dos seus respectivos objetos.
  public void draw(Graphics g) {
    g.setColor(Color.white);
    g.fillRect(0, 0, 800, 600);

    jogador.draw(g);
    jogador2.draw(g);
  }

  //Para refer�ncia sobre os m�todos abaixo consulte o ap�ndice D do livro.
  public void unload() {
  }

  public void start() {
  }

  public void stop() {
  }
}
