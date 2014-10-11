package org.dario.game2048;
public class StepRight extends Step {

   public StepRight(int x, int y) {
      super(x, y);
   }

   @Override
   public int nextX() {
      return getX();
   }

   @Override
   public int nextY() {
      return getY() + 1;
   }

   @Override
   public boolean isFirstPosition() {
      return getY() == 3;
   }

   @Override
   public Step nextStep() {
      return new StepRight(nextX(), nextY());
   }

}
