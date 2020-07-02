public class PitotTube extends SpeedConverter {
	
	@Override
	protected boolean isFast(double speed) {
		return (speed > 920);
	}

	@Override
	public Object convert(Object speed) {
		return (double)speed * 2.9411764705882d;
	}
}