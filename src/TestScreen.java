import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class TestScreen {
    private JList list1;
    private JPanel panel1;
    private Image frameImage = new ImageIcon("indeks.jpg").getImage();
    public TestScreen(List<String> question, List<String> answers, List<String> rightAnswers)
    {
        DefaultListModel model = new DefaultListModel();

        for(int i=0;i<question.size();i++)
        {
            model.add(i,question.get(i)+ " "+ answers.get(i)+" "+"Poprawna odpowiedź:  "+rightAnswers.get(i));
        }
        list1 = new javax.swing.JList(model);

        JFrame frame = new JFrame("Pytania");
        frame.setIconImage(frameImage);
        frame.setContentPane(new JScrollPane(list1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(400,400);
    }
}
