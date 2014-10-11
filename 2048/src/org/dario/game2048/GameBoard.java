package org.dario.game2048;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameBoard extends JFrame implements ActionListener {

   /**
    * 
    */
   private static final long serialVersionUID = 1L;
   private JButton up, down, left, right;
   private JPanel grid = new JPanel(new GridLayout(4, 4, 5, 5));
   private Game game = new Game();

   public GameBoard() {
      super("2048");
      up = new JButton("^");
      down = new JButton("v");
      left = new JButton("<");
      right = new JButton(">");
      right.addActionListener(this);
      down.addActionListener(this);
      up.addActionListener(this);
      left.addActionListener(this);
      add(up, BorderLayout.NORTH);
      add(down, BorderLayout.SOUTH);
      add(left, BorderLayout.WEST);
      add(right, BorderLayout.EAST);
      for (int i = 0; i < 4; i++) {
         for (int j = 0; j < 4; j++) {
            grid.add(new BoardCell());
         }
      }
      add(grid);

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      refresh();
   }

   public static void main(String[] args) {
      GameBoard gb = new GameBoard();
      gb.pack();
      gb.setVisible(true);

   }

   @Override
   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == right) {
         game.moveRight();
      } else if (e.getSource() == down) {
         game.moveDown();
      } else if (e.getSource() == up) {
         game.moveUp();
      } else if (e.getSource() == left) {
         game.moveLeft();
      }
      refresh();
      if (game.isOver()) {
         JOptionPane.showMessageDialog(this, "Game Over");
         game = new Game();
         refresh();
      }
   }

   private void refresh() {
      int x = grid.getComponentCount();
      BoardCell cell = null;
      JLabel label = null;
      int value = 0;
      for (int i = 0; i < x; i++) {
         cell = (BoardCell) grid.getComponent(i);
         label = cell.getLabel();
         value = game.getValue(i / 4, i % 4);
         if (value == 0) {
            label.setText("");
            label.setBackground(Color.WHITE);
            cell.setBackground(Color.WHITE);
         } else {
            label.setText(Integer.toString(value));
            label.setFont(new Font("Arial", Font.BOLD, 40));
            cell.setBackground(new Color(255, 256 / value, 256 / value));
         }
      }
   }

   class BoardCell extends JPanel {
      /**
       * 
       */
      private static final long serialVersionUID = 1L;
      private JLabel label;

      public BoardCell() {
         label = new JLabel();
         add(label);
      }

      public JLabel getLabel() {
         return label;
      }

   }
}
