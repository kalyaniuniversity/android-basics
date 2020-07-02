public class Thermocouple extends TemperatureConverter {

	@Override
	protected boolean isHot(double temperature) {
		return (temperature > 120);
	}

	@Override
	public Object convert(Object celsius) {
		return (double) celsius + 273.15;
	}
}