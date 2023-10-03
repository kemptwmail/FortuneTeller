import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class FortuneTellerFrame extends JFrame
{
    JPanel mainPnl = new JPanel();
    JPanel iconPnl;
    JPanel displayPnl;
    JPanel controlPnl;
    JLabel iconLbl;

    JLabel labelFTI;
    ImageIcon FTIcon;

    JScrollPane scroller;
    JTextArea fortuneTA;

    JButton quitBtn;
    JButton fortuneBtn;

    private int lastFortuneIndex = -1;

    ArrayList<String> diffFortunes = new ArrayList<>();

    public FortuneTellerFrame()
    {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());
        add(mainPnl);

        iconPnl = new JPanel();
        iconPnl.setLayout(new BoxLayout(iconPnl, BoxLayout.PAGE_AXIS));

        iconLbl = new JLabel("Fortune Teller",SwingConstants.CENTER);
        Font font = new Font("Arial",Font.PLAIN, 36);
        iconLbl.setFont(font);
        iconPnl.add(iconLbl);
        FTIcon = new ImageIcon("FortuneTellerIMG.jpg");
        Image FTI = FTIcon.getImage();
        Image scaledFTI = FTI.getScaledInstance(150,150,Image.SCALE_SMOOTH);
        FTIcon = new ImageIcon(scaledFTI);
        labelFTI = new JLabel(FTIcon,SwingConstants.CENTER);
        iconPnl.add(labelFTI);

        iconLbl.setVerticalAlignment(SwingConstants.NORTH);
        iconLbl.setHorizontalTextPosition(SwingConstants.CENTER);
        iconPnl.add(iconLbl);

        labelFTI.setVerticalAlignment(SwingConstants.NORTH);
        labelFTI.setHorizontalAlignment(SwingConstants.CENTER);

        displayPnl = new JPanel();
        displayPnl.setLayout(new BorderLayout());

        fortuneTA = new JTextArea(10,10);
        scroller = new JScrollPane(fortuneTA);
        fortuneTA.setEditable(false);
        fortuneTA.setFont(new Font("Open Sans",Font.PLAIN,16));
        displayPnl.add(scroller);


        controlPnl = new JPanel();
        controlPnl.setLayout( new FlowLayout());


        fortuneBtn = new JButton("Read My Fortune!");
        quitBtn = new JButton("Quit");

        controlPnl.add(fortuneBtn);
        controlPnl.add(quitBtn);

        add(iconPnl, BorderLayout.NORTH);
        add(displayPnl, BorderLayout.CENTER);
        add(controlPnl, BorderLayout.SOUTH);

        diffFortunes.add("Fortune 1: You will find 5 dollars today.");
        diffFortunes.add("Fortune 2: You will see someone from your past in the near future.");
        diffFortunes.add("Fortune 3: Today you will find your soulmate.");
        diffFortunes.add("Fortune 4: Tonight you will see a ghost.");
        diffFortunes.add("Fortune 5: When you wake up you will be surrounded by pancakes.");
        diffFortunes.add("Fortune 6: Tomorrow you will meet a new best friend.");
        diffFortunes.add("Fortune 7: Today you will find a four-leaf clover.");
        diffFortunes.add("Fortune 8: This evening you will find a pot of gold.");
        diffFortunes.add("Fortune 9: Tomorrow a wizard will visit you.");
        diffFortunes.add("Fortune 10: Today you will travel back in time.");
        diffFortunes.add("Fortune 11: You will grow wings in the near future.");
        diffFortunes.add("Fortune 12: Tonight a fair will give you magical powers.");

        fortuneBtn.addActionListener(e -> getFortune());
        quitBtn.addActionListener(e -> System.exit(0));

        pack();
        centerFrameOnScreen();
    }
    private void centerFrameOnScreen()
    {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenDim = toolkit.getScreenSize();
        int width = (int) (screenDim.getWidth() * 0.75);
        int height = (int) (screenDim.getHeight() * 0.75);
        setSize(width,height);
        setLocationRelativeTo(null);

    }
    private void getFortune()
    {
        int newIndex;
        do
        {
            newIndex = new Random().nextInt(diffFortunes.size());
        }
        while (newIndex == lastFortuneIndex);

        String fortune = diffFortunes.get(newIndex);
        fortuneTA.append(fortune + "\n");
        lastFortuneIndex = newIndex;
    }

}
