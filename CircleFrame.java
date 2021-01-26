import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CircleFrame extends JFrame{
	private JButton Jbtn_return = new JButton("��^�D���");
	private JLabel Jlb_title = new JLabel();
	private JLabel Jlb_info = new JLabel();
	private JLabel Jlb_radius = new JLabel("�b�|�G");
	private JTextField jRadius = new JTextField();
    private JButton Jbtn_count = new JButton("�p��");
    private JButton Jbtn_clean = new JButton("�M��");
    private JLabel Jlb_area = new JLabel("<html>����έ��n���G</html>");
    private JLabel Jlb_perimeter = new JLabel("<html>����ΩP�����G</html>");
    private Shape circle = new Circle();
    
    CircleFrame() {
    	Container c = getContentPane();
        c.setLayout(null);
        
        setTitle("���");
		setSize(600, 600);
		setLocationRelativeTo(null);//�����m��
		setResizable(false);//������j���s�L��
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//�]�w���D�j�p��m����ܦr��
        Jlb_title.setLocation(14,77);
        Jlb_title.setSize(89,58);
        Jlb_title.setFont(new Font("�L�n������", Font.BOLD, 36));
        Jlb_title.setText(circle.getShapeName());
        c.add(Jlb_title);
        
        //�]�w���Фj�p��m����ܦr��
        Jlb_info.setLocation(369,13);
        Jlb_info.setSize(211,122);
        Icon image = new ImageIcon("image//���.png");
        Jlb_info.setIcon(image);
        c.add(Jlb_info);
        
        //�]�w�b�|���Ҥj�p��m����ܦr��
        Jlb_radius.setLocation(24,132);
        Jlb_radius.setSize(95,47);
        Jlb_radius.setFont(new Font("�L�n������", Font.BOLD, 30));
        c.add(Jlb_radius);
                
        //�]�w�b�|��J�ؤj�p��m����ܦr��
        jRadius.setLocation(115,142);
        jRadius.setSize(152,33);
        jRadius.setFont(new Font("�L�n������", Font.BOLD, 24));
        c.add(jRadius);
        
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
        Jbtn_count.setLocation(281,143);
        Jbtn_count.setSize(89,33);
        Jbtn_count.setFont(new Font("�L�n������", Font.BOLD, 22));
        c.add(Jbtn_count);
        Jbtn_count.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String strRadius = jRadius.getText();
				if(strRadius.equals("")) {
					JOptionPane.showMessageDialog(new JFrame(), "��J�ؤ��i����", "���", JOptionPane.ERROR_MESSAGE);
				}
				else if(judgeNum(strRadius)) {
					double radius = Double.parseDouble(strRadius);
					circle = new Circle(radius);
					Jlb_perimeter.setText("<html>����ΩP�����G<br/>" + circle.computePerimeter() + "</html>");
					Jlb_area.setText("<html>����έ��n���G<br/>" + circle.computeArea() + "</html>");
				}
				else {
					JOptionPane.showMessageDialog(new JFrame(), "��J�������Ʀr", "���", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
        
        //�]�w�M�ū��s�j�p��m����ܦr��
        Jbtn_clean.setLocation(384,143);
        Jbtn_clean.setSize(89,33);
        Jbtn_clean.setFont(new Font("�L�n������", Font.BOLD, 22));
        c.add(Jbtn_clean);
        Jbtn_clean.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Jlb_perimeter.setText("<html>����ΩP�����G</html>");
				Jlb_area.setText("<html>����έ��n���G</html>");
				jRadius.setText("");
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
