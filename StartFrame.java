import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class StartFrame extends JFrame{
	private JLabel Jlb_title = new JLabel("�ϧΪ��h��");
    private JButton Jbtn_rightTriangle = new JButton("�����T����");
    private JButton Jbtn_circle = new JButton("���");
    private JButton Jbtn_rectangle = new JButton("�x��");
    private JButton Jbtn_regularTriangle = new JButton("���T����");
    private JButton Jbtn_test = new JButton("����");
    
    StartFrame() {
    	Container c = getContentPane();
    	c.setBackground(new Color(173, 216, 230));
        c.setLayout(null);
        
        setTitle("�ϧΪ��h��");
		setSize(600, 600);
		setLocationRelativeTo(null);//�����m��
		setResizable(false);//������j���s�L��
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//�]�w���D�j�p��m����ܦr��
        Jlb_title.setLocation(194,48);
        Jlb_title.setSize(206,63);
        Jlb_title.setFont(new Font("�L�n������", Font.BOLD, 38));
        c.add(Jlb_title);
        
        //�]�w�����T���Ϋ��s�j�p��m����ܦr��
        Jbtn_rightTriangle.setLocation(157,309);
        Jbtn_rightTriangle.setSize(280,57);
        Jbtn_rightTriangle.setFont(new Font("�L�n������", Font.BOLD, 24));
        c.add(Jbtn_rightTriangle);
        Jbtn_rightTriangle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new RightTriangleFrame();
			}
		});
		
		//�]�w��Ϋ��s�j�p��m����ܦr��
		Jbtn_circle.setLocation(157,391);
		Jbtn_circle.setSize(280,57);
		Jbtn_circle.setFont(new Font("�L�n������", Font.BOLD, 24));
        c.add(Jbtn_circle);
        Jbtn_circle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new CircleFrame();
			}
		});
		
		 //�]�w�x�Ϋ��s�j�p��m����ܦr��
        Jbtn_rectangle.setLocation(157,145);
        Jbtn_rectangle.setSize(280,57);
        Jbtn_rectangle.setFont(new Font("�L�n������", Font.BOLD, 24));
        c.add(Jbtn_rectangle);
        Jbtn_rectangle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new RectangleFrame();
			}
		});
		
		//�]�w���T���Ϋ��s�j�p��m����ܦr��
        Jbtn_regularTriangle.setLocation(157,227);
        Jbtn_regularTriangle.setSize(280,57);
        Jbtn_regularTriangle.setFont(new Font("�L�n������", Font.BOLD, 24));
        c.add(Jbtn_regularTriangle);
        Jbtn_regularTriangle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new RegularTriangleFrame();
			}
		});
        
        //�]�w������s�j�p��m����ܦr��
        Jbtn_test.setLocation(157,473);
        Jbtn_test.setSize(280,57);
        Jbtn_test.setFont(new Font("�L�n������", Font.BOLD, 24));
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
