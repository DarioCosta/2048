package org.dario.game2048;
public class MoveLeft extends Move {

   public MoveLeft(Game game) {
      super(game);
   }

   // @Override
   // protected boolean playMove() {
   // boolean changed = false;
   // for (int i = 0; i < 4; i++) {
   // for (int j = 0; j < 4; j++) {
   // if (getGame().move(new StepLeft(i, j))) {
   // changed = true;
   // }
   // }
   // }
   // return changed;
   // }

   @Override
   protected boolean playMove() {
      boolean changed = false;
      for (int i = 0; i < 4; i++) {
         for (int j = 0; j < 4; j++) {
            if (getGame().pack(new StepLeft(i, j))) {
               changed = true;
            }
         }
      }
      for (int i = 0; i < 4; i++) {
         for (int j = 0; j < 4; j++) {
            if (getGame().addUp(new StepLeft(i, j))) {
               changed = true;
            }
         }
      }
      for (int i = 0; i < 4; i++) {
         for (int j = 0; j < 4; j++) {
            if (getGame().pack(new StepLeft(i, j))) {
               changed = true;
            }
         }
      }
      return changed;
   }

}
