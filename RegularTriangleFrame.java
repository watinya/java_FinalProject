import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class RegularTriangleFrame extends JFrame{
	private JButton Jbtn_return = new JButton("��^�D���");
	private JLabel Jlb_title = new JLabel();
	private JLabel Jlb_info = new JLabel();
	private JLabel Jlb_sideLength = new JLabel("����G");
	private JTextField jSideLength = new JTextField();
    private JButton Jbtn_count = new JButton("�p��");
    private JButton Jbtn_clean = new JButton("�M��");
    private JLabel Jlb_height = new JLabel("<html>�����T���ΰ����G</html>");
    private JLabel Jlb_area = new JLabel("<html>�����T���έ��n���G</html>");
    private JLabel Jlb_perimeter = new JLabel("<html>�����T���ΩP�����G</html>");
    private Triangle regularTriangle = new RegularTriangle();
    
    RegularTriangleFrame() {
    	Container c = getContentPane();
        c.setLayout(null);
        
        setTitle("���T����");
		setSize(600, 600);
		setLocationRelativeTo(null);//�����m��
		setResizable(false);//������j���s�L��
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//�]�w���D�j�p��m����ܦr��
        Jlb_title.setLocation(14,77);
        Jlb_title.setSize(196,58);
        Jlb_title.setFont(new Font("�L�n������", Font.BOLD, 36));
        Jlb_title.setText(regularTriangle.getShapeName());
        c.add(Jlb_title);
        
        //�]�w���Фj�p��m����ܦr��
        Jlb_info.setLocation(369,13);
        Jlb_info.setSize(211,122);
        Icon image = new ImageIcon("image//���T����.png");
        Jlb_info.setIcon(image);
        c.add(Jlb_info);
        
        //�]�w������Ҥj�p��m����ܦr��
        Jlb_sideLength.setLocation(24,132);
        Jlb_sideLength.setSize(102,47);
        Jlb_sideLength.setFont(new Font("�L�n������", Font.BOLD, 30));
        c.add(Jlb_sideLength);
               
        //�]�w�����J�ؤj�p��m����ܦr��
        jSideLength.setLocation(113,142);
        jSideLength.setSize(152,33);
        jSideLength.setFont(new Font("�L�n������", Font.BOLD, 24));
        c.add(jSideLength);
        
        //�]�w�����G���Ҥj�p��m����ܦr��
        Jlb_height.setLocation(24,192);
        Jlb_height.setSize(556,70);
        Jlb_height.setFont(new Font("�L�n������", Font.BOLD, 28));
        Jlb_height.setVerticalTextPosition(SwingConstants.TOP);
        c.add(Jlb_height);
        
        //�]�w�P�����G���Ҥj�p��m����ܦr��
        Jlb_perimeter.setLocation(24,275);
        Jlb_perimeter.setSize(556,70);
        Jlb_perimeter.setFont(new Font("�L�n������", Font.BOLD, 28));
        Jlb_perimeter.setVerticalTextPosition(SwingConstants.TOP);
        c.add(Jlb_perimeter);
        
        //�]�w���n���G���Ҥj�p��m����ܦr��
        Jlb_area.setLocation(24,358);
        Jlb_area.setSize(556,70);
        Jlb_area.setFont(new Font("�L�n������", Font.BOLD, 28));
        Jlb_area.setVerticalTextPosition(SwingConstants.TOP);
        c.add(Jlb_area);
        
        //�]�w�p����s�j�p��m����ܦr��
        Jbtn_count.setLocation(275,143);
        Jbtn_count.setSize(89,33);
        Jbtn_count.setFont(new Font("�L�n������", Font.BOLD, 22));
        c.add(Jbtn_count);
        Jbtn_count.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String strBaseLength = jSideLength.getText();
				if(strBaseLength.equals("")) {
					JOptionPane.showMessageDialog(new JFrame(), "��J�ؤ��i����", "���T����", JOptionPane.ERROR_MESSAGE);
				}
				else if(judgeNum(strBaseLength)) {
					double sideLength = Double.parseDouble(strBaseLength);
					regularTriangle = new RegularTriangle(sideLength);
					Jlb_height.setText("<html>�����T���ΰ����G<br/>" + regularTriangle.computeHeight() + "</html>");
					Jlb_perimeter.setText("<html>�����T���ΩP�����G<br/>" + regularTriangle.computePerimeter() + "</html>");
					Jlb_area.setText("<html>�����T���έ��n���G<br/>" + regularTriangle.computeArea() + "</html>");
				}
				else {
					JOptionPane.showMessageDialog(new JFrame(), "��J�������Ʀr", "���T����", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
        
        //�]�w�M�ū��s�j�p��m����ܦr��
        Jbtn_clean.setLocation(374,143);
        Jbtn_clean.setSize(89,33);
        Jbtn_clean.setFont(new Font("�L�n������", Font.BOLD, 22));
        c.add(Jbtn_clean);
        Jbtn_clean.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Jlb_height.setText("<html>�����T���ΰ����G</html>");
				Jlb_perimeter.setText("<html>�����T���ΩP�����G</html>");
				Jlb_area.setText("<html>�����T���έ��n���G</html>");
				jSideLength.setText("");
			}
		});
        
        //�]�w��^�D�����s�j�p��m����ܦr��
        Jbtn_return.setLocation(14,13);
        Jbtn_return.setSize(130,33);
        Jbtn_return.setFont(new Font("�L�n������", Font.BOLD, 18));
        c.add(Jbtn_return);
        Jbtn_return.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new StartFrame();
			}
		});
    }
    
    //�P�_��J�O�_���Ʀr
  	public boolean judgeNum(String msg) {
  		try {
  			Double.parseDouble(msg);
  			return true;
  		} catch (Exception e) {
  			return false;
  		}
  	}
}
