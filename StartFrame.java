import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class StartFrame extends JFrame{
	private JLabel Jlb_title = new JLabel("圖形知多少");
    private JButton Jbtn_rightTriangle = new JButton("直角三角形");
    private JButton Jbtn_circle = new JButton("圓形");
    private JButton Jbtn_rectangle = new JButton("矩形");
    private JButton Jbtn_regularTriangle = new JButton("正三角形");
    private JButton Jbtn_test = new JButton("測驗");
    
    StartFrame() {
    	Container c = getContentPane();
    	c.setBackground(new Color(173, 216, 230));
        c.setLayout(null);
        
        setTitle("圖形知多少");
		setSize(600, 600);
		setLocationRelativeTo(null);//視窗置中
		setResizable(false);//視窗放大按鈕無效
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//設定標題大小位置及顯示字型
        Jlb_title.setLocation(194,48);
        Jlb_title.setSize(206,63);
        Jlb_title.setFont(new Font("微軟正黑體", Font.BOLD, 38));
        c.add(Jlb_title);
        
        //設定直角三角形按鈕大小位置及顯示字型
        Jbtn_rightTriangle.setLocation(157,309);
        Jbtn_rightTriangle.setSize(280,57);
        Jbtn_rightTriangle.setFont(new Font("微軟正黑體", Font.BOLD, 24));
        c.add(Jbtn_rightTriangle);
        Jbtn_rightTriangle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new RightTriangleFrame();
			}
		});
		
		//設定圓形按鈕大小位置及顯示字型
		Jbtn_circle.setLocation(157,391);
		Jbtn_circle.setSize(280,57);
		Jbtn_circle.setFont(new Font("微軟正黑體", Font.BOLD, 24));
        c.add(Jbtn_circle);
        Jbtn_circle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new CircleFrame();
			}
		});
		
		 //設定矩形按鈕大小位置及顯示字型
        Jbtn_rectangle.setLocation(157,145);
        Jbtn_rectangle.setSize(280,57);
        Jbtn_rectangle.setFont(new Font("微軟正黑體", Font.BOLD, 24));
        c.add(Jbtn_rectangle);
        Jbtn_rectangle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new RectangleFrame();
			}
		});
		
		//設定正三角形按鈕大小位置及顯示字型
        Jbtn_regularTriangle.setLocation(157,227);
        Jbtn_regularTriangle.setSize(280,57);
        Jbtn_regularTriangle.setFont(new Font("微軟正黑體", Font.BOLD, 24));
        c.add(Jbtn_regularTriangle);
        Jbtn_regularTriangle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new RegularTriangleFrame();
			}
		});
        
        //設定測驗按鈕大小位置及顯示字型
        Jbtn_test.setLocation(157,473);
        Jbtn_test.setSize(280,57);
        Jbtn_test.setFont(new Font("微軟正黑體", Font.BOLD, 24));
        c.add(Jbtn_test);
        Jbtn_test.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new TestFrame();
			}
		});
        
    }
}
