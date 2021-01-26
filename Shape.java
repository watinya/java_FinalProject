
public abstract class Shape implements Graphics2D{
	private String shapeName;
	
	public Shape(String shapeName) {
		this.shapeName = shapeName;
	}
	
	public String getShapeName() {
		return shapeName;
	}
	
	public abstract String getQuestion();
	public abstract String computeArea();
	public abstract String computePerimeter();
}
