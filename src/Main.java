import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;



public class Main extends JFrame {

    private JPanel mainPanel;
    private JCanvasPanel canvas;
    int windowToleranceX;
    int windowToleranceY;
    private JPanel buttonPanel;
    private  JButton stopButton;


    private JButton refreshButton;
    private  JButton playButton;
    private  JButton startingPositionButton;
    private JComboBox boundary;

    static DataManager dm;
    Utility util;

    public Main(String title) {

        super(title);
        dm = new DataManager(600,500,10);


        util = new Utility(dm);
            windowToleranceX=9;
            windowToleranceY=31;


        //Buttons


        String[] startingText ={"Unchanging","Glider","Oscillator","Random"};
        boundary=new JComboBox(startingText);
        startingPositionButton=new JButton("Set Starting Position");
        playButton =new JButton("PLAY");
        stopButton=new JButton("STOP");

        refreshButton=new JButton("REFRESH");





        //ACtion Listener


        refreshButton.addActionListener(e -> {
            util.reset();
            canvas.repaint();
        });


        startingPositionButton.addActionListener(e -> {
            util.game(boundary.getSelectedItem().toString(),canvas.getGraphics(),dm.getStateCells());
        });






        //Add Buttons

        canvas = new JCanvasPanel(dm);

        buttonPanel = new JPanel();

        buttonPanel.add(boundary);
        buttonPanel.add(startingPositionButton);
        buttonPanel.add(refreshButton);
        buttonPanel.add(playButton);
        buttonPanel.add(stopButton);
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        buttonPanel.setLayout(new GridLayout(11, 1));

        mainPanel.add(BorderLayout.CENTER, canvas);
        mainPanel.add(BorderLayout.EAST, buttonPanel);

        //Else

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);

        this.setSize(new Dimension(700, 500));
        this.setLocationRelativeTo(null);


        //Animation
        AtomicBoolean state=new AtomicBoolean(false);
        final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(() -> {
           if(state.get())
               util.game2(dm, dm.getStateCells());

            canvas.repaint();

        }, 0, 100, TimeUnit.MILLISECONDS);

        playButton.addActionListener(e->{
            state.set(true);
        });

        stopButton.addActionListener(e->{
            state.set(false);
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                int x=e.getX()-windowToleranceX;
                int y=e.getY()-windowToleranceY;
                util.MouseMakeAlive(x,y,canvas.getGraphics());
                canvas.repaint();
            }
        });
    }

    public static void main(String[] args)  {

        Main mw = new Main("Modelowanie Dyskretne");
        mw.setVisible(true);



    }
}


