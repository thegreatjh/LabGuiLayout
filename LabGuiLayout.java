package guiLayout;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Component;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Exercise for working with WindowBuilder to manipulate JFrame Components.
 * Creates a window with four numbered labels that switches the blue background
 * between labels with buttons.
 * 
 * @author Jason Hasleton
 *
 */
@SuppressWarnings("unused")
public class LabGuiLayout extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblOne = new JLabel();
	private JLabel lblTwo = new JLabel();
	private JLabel lblThree = new JLabel();
	private JLabel lblFour = new JLabel();
	private int blueBackground = 2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LabGuiLayout frame = new LabGuiLayout();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the frame.
	 */
	public LabGuiLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLabel lblTitleLabel = lblTitleLabel();
		contentPane.add(lblTitleLabel, BorderLayout.NORTH);

		JPanel controlPanel = controlPanel();
		contentPane.add(controlPanel, BorderLayout.WEST);

		JPanel mainPanel = mainPanel();
		contentPane.add(mainPanel, BorderLayout.CENTER);

		JLabel lblOne = lblOne();
		mainPanel.add(lblOne);

		JLabel lblTwo = lblTwo();
		mainPanel.add(lblTwo);

		JLabel lblThree = lblThree();
		mainPanel.add(lblThree);

		JLabel lblFour = lblFour();
		mainPanel.add(lblFour);
	}

	/**
	 * Creates the Right Button and performs moveRight when clicked.
	 */
	public JButton btnRightButton() {
		JButton btnRightButton = new JButton("==>");
		btnRightButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moveRight();
			}
		});
		return btnRightButton;
	}

	/**
	 * Creates the Left Button and performs moveLeft when clicked.
	 */
	public JButton btnLeftButton() {
		JButton btnLeftButton = new JButton("<==");
		btnLeftButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moveLeft();
			}
		});
		return btnLeftButton;
	}

	/**
	 * Creates the mainPanel.
	 */
	public JPanel mainPanel() {
		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainPanel.setLayout(new GridLayout(0, 4, 10, 0));
		return mainPanel;
	}

	/**
	 * Creates the controlPanel.
	 */
	public JPanel controlPanel() {
		JPanel controlPanel = new JPanel();
		controlPanel.setBorder(new EmptyBorder(10, 10, 30, 10));
		controlPanel.setLayout(new GridLayout(2, 2, 0, 2));

		JButton btnLeftButton = btnLeftButton();
		controlPanel.add(btnLeftButton);

		JButton btnRightButton = btnRightButton();
		controlPanel.add(btnRightButton);

		return controlPanel;
	}

	/**
	 * Creates a label Four.
	 */
	public JLabel lblFour() {
		lblFour = new JLabel("4");
		lblFour.setBackground(new Color(255, 255, 0));
		lblFour.setOpaque(true);
		lblFour.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblFour.setHorizontalAlignment(SwingConstants.CENTER);
		return lblFour;
	}

	/**
	 * Creates a label Three.
	 */
	public JLabel lblThree() {
		lblThree = new JLabel("3");
		lblThree.setBackground(new Color(255, 255, 0));
		lblThree.setOpaque(true);
		lblThree.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblThree.setHorizontalAlignment(SwingConstants.CENTER);
		return lblThree;
	}

	/**
	 * Creates a label Two.
	 */
	public JLabel lblTwo() {
		lblTwo = new JLabel("2");
		lblTwo.setBackground(new Color(100, 149, 237));
		lblTwo.setOpaque(true);
		lblTwo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTwo.setHorizontalAlignment(SwingConstants.CENTER);
		return lblTwo;
	}

	/**
	 * Creates a label One.
	 */
	public JLabel lblOne() {
		lblOne = new JLabel("1");
		lblOne.setOpaque(true);
		lblOne.setBackground(new Color(255, 255, 0));
		lblOne.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblOne.setHorizontalAlignment(SwingConstants.CENTER);
		System.out.println(lblOne.getBackground().getColorSpace());
		return lblOne;
	}

	/**
	 * Creates the Title Label.
	 */
	public JLabel lblTitleLabel() {
		JLabel lblTitleLabel = new JLabel("Demo Layout");
		lblTitleLabel.setBorder(new EmptyBorder(7, 0, 7, 0));
		lblTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		return lblTitleLabel;
	}

	/**
	 * Provides functionality for the right button.
	 */
	public void moveRight() {
		switch (blueBackground) {
		case 1:
			blueBackground++;
			lblOne.setBackground(new Color(255, 255, 0));
			lblTwo.setBackground(new Color(100, 149, 237));
			break;
		case 2:
			blueBackground++;
			lblTwo.setBackground(new Color(255, 255, 0));
			lblThree.setBackground(new Color(100, 149, 237));
			break;
		case 3:
			blueBackground++;
			lblThree.setBackground(new Color(255, 255, 0));
			lblFour.setBackground(new Color(100, 149, 237));
			break;
		case 4:
			blueBackground = 1;
			lblFour.setBackground(new Color(255, 255, 0));
			lblOne.setBackground(new Color(100, 149, 237));
			break;
		}
	}

	/**
	 * Provides functionality for the left button.
	 */
	public void moveLeft() {
		switch (blueBackground) {
		case 1:
			blueBackground = 4;
			lblOne.setBackground(new Color(255, 255, 0));
			lblFour.setBackground(new Color(100, 149, 237));
			break;
		case 2:
			blueBackground--;
			lblTwo.setBackground(new Color(255, 255, 0));
			lblOne.setBackground(new Color(100, 149, 237));
			break;
		case 3:
			blueBackground--;
			lblThree.setBackground(new Color(255, 255, 0));
			lblTwo.setBackground(new Color(100, 149, 237));
			break;
		case 4:
			blueBackground--;
			lblFour.setBackground(new Color(255, 255, 0));
			lblThree.setBackground(new Color(100, 149, 237));
			break;
		}
	}
}
