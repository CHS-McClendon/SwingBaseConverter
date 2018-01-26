// SwingConverter.java
class SwingConverter implements java.awt.event.ActionListener
{

  private javax.swing.JPanel inputPanel = initInputPanel();
  private javax.swing.JTextField inputText;
  private javax.swing.JTextArea resultArea;
  private javax.swing.JButton enterButton;

  public javax.swing.JPanel initInputPanel()
  {
    javax.swing.JPanel panel=new javax.swing.JPanel();

    panel.setPreferredSize(new java.awt.Dimension(800,480));
    panel.setLayout(null);

    javax.swing.JLabel label = new javax.swing.JLabel("Enter a base-10 number: ");
    label.setBounds(50,50,220,30);
    panel.add(label);

    javax.swing.JTextField text;
    text = inputText = new javax.swing.JTextField();
    text.setBounds(230,50,100,30);
    panel.add(text);

    javax.swing.JButton button = new javax.swing.JButton("Enter");
    button.setActionCommand("Enter");
    button.setBounds(340,50,80,30);
    button.addActionListener(this);
    panel.add(button);
    enterButton = button;   // save a global copy

    button = new javax.swing.JButton("Reset");
    button.setActionCommand("Reset");
    button.setBounds(430,50,80,30);
    button.addActionListener(this);
    panel.add(button);

    resultArea = new javax.swing.JTextArea(); 
    resultArea.setBounds(50,180,500,200);
    resultArea.setEditable(false);
resultArea.setBackground(java.awt.Color.CYAN);
    panel.add(resultArea);

    return panel;
  }  

  public SwingConverter()
  {
    javax.swing.JFrame window = new javax.swing.JFrame("Base Converter");
    window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
    
    window.add(inputPanel);
    window.pack();
    window.setVisible(true);
  }

  private Integer getInputNumber()
  {
    try {
      Integer n = Integer.parseInt(inputText.getText());
      return n;
    }
    catch (Exception e)
    {
      return null;
    }
  }

  private void showResult()
  {
    inputText.setEnabled(false);
    enterButton.setEnabled(false);
    
    Integer n=getInputNumber();
    if (n==null)
    {
      resultArea.append("Invalid number !");     
      return;
    }

    int decimal = n.intValue();
    resultArea.append("dec = "+decimal+"\n");
    resultArea.append("bin = "+Integer.toString(decimal,2)+"\n");
    resultArea.append("oct = "+Integer.toString(decimal,8)+"\n");
    resultArea.append("hex = "+Integer.toString(decimal,16)+"\n");

  }

  public void actionPerformed(java.awt.event.ActionEvent ev)
  {
    String command=ev.getActionCommand();
    if (command.equals("Enter"))
    {
      showResult();    
    }
    else if (command.equals("Reset"))
    {
      inputText.setText("");
      resultArea.setText("");
      inputText.setEnabled(true);
      enterButton.setEnabled(true);
      inputText.requestFocus();
    }
  }

  public static void main(String[] args) throws Exception
  {
    new SwingConverter();
  }
}