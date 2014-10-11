package org.dario.game2048;
public class MoveDown extends Move {

   public MoveDown(Game game) {
      super(game);
   }

   // @Override
   // protected boolean playMove() {
   // boolean changed = false;
   // for (int i = 0; i < 4; i++) {
   // for (int j = 3; j >= 0; j--) {
   // if (getGame().move(new StepDown(j, i))) {
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
         for (int j = 3; j >= 0; j--) {
            if (getGame().pack(new StepDown(j, i))) {
               changed = true;
            }
         }
      }
      for (int i = 0; i < 4; i++) {
         for (int j = 3; j >= 0; j--) {
            if (getGame().addUp(new StepDown(j, i))) {
               changed = true;
            }
         }
      }
      for (int i = 0; i < 4; i++) {
         for (int j = 3; j >= 0; j--) {
            if (getGame().pack(new StepDown(j, i))) {
               changed = true;
            }
         }
      }
      return changed;
   }

}
