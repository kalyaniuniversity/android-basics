public class Thermometer extends TemperatureConverter {
	
	@Override
	protected boolean isHot(double temperature) {
		return (temperature > 99);
	}

	@Override
	public Object convert(Object celsius) {
		return (((double) celsius) * (9.0 / 5.0)) + 32;
	}
}