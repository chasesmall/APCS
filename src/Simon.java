import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Simon extends JFrame implements ActionListener {

    ArrayList<Integer> pattern = new ArrayList<>();
    ArrayList<Integer> guess = new ArrayList<>();
    int score = 1;
    private static int number = 0;
    JLabel sboard;
    JLabel color;
    JButton redb;
    JButton blueb;
    JButton yellowb;
    JButton greenb;

    boolean done = false;

    Simon() {
        super("Visual Learner Type Test");
        setSize(1280, 720);
//        setExtendedState(JFrame.MAXIMIZED_BOTH);  //create JFrame
        requestFocus();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridBagLayout());    //create JPanel with GridBagLayout
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(15, 15, 15, 15);

        JLabel title = new JLabel("Visual Learner Type Test", SwingConstants.CENTER); //create JComponents
        title.setBackground(Color.cyan);
        title.setOpaque(true);
        title.setFont(new Font("Arial", Font.BOLD, 30));

        color = new JLabel();
        color.setBackground(Color.gray);
        color.setOpaque(true);
        color.setFont(new Font("Arial", Font.ITALIC, 30));

        redb = new JButton("Red");
        redb.setBackground(Color.red);
        redb.setOpaque(true);
        redb.setFont(new Font("Arial", Font.PLAIN, 30));

        blueb = new JButton("Blue");
        blueb.setBackground(Color.blue);
        blueb.setOpaque(true);
        blueb.setFont(new Font("Arial", Font.PLAIN, 30));

        greenb = new JButton("Green");
        greenb.setBackground(Color.green);
        greenb.setOpaque(true);
        greenb.setFont(new Font("Arial", Font.PLAIN, 30));

        yellowb = new JButton("Yellow");
        yellowb.setBackground(Color.yellow);
        yellowb.setOpaque(true);
        yellowb.setFont(new Font("Arial", Font.PLAIN, 30));

        sboard = new JLabel(String.valueOf(score), SwingConstants.CENTER);
        sboard.setBackground(Color.gray);
        sboard.setOpaque(true);
        sboard.setFont(new Font("Arial", Font.BOLD, 30));

        c.fill = GridBagConstraints.BOTH; //Add JComponents
        c.weightx = 0.5;
        c.gridy = 2;
        c.gridx = 0;
        add(redb, c);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.gridy = 2;
        c.gridx = 1;
        add(blueb, c);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.gridy = 2;
        c.gridx = 2;
        add(yellowb, c);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.gridy = 2;
        c.gridx = 3;
        add(greenb, c);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.ipady = 500;
        c.gridy = 1;
        c.gridx = 0;
        c.gridwidth = 4;
        add(color, c);
        c.ipady = 0;
        c.gridy = 0;
        c.gridx = 0;
        c.gridwidth = 4;
        add(title, c);
        c.gridy = 1;
        c.gridx = 5;
        c.gridwidth = 1;
        c.ipady = 40;
        add(sboard, c);

        redb.setActionCommand("1");
        blueb.setActionCommand("2");
        yellowb.setActionCommand("3");
        greenb.setActionCommand("4");

        setVisible(true);

        doGuess();

    }

    public void gameOver() {
        done = true;
        Dimension dem = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dem.width / 2 - 250, dem.height / 2 - 250);
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel end = new JPanel();
        JLabel done = new JLabel("You scored: " + String.valueOf(score), SwingConstants.CENTER);
        end.add(done);
        add(end);
    }

    public void sleep(long time) {
        try {
            Thread.sleep(time * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doGuess() {
        action(false);
        guess.clear();
        number++;
        pattern.add((int) (Math.random() * 4) + 1);

        sboard.setText(String.valueOf(number));

        //display pattern\\
        Color newColor;
        for (Integer k : pattern) {
            color.setBackground(Color.GRAY);
            color.setOpaque(true);
            switch (k) {
                case 1:
                    newColor = Color.red;
                    break;
                case 2:
                    newColor = Color.blue;
                    break;
                case 3:
                    newColor = Color.yellow;
                    break;
                default:
                    newColor = Color.green;
                    break;
            }
            sleep(1);

            color.setBackground(newColor);
            color.setOpaque(true);
            color.repaint();
            this.repaint();
            setVisible(true);
            System.out.println("showing " + newColor.toString());

            sleep(1);

            color.setBackground(Color.GRAY);
            color.setOpaque(true);
            color.repaint();
            this.repaint();
            setVisible(true);

            System.out.println("back in black");
        }

        action(true);
    }

    public boolean isMatch() {    //test to see if guess is accurate
        if (guess.size() == 0) return false;
        return pattern.equals(guess);
    }


    public static void main(String[] args) {
        new Simon();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Runnable r = () -> {
            System.out.println("BUTTON: " + e.getActionCommand());
            guess.add(Integer.parseInt(e.getActionCommand()));
            if (guess.size() == number && !isMatch()) {
                gameOver();
                return;
            }
            doGuess();
        };
        Thread t = new Thread(r);
        t.start();
    }
    
    public void action(boolean b) {
        if (b) {
            redb.addActionListener(this);
            blueb.addActionListener(this);
            yellowb.addActionListener(this);
            greenb.addActionListener(this);
        } else {
            redb.removeActionListener(this);
            blueb.removeActionListener(this);
            yellowb.removeActionListener(this);
            greenb.removeActionListener(this);
        }
    }
}

