
public class Rectangle extends Shape{
	private double width;
	private double length;
	
	public Rectangle() {
		super("矩形");
	}
	public Rectangle(double width, double length) {
		super("矩形");
		this.width = width;
		this.length = length;
	}
	
	@Override
	public String getQuestion() {
		int width = getRandomNumber();
		this.width = width;
		int length = getRandomNumber();
		this.length = length;
		String question = "此矩形 高：" + length + " 寬：" + width;
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
