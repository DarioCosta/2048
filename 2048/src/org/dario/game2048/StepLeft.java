package org.dario.game2048;
public class StepLeft extends Step {

   public StepLeft(int x, int y) {
      super(x, y);
   }

   @Override
   public int nextX() {
      return getX();
   }

   @Override
   public int nextY() {
      return getY() - 1;
   }

   @Override
   public boolean isFirstPosition() {
      return getY() == 0;
   }

   @Override
   public Step nextStep() {
      return new StepLeft(nextX(), nextY());
   }

}
