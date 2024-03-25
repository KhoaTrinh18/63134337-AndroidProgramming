package ntu.mssv63134337;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.FormatFlagsConversionMismatchException;
import java.awt.Toolkit;

public class CalculatorApp {

	private JFrame frmCalculator;
	private JTextField txtKQ;
	private JTextField txtPhepTinh;
	JLabel btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnCham, btnDau;
	JLabel btnCong, btnTru, btnNhan, btnChia, btnCE, btnC, btnDel, btnBang;
	private double a, b;
	private String stra, strb;
	private boolean checked = true, checkNan = true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorApp window = new CalculatorApp();
					window.frmCalculator.setVisible(true);
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
		frmCalculator = new JFrame();
		frmCalculator.setTitle("Calculator");
		frmCalculator.setIconImage(Toolkit.getDefaultToolkit().getImage(CalculatorApp.class.getResource("/img/CalculatorIcon.png")));
		frmCalculator.setBackground(new Color(255, 255, 255));
		frmCalculator.getContentPane().setBackground(new Color(45, 45, 45));
		frmCalculator.getContentPane().setLayout(null);
		
		txtKQ = new JTextField();
		txtKQ.setFocusable(false);
		txtKQ.setHorizontalAlignment(SwingConstants.RIGHT);
		txtKQ.setForeground(new Color(255, 255, 255));
		txtKQ.setFont(new Font("Tahoma", Font.PLAIN, 48));
		txtKQ.setBackground(new Color(45, 45, 45));
		txtKQ.setBounds(5, 107, 335, 81);
		txtKQ.setBorder(null);
		frmCalculator.getContentPane().add(txtKQ);
		txtKQ.setColumns(10);
		txtKQ.setText("0");
		
		txtPhepTinh = new JTextField();
		txtPhepTinh.setFocusable(false);
		txtPhepTinh.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPhepTinh.setForeground(new Color(192, 192, 192));
		txtPhepTinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPhepTinh.setColumns(10);
		txtPhepTinh.setBorder(null);
		txtPhepTinh.setBackground(new Color(45, 45, 45));
		txtPhepTinh.setBounds(5, 67, 335, 30);
		
