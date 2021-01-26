import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CircleFrame extends JFrame{
	private JButton Jbtn_return = new JButton("返回主選單");
	private JLabel Jlb_title = new JLabel();
	private JLabel Jlb_info = new JLabel();
	private JLabel Jlb_radius = new JLabel("半徑：");
	private JTextField jRadius = new JTextField();
    private JButton Jbtn_count = new JButton("計算");
    private JButton Jbtn_clean = new JButton("清空");
    private JLabel Jlb_area = new JLabel("<html>此圓形面積為：</html>");
    private JLabel Jlb_perimeter = new JLabel("<html>此圓形周長為：</html>");
    private Shape circle = new Circle();
    
    CircleFrame() {
    	Container c = getContentPane();
        c.setLayout(null);
        
        setTitle("圓形");
		setSize(600, 600);
		setLocationRelativeTo(null);//視窗置中
		setResizable(false);//視窗放大按鈕無效
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//設定標題大小位置及顯示字型
        Jlb_title.setLocation(14,77);
        Jlb_title.setSize(89,58);
        Jlb_title.setFont(new Font("微軟正黑體", Font.BOLD, 36));
        Jlb_title.setText(circle.getShapeName());
        c.add(Jlb_title);
        
        //設定介紹大小位置及顯示字型
        Jlb_info.setLocation(369,13);
        Jlb_info.setSize(211,122);
        Icon image = new ImageIcon("image//圓形.png");
        Jlb_info.setIcon(image);
        c.add(Jlb_info);
        
        //設定半徑標籤大小位置及顯示字型
        Jlb_radius.setLocation(24,132);
        Jlb_radius.setSize(95,47);
        Jlb_radius.setFont(new Font("微軟正黑體", Font.BOLD, 30));
        c.add(Jlb_radius);
                
        //設定半徑輸入框大小位置及顯示字型
        jRadius.setLocation(115,142);
        jRadius.setSize(152,33);
        jRadius.setFont(new Font("微軟正黑體", Font.BOLD, 24));
        c.add(jRadius);
        
        //設定周長結果標籤大小位置及顯示字型
        Jlb_perimeter.setLocation(24,246);
        Jlb_perimeter.setSize(556,70);
        Jlb_perimeter.setFont(new Font("微軟正黑體", Font.BOLD, 28));
        c.add(Jlb_perimeter);
        
        //設定面積結果標籤大小位置及顯示字型
        Jlb_area.setLocation(24,329);
        Jlb_area.setSize(556,70);
        Jlb_area.setFont(new Font("微軟正黑體", Font.BOLD, 28));
        c.add(Jlb_area);
        
        //設定計算按鈕大小位置及顯示字型
        Jbtn_count.setLocation(281,143);
        Jbtn_count.setSize(89,33);
        Jbtn_count.setFont(new Font("微軟正黑體", Font.BOLD, 22));
        c.add(Jbtn_count);
        Jbtn_count.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String strRadius = jRadius.getText();
				if(strRadius.equals("")) {
					JOptionPane.showMessageDialog(new JFrame(), "輸入框不可為空", "圓形", JOptionPane.ERROR_MESSAGE);
				}
				else if(judgeNum(strRadius)) {
					double radius = Double.parseDouble(strRadius);
					circle = new Circle(radius);
					Jlb_perimeter.setText("<html>此圓形周長為：<br/>" + circle.computePerimeter() + "</html>");
					Jlb_area.setText("<html>此圓形面積為：<br/>" + circle.computeArea() + "</html>");
				}
				else {
					JOptionPane.showMessageDialog(new JFrame(), "輸入必須為數字", "圓形", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
        
        //設定清空按鈕大小位置及顯示字型
        Jbtn_clean.setLocation(384,143);
        Jbtn_clean.setSize(89,33);
        Jbtn_clean.setFont(new Font("微軟正黑體", Font.BOLD, 22));
        c.add(Jbtn_clean);
        Jbtn_clean.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Jlb_perimeter.setText("<html>此圓形周長為：</html>");
				Jlb_area.setText("<html>此圓形面積為：</html>");
				jRadius.setText("");
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
