package exemplo5.itens;

import exemplo5.Jogador;
import exemplo5.itens.Item;
import java.awt.Color;

public class MacaVenenosa extends Item {

  public MacaVenenosa(){
    super(Color.red);
  }

  public void encontrou(Jogador j) {
    //Se o �tem n�o est� ativo, n�o faz nada.
    if(this.isActive()){
      //jogador fica pirado.
      j.inverteDirecao();
      this.setActive(false);
    }
  }

}
