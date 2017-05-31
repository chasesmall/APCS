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

    ArrayList<Integer> pattern = new ArrayList<Integer>();
    ArrayList<Integer> guess = new ArrayList<Integer>();
    int score = 1;

    Simon() {
        super("Visual Learner Type Test");
        setExtendedState(JFrame.MAXIMIZED_BOTH);  //create JFrame
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());    //create JPanel with GridBagLayout
        getContentPane().add(panel);
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(15, 15, 15, 15);

        JLabel title = new JLabel("Visual Learner Type Test", SwingConstants.CENTER); //create JComponents
        title.setBackground(Color.cyan);
        title.setOpaque(true);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        JLabel color = new JLabel();
        color.setBackground(Color.gray);
        color.setOpaque(true);
        color.setFont(new Font("Arial", Font.ITALIC, 30));
        JButton redb = new JButton("Red");
        redb.setBackground(Color.red);
        redb.setOpaque(true);
        //redb.setBorderPainted(false);
        redb.setFont(new Font("Arial", Font.PLAIN, 30));
        JButton blueb = new JButton("Blue");
        blueb.setBackground(Color.blue);
        blueb.setOpaque(true);
        //blueb.setBorderPainted(false);
        blueb.setFont(new Font("Arial", Font.PLAIN, 30));
        JButton greenb = new JButton("Green");
        greenb.setBackground(Color.green);
        greenb.setOpaque(true);
        //greenb.setBorderPainted(false);
        greenb.setFont(new Font("Arial", Font.PLAIN, 30));
        JButton yellowb = new JButton("Yellow");
        yellowb.setBackground(Color.yellow);
        yellowb.setOpaque(true);
        //yellowb.setBorderPainted(false);
        yellowb.setFont(new Font("Arial", Font.PLAIN, 30));
        JLabel sboard = new JLabel(String.valueOf(score), SwingConstants.CENTER);
        sboard.setBackground(Color.gray);
        sboard.setOpaque(true);
        sboard.setFont(new Font("Arial", Font.BOLD, 30));


        c.fill = GridBagConstraints.BOTH; //Add JComponents
        c.weightx = 0.5;
        c.gridy = 2;
        c.gridx = 0;
        panel.add(redb, c);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.gridy = 2;
        c.gridx = 1;
        panel.add(blueb, c);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.gridy = 2;
        c.gridx = 2;
        panel.add(yellowb, c);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.gridy = 2;
        c.gridx = 3;
        panel.add(greenb, c);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.ipady = 500;
        c.gridy = 1;
        c.gridx = 0;
        c.gridwidth = 4;
        panel.add(color, c);
        c.ipady = 0;
        c.gridy = 0;
        c.gridx = 0;
        c.gridwidth = 4;
        panel.add(title, c);
        c.gridy = 1;
        c.gridx = 5;
        c.gridwidth = 1;
        c.ipady = 40;
        panel.add(sboard, c);


        do {
            guess.clear();
            int i = 0;
            i++;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            //creates pattern\\
            score = i;
            sboard.setText(String.valueOf(score));
            pattern.add(i - 1, (int) (Math.random() * 4) + 1);
            //display pattern\\
            for (int k = 0; k < i; k++) {
                color.setBackground(Color.GRAY);
                color.setOpaque(true);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                if (pattern.get(k) == 1) {
                    color.setBackground(Color.red);
                    color.setOpaque(true);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
                if (pattern.get(k) == 2) {
                    color.setBackground(Color.yellow);
                    color.setOpaque(true);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }

                }
                if (pattern.get(k) == 3) {
                    color.setBackground(Color.green);
                    color.setOpaque(true);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }

                }
                if (pattern.get(k) == 4) {
                    color.setBackground(Color.blue);
                    color.setOpaque(true);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }

                }

                color.setBackground(Color.GRAY);
                color.setOpaque(true);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                //take in guess\\ DOESNT GIVE TIME TO GUESS
                for (int q = 0; q < i; q++) {
                    int o = q;
                    redb.addActionListener(this);
                    redb.setActionCommand("1" + o);
                    
                    blueb.addActionListener(this);
                    blueb.setActionCommand("2" + o);
                    
                    yellowb.addActionListener(this);
                    yellowb.setActionCommand("3" + o);
                    
                    greenb.addActionListener(this);
                    greenb.setActionCommand("4" + o);
                }
            }
        } while (isMatch());
        
        Dimension dem = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dem.width / 2 - 250, dem.height / 2 - 250 );
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel end = new JPanel();
        JLabel done = new JLabel("You scored: " + String.valueOf(score), SwingConstants.CENTER);
        end.add(done);
        
    }

    public boolean isMatch() {    //test to see if guess is accurate
        if (guess.size() == 0) return false;
        for (int a = 0; a < pattern.size(); a++) {
            if (!pattern.get(a).equals(guess.get(a))) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        new Simon();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand().substring(0, 1);
        String o = e.getActionCommand().substring(1);
        System.out.println("BUTTON: " + button);
        System.out.println("O: " + o);
        guess.add(Integer.parseInt(o), Integer.parseInt(button));
    }
}

