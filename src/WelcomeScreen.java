import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeScreen {
    private JPanel panel1;
    private JButton OKButton;
    private Image frameImage = new ImageIcon("indeks.jpg").getImage();
    public WelcomeScreen()
    {
        JFrame frame = new JFrame("Ekran powitalny");
        frame.setIconImage(frameImage);
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(400,200);

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                frame.setVisible(false);
            }
        });
    }


}
