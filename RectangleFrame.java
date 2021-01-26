import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class RectangleFrame extends JFrame{
	private JButton Jbtn_return = new JButton("��^�D���");
	private JLabel Jlb_title = new JLabel();
	private JLabel Jlb_info = new JLabel();
	private JLabel Jlb_length = new JLabel("���G");
	private JLabel Jlb_width = new JLabel("�e�G");
	private JTextField jLength = new JTextField();
    private JTextField jWidth = new JTextField();
    private JButton Jbtn_count = new JButton("�p��");
    private JButton Jbtn_clean = new JButton("�M��");
    private JLabel Jlb_area = new JLabel("<html>���x�έ��n���G</html>");
    private JLabel Jlb_perimeter = new JLabel("<html>���x�ΩP�����G</html>");
    private Shape rectangle = new Rectangle();
    
    RectangleFrame() {
    	Container c = getContentPane();
        c.setLayout(null);
        
        setTitle("�x��");
		setSize(600, 600);
		setLocationRelativeTo(null);//�����m��
		setResizable(false);//������j���s�L��
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//�]�w���D�j�p��m����ܦr��
        Jlb_title.setLocation(14,77);
        Jlb_title.setSize(89,58);
        Jlb_title.setFont(new Font("�L�n������", Font.BOLD, 36));
        Jlb_title.setText(rectangle.getShapeName());
        c.add(Jlb_title);
        
        //�]�w���Фj�p��m����ܦr��
        Jlb_info.setLocation(369,13);
        Jlb_info.setSize(211,122);
        Icon image = new ImageIcon("image//�x��.png");
        Jlb_info.setIcon(image);
        c.add(Jlb_info);
        
        //�]�w�����Ҥj�p��m����ܦr��
        Jlb_length.setLocation(24,132);
        Jlb_length.setSize(60,47);
        Jlb_length.setFont(new Font("�L�n������", Font.BOLD, 30));
        c.add(Jlb_length);
        
        //�]�w�e���Ҥj�p��m����ܦr��
        Jlb_width.setLocation(24,174);
        Jlb_width.setSize(60,47);
        Jlb_width.setFont(new Font("�L�n������", Font.BOLD, 30));
        c.add(Jlb_width);
        
        //�]�w����J�ؤj�p��m����ܦr��
        jLength.setLocation(84,140);
        jLength.setSize(152,33);
        jLength.setFont(new Font("�L�n������", Font.BOLD, 24));
        c.add(jLength);
        
        //�]�w�e��J�ؤj�p��m����ܦr��
        jWidth.setLocation(84,182);
        jWidth.setSize(152,33);
        jWidth.setFont(new Font("�L�n������", Font.BOLD, 24));
        c.add(jWidth);
        
        //�]�w�P�����G���Ҥj�p��m����ܦr��
        Jlb_perimeter.setLocation(24,246);
        Jlb_perimeter.setSize(556,70);
        Jlb_perimeter.setFont(new Font("�L�n������", Font.BOLD, 28));
        c.add(Jlb_perimeter);
        
        //�]�w���n���G���Ҥj�p��m����ܦr��
        Jlb_area.setLocation(24,329);
        Jlb_area.setSize(556,70);
        Jlb_area.setFont(new Font("�L�n������", Font.BOLD, 28));
        c.add(Jlb_area);
        
        //�]�w�p����s�j�p��m����ܦr��
        Jbtn_count.setLocation(250,185);
        Jbtn_count.setSize(89,33);
        Jbtn_count.setFont(new Font("�L�n������", Font.BOLD, 22));
        c.add(Jbtn_count);
        Jbtn_count.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String strWidth = jWidth.getText();
				String strLength = jLength.getText();
				if(strWidth.equals("") || strLength.equals("")) {
					JOptionPane.showMessageDialog(new JFrame(), "��J�ؤ��i����", "�x��", JOptionPane.ERROR_MESSAGE);
				}
				else if(judgeNum(strWidth) && judgeNum(strLength)) {
					double width = Double.parseDouble(strWidth);
					double length = Double.parseDouble(strLength);
					rectangle = new Rectangle(width, length);
					Jlb_perimeter.setText("<html>���x�ΩP�����G<br/>" + rectangle.computePerimeter() + "</html>");
					Jlb_area.setText("<html>���x�έ��n���G<br/>" + rectangle.computeArea() + "</html>");
				}
				else {
					JOptionPane.showMessageDialog(new JFrame(), "��J�������Ʀr", "�x��", JOptionPane.ERROR_MESSAGE);
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
				Jlb_perimeter.setText("<html>���x�ΩP�����G</html>");
				Jlb_area.setText("<html>���x�έ��n���G</html>");
				jLength.setText("");
				jWidth.setText("");
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
