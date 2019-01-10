
public enum OrientationEnum {
	 W("Ouest"),
	 E("Est"),
	 N("Nord"),
	 S("Sud");


	private String direction;
	OrientationEnum(String orientation)	
	{
		setOrientation(orientation);
	}
	public String getOrientation() {
		return direction;
	}
	public void setOrientation(String direction) {
		this.direction = direction;
	}

}
