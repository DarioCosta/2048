package org.dario.game2048;
public class MoveRight extends Move {

   public MoveRight(Game game) {
      super(game);
   }

   // @Override
   // protected boolean playMove() {
   // boolean changed = false;
   // for (int i = 0; i < 4; i++) {
   // for (int j = 3; j >= 0; j--) {
   // if (getGame().move(new StepRight(i, j))) {
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
            if (getGame().pack(new StepRight(i, j))) {
               changed = true;
            }
         }
      }
      for (int i = 0; i < 4; i++) {
         for (int j = 3; j >= 0; j--) {
            if (getGame().addUp(new StepRight(i, j))) {
               changed = true;
            }
         }
      }
      for (int i = 0; i < 4; i++) {
         for (int j = 3; j >= 0; j--) {
            if (getGame().pack(new StepRight(i, j))) {
               changed = true;
            }
         }
      }
      return changed;
   }

}
