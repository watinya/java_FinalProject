
public class RegularTriangle extends Triangle{
	private double sideLength;
	
	public RegularTriangle() {
		super("���T����");
	}
	public RegularTriangle(double sideLength) {
		super("���T����");
		this.sideLength = sideLength;
	}
	
	public String computeHeight() {
		double num = Math.sqrt(3) / 2;
		double height = num * sideLength;
		String result = String.format("%.2f", height);
		return result;
	}
	
	@Override
	public String getQuestion() {
		int sideLength = getRandomNumber();
		this.sideLength = sideLength;
		String question = "�����T���� ����G" + sideLength;
		return question;
	}
	private int getRandomNumber() {
		int num = (int)(Math.random()*10) + 1;
		return num;
	}
	
	@Override
	public String computeArea() {
		double num = Math.sqrt(3) / 4;
		double area = num * Math.pow(sideLength, 2);
		String result = String.format("%.2f", area);
		return result;
	}

	@Override
	public String computePerimeter() {
		double perimeter = sideLength * 3;
		String result = String.format("%.2f", perimeter);
		return result;
	}
}
