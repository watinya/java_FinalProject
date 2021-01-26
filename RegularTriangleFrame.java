import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class RegularTriangleFrame extends JFrame{
	private JButton Jbtn_return = new JButton("返回主選單");
	private JLabel Jlb_title = new JLabel();
	private JLabel Jlb_info = new JLabel();
	private JLabel Jlb_sideLength = new JLabel("邊長：");
	private JTextField jSideLength = new JTextField();
    private JButton Jbtn_count = new JButton("計算");
    private JButton Jbtn_clean = new JButton("清空");
    private JLabel Jlb_height = new JLabel("<html>此正三角形高為：</html>");
    private JLabel Jlb_area = new JLabel("<html>此正三角形面積為：</html>");
    private JLabel Jlb_perimeter = new JLabel("<html>此正三角形周長為：</html>");
    private Triangle regularTriangle = new RegularTriangle();
    
    RegularTriangleFrame() {
    	Container c = getContentPane();
        c.setLayout(null);
        
        setTitle("正三角形");
		setSize(600, 600);
		setLocationRelativeTo(null);//視窗置中
		setResizable(false);//視窗放大按鈕無效
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//設定標題大小位置及顯示字型
        Jlb_title.setLocation(14,77);
        Jlb_title.setSize(196,58);
        Jlb_title.setFont(new Font("微軟正黑體", Font.BOLD, 36));
        Jlb_title.setText(regularTriangle.getShapeName());
        c.add(Jlb_title);
        
        //設定介紹大小位置及顯示字型
        Jlb_info.setLocation(369,13);
        Jlb_info.setSize(211,122);
        Icon image = new ImageIcon("image//正三角形.png");
        Jlb_info.setIcon(image);
        c.add(Jlb_info);
        
        //設定邊長標籤大小位置及顯示字型
        Jlb_sideLength.setLocation(24,132);
        Jlb_sideLength.setSize(102,47);
        Jlb_sideLength.setFont(new Font("微軟正黑體", Font.BOLD, 30));
        c.add(Jlb_sideLength);
               
        //設定邊長輸入框大小位置及顯示字型
        jSideLength.setLocation(113,142);
        jSideLength.setSize(152,33);
        jSideLength.setFont(new Font("微軟正黑體", Font.BOLD, 24));
        c.add(jSideLength);
        
        //設定高結果標籤大小位置及顯示字型
        Jlb_height.setLocation(24,192);
        Jlb_height.setSize(556,70);
        Jlb_height.setFont(new Font("微軟正黑體", Font.BOLD, 28));
        Jlb_height.setVerticalTextPosition(SwingConstants.TOP);
        c.add(Jlb_height);
        
        //設定周長結果標籤大小位置及顯示字型
        Jlb_perimeter.setLocation(24,275);
        Jlb_perimeter.setSize(556,70);
        Jlb_perimeter.setFont(new Font("微軟正黑體", Font.BOLD, 28));
        Jlb_perimeter.setVerticalTextPosition(SwingConstants.TOP);
        c.add(Jlb_perimeter);
        
        //設定面積結果標籤大小位置及顯示字型
        Jlb_area.setLocation(24,358);
        Jlb_area.setSize(556,70);
        Jlb_area.setFont(new Font("微軟正黑體", Font.BOLD, 28));
        Jlb_area.setVerticalTextPosition(SwingConstants.TOP);
        c.add(Jlb_area);
        
        //設定計算按鈕大小位置及顯示字型
        Jbtn_count.setLocation(275,143);
        Jbtn_count.setSize(89,33);
        Jbtn_count.setFont(new Font("微軟正黑體", Font.BOLD, 22));
        c.add(Jbtn_count);
        Jbtn_count.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String strBaseLength = jSideLength.getText();
				if(strBaseLength.equals("")) {
					JOptionPane.showMessageDialog(new JFrame(), "輸入框不可為空", "正三角形", JOptionPane.ERROR_MESSAGE);
				}
				else if(judgeNum(strBaseLength)) {
					double sideLength = Double.parseDouble(strBaseLength);
					regularTriangle = new RegularTriangle(sideLength);
					Jlb_height.setText("<html>此正三角形高為：<br/>" + regularTriangle.computeHeight() + "</html>");
					Jlb_perimeter.setText("<html>此正三角形周長為：<br/>" + regularTriangle.computePerimeter() + "</html>");
					Jlb_area.setText("<html>此正三角形面積為：<br/>" + regularTriangle.computeArea() + "</html>");
				}
				else {
					JOptionPane.showMessageDialog(new JFrame(), "輸入必須為數字", "正三角形", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
        
        //設定清空按鈕大小位置及顯示字型
        Jbtn_clean.setLocation(374,143);
        Jbtn_clean.setSize(89,33);
        Jbtn_clean.setFont(new Font("微軟正黑體", Font.BOLD, 22));
        c.add(Jbtn_clean);
        Jbtn_clean.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Jlb_height.setText("<html>此正三角形高為：</html>");
				Jlb_perimeter.setText("<html>此正三角形周長為：</html>");
				Jlb_area.setText("<html>此正三角形面積為：</html>");
				jSideLength.setText("");
			}
		});
        
        //設定返回主選單按鈕大小位置及顯示字型
        Jbtn_return.setLocation(14,13);
        Jbtn_return.setSize(130,33);
        Jbtn_return.setFont(new Font("微軟正黑體", Font.BOLD, 18));
        c.add(Jbtn_return);
        Jbtn_return.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new StartFrame();
			}
		});
    }
    
    //判斷輸入是否為數字
  	public boolean judgeNum(String msg) {
  		try {
  			Double.parseDouble(msg);
  			return true;
  		} catch (Exception e) {
  			return false;
  		}
  	}
}
