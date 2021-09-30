import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class pizzaUIFrame extends JFrame
{
	private static final int FRAME_WIDTH = 300;
	   private static final int FRAME_HEIGHT = 400;

	   private JLabel label;
	   private JTextArea bill;
	   private JCheckBox exCheeseCheckBox;
	   private JCheckBox baconCheckBox;
	   private JCheckBox mushCheckBox;
	   private JRadioButton cheeseButton;
	   private JRadioButton pepButton;
	   private JRadioButton veggiButton;
	   private JComboBox facenameCombo;
   private ActionListener listener;


   public pizzaUIFrame()
     {

  	      JPanel choicePanel = new JPanel();
          choicePanel.setLayout(new BorderLayout());


         // create five buttons
         JPanel pizza = createPizzaButtons();
         JPanel toping = createTopingsBoxes();
         label = new JLabel("Joe's Pizza");
         JButton calcButton = new JButton("Calculate Total");
         bill = new JTextArea(20,10);
         JPanel centerpanel = new JPanel();
         centerpanel.add(pizza);
         centerpanel.add(toping);

          ActionListener  listener = new ChoiceListener();


          calcButton.addActionListener(listener);

         // add five buttons to the content pane of JApplet object
         choicePanel.add(centerpanel, BorderLayout.CENTER);
         choicePanel.add(label, BorderLayout.NORTH);
         choicePanel.add(calcButton, BorderLayout.SOUTH);
         //choicePanel.add(toping, BorderLayout.WEST);
         choicePanel.add(bill, BorderLayout.EAST);


       add(choicePanel);

      final int FRAME_WIDTH = 600;
  	final int FRAME_HEIGHT = 200;
  	setSize(FRAME_WIDTH, FRAME_HEIGHT);
  	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

   public JPanel createPizzaButtons()
   {
      cheeseButton = new JRadioButton("Cheese");
      cheeseButton.addActionListener(listener);

      pepButton = new JRadioButton("Pepperoni");
      pepButton.addActionListener(listener);

      veggiButton = new JRadioButton("Veggi");
      veggiButton.addActionListener(listener);
      veggiButton.setSelected(true);

      // Add radio buttons to button group

      ButtonGroup group = new ButtonGroup();
      group.add(cheeseButton);
      group.add(pepButton);
      group.add(veggiButton);

      JPanel panel = new JPanel();
      panel.setLayout(new GridLayout(3,1));
      panel.add(cheeseButton);
      panel.add(pepButton);
      panel.add(veggiButton);
      panel.setBorder(new TitledBorder(new EtchedBorder(), "Pizza Type"));
      panel.setSize(50,200);

      return panel;
   }

    public JPanel createTopingsBoxes()
      {
         exCheeseCheckBox = new JCheckBox("ExtraCheese");
         exCheeseCheckBox.addActionListener(listener);

         baconCheckBox = new JCheckBox("Bacon");
         baconCheckBox.addActionListener(listener);

         mushCheckBox = new JCheckBox("Mushroom");
         mushCheckBox.addActionListener(listener);

         JPanel panel = new JPanel();
         panel.setLayout(new GridLayout(3,1));
         panel.add(exCheeseCheckBox);
         panel.add(baconCheckBox);
         panel.add(mushCheckBox);
         panel.setBorder(new TitledBorder(new EtchedBorder(), "Toppings"));

         return panel;
      }

      public void calculateBill()
      {
		     int top=0;
		     double pizza=0;

			 final double CHEESE=10.00, PEPPERONI=12, VEGGI=15.00;
		     final double TOPPING=1.50;

		        if (exCheeseCheckBox.isSelected())
		        {
		           top++;
		        }
		        if (baconCheckBox.isSelected())
		        {
		          top++;
		        }
		        if (mushCheckBox.isSelected())
			    {
				   top++;
		        }


		        if (cheeseButton.isSelected()) { pizza = CHEESE; }
		        else if (pepButton.isSelected()) { pizza =PEPPERONI; }
		        else if (veggiButton.isSelected()) { pizza = VEGGI; }

		        // Set font of text field

		        /*label.setFont(new Font(facename, style, size));
		        label.repaint();*/
				String billAmount="$";


		        pizza += top*TOPPING;
		        billAmount +=pizza;
		        bill.setText(billAmount);

	  }


   class ChoiceListener implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         calculateBill();
      }
   }




}