package package1;

import javax.swing.*;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.plaf.FontUIResource;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**********************************************************************
 * GUI class for the asteroid sets up the JPanel and JFrame for the
 * asteroid game and calls on player and asteroid to instantiate the
 * new objects.
 * Created by tyleranson on 2/15/16.
 *********************************************************************/
public class GUI extends JPanel implements ActionListener {

    private JPanel gameContainer;
    private CardLayout screens;
    Vector position = new Vector();

    private JFrame gameFrame;

    /** menuBar object**/
    private JMenuBar menuBar;
    private JMenu File;
    private JMenuItem restart, exit;

    // title screen
    private JPanel titleScreen;
    private JLabel astroyd;
    private JButton startButton, optionsButton, exitButton;

    // start screen
    private JPanel startScreen;
    private JButton modeButton, backButton;

    // mode selection screen
    private JPanel modeScreen;
    private JButton timeAttackButton, survivalButton, insaneButton;

    //time attack screen
    private JPanel timeAttackScreen;

    //dimension of buttons
    private final Dimension D = new Dimension (200 , 100);




    /******************************************************************
     * GUI constructor (default)  instantiates a new asteroid and a
     * player
     ******************************************************************/
    public GUI() {



        //initialize main screen
        screens = new CardLayout();
        gameContainer = new JPanel();

        buttons();
        screenViews();
        menu();

        //Frame
        gameFrame = new JFrame();
        gameFrame.setTitle("ASTROYED");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setMinimumSize(new Dimension(1200, 900));
        gameFrame.setMaximumSize(new Dimension(1200, 900));

        //Game Screens
        gameContainer.setLayout(screens);
        gameContainer.add(titleScreen, "title");
        gameContainer.add(startScreen, "start");
        gameContainer.add(modeScreen, "mode");
        gameContainer.add(timeAttackScreen, "time");

        //Pack
        gameFrame.add(gameContainer);
        gameFrame.setJMenuBar(menuBar);
        gameFrame.pack();
        gameFrame.setVisible(true);

    }

    public void menu(){

        //Menu
        File = new JMenu("File");
        restart = new JMenuItem("New");
        exit = new JMenuItem("Exit");
        menuBar = new JMenuBar();
        menuBar.add(File);
        File.add(restart);
        File.add(exit);
        restart.addActionListener(this);
        exit.addActionListener(this);
    }

    public void buttons(){

//        Insets r = new Insets(40,50,60,70);

        //title screen buttons
        startButton = new JButton("START");
        startButton.addActionListener(this);
        startButton.setPreferredSize(D);
        startButton.setBorder(
                BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.black, 15),
                    BorderFactory.createLineBorder(Color.cyan, 5)));
        startButton.setBackground(Color.red);
        startButton.setFocusPainted(false);
        startButton.setForeground(Color.blue);
        startButton.setFocusable(true);
        startButton.setContentAreaFilled(true);
