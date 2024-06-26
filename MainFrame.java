import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainFrame extends JFrame {

    Calendar calendar;
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    String time;
    String date;
    String day;

    MainFrame() {
        // instantiating
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Clock Program");
        this.setLayout(new BorderLayout());
        this.setSize(500, 500);
        this.setResizable(false);

        // formatting for day, date and time
        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("E");
        dateFormat = new SimpleDateFormat("MMMMM dd, yyyy");

        // Create a new JLabel to display the time
        // Set the font of the timeLabel to "Verdana", plain style, and size 50
        // Set the text color (foreground) of the timeLabel to green (hex: 0x00FF00)
        // Set the background color of the timeLabel to black
        // Make the background color visible by setting the label to opaque
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 50));
        timeLabel.setForeground(new Color(0x00FF00));
        timeLabel.setBackground(Color.black);
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Create a new JLabel to display the day
        // Set the font of the dayLabel to "Ink Free", plain style, and size 35
        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Ink Free", Font.PLAIN, 35));
        dayLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Create a new JLabel to display the date
        // Set the font of the dateLabel to "Ink Free", plain style, and size 25
        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Ink Free", Font.PLAIN, 25));
        dateLabel.setHorizontalAlignment(SwingConstants.CENTER);

        time = timeFormat.format(Calendar.getInstance().getTime());
        timeLabel.setText(time);

        JPanel datePanel = new JPanel();
        datePanel.setLayout(new GridLayout(2, 1));
        datePanel.add(dayLabel);
        datePanel.add(dateLabel);

        this.add(timeLabel, BorderLayout.CENTER);
        this.add(datePanel, BorderLayout.SOUTH);
        this.setVisible(true);

        setTime();
    }

    public void setTime() {
        while (true) {
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);

            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


