
public abstract class Triangle extends Shape{

	public Triangle(String shapeName) {
		super(shapeName);
	}
	public String computeHeight() {
		return null;
	}
	
	public abstract String getQuestion();
	public abstract String computeArea();
	public abstract String computePerimeter();

}
