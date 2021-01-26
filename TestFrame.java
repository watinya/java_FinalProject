import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TestFrame extends JFrame{
	private JButton Jbtn_return = new JButton("返回主選單");
	private JComboBox<String> jcb_shape = new JComboBox<String>();
	private JLabel Jlb_shape = new JLabel();
	private JLabel Jlb_title = new JLabel();
	private JButton Jbtn_how = new JButton("？");
	private JLabel Jlb_area = new JLabel("面積：");
	private JLabel Jlb_perimeter = new JLabel("周長：");
	private JTextField jArea = new JTextField();
    private JTextField jPerimeter = new JTextField();
    private JButton Jbtn_confirm = new JButton("確認");
    private JButton Jbtn_clean = new JButton("清空");
    private JLabel Jlb_hint = new JLabel("如有小數點需取至小數點後第二位");
    private JButton Jbtn_next = new JButton("下一題");
    private JLabel Jlb_score = new JLabel();
    private JLabel Jlb_result = new JLabel();
    
    Rectangle rectangle = new Rectangle();
    Triangle regularTriangle = new RegularTriangle();
    Triangle rightTriangle = new RightTriangle();
	Circle circle = new Circle();
	String doubleArea, doublePerimeter;
	String intArea, intPerimeter;
	int score = 0;
    
    TestFrame() {
    	Container c = getContentPane();
        c.setLayout(null);
        
        setTitle("矩形");
		setSize(600, 600);
		setLocationRelativeTo(null);//視窗置中
		setResizable(false);//視窗放大按鈕無效
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//設定圖形選單標籤大小位置及顯示字型
		Jlb_shape.setLocation(186,12);
		Jlb_shape.setSize(65,41);
		Jlb_shape.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		Jlb_shape.setText("形狀：");
        c.add(Jlb_shape);
		
		//設定選單大小位置及顯示字型
		jcb_shape.addItem("請選擇");
		jcb_shape.addItem("矩形");
		jcb_shape.addItem("正三角形");
		jcb_shape.addItem("直角三角形");
		jcb_shape.addItem("圓形");
		jcb_shape.setLocation(247, 13);
		jcb_shape.setSize(152, 36);
		jcb_shape.setFont(new Font("微軟正黑體",Font.BOLD,22));
		jcb_shape.addItemListener(new ItemListener() {
    		@Override
    		public void itemStateChanged(ItemEvent e) {
    			if(e.getStateChange() == ItemEvent.SELECTED){
    				judgeShape();
    				jArea.setText("");
    				jPerimeter.setText("");
    				Jbtn_confirm.setEnabled(true);
    				Jbtn_clean.setEnabled(true);
    				Jlb_result.setVisible(false);
    				Jbtn_next.setVisible(false);
    			} 
    		}
    	});
        c.add(jcb_shape);
		
        //設定玩法介紹大小位置及顯示字型
        Jbtn_how.setLocation(517,12);
        Jbtn_how.setSize(63,41);
        Jbtn_how.setFont(new Font("微軟正黑體", Font.BOLD, 28));
        c.add(Jbtn_how);
        Jbtn_how.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(new JFrame(), "從選單選出想要測驗的形狀\n根據題目計算並輸入\n按下確認查看答案是否正確", "測驗使用方法", JOptionPane.INFORMATION_MESSAGE);
			}
		});
        
		//設定題目大小位置及顯示字型
        Jlb_title.setLocation(14,77);
        Jlb_title.setSize(566,58);
        Jlb_title.setFont(new Font("微軟正黑體", Font.BOLD, 36));
        c.add(Jlb_title);
        
        //設定面積標籤大小位置及顯示字型
        Jlb_area.setLocation(24,174);
        Jlb_area.setSize(99,47);
        Jlb_area.setFont(new Font("微軟正黑體", Font.BOLD, 30));
        c.add(Jlb_area);
        
        //設定周長標籤大小位置及顯示字型
        Jlb_perimeter.setLocation(24,132);
        Jlb_perimeter.setSize(99,47);
        Jlb_perimeter.setFont(new Font("微軟正黑體", Font.BOLD, 30));
        c.add(Jlb_perimeter);
        
        //設定面積輸入框大小位置及顯示字型
        jArea.setLocation(117,184);
        jArea.setSize(152,33);
        jArea.setFont(new Font("微軟正黑體", Font.BOLD, 24));
        c.add(jArea);
        
        //設定周長輸入框大小位置及顯示字型
        jPerimeter.setLocation(117,142);
        jPerimeter.setSize(152,33);
        jPerimeter.setFont(new Font("微軟正黑體", Font.BOLD, 24));
        c.add(jPerimeter);
            
        //設定提示大小位置及顯示字型
        Jlb_hint.setLocation(34,217);
        Jlb_hint.setSize(299,33);
        Jlb_hint.setForeground(new Color(255, 0, 0));
        Jlb_hint.setFont(new Font("微軟正黑體", Font.BOLD, 18));
        c.add(Jlb_hint);
        
        //設定成績大小位置及顯示字型
        Jlb_score.setLocation(14,511);
        Jlb_score.setSize(177,41);
        Jlb_score.setForeground(new Color(65, 105, 225));
        Jlb_score.setFont(new Font("微軟正黑體", Font.BOLD, 20));
        Jlb_score.setText("答對題數：" + score);
        c.add(Jlb_score);
        
        //設定結果標籤大小位置及顯示字型
        Jlb_result.setLocation(31,256);
        Jlb_result.setSize(385,172);
        Jlb_result.setVisible(false);
        Jlb_result.setVerticalAlignment(SwingConstants.TOP);
        Jlb_result.setForeground(new Color(255, 0, 0));
        Jlb_result.setFont(new Font("微軟正黑體", Font.BOLD, 26));
        c.add(Jlb_result);
        
        //設定確認按鈕大小位置及顯示字型
        Jbtn_confirm.setLocation(294,185);
        Jbtn_confirm.setSize(89,33);
        Jbtn_confirm.setFont(new Font("微軟正黑體", Font.BOLD, 22));
        c.add(Jbtn_confirm);
        Jbtn_confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String area = jArea.getText();
				String perimeter = jPerimeter.getText();
				if(jcb_shape.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(new JFrame(), "請選擇形狀", "測驗", JOptionPane.ERROR_MESSAGE);
				}
				else if(area.equals("") || perimeter.equals("")) {
					JOptionPane.showMessageDialog(new JFrame(), "答案不可為空", "測驗", JOptionPane.ERROR_MESSAGE);
				}
				else if(judgeNum(area) && judgeNum(perimeter)) {
					if((area.equals(doubleArea) || area.equals(intArea)) && (perimeter.equals(doublePerimeter) || perimeter.equals(intPerimeter))) {
						Jlb_result.setText("恭喜你，答對了！");
						Jlb_result.setVisible(true);
						Jlb_score.setText("答對題數：" + ++score);
					}
					else {
						Jlb_result.setText("<html>噢不，你答錯了！<br/>正確答案為：<br/>  周長："+doublePerimeter+"<br/>  面積："+doubleArea+"</html>");
						Jlb_result.setVisible(true);
					}
					Jbtn_next.setVisible(true);
					Jbtn_confirm.setEnabled(false);
					Jbtn_clean.setEnabled(false);
				}
				else {
					JOptionPane.showMessageDialog(new JFrame(), "答案必須為數字", "測驗", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
        
        //設定下一題按鈕大小位置及顯示字型
        Jbtn_next.setVisible(false);
        Jbtn_next.setLocation(457,498);
        Jbtn_next.setSize(123,54);
        Jbtn_next.setFont(new Font("微軟正黑體", Font.BOLD, 22));
        c.add(Jbtn_next);
        Jbtn_next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				judgeShape();
				jArea.setText("");
				jPerimeter.setText("");
				Jbtn_confirm.setEnabled(true);
				Jbtn_clean.setEnabled(true);
				Jlb_result.setVisible(false);
				Jbtn_next.setVisible(false);
			}
		});
        
        //設定清空按鈕大小位置及顯示字型
        Jbtn_clean.setLocation(395,185);
        Jbtn_clean.setSize(89,33);
        Jbtn_clean.setFont(new Font("微軟正黑體", Font.BOLD, 22));
        c.add(Jbtn_clean);
        Jbtn_clean.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jArea.setText("");
				jPerimeter.setText("");
				Jlb_result.setVisible(false);
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
	
	//判斷使用者選擇的形狀，並記錄面積和周長答案
	public void judgeShape() {
		String selectedShape = (String) jcb_shape.getSelectedItem();
		switch(selectedShape) {
        case "矩形":
        	Jlb_title.setText(rectangle.getQuestion());
        	doubleArea = rectangle.computeArea();
        	doublePerimeter = rectangle.computePerimeter();
        	break;
        case "正三角形":
        	Jlb_title.setText(regularTriangle.getQuestion());
        	doubleArea = regularTriangle.computeArea();
        	doublePerimeter = regularTriangle.computePerimeter();
        	break;
        case "直角三角形":
        	Jlb_title.setText(rightTriangle.getQuestion());
        	doubleArea = rightTriangle.computeArea();
        	doublePerimeter = rightTriangle.computePerimeter();
        	break;
        case "圓形":
        	Jlb_title.setText(circle.getQuestion());
        	doubleArea = circle.computeArea();
        	doublePerimeter = circle.computePerimeter();
        	break;
        }
		
		//去除小數點後的數
		intArea = doubleArea.substring(0, doubleArea.length()-3);
		intPerimeter = doublePerimeter.substring(0, doublePerimeter.length()-3);
	}
}