		frmCalculator.getContentPane().add(txtPhepTinh);
		frmCalculator.setBounds(100, 100, 360, 588);
		frmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		cacToanHang();
		cacPhepTinh();
	}
	
	public void cacToanHang() {
		//Khai báo nút dấu +/-
		btnDau = new JLabel("");
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
		frmCalculator.getContentPane().add(btnDau);
		
		//Khai báo nút chấm
		btnCham = new JLabel("");
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
		frmCalculator.getContentPane().add(btnCham);
		
		//Khai báo nút 0
		btn0 = new JLabel("New label");
		//Xử lý sự kiện khi ấn nút 0
		btn0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((txtKQ.getText().equals("0") && !txtKQ.getText().contains(".")) || checked == false) {
					txtKQ.setText("");
					checked = true;
				}
				if(checkNan == false) {
					btnChia.setEnabled(true);
					btnNhan.setEnabled(true);
					btnCong.setEnabled(true);
					btnTru.setEnabled(true);
					txtPhepTinh.setText("");
					checkNan = true;
				}
				txtKQ.setText(txtKQ.getText() + 0);
			}
		});
		btn0.setIcon(new ImageIcon(CalculatorApp.class.getResource("/img/KhongButton.png")));
		btn0.setBounds(90, 485, 80, 60);
		frmCalculator.getContentPane().add(btn0);
		
		//Khai báo nút 1
		btn1 = new JLabel("");
		//Xử lý sự kiện khi ấn nút 1
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((txtKQ.getText().equals("0") && !txtKQ.getText().contains(".")) || checked == false) {
					txtKQ.setText("");
					checked = true;
				}
				if(checkNan == false) {
					btnChia.setEnabled(true);
					btnNhan.setEnabled(true);
					btnCong.setEnabled(true);
					btnTru.setEnabled(true);
					txtPhepTinh.setText("");
					checkNan = true;
				}
				txtKQ.setText(txtKQ.getText() + 1);
			}
		});
		btn1.setIcon(new ImageIcon(CalculatorApp.class.getResource("/img/MotButton.png")));
		btn1.setBounds(5, 420, 80, 60);
		frmCalculator.getContentPane().add(btn1);
		
		//Khai báo nút 2
		btn2 = new JLabel("");
		//Xử lý sự kiện khi ấn nút 2
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((txtKQ.getText().equals("0") && !txtKQ.getText().contains(".")) || checked == false) {
					txtKQ.setText("");
					checked = true;
				}
				if(checkNan == false) {
					btnChia.setEnabled(true);
					btnNhan.setEnabled(true);
					btnCong.setEnabled(true);
					btnTru.setEnabled(true);
					txtPhepTinh.setText("");
					checkNan = true;
				}
				txtKQ.setText(txtKQ.getText() + 2);
			}
		});
		btn2.setIcon(new ImageIcon(CalculatorApp.class.getResource("/img/HaiButton.png")));
		btn2.setBounds(90, 420, 80, 60);
		frmCalculator.getContentPane().add(btn2);
		
		//Khai báo nút 3
		btn3 = new JLabel("");
		//Xử lý sự kiện khi ấn nút 3
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((txtKQ.getText().equals("0") && !txtKQ.getText().contains(".")) || checked == false) {
					txtKQ.setText("");
					checked = true;
				}
				if(checkNan == false) {
					btnChia.setEnabled(true);
					btnNhan.setEnabled(true);
					btnCong.setEnabled(true);
					btnTru.setEnabled(true);
					txtPhepTinh.setText("");
					checkNan = true;
				}
				txtKQ.setText(txtKQ.getText() + 3);
			}
		});
		btn3.setIcon(new ImageIcon(CalculatorApp.class.getResource("/img/BaButton.png")));
		btn3.setBounds(175, 420, 80, 60);
		frmCalculator.getContentPane().add(btn3);
		

		//Khai báo nút 4
		btn4 = new JLabel("");
		//Xử lý sự kiện khi ấn nút 4
		btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((txtKQ.getText().equals("0") && !txtKQ.getText().contains(".")) || checked == false) {
					txtKQ.setText("");
					checked = true;
				}
				if(checkNan == false) {
					btnChia.setEnabled(true);
					btnNhan.setEnabled(true);
					btnCong.setEnabled(true);
					btnTru.setEnabled(true);
					txtPhepTinh.setText("");
					checkNan = true;
				}
				txtKQ.setText(txtKQ.getText() + 4);
			}
		});
		btn4.setIcon(new ImageIcon(CalculatorApp.class.getResource("/img/BonButton.png")));
		btn4.setBounds(5, 355, 80, 60);
		frmCalculator.getContentPane().add(btn4);
		
		//Khai báo nút 5
		btn5 = new JLabel("");
		//Xử lý sự kiện khi ấn nút 5
		btn5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((txtKQ.getText().equals("0") && !txtKQ.getText().contains(".")) || checked == false) {
					txtKQ.setText("");
					checked = true;
				}
				if(checkNan == false) {
					btnChia.setEnabled(true);
					btnNhan.setEnabled(true);
					btnCong.setEnabled(true);
					btnTru.setEnabled(true);
					txtPhepTinh.setText("");
					checkNan = true;
				}
				txtKQ.setText(txtKQ.getText() + 5);
			}
		});
		btn5.setIcon(new ImageIcon(CalculatorApp.class.getResource("/img/NamButton.png")));
		btn5.setBounds(90, 355, 80, 60);
		frmCalculator.getContentPane().add(btn5);
		
		//Khai báo nút 6
		btn6 = new JLabel("");
		//Xử lý sự kiện khi ấn nút 6
		btn6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((txtKQ.getText().equals("0") && !txtKQ.getText().contains(".")) || checked == false) {
					txtKQ.setText("");
					checked = true;
				}
				if(checkNan == false) {
					btnChia.setEnabled(true);
					btnNhan.setEnabled(true);
					btnCong.setEnabled(true);
					btnTru.setEnabled(true);
					txtPhepTinh.setText("");
					checkNan = true;
				}
				txtKQ.setText(txtKQ.getText() + 6);
			}
		});
		btn6.setIcon(new ImageIcon(CalculatorApp.class.getResource("/img/SauButton.png")));
		btn6.setBounds(175, 355, 80, 60);
		frmCalculator.getContentPane().add(btn6);
		
		//Khai báo nút 7
		btn7 = new JLabel("");
		//Xử lý sự kiện khi ấn nút 7
		btn7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((txtKQ.getText().equals("0") && !txtKQ.getText().contains(".")) || checked == false) {
					txtKQ.setText("");
					checked = true;
				}
				if(checkNan == false) {
					btnChia.setEnabled(true);
					btnNhan.setEnabled(true);
					btnCong.setEnabled(true);
					btnTru.setEnabled(true);
					txtPhepTinh.setText("");
					checkNan = true;
				}
				txtKQ.setText(txtKQ.getText() + 7);
			}
		});
		btn7.setIcon(new ImageIcon(CalculatorApp.class.getResource("/img/BayButton.png")));
		btn7.setBounds(5, 290, 80, 60);
		frmCalculator.getContentPane().add(btn7);
		
		//Khai báo nút 8
		btn8 = new JLabel("");
		//Xử lý sự kiện khi ấn nút 8
		btn8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((txtKQ.getText().equals("0") && !txtKQ.getText().contains(".")) || checked == false) {
					txtKQ.setText("");
					checked = true;
				}
				if(checkNan == false) {
					btnChia.setEnabled(true);
					btnNhan.setEnabled(true);
					btnCong.setEnabled(true);
					btnTru.setEnabled(true);
					txtPhepTinh.setText("");
					checkNan = true;
				}
				txtKQ.setText(txtKQ.getText() + 8);
			}
		});
		btn8.setIcon(new ImageIcon(CalculatorApp.class.getResource("/img/TamButton.png")));
		btn8.setBounds(90, 290, 80, 60);
		frmCalculator.getContentPane().add(btn8);
		
		//Khai báo nút 9
		btn9 = new JLabel("");
		//Xử lý sự kiện khi ấn nút 9
		btn9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if((txtKQ.getText().equals("0") && !txtKQ.getText().contains(".")) || checked == false) {
					txtKQ.setText("");
					checked = true;
				}
				if(checkNan == false) {
					btnChia.setEnabled(true);
					btnNhan.setEnabled(true);
					btnCong.setEnabled(true);
					btnTru.setEnabled(true);
					txtPhepTinh.setText("");
					checkNan = true;
				}
				txtKQ.setText(txtKQ.getText() + 9);
			}
		});
		btn9.setIcon(new ImageIcon(CalculatorApp.class.getResource("/img/ChinButton.png")));
		btn9.setBounds(175, 290, 80, 60);
		frmCalculator.getContentPane().add(btn9);
	}
	
	public void cacPhepTinh() {
		//Khai báo nút cộng
		btnCong = new JLabel("");
		//Xử lý sự kiện khi ấn nút cộng
		btnCong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(checkNan == true) {
					if(txtPhepTinh.getText().equals("")) {
						a = Double.parseDouble(txtKQ.getText());
						if(a == (int) a) 
							stra = String.format("%.0f", a);
						else 
							stra = String.valueOf(a);
					} else {
						a = a + Double.parseDouble(txtKQ.getText());
						if(a == (int) a) 
							stra = String.format("%.0f", a);
						else 
							stra = String.valueOf(a);
						txtKQ.setText(stra);;
					}
					txtPhepTinh.setText(stra + " + ");
					checked = false;
				}
			}
		});
		btnCong.setIcon(new ImageIcon(CalculatorApp.class.getResource("/img/CongButton.png")));
		btnCong.setBounds(260, 420, 80, 60);
		frmCalculator.getContentPane().add(btnCong);
		
		//Khai báo nút trừ
		btnTru = new JLabel("");
		//Xử lý sự kiện khi ấn nút trừ
		btnTru.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(checkNan == true) {
					if(txtPhepTinh.getText().equals("")) {
						a = Double.parseDouble(txtKQ.getText());
						if(a == (int) a) 
							stra = String.format("%.0f", a);
						else 
							stra = String.valueOf(a);
					} else {
						a = a - Double.parseDouble(txtKQ.getText());
						if(a == (int) a) 
							stra = String.format("%.0f", a);
						else 
							stra = String.valueOf(a);
						txtKQ.setText(stra);;
					}
					txtPhepTinh.setText(stra + " - ");
					checked = false;
				}
			}
		});
		btnTru.setIcon(new ImageIcon(CalculatorApp.class.getResource("/img/TruButton.png")));
		btnTru.setBounds(260, 355, 80, 60);
		frmCalculator.getContentPane().add(btnTru);
		
		//Khai báo nút nhân
		btnNhan = new JLabel("");
		//Xử lý sự kiện khi ấn nút nhân
		btnNhan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(checkNan == true) {
					if(txtPhepTinh.getText().equals("")) {
						a = Double.parseDouble(txtKQ.getText());
						if(a == (int) a) 
							stra = String.format("%.0f", a);
						else 
							stra = String.valueOf(a);
					} else {
						a = a * Double.parseDouble(txtKQ.getText());
						if(a == (int) a) 
							stra = String.format("%.0f", a);
						else 
							stra = String.valueOf(a);
					}
					txtPhepTinh.setText(stra + " x ");
					checked = false;
				}
			}
		});
		btnNhan.setIcon(new ImageIcon(CalculatorApp.class.getResource("/img/NhanButton.png")));
		btnNhan.setBounds(260, 290, 80, 60);
		frmCalculator.getContentPane().add(btnNhan);
		
		//Khai báo nút chia
		btnChia = new JLabel("");
		//Xử lý sự kiện khi ấn nút chia
		btnChia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(checkNan == true) {
					if(txtPhepTinh.getText().equals("")) {
						a = Double.parseDouble(txtKQ.getText());
						if(a == (int) a) 
							stra = String.format("%.0f", a);
						else 
							stra = String.valueOf(a);
					} else {
						if(txtKQ.getText().equals("0")) {
							btnChia.setEnabled(false);
							btnNhan.setEnabled(false);
							btnCong.setEnabled(false);
							btnTru.setEnabled(false);
							checkNan = false;
							txtKQ.setText("Nan");
						}else {
							a = a / Double.parseDouble(txtKQ.getText());
							if(a == (int) a) 
								stra = String.format("%.0f", a);
							else 
								stra = String.valueOf(a);
						}
					}
					txtPhepTinh.setText(stra + " ÷ ");
					checked = false;
				}
			}
		});
		btnChia.setIcon(new ImageIcon(CalculatorApp.class.getResource("/img/ChiaButton.png")));
		btnChia.setBounds(260, 225, 80, 60);
		frmCalculator.getContentPane().add(btnChia);
		
		//Khai báo nút bằng
		btnBang = new JLabel("");
		//Xử lý sự kiện khi ấn nút bằng
		btnBang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double kq = 0;
				String strkq;
				
				if(checked == true) {
					b = Double.parseDouble(txtKQ.getText());
				}
				
				if(b == (int) b) 
					strb = String.format("%.0f", b);
				else 
					strb = String.valueOf(b);
				
				if(checkNan == false) {
					btnChia.setEnabled(true);
					btnNhan.setEnabled(true);
					btnCong.setEnabled(true);
					btnTru.setEnabled(true);
					txtPhepTinh.setText("");
					checkNan = true;
					txtKQ.setText("0");
					txtPhepTinh.setText("");
					b = 1;
				}
				
				//Phép tính cộng
				if(txtPhepTinh.getText().contains("+")) {	
					kq = a + b;
					txtPhepTinh.setText(stra + " + " + strb + " =");
				}
				
				//Phép tính trừ
				if(txtPhepTinh.getText().contains(" - ")) {	
					kq = a - b;
					txtPhepTinh.setText(stra + " - " + strb + " =");
				}
				
				//Phép tính nhân
				if(txtPhepTinh.getText().contains("x")) {	
					kq = a * b;
					txtPhepTinh.setText(stra + " x " + strb + " =");
				}
				
				//Phép tính chia
				if(txtPhepTinh.getText().contains("÷")) {	
					if(b == 0) {
						btnChia.setEnabled(false);
						btnNhan.setEnabled(false);
						btnCong.setEnabled(false);
						btnTru.setEnabled(false);
						checkNan = false;
						txtPhepTinh.setText(stra + " ÷ " + strb + " =");
					}
					else {
						kq = a / b;
						txtPhepTinh.setText(stra + " ÷ " + strb + " =");
					}
				}
				if(kq == (int) kq) 
					strkq = String.format("%.0f", kq);
				else 
					strkq = String.valueOf(kq);
				txtKQ.setText(strkq);
				if(b == 0) txtKQ.setText("Nan");
				a = kq;
				stra = strkq;
				
				checked = false;
			}
		});
		btnBang.setIcon(new ImageIcon(CalculatorApp.class.getResource("/img/BangButton.png")));
		btnBang.setBounds(260, 485, 80, 60);
		frmCalculator.getContentPane().add(btnBang);
		
		//Khai báo nút CE
		btnCE = new JLabel("");
		//Xử lý sự kiện khi ấn nút CE
		btnCE.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtKQ.setText(String.valueOf(0));
				if(txtPhepTinh.getText().contains("="))
					txtPhepTinh.setText("");
				if(checkNan == false) {
					btnChia.setEnabled(true);
					btnNhan.setEnabled(true);
					btnCong.setEnabled(true);
					btnTru.setEnabled(true);
					txtPhepTinh.setText("");
					checkNan = true;
				}
			}
		});
		btnCE.setIcon(new ImageIcon(CalculatorApp.class.getResource("/img/CEButton.png")));
		btnCE.setBounds(5, 225, 80, 60);
		frmCalculator.getContentPane().add(btnCE);
		
		//Khai báo nút C
		btnC = new JLabel("");
		//Xử lý sự kiện khi ấn nút C
		btnC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtKQ.setText("0");
				txtPhepTinh.setText("");
				if(checkNan == false) {
					btnChia.setEnabled(true);
					btnNhan.setEnabled(true);
					btnCong.setEnabled(true);
					btnTru.setEnabled(true);
					txtPhepTinh.setText("");
					checkNan = true;
				}
			}
		});
		btnC.setIcon(new ImageIcon(CalculatorApp.class.getResource("/img/CButton.png")));
		btnC.setBounds(90, 225, 80, 60);
		frmCalculator.getContentPane().add(btnC);
		
		//Khai báo nút del
		btnDel = new JLabel("");
		//Xử lý sự kiện khi ấn nút del
		btnDel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!txtKQ.getText().equals("0")) {
					StringBuilder strkq = new StringBuilder(txtKQ.getText());
					strkq.deleteCharAt(strkq.length() - 1);
					if(strkq.toString().equals("")) 
						txtKQ.setText("0");
					else
						txtKQ.setText(strkq.toString());
				}
				if(checkNan == false) {
					btnChia.setEnabled(true);
					btnNhan.setEnabled(true);
					btnCong.setEnabled(true);
					btnTru.setEnabled(true);
					txtPhepTinh.setText("");
					txtKQ.setText("0");
					checkNan = true;
				}
			}
		});
		btnDel.setIcon(new ImageIcon(CalculatorApp.class.getResource("/img/DelButton.png")));
		btnDel.setBounds(175, 225, 80, 60);
		frmCalculator.getContentPane().add(btnDel);
	}
}
