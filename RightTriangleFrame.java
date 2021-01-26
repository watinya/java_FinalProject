import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class RightTriangleFrame extends JFrame{
	private JButton Jbtn_return = new JButton("��^�D���");
	private JLabel Jlb_title = new JLabel();
	private JLabel Jlb_info = new JLabel();
	private JLabel Jlb_base = new JLabel("���G");
	private JLabel Jlb_height = new JLabel("���G");
	private JTextField jBase = new JTextField();
    private JTextField jHeight = new JTextField();
    private JButton Jbtn_count = new JButton("�p��");
    private JButton Jbtn_clean = new JButton("�M��");
    private JLabel Jlb_area = new JLabel("<html>�������T���έ��n���G</html>");
    private JLabel Jlb_perimeter = new JLabel("<html>�������T���ΩP�����G</html>");
    private Triangle rightTriangle = new RightTriangle();
    
    RightTriangleFrame() {
    	Container c = getContentPane();
        c.setLayout(null);
        
        setTitle("�����T����");
		setSize(600, 600);
		setLocationRelativeTo(null);//�����m��
		setResizable(false);//������j���s�L��
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//�]�w���D�j�p��m����ܦr��
        Jlb_title.setLocation(14,77);
        Jlb_title.setSize(196,58);
        Jlb_title.setFont(new Font("�L�n������", Font.BOLD, 36));
        Jlb_title.setText(rightTriangle.getShapeName());
        c.add(Jlb_title);
        
        //�]�w���Фj�p��m����ܦr��
        Jlb_info.setLocation(369,13);
        Jlb_info.setSize(211,122);
        Icon image = new ImageIcon("image//�����T����.png");
        Jlb_info.setIcon(image);
        c.add(Jlb_info);
        
        //�]�w�����Ҥj�p��m����ܦr��
        Jlb_base.setLocation(24,132);
        Jlb_base.setSize(60,47);
        Jlb_base.setFont(new Font("�L�n������", Font.BOLD, 30));
        c.add(Jlb_base);
        
        //�]�w�����Ҥj�p��m����ܦr��
        Jlb_height.setLocation(24,174);
        Jlb_height.setSize(60,47);
        Jlb_height.setFont(new Font("�L�n������", Font.BOLD, 30));
        c.add(Jlb_height);
        
        //�]�w����J�ؤj�p��m����ܦr��
        jBase.setLocation(84,140);
        jBase.setSize(152,33);
        jBase.setFont(new Font("�L�n������", Font.BOLD, 24));
        c.add(jBase);
        
        //�]�w����J�ؤj�p��m����ܦr��
        jHeight.setLocation(84,182);
        jHeight.setSize(152,33);
        jHeight.setFont(new Font("�L�n������", Font.BOLD, 24));
        c.add(jHeight);
        
        //�]�w�P�����G���Ҥj�p��m����ܦr��
        Jlb_perimeter.setLocation(24,246);
        Jlb_perimeter.setSize(556,70);
        Jlb_perimeter.setFont(new Font("�L�n������", Font.BOLD, 28));
        Jlb_perimeter.setVerticalTextPosition(SwingConstants.TOP);
        c.add(Jlb_perimeter);
        
        //�]�w���n���G���Ҥj�p��m����ܦr��
        Jlb_area.setLocation(24,329);
        Jlb_area.setSize(556,70);
        Jlb_area.setFont(new Font("�L�n������", Font.BOLD, 28));
        Jlb_area.setVerticalTextPosition(SwingConstants.TOP);
        c.add(Jlb_area);
        
        //�]�w�p����s�j�p��m����ܦr��
        Jbtn_count.setLocation(250,185);
        Jbtn_count.setSize(89,33);
        Jbtn_count.setFont(new Font("�L�n������", Font.BOLD, 22));
        c.add(Jbtn_count);
        Jbtn_count.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String strBase = jBase.getText();
				String strHeight = jHeight.getText();
				if(strBase.equals("") || strHeight.equals("")) {
					JOptionPane.showMessageDialog(new JFrame(), "��J�ؤ��i����", "�����T����", JOptionPane.ERROR_MESSAGE);
				}
				else if(judgeNum(strBase) && judgeNum(strHeight)) {
					double base = Double.parseDouble(strBase);
					double height = Double.parseDouble(strHeight);
					rightTriangle = new RightTriangle(base, height);
					Jlb_perimeter.setText("<html>�������T���ΩP�����G<br/>" + rightTriangle.computePerimeter() + "</html>");
					Jlb_area.setText("<html>�������T���έ��n���G<br/>" + rightTriangle.computeArea() + "</html>");
				}
				else {
					JOptionPane.showMessageDialog(new JFrame(), "��J�������Ʀr", "�����T����", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
        
        //�]�w�M�ū��s�j�p��m����ܦr��
        Jbtn_clean.setLocation(348,185);
        Jbtn_clean.setSize(89,33);
        Jbtn_clean.setFont(new Font("�L�n������", Font.BOLD, 22));
        c.add(Jbtn_clean);
        Jbtn_clean.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Jlb_perimeter.setText("<html>�������T���ΩP�����G</html>");
				Jlb_area.setText("<html>�������T���έ��n���G</html>");
				jBase.setText("");
				jHeight.setText("");
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
