import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jfree.chart.ChartFactory;


public class MainWindow {
    private JPanel panel1;
    private JButton wczytajButton;
    private JTextField textField1;
    private JButton wczytajButton1;
    private JTextField textField2;
    private JButton sprawdźButton;
    private JButton wynikiButton;
    private JButton histogramButton;
    private JButton szablonOdpowiedziButton;
    private JButton button1;
    private JTextField textField3;
    private SolutionCard solutionCard = new SolutionCard();
    private KeyCard keyCard = new KeyCard();
    private Statistics statistics = new Statistics();
    private int maxPoint;
    private Image frameImage = new ImageIcon("indeks.jpg").getImage();
    public MainWindow()
    {
        JFrame frame = new JFrame("Aplikacja - testy");
        frame.setIconImage(frameImage);
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(600,600);
        wczytajButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                keyCard.readFromXmlFile(textField1.getText());
            }
        });
        wczytajButton1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                solutionCard.readKeyCard(textField2.getText());
            }
        });
        sprawdźButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                statistics.examine(keyCard.getRightAnswer(),solutionCard.getStudentsList(),maxPoint);
            }
        });
        histogramButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                DefaultCategoryDataset dcd = new DefaultCategoryDataset();
                for(int i =0;i<solutionCard.getStudentsList().size();i++)
                {
                    dcd.addValue(solutionCard.getStudentsList().get(i).getPoints(),"Punkty",solutionCard.getStudentsList().get(i).getName());
                }

                JFreeChart jchart = ChartFactory.createBarChart("Wyniki studentów","Student","Punkty",dcd,PlotOrientation.VERTICAL,true,true,false);
                CategoryPlot plot = jchart.getCategoryPlot();
                plot.setRangeGridlinePaint(Color.black);
                ChartFrame chartFrm = new ChartFrame("Wyniki studentów",jchart,true);
                chartFrm.setIconImage(frameImage);
                chartFrm.setVisible(true);
                chartFrm.setSize(500,400);
            }
        });
        wynikiButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new PerformanceScreen(solutionCard.getStudentsList());
            }
        });
        szablonOdpowiedziButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new TestScreen(keyCard.getQuestion(),keyCard.getAnswers(), keyCard.getRightAnswer());
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                maxPoint = Integer.parseInt(textField3.getText());
            }
        });

    }
}
