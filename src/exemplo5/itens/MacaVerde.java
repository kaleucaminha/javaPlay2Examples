package exemplo5.itens;

import exemplo5.Jogador;
import exemplo5.itens.Item;
import java.awt.Color;

public class MacaVerde extends Item {

  public MacaVerde(){
    super(Color.green);
  }

  public void encontrou(Jogador j) {
    //Se o �tem n�o est� ativo, n�o faz nada.
    if(this.isActive()){
      j.endireitaDirecao();
      j.aumentaVelocidade();
      this.setActive(false);
    }
  }
  
}

