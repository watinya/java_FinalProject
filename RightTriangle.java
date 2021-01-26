
public class RightTriangle extends Triangle{
	private double base;
	private double height;
	
	public RightTriangle() {
		super("�����T����");
	}
	public RightTriangle(double base, double height) {
		super("�����T����");
		this.base = base;
		this.height = height;
	}
	
	@Override
	public String getQuestion() {
		int base = getRandomNumber();
		this.base = base;
		int height = getRandomNumber();
		this.height = height;
		String question = "�������T���� ���G" + base + " ���G" + height;
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