//        startButton.setMargin(r);


        optionsButton = new JButton("OPTIONS");
        optionsButton.addActionListener(this);
        optionsButton.setPreferredSize(D);
        optionsButton.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.black, 15),
                        BorderFactory.createLineBorder(Color.cyan, 5)));
        optionsButton.setBackground(Color.red);
        optionsButton.setFocusPainted(true);
        optionsButton.setForeground(Color.blue);
        optionsButton.setFocusable(true);

        exitButton = new JButton("EXIT");
        exitButton.addActionListener(this);
        exitButton.setPreferredSize(D);
        exitButton.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.black, 15),
                        BorderFactory.createLineBorder(Color.cyan, 5)));
        exitButton.setBackground(Color.red);
        exitButton.setFocusPainted(true);
        exitButton.setForeground(Color.blue);
        exitButton.setFocusable(true);

        //start screen buttons
        modeButton = new JButton("MODE");
        modeButton.addActionListener(this);
        modeButton.setPreferredSize(D);
        modeButton.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.black, 15),
                        BorderFactory.createLineBorder(Color.cyan, 5)));
        modeButton.setBackground(Color.red);
        modeButton.setFocusPainted(true);
        modeButton.setForeground(Color.blue);
        modeButton.setFocusable(true);

        backButton = new JButton("BACK");
        backButton.addActionListener(this);
        backButton.setPreferredSize(D);
        backButton.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.black, 15),
                        BorderFactory.createLineBorder(Color.cyan, 5)));
        backButton.setBackground(Color.red);
        backButton.setFocusPainted(true);
        backButton.setForeground(Color.blue);
        backButton.setFocusable(true);

        //mode screen buttons
        timeAttackButton = new JButton("TIME ATTACK");
        timeAttackButton.addActionListener(this);
        timeAttackButton.setPreferredSize(D);
        timeAttackButton.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.black, 15),
                        BorderFactory.createLineBorder(Color.cyan, 5)));
        timeAttackButton.setBackground(Color.red);
        timeAttackButton.setFocusPainted(true);
        timeAttackButton.setForeground(Color.blue);
        timeAttackButton.setFocusable(true);

        survivalButton = new JButton("SURVIVAL");
        survivalButton.addActionListener(this);
        survivalButton.setPreferredSize(D);
        survivalButton.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.black, 15),
                        BorderFactory.createLineBorder(Color.cyan, 5)));
        survivalButton.setBackground(Color.red);
        survivalButton.setFocusPainted(true);
        survivalButton.setForeground(Color.blue);
        survivalButton.setFocusable(true);

        insaneButton = new JButton("INSANE-O");
        insaneButton.addActionListener(this);
        insaneButton.setPreferredSize(D);
        insaneButton.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.black, 15),
                        BorderFactory.createLineBorder(Color.cyan, 5)));
        insaneButton.setBackground(Color.red);
        insaneButton.setFocusPainted(true);
        insaneButton.setForeground(Color.blue);
        insaneButton.setFocusable(true);
    }

    public void screenViews(){

        //GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 20;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.CENTER;
//        gbc.weighty = 1;
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridy = 50;
        gbc1.gridx = 0;
        gbc1.anchor = GridBagConstraints.CENTER;
//        gbc1.weighty = 1;
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridy = 80;
        gbc2.gridx = 0;
        gbc2.anchor = GridBagConstraints.CENTER;
//        gbc2.weighty = 1;
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.anchor = GridBagConstraints.NORTH;
//        gbc3.gridx = 0;
//        gbc3.gridx = 0;
//        gbc3.weighty = 0;



        //title screen view
        titleScreen = new JPanel(new GridBagLayout());
        titleScreen.setBackground(Color.black);

        astroyd  = new JLabel();
        astroyd.setText("ASTROYED");
        astroyd.setFont(new Font("Serif", 5 , 60));
        astroyd.setSize(200,200);
        astroyd.setForeground(Color.red);

        titleScreen.add(astroyd);
        titleScreen.add(startButton, gbc);
        titleScreen.add(optionsButton, gbc1);
        titleScreen.add(exitButton, gbc2);


        //start screen view
        startScreen = new JPanel(new GridBagLayout());
        startScreen.setBackground(Color.black);
        startScreen.add(modeButton, gbc);
        startScreen.add(backButton, gbc1);

        //mode screen view
        modeScreen = new JPanel(new GridBagLayout());
        modeScreen.setBackground(Color.BLACK);
        modeScreen.add(timeAttackButton, gbc);
        modeScreen.add(survivalButton, gbc1);
        modeScreen.add(insaneButton, gbc2);

        //time attack screen view
        timeAttackScreen = new JPanel(new BorderLayout());
        Player s = new Player();
        Asteroid a = new Asteroid();
//        Entity e = new Entity() {
//            @Override
//            public void handleCollision(Game game, Entity other) {
//
//            }
//
//            @Override
//            public void draw(Graphics2D g, Game game) {
//
//            }
//        };
        timeAttackScreen.add(a);
    }
    /******************************************************************
     * main method of the GUI that makes an instance of the GUI
     * @param args
     *****************************************************************/
    public static void main(String args[])  {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        GUI g = new GUI();
    }


    /******************************************************************
     *
     * @param e
     *****************************************************************/
    @Override
    public void actionPerformed(ActionEvent e){

        Object clickTarget = e.getSource();

        if(exit == clickTarget){
            System.exit(0);
        }
        if(startButton == clickTarget){
            screens.show(gameContainer, "start");
        }
        if(exitButton == clickTarget){
            System.exit(0);
        }
        if(modeButton == clickTarget){
            screens.show(gameContainer, "mode");
        }
        if(backButton == clickTarget){
            screens.show(gameContainer, "title");
        }
        if(timeAttackButton == clickTarget){
            screens.show(gameContainer, "time");
        }
        if(restart == clickTarget){
            screens.show(gameContainer, "title");
        }
    }
}
