import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TestFrame extends JFrame{
	private JButton Jbtn_return = new JButton("��^�D���");
	private JComboBox<String> jcb_shape = new JComboBox<String>();
	private JLabel Jlb_shape = new JLabel();
	private JLabel Jlb_title = new JLabel();
	private JButton Jbtn_how = new JButton("�H");
	private JLabel Jlb_area = new JLabel("���n�G");
	private JLabel Jlb_perimeter = new JLabel("�P���G");
	private JTextField jArea = new JTextField();
    private JTextField jPerimeter = new JTextField();
    private JButton Jbtn_confirm = new JButton("�T�{");
    private JButton Jbtn_clean = new JButton("�M��");
    private JLabel Jlb_hint = new JLabel("�p���p���I�ݨ��ܤp���I��ĤG��");
    private JButton Jbtn_next = new JButton("�U�@�D");
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
        
        setTitle("�x��");
		setSize(600, 600);
		setLocationRelativeTo(null);//�����m��
		setResizable(false);//������j���s�L��
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//�]�w�ϧο����Ҥj�p��m����ܦr��
		Jlb_shape.setLocation(186,12);
		Jlb_shape.setSize(65,41);
		Jlb_shape.setFont(new Font("�L�n������", Font.BOLD, 20));
		Jlb_shape.setText("�Ϊ��G");
        c.add(Jlb_shape);
		
		//�]�w���j�p��m����ܦr��
		jcb_shape.addItem("�п��");
		jcb_shape.addItem("�x��");
		jcb_shape.addItem("���T����");
		jcb_shape.addItem("�����T����");
		jcb_shape.addItem("���");
		jcb_shape.setLocation(247, 13);
		jcb_shape.setSize(152, 36);
		jcb_shape.setFont(new Font("�L�n������",Font.BOLD,22));
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
		
        //�]�w���k���Фj�p��m����ܦr��
        Jbtn_how.setLocation(517,12);
        Jbtn_how.setSize(63,41);
        Jbtn_how.setFont(new Font("�L�n������", Font.BOLD, 28));
        c.add(Jbtn_how);
        Jbtn_how.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(new JFrame(), "�q����X�Q�n���窺�Ϊ�\n�ھ��D�حp��ÿ�J\n���U�T�{�d�ݵ��׬O�_���T", "����ϥΤ�k", JOptionPane.INFORMATION_MESSAGE);
			}
		});
        
		//�]�w�D�ؤj�p��m����ܦr��
        Jlb_title.setLocation(14,77);
        Jlb_title.setSize(566,58);
        Jlb_title.setFont(new Font("�L�n������", Font.BOLD, 36));
        c.add(Jlb_title);
        
        //�]�w���n���Ҥj�p��m����ܦr��
        Jlb_area.setLocation(24,174);
        Jlb_area.setSize(99,47);
        Jlb_area.setFont(new Font("�L�n������", Font.BOLD, 30));
        c.add(Jlb_area);
        
        //�]�w�P�����Ҥj�p��m����ܦr��
        Jlb_perimeter.setLocation(24,132);
        Jlb_perimeter.setSize(99,47);
        Jlb_perimeter.setFont(new Font("�L�n������", Font.BOLD, 30));
        c.add(Jlb_perimeter);
        
        //�]�w���n��J�ؤj�p��m����ܦr��
        jArea.setLocation(117,184);
        jArea.setSize(152,33);
        jArea.setFont(new Font("�L�n������", Font.BOLD, 24));
        c.add(jArea);
        
        //�]�w�P����J�ؤj�p��m����ܦr��
        jPerimeter.setLocation(117,142);
        jPerimeter.setSize(152,33);
        jPerimeter.setFont(new Font("�L�n������", Font.BOLD, 24));
        c.add(jPerimeter);
            
        //�]�w���ܤj�p��m����ܦr��
        Jlb_hint.setLocation(34,217);
        Jlb_hint.setSize(299,33);
        Jlb_hint.setForeground(new Color(255, 0, 0));
        Jlb_hint.setFont(new Font("�L�n������", Font.BOLD, 18));
        c.add(Jlb_hint);
        
        //�]�w���Z�j�p��m����ܦr��
        Jlb_score.setLocation(14,511);
        Jlb_score.setSize(177,41);
        Jlb_score.setForeground(new Color(65, 105, 225));
        Jlb_score.setFont(new Font("�L�n������", Font.BOLD, 20));
        Jlb_score.setText("�����D�ơG" + score);
        c.add(Jlb_score);
        
        //�]�w���G���Ҥj�p��m����ܦr��
        Jlb_result.setLocation(31,256);
        Jlb_result.setSize(385,172);
        Jlb_result.setVisible(false);
        Jlb_result.setVerticalAlignment(SwingConstants.TOP);
        Jlb_result.setForeground(new Color(255, 0, 0));
        Jlb_result.setFont(new Font("�L�n������", Font.BOLD, 26));
        c.add(Jlb_result);
        
        //�]�w�T�{���s�j�p��m����ܦr��
        Jbtn_confirm.setLocation(294,185);
        Jbtn_confirm.setSize(89,33);
        Jbtn_confirm.setFont(new Font("�L�n������", Font.BOLD, 22));
        c.add(Jbtn_confirm);
        Jbtn_confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String area = jArea.getText();
				String perimeter = jPerimeter.getText();
				if(jcb_shape.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(new JFrame(), "�п�ܧΪ�", "����", JOptionPane.ERROR_MESSAGE);
				}
				else if(area.equals("") || perimeter.equals("")) {
					JOptionPane.showMessageDialog(new JFrame(), "���פ��i����", "����", JOptionPane.ERROR_MESSAGE);
				}
				else if(judgeNum(area) && judgeNum(perimeter)) {
					if((area.equals(doubleArea) || area.equals(intArea)) && (perimeter.equals(doublePerimeter) || perimeter.equals(intPerimeter))) {
						Jlb_result.setText("���ߧA�A����F�I");
						Jlb_result.setVisible(true);
						Jlb_score.setText("�����D�ơG" + ++score);
					}
					else {
						Jlb_result.setText("<html>�����A�A�����F�I<br/>���T���׬��G<br/>  �P���G"+doublePerimeter+"<br/>  ���n�G"+doubleArea+"</html>");
						Jlb_result.setVisible(true);
					}
					Jbtn_next.setVisible(true);
					Jbtn_confirm.setEnabled(false);
					Jbtn_clean.setEnabled(false);
				}
				else {
					JOptionPane.showMessageDialog(new JFrame(), "���ץ������Ʀr", "����", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
        
        //�]�w�U�@�D���s�j�p��m����ܦr��
        Jbtn_next.setVisible(false);
        Jbtn_next.setLocation(457,498);
        Jbtn_next.setSize(123,54);
        Jbtn_next.setFont(new Font("�L�n������", Font.BOLD, 22));
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
        
        //�]�w�M�ū��s�j�p��m����ܦr��
        Jbtn_clean.setLocation(395,185);
        Jbtn_clean.setSize(89,33);
        Jbtn_clean.setFont(new Font("�L�n������", Font.BOLD, 22));
        c.add(Jbtn_clean);
        Jbtn_clean.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jArea.setText("");
				jPerimeter.setText("");
				Jlb_result.setVisible(false);
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
	
	//�P�_�ϥΪ̿�ܪ��Ϊ��A�ðO�����n�M�P������
	public void judgeShape() {
		String selectedShape = (String) jcb_shape.getSelectedItem();
		switch(selectedShape) {
        case "�x��":
        	Jlb_title.setText(rectangle.getQuestion());
        	doubleArea = rectangle.computeArea();
        	doublePerimeter = rectangle.computePerimeter();
        	break;
        case "���T����":
        	Jlb_title.setText(regularTriangle.getQuestion());
        	doubleArea = regularTriangle.computeArea();
        	doublePerimeter = regularTriangle.computePerimeter();
        	break;
        case "�����T����":
        	Jlb_title.setText(rightTriangle.getQuestion());
        	doubleArea = rightTriangle.computeArea();
        	doublePerimeter = rightTriangle.computePerimeter();
        	break;
        case "���":
        	Jlb_title.setText(circle.getQuestion());
        	doubleArea = circle.computeArea();
        	doublePerimeter = circle.computePerimeter();
        	break;
        }
		
		//�h���p���I�᪺��
		intArea = doubleArea.substring(0, doubleArea.length()-3);
		intPerimeter = doublePerimeter.substring(0, doublePerimeter.length()-3);
	}
}
