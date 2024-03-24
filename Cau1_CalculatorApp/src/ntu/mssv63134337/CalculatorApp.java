package ntu.mssv63134337;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.zip.CheckedInputStream;

public class CalculatorApp {

	private JFrame frame;
	private JTextField txtKQ;
	private JTextField txtPhepTinh;
	private double a, b;
	private boolean checked = true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorApp window = new CalculatorApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CalculatorApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(255, 255, 255));
		frame.getContentPane().setBackground(new Color(45, 45, 45));
		frame.getContentPane().setLayout(null);
		
		txtKQ = new JTextField();
		txtKQ.setHorizontalAlignment(SwingConstants.RIGHT);
		txtKQ.setForeground(new Color(255, 255, 255));
		txtKQ.setFont(new Font("Tahoma", Font.PLAIN, 48));
		txtKQ.setBackground(new Color(45, 45, 45));
		txtKQ.setBounds(5, 107, 335, 81);
		txtKQ.setBorder(null);
		frame.getContentPane().add(txtKQ);
		txtKQ.setColumns(10);
		txtKQ.setText(String.valueOf(0));
		
		txtPhepTinh = new JTextField();
		txtPhepTinh.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPhepTinh.setForeground(SystemColor.activeCaptionBorder);
		txtPhepTinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPhepTinh.setColumns(10);
		txtPhepTinh.setBorder(null);
		txtPhepTinh.setBackground(new Color(45, 45, 45));
		txtPhepTinh.setBounds(5, 67, 335, 30);
		frame.getContentPane().add(txtPhepTinh);
		frame.setBounds(100, 100, 360, 588);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		cacToanHang();
		cacPhepTinh();
	}
	
	public void cacToanHang() {
		//Khai báo nút dấu +/-
		JLabel btnDau = new JLabel("");
		//Xử lý sự kiện khi ấn nút dấu +/-
		btnDau.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int so = Integer.parseInt(txtKQ.getText());
				txtKQ.setText(String.valueOf(Math.negateExact(so)));
			}
		});
		btnDau.setIcon(new ImageIcon(CalculatorApp.class.getResource("/img/DauButton.png")));
		btnDau.setBounds(5, 485, 80, 60);
		frame.getContentPane().add(btnDau);
		
		//Khai báo nút chấm
		JLabel btnCham = new JLabel("");
		//Xử lý sự kiện khi ấn nút chấm
		btnCham.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!txtKQ.getText().contains(".")) {
					txtKQ.setText(txtKQ.getText() + ".");
				}
			}
		});
		btnCham.setIcon(new ImageIcon(CalculatorApp.class.getResource("/img/ChamButton.png")));
		btnCham.setBounds(175, 485, 80, 60);
		frame.getContentPane().add(btnCham);
		
		//Khai báo nút 0
		JLabel btn0 = new JLabel("New label");
		//Xử lý sự kiện khi ấn nút 0
		btn0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((txtKQ.getText().equals("0") && !txtKQ.getText().contains(".")) || checked == false) {
					txtKQ.setText("");
					checked = true;
				}
				txtKQ.setText(txtKQ.getText() + String.valueOf(0));
			}
		});
		btn0.setIcon(new ImageIcon(CalculatorApp.class.getResource("/img/KhongButton.png")));
		btn0.setBounds(90, 485, 80, 60);
		frame.getContentPane().add(btn0);
		
		//Khai báo nút 1
		JLabel btn1 = new JLabel("");
		//Xử lý sự kiện khi ấn nút 1
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((txtKQ.getText().equals("0") && !txtKQ.getText().contains(".")) || checked == false) {
					txtKQ.setText("");
					checked = true;
				}
				txtKQ.setText(txtKQ.getText() + String.valueOf(1));
			}
		});
		btn1.setIcon(new ImageIcon(CalculatorApp.class.getResource("/img/MotButton.png")));
		btn1.setBounds(5, 420, 80, 60);
		frame.getContentPane().add(btn1);
		
		//Khai báo nút 2
		JLabel btn2 = new JLabel("");
		//Xử lý sự kiện khi ấn nút 1
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((txtKQ.getText().equals("0") && !txtKQ.getText().contains(".")) || checked == false) {
					txtKQ.setText("");
					checked = true;
				}
				txtKQ.setText(txtKQ.getText() + String.valueOf(2));
			}
		});
		btn2.setIcon(new ImageIcon(CalculatorApp.class.getResource("/img/HaiButton.png")));
		btn2.setBounds(90, 420, 80, 60);
		frame.getContentPane().add(btn2);
		
		//Khai báo nút 3
		JLabel btn3 = new JLabel("");
		//Xử lý sự kiện khi ấn nút 3
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((txtKQ.getText().equals("0") && !txtKQ.getText().contains(".")) || checked == false) {
					txtKQ.setText("");
					checked = true;
				}
				txtKQ.setText(txtKQ.getText() + String.valueOf(3));
			}
		});
		btn3.setIcon(new ImageIcon(CalculatorApp.class.getResource("/img/BaButton.png")));
		btn3.setBounds(175, 420, 80, 60);
		frame.getContentPane().add(btn3);
		

		//Khai báo nút 4
		JLabel btn4 = new JLabel("");
		//Xử lý sự kiện khi ấn nút 4
		btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((txtKQ.getText().equals("0") && !txtKQ.getText().contains(".")) || checked == false) {
					txtKQ.setText("");
					checked = true;
				}
				txtKQ.setText(txtKQ.getText() + String.valueOf(4));
			}
		});
		btn4.setIcon(new ImageIcon(CalculatorApp.class.getResource("/img/BonButton.png")));
		btn4.setBounds(5, 355, 80, 60);
		frame.getContentPane().add(btn4);
		
		//Khai báo nút 5
		JLabel btn5 = new JLabel("");
		//Xử lý sự kiện khi ấn nút 5
		btn5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((txtKQ.getText().equals("0") && !txtKQ.getText().contains(".")) || checked == false) {
					txtKQ.setText("");
					checked = true;
				}
				txtKQ.setText(txtKQ.getText() + String.valueOf(5));
			}
		});
		btn5.setIcon(new ImageIcon(CalculatorApp.class.getResource("/img/NamButton.png")));
		btn5.setBounds(90, 355, 80, 60);
		frame.getContentPane().add(btn5);
		
		//Khai báo nút 6
		JLabel btn6 = new JLabel("");
		//Xử lý sự kiện khi ấn nút 6
		btn6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((txtKQ.getText().equals("0") && !txtKQ.getText().contains(".")) || checked == false) {
					txtKQ.setText("");
					checked = true;
				}
				txtKQ.setText(txtKQ.getText() + String.valueOf(6));
			}
		});
		btn6.setIcon(new ImageIcon(CalculatorApp.class.getResource("/img/SauButton.png")));
		btn6.setBounds(175, 355, 80, 60);
		frame.getContentPane().add(btn6);
		
		//Khai báo nút 7
		JLabel btn7 = new JLabel("");
		//Xử lý sự kiện khi ấn nút 7
		btn7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((txtKQ.getText().equals("0") && !txtKQ.getText().contains(".")) || checked == false) {
					txtKQ.setText("");
					checked = true;
				}
				txtKQ.setText(txtKQ.getText() + String.valueOf(7));
			}
		});
		btn7.setIcon(new ImageIcon(CalculatorApp.class.getResource("/img/BayButton.png")));
		btn7.setBounds(5, 290, 80, 60);
		frame.getContentPane().add(btn7);
		
		//Khai báo nút 8
		JLabel btn8 = new JLabel("");
		//Xử lý sự kiện khi ấn nút 8
		btn8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((txtKQ.getText().equals("0") && !txtKQ.getText().contains(".")) || checked == false) {
					txtKQ.setText("");
					checked = true;
				}
				txtKQ.setText(txtKQ.getText() + String.valueOf(8));
			}
		});
		btn8.setIcon(new ImageIcon(CalculatorApp.class.getResource("/img/TamButton.png")));
		btn8.setBounds(90, 290, 80, 60);
		frame.getContentPane().add(btn8);
		
		//Khai báo nút 9
		JLabel btn9 = new JLabel("");
		//Xử lý sự kiện khi ấn nút 9
		btn9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((txtKQ.getText().equals("0") && !txtKQ.getText().contains(".")) || checked == false) {
					txtKQ.setText("");
					checked = true;
				}
				txtKQ.setText(txtKQ.getText() + String.valueOf(9));
			}
		});
		btn9.setIcon(new ImageIcon(CalculatorApp.class.getResource("/img/ChinButton.png")));
		btn9.setBounds(175, 290, 80, 60);
		frame.getContentPane().add(btn9);
	}
	
	public void cacPhepTinh() {
		//Khai báo nút cộng
		JLabel btnCong = new JLabel("");
		//Xử lý sự kiện khi ấn nút cộng
		btnCong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				a = Double.parseDouble(txtKQ.getText());
				if(a == (int) a) {
					int inta = (int) a;
					txtPhepTinh.setText(inta + " + ");
				}else txtPhepTinh.setText(a + " + ");
				checked = false;
			}
		});
		btnCong.setIcon(new ImageIcon(CalculatorApp.class.getResource("/img/CongButton.png")));
		btnCong.setBounds(260, 420, 80, 60);
		frame.getContentPane().add(btnCong);
		
		//Khai báo nút trừ
		JLabel btnTru = new JLabel("");
		//Xử lý sự kiện khi ấn nút trừ
		btnTru.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnTru.setIcon(new ImageIcon(CalculatorApp.class.getResource("/img/TruButton.png")));
		btnTru.setBounds(260, 355, 80, 60);
		frame.getContentPane().add(btnTru);
		
		//Khai báo nút nhân
		JLabel btnNhan = new JLabel("");
		//Xử lý sự kiện khi ấn nút nhân
		btnNhan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNhan.setIcon(new ImageIcon(CalculatorApp.class.getResource("/img/NhanButton.png")));
		btnNhan.setBounds(260, 290, 80, 60);
		frame.getContentPane().add(btnNhan);
		
		//Khai báo nút chia
		JLabel btnChia = new JLabel("");
		//Xử lý sự kiện khi ấn nút chia
		btnChia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnChia.setIcon(new ImageIcon(CalculatorApp.class.getResource("/img/ChiaButton.png")));
		btnChia.setBounds(260, 225, 80, 60);
		frame.getContentPane().add(btnChia);
		
		//Khai báo nút bằng
		JLabel btnBang = new JLabel("");
		//Xử lý sự kiện khi ấn nút bằng
		btnBang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				b = Double.parseDouble(txtKQ.getText());
				if(b == (int) b) {
					int intb = (int) b;
					if(txtPhepTinh.getText().contains("+")) {
						txtPhepTinh.setText( + intb + " =");
						txtKQ.setText(String.valueOf(a + b));
						a = b;
					}
				}
				checked = false;
			}
		});
		btnBang.setIcon(new ImageIcon(CalculatorApp.class.getResource("/img/BangButton.png")));
		btnBang.setBounds(260, 485, 80, 60);
		frame.getContentPane().add(btnBang);
		
		//Khai báo nút CE
		JLabel btnCE = new JLabel("");
		//Xử lý sự kiện khi ấn nút CE
		btnCE.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtKQ.setText(String.valueOf(0));
				txtPhepTinh.setText("");
			}
		});
		btnCE.setIcon(new ImageIcon(CalculatorApp.class.getResource("/img/CEButton.png")));
		btnCE.setBounds(5, 225, 80, 60);
		frame.getContentPane().add(btnCE);
		
		//Khai báo nút C
		JLabel btnC = new JLabel("");
		//Xử lý sự kiện khi ấn nút C
		btnC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnC.setIcon(new ImageIcon(CalculatorApp.class.getResource("/img/CButton.png")));
		btnC.setBounds(90, 225, 80, 60);
		frame.getContentPane().add(btnC);
		
		//Khai báo nút del
		JLabel btnDel = new JLabel("");
		//Xử lý sự kiện khi ấn nút del
		btnDel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnDel.setIcon(new ImageIcon(CalculatorApp.class.getResource("/img/DelButton.png")));
		btnDel.setBounds(175, 225, 80, 60);
		frame.getContentPane().add(btnDel);
	}
}
