package org.dario.game2048;
public abstract class Step {

   private int x;
   private int y;

   public int getX() {
      return x;
   }

   public int getY() {
      return y;
   }

   public Step(int x, int y) {
      this.x = x;
      this.y = y;
   }

   public abstract int nextX();

   public abstract int nextY();

   public abstract boolean isFirstPosition();

   public abstract Step nextStep();

}
