package org.dario.game2048;
public class MoveUp extends Move {

   public MoveUp(Game game) {
      super(game);
   }

   // @Override
   // protected boolean playMove() {
   // boolean changed = false;
   // for (int i = 0; i < 4; i++) {
   // for (int j = 0; j < 4; j++) {
   // if (getGame().move(new StepUp(j, i))) {
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
            if (getGame().pack(new StepUp(j, i))) {
               changed = true;
            }
         }
      }
      for (int i = 0; i < 4; i++) {
         for (int j = 0; j < 4; j++) {
            if (getGame().addUp(new StepUp(j, i))) {
               changed = true;
            }
         }
      }
      for (int i = 0; i < 4; i++) {
         for (int j = 0; j < 4; j++) {
            if (getGame().pack(new StepUp(j, i))) {
               changed = true;
            }
         }
      }
      return changed;
   }

}
