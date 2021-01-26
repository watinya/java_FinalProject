
public class Circle extends Shape{
	private double radius;
	
	public Circle() {
		super("圓形");
	}
	public Circle(double radius) {
		super("圓形");
		this.radius = radius;
	}

	@Override
	public String getQuestion() {
		int radius = getRandomNumber();
		this.radius = radius;
		String question = "此圓形 邊長：" + radius;
		return question;
	}
	private int getRandomNumber() {
		int num = (int)(Math.random()*10) + 1;
		return num;
	}
	
	@Override
	public String computeArea() {
		double area = Math.PI * Math.pow(radius, 2);
		String result = String.format("%.2f", area);
		return result;
	}

	@Override
	public String computePerimeter() {
		double perimeter = radius * 2 * Math.PI;
		String result = String.format("%.2f", perimeter);
		return result;
	}
}
