import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class RightTriangleFrame extends JFrame{
	private JButton Jbtn_return = new JButton("返回主選單");
	private JLabel Jlb_title = new JLabel();
	private JLabel Jlb_info = new JLabel();
	private JLabel Jlb_base = new JLabel("底：");
	private JLabel Jlb_height = new JLabel("高：");
	private JTextField jBase = new JTextField();
    private JTextField jHeight = new JTextField();
    private JButton Jbtn_count = new JButton("計算");
    private JButton Jbtn_clean = new JButton("清空");
    private JLabel Jlb_area = new JLabel("<html>此直角三角形面積為：</html>");
    private JLabel Jlb_perimeter = new JLabel("<html>此直角三角形周長為：</html>");
    private Triangle rightTriangle = new RightTriangle();
    
    RightTriangleFrame() {
    	Container c = getContentPane();
        c.setLayout(null);
        
        setTitle("直角三角形");
		setSize(600, 600);
		setLocationRelativeTo(null);//視窗置中
		setResizable(false);//視窗放大按鈕無效
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//設定標題大小位置及顯示字型
        Jlb_title.setLocation(14,77);
        Jlb_title.setSize(196,58);
        Jlb_title.setFont(new Font("微軟正黑體", Font.BOLD, 36));
        Jlb_title.setText(rightTriangle.getShapeName());
        c.add(Jlb_title);
        
        //設定介紹大小位置及顯示字型
        Jlb_info.setLocation(369,13);
        Jlb_info.setSize(211,122);
        Icon image = new ImageIcon("image//直角三角形.png");
        Jlb_info.setIcon(image);
        c.add(Jlb_info);
        
        //設定底標籤大小位置及顯示字型
        Jlb_base.setLocation(24,132);
        Jlb_base.setSize(60,47);
        Jlb_base.setFont(new Font("微軟正黑體", Font.BOLD, 30));
        c.add(Jlb_base);
        
        //設定高標籤大小位置及顯示字型
        Jlb_height.setLocation(24,174);
        Jlb_height.setSize(60,47);
        Jlb_height.setFont(new Font("微軟正黑體", Font.BOLD, 30));
        c.add(Jlb_height);
        
        //設定底輸入框大小位置及顯示字型
        jBase.setLocation(84,140);
        jBase.setSize(152,33);
        jBase.setFont(new Font("微軟正黑體", Font.BOLD, 24));
        c.add(jBase);
        
        //設定高輸入框大小位置及顯示字型
        jHeight.setLocation(84,182);
        jHeight.setSize(152,33);
        jHeight.setFont(new Font("微軟正黑體", Font.BOLD, 24));
        c.add(jHeight);
        
        //設定周長結果標籤大小位置及顯示字型
        Jlb_perimeter.setLocation(24,246);
        Jlb_perimeter.setSize(556,70);
        Jlb_perimeter.setFont(new Font("微軟正黑體", Font.BOLD, 28));
        Jlb_perimeter.setVerticalTextPosition(SwingConstants.TOP);
        c.add(Jlb_perimeter);
        
        //設定面積結果標籤大小位置及顯示字型
        Jlb_area.setLocation(24,329);
        Jlb_area.setSize(556,70);
        Jlb_area.setFont(new Font("微軟正黑體", Font.BOLD, 28));
        Jlb_area.setVerticalTextPosition(SwingConstants.TOP);
        c.add(Jlb_area);
        
        //設定計算按鈕大小位置及顯示字型
        Jbtn_count.setLocation(250,185);
        Jbtn_count.setSize(89,33);
        Jbtn_count.setFont(new Font("微軟正黑體", Font.BOLD, 22));
        c.add(Jbtn_count);
        Jbtn_count.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String strBase = jBase.getText();
				String strHeight = jHeight.getText();
				if(strBase.equals("") || strHeight.equals("")) {
					JOptionPane.showMessageDialog(new JFrame(), "輸入框不可為空", "直角三角形", JOptionPane.ERROR_MESSAGE);
				}
				else if(judgeNum(strBase) && judgeNum(strHeight)) {
					double base = Double.parseDouble(strBase);
					double height = Double.parseDouble(strHeight);
					rightTriangle = new RightTriangle(base, height);
					Jlb_perimeter.setText("<html>此直角三角形周長為：<br/>" + rightTriangle.computePerimeter() + "</html>");
					Jlb_area.setText("<html>此直角三角形面積為：<br/>" + rightTriangle.computeArea() + "</html>");
				}
				else {
					JOptionPane.showMessageDialog(new JFrame(), "輸入必須為數字", "直角三角形", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
        
        //設定清空按鈕大小位置及顯示字型
        Jbtn_clean.setLocation(348,185);
        Jbtn_clean.setSize(89,33);
        Jbtn_clean.setFont(new Font("微軟正黑體", Font.BOLD, 22));
        c.add(Jbtn_clean);
        Jbtn_clean.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Jlb_perimeter.setText("<html>此直角三角形周長為：</html>");
				Jlb_area.setText("<html>此直角三角形面積為：</html>");
				jBase.setText("");
				jHeight.setText("");
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
