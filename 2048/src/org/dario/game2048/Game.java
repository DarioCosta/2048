package org.dario.game2048;
public class Game {

   private int[][] data = new int[4][4];
   private Move[] moves = new Move[4];

   public static final int MOVE_LEFT = 0;
   public static final int MOVE_RIGHT = 1;
   public static final int MOVE_DOWN = 2;
   public static final int MOVE_UP = 3;

   public Game() {
      for (int i = 0; i < 4; i++) {
         for (int j = 0; j < 4; j++) {
            data[i][j] = 0;
         }
      }
      moves[MOVE_LEFT] = new MoveLeft(this);
      moves[MOVE_RIGHT] = new MoveRight(this);
      moves[MOVE_DOWN] = new MoveDown(this);
      moves[MOVE_UP] = new MoveUp(this);

      addNew();
      addNew();
   }

   public boolean addNew() {
      int n = 0;
      for (int i = 0; i < 4; i++) {
         for (int j = 0; j < 4; j++) {
            if (data[i][j] == 0) {
               n++;
            }
         }
      }
      if (n == 0) {
         return false;
      }
      int pos = ((int) (Math.random() * n)) + 1;
      int count = 0;
      for (int i = 0; i < 4; i++) {
         for (int j = 0; j < 4; j++) {
            if (data[i][j] == 0) {
               count++;
               if (count == pos) {
                  data[i][j] = 2;
                  break;
               }
            }
         }
      }
      return true;
   }

   private boolean canMove(int x, int y) {
      if (x > 0) {
         if (data[x][y] == data[x - 1][y]) {
            return true;
         }
      }
      if (x < data.length - 1) {
         if (data[x][y] == data[x + 1][y]) {
            return true;
         }
      }
      if (y > 0) {
         if (data[x][y] == data[x][y - 1]) {
            return true;
         }
      }
      if (y < data.length - 1) {
         if (data[x][y] == data[x][y + 1]) {
            return true;
         }
      }
      return false;
   }

   public boolean isOver() {
      for (int i = 0; i < data.length; i++) {
         for (int j = 0; j < data.length; j++) {
            if (data[i][j] == 0) {
               return false;
            } else {
               if (canMove(i, j)) {
                  return false;
               }
            }
         }
      }
      return true;
   }

   @Deprecated
   public void moveRight(int x, int y, int j, int k) {
      if (y == 3) {
         return;
      }
      if (data[x][y] == 0) {
         return;
      }
      if (data[j][k] == 0) {
         data[j][k] = data[x][y];
         data[x][y] = 0;
         moveRight(j, k, j, k + 1);
      } else {
         if (data[j][k] == data[x][y]) {
            data[j][k] *= 2;
            data[x][y] = 0;
         }
      }
   }

   public void move(int[] line) {
      int[] newLine = new int[line.length];
      for (int i = 0; i < newLine.length; i++) {
         newLine[i] = 0;
      }
      int j = 0;
      for (int i = 0; i < line.length - 1; i++) {
         if (line[i] == 0) {
            // do nothing
         } else {
            if (line[i] == line[i + 1]) {
               newLine[j] = line[i] * 2;
               line[i + 1] = 0;
               j++;
            } else {
               newLine[j] = line[i];
               j++;
            }
         }
      }
   }

   protected boolean move(Step m) {
      int x = m.getX();
      int y = m.getY();
      int j = m.nextX();
      int k = m.nextY();

      if (m.isFirstPosition()) {
         return false;
      }
      if (data[x][y] == 0) {
         return false;
      }
      if (data[j][k] == 0) {
         data[j][k] = data[x][y];
         data[x][y] = 0;
         move(m.nextStep());
         return true;
      } else {
         if (data[j][k] == data[x][y]) {
            data[j][k] *= 2;
            data[x][y] = 0;
            return true;
         } else {
            return false;
         }
      }
   }

   protected boolean pack(Step m) {
      int x = m.getX();
      int y = m.getY();
      int j = m.nextX();
      int k = m.nextY();

      if (m.isFirstPosition()) {
         return false;
      }
      if (data[x][y] == 0) {
         return false;
      }
      if (data[j][k] == 0) {
         data[j][k] = data[x][y];
         data[x][y] = 0;
         pack(m.nextStep());
         return true;
      } else {
         return false;
      }
   }

   protected boolean addUp(Step m) {
      int x = m.getX();
      int y = m.getY();
      int j = m.nextX();
      int k = m.nextY();

      if (m.isFirstPosition()) {
         return false;
      }
      if (data[x][y] == 0) {
         return false;
      }
      if (data[j][k] != 0) {
         if (data[j][k] == data[x][y]) {
            data[j][k] *= 2;
            data[x][y] = 0;
            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   private void play(int i) {
      moves[i].play();
   }

   public void moveLeft() {
      play(MOVE_LEFT);
   }

   public void moveRight() {
      play(MOVE_RIGHT);
   }

   public void moveDown() {
      play(MOVE_DOWN);
   }

   public void moveUp() {
      play(MOVE_UP);
   }

   public int getValue(int x, int y) {
      return data[x][y];
   }
}
