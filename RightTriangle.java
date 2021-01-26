
public class RightTriangle extends Triangle{
	private double base;
	private double height;
	
	public RightTriangle() {
		super("直角三角形");
	}
	public RightTriangle(double base, double height) {
		super("直角三角形");
		this.base = base;
		this.height = height;
	}
	
	@Override
	public String getQuestion() {
		int base = getRandomNumber();
		this.base = base;
		int height = getRandomNumber();
		this.height = height;
		String question = "此直角三角形 底：" + base + " 高：" + height;
		return question;
	}
	private int getRandomNumber() {
		int num = (int)(Math.random()*10) + 1;
		return num;
	}
	
	@Override
	public String computeArea() {
		double area = base * height / 2;
		String result = String.format("%.2f", area);
		return result;
	}

	@Override
	public String computePerimeter() {
		double hypotenuse = Math.sqrt(base * base + height * height);
		double perimeter = base + height + hypotenuse;
		String result = String.format("%.2f", perimeter);
		return result;
	}

}
