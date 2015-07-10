
public class Sensor
{
	private boolean activated;
	public Sensor()
	{
		this.activated = false;
	}
	public void trigger()
	{
		this.activated = !activated;
	}
}
