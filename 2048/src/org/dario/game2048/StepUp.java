package org.dario.game2048;
public class StepUp extends Step {

   public StepUp(int x, int y) {
      super(x, y);
   }

   @Override
   public int nextX() {
      return getX() - 1;
   }

   @Override
   public int nextY() {
      return getY();
   }

   @Override
   public boolean isFirstPosition() {
      return getX() == 0;
   }

   @Override
   public Step nextStep() {
      return new StepUp(nextX(), nextY());
   }

}
