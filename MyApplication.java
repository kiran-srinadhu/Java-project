import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyApplication extends JFrame implements ActionListener, Runnable {
    private JButton startButton, stopButton;
    private JTextArea textArea;
    private Thread thread;

    public MyApplication() {
        super("My Application");
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        textArea = new JTextArea();

   
        setLayout(new BorderLayout());
        add(startButton, BorderLayout.NORTH);
        add(stopButton, BorderLayout.SOUTH);
        add(new JScrollPane(textArea), BorderLayout.CENTER);


        startButton.addActionListener(this);
        stopButton.addActionListener(this);

  
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
          
            thread = new Thread(this);
            thread.start();
        } else if (e.getSource() == stopButton) {
         
            thread.interrupt();
        }
    }

  
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
            
                textArea.append("good morning ma'am....\n");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
         
            textArea.append("Interrupted!\n");
        }
    }

    public static void main(String[] args) {
        try {
            new MyApplication();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error has occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
