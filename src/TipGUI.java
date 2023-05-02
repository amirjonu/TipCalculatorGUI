import javax.swing.*;
import java.awt.event.*;
public class TipGUI extends JFrame implements ActionListener, KeyListener{
    private JPanel TipCalculator;
    private JButton plusForTipPer;
    private JButton PlusForPeople;
    private JLabel Bill;
    private JTextField BillArea;
    private JLabel TipName;
    private JTextArea TipArea;
    private JLabel NumPeopleName;
    private JTextArea NumPeopleArea;
    private JButton minusButtonForTipPer;
    private JButton minusbuttonforPeople;
    private JLabel TipOutput;
    private JTextArea TipOutputArea;
    private JLabel totalName;
    private JTextArea TotalOutputArea;
    private JButton calculate;


    private int tipVal=15;
    private int numPeople=1;


    public TipGUI(){
        createUIComponents();
    }

    private void createUIComponents() {
        setContentPane(TipCalculator);
        setTitle("Tip Calculator");
        setSize(700,400);
        setLocation(450,100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        plusForTipPer.addActionListener(this);
        PlusForPeople.addActionListener(this);
        minusButtonForTipPer.addActionListener(this);
        minusbuttonforPeople.addActionListener(this);
        calculate.addActionListener(this);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if (source instanceof JButton){
            JButton button = (JButton) source;
            String text = button.getText();

            if (text.equals("+")){
                tipVal++;
               TipArea.setText(""+tipVal);
            }else if (text.equals("-")){
                if (tipVal==0){
                    TipArea.setText(""+ tipVal);
                }else{
                    tipVal--;
                    TipArea.setText(""+ tipVal);
                }

            }
            else if (text.equals(".+.")){
                numPeople++;
                NumPeopleArea.setText(""+ numPeople);
            }
            else if (text.equals(".-.")){
                if (numPeople==0){
                    NumPeopleArea.setText(""+ numPeople);
                }else{
                    numPeople--;
                    NumPeopleArea.setText(""+ numPeople);
                }

            }else{
                TipCalculator s= new TipCalculator(Double.parseDouble(BillArea.getText()), tipVal, numPeople);
                TipOutputArea.setText(""+s.tipPerPerson());
                TotalOutputArea.setText(""+s.totalPerPerson());
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e){

    }

    @Override
    public void keyPressed(KeyEvent e){

    }

    @Override
    public void keyReleased(KeyEvent e){

    }


}
