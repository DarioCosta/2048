package org.dario.game2048;
public class StepDown extends Step {

   public StepDown(int x, int y) {
      super(x, y);
   }

   @Override
   public int nextX() {
      return getX() + 1;
   }

   @Override
   public int nextY() {
      return getY();
   }

   @Override
   public boolean isFirstPosition() {
      return getX() == 3;
   }

   @Override
   public Step nextStep() {
      return new StepDown(nextX(), nextY());
   }

}
