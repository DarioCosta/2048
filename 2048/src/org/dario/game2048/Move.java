package org.dario.game2048;
public abstract class Move {

   private Game game;

   public Move(Game game) {
      this.game = game;
   }

   protected Game getGame() {
      return game;
   }

   protected abstract boolean playMove();

   public void play() {
      if (playMove()) {
         getGame().addNew();
      }

   }
}
