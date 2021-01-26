
public class Rectangle extends Shape{
	private double width;
	private double length;
	
	public Rectangle() {
		super("�x��");
	}
	public Rectangle(double width, double length) {
		super("�x��");
		this.width = width;
		this.length = length;
	}
	
	@Override
	public String getQuestion() {
		int width = getRandomNumber();
		this.width = width;
		int length = getRandomNumber();
		this.length = length;
		String question = "���x�� ���G" + length + " �e�G" + width;
		return question;
	}
	private int getRandomNumber() {
		int num = (int)(Math.random()*100) + 1;
		return num;
	}
	
	@Override
	public String computeArea() {
		double area = width * length;
		String result = String.format("%.2f", area);
		return result;
	}

	@Override
	public String computePerimeter() {
		double perimeter = (width + length) * 2;
		String result = String.format("%.2f", perimeter);
		return result;
	}

}
