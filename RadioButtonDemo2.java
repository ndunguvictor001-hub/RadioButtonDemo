package radiobuttondemo2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class RadioButtonDemo2 extends JFrame implements ActionListener {

    private JRadioButton birdButton, catButton, dogButton, rabbitButton, pigButton;
    private JLabel imageLabel;
    private ButtonGroup group;

    public RadioButtonDemo2() {
        setTitle("RadioButtonDemo");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create radio buttons
        birdButton = new JRadioButton("Bird");
        catButton = new JRadioButton("Cat");
        dogButton = new JRadioButton("Dog");
        rabbitButton = new JRadioButton("Rabbit");
        pigButton = new JRadioButton("Pig");

        // Default selection, matching the required screenshot
        pigButton.setSelected(true);

        // Group them so only one can be selected
        group = new ButtonGroup();
        group.add(birdButton);
        group.add(catButton);
        group.add(dogButton);
        group.add(rabbitButton);
        group.add(pigButton);

        // Add listeners
        birdButton.addActionListener(this);
        catButton.addActionListener(this);
        dogButton.addActionListener(this);
        rabbitButton.addActionListener(this);
        pigButton.addActionListener(this);

        // Add to frame
        add(birdButton);
        add(catButton);
        add(dogButton);
        add(rabbitButton);
        add(pigButton);

        // Image label
        imageLabel = new JLabel();
        add(imageLabel);
        
        // Show the Pig image immediately on startup, since Pig is pre-selected
        setImageForPet("Pig");

        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String pet = e.getActionCommand();
        JOptionPane.showMessageDialog(this, "You selected: " + pet);
        setImageForPet(pet);
    }
    private void setImageForPet(String pet) {
        String fileName;
        switch (pet) {
            case "Bird":
                fileName = "/images/bird.png";
                break;
            case "Cat":
                fileName = "/images/cat.png";
                break;
            case "Dog":
                fileName = "/images/dog.png";
                break;
            case "Rabbit":
                fileName = "/images/rabbit.png";
                break;
            case "Pig":
                fileName = "/images/pig.png";
                break;
            default:
                imageLabel.setIcon(null);
                imageLabel.setText("Unknown selection!");
                JOptionPane.showMessageDialog(this, "Unknown selection!");
                return;
        }
        URL imgURL = getClass().getResource(fileName);
        if (imgURL != null) {
            imageLabel.setIcon(new ImageIcon(imgURL));
            imageLabel.setText(null);
        } else {
            imageLabel.setIcon(null);
            imageLabel.setText("Image not found: " + fileName);
            System.err.println("Could not find resource: " + fileName);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RadioButtonDemo2 frame = new RadioButtonDemo2();
            frame.setVisible(true);
        });
    }
}