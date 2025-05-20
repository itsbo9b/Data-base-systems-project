import javax.swing.*;
import java.awt.Color;
import helper_classes.*;

public class WindowBuilder {
  public static void main(String[] args) {

     JFrame frame = new JFrame("My Awesome Window");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(662, 358);
     JPanel panel = new JPanel();
     panel.setLayout(null);
     panel.setBackground(Color.decode("#1e1e1e"));

     JButton effff = new JButton("Click Me");
     effff.setBounds(266, 191, 106, 28);
     effff.setBackground(Color.decode("#2e2e2e"));
     effff.setForeground(Color.decode("#D9D9D9"));
     effff.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
     effff.setBorder(new RoundedBorder(4, Color.decode("#979797"), 1));
     effff.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(effff, Color.decode("#232323"), Color.decode("#2e2e2e"));
     panel.add(effff);

     JTextField element2 = new JTextField("");
     element2.setBounds(221, 101, 189, 21);
     element2.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
     element2.setBackground(Color.decode("#B2B2B2"));
     element2.setForeground(Color.decode("#656565"));
     element2.setBorder(new RoundedBorder(2, Color.decode("#979797"), 0));
     OnFocusEventHelper.setOnFocusText(element2, "Your Input!", Color.decode("#353535"),   Color.decode("#656565"));
     panel.add(element2);

     JTextField element3 = new JTextField("");
     element3.setBounds(221, 141, 190, 21);
     element3.setFont(CustomFontLoader.loadFont("./resources/fonts/Lato.ttf", 14));
     element3.setBackground(Color.decode("#B2B2B2"));
     element3.setForeground(Color.decode("#656565"));
     element3.setBorder(new RoundedBorder(2, Color.decode("#979797"), 0));
     OnFocusEventHelper.setOnFocusText(element3, "Your Input!", Color.decode("#353535"),   Color.decode("#656565"));
     panel.add(element3);

     frame.add(panel);
     frame.setVisible(true);

  }
}