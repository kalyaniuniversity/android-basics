public class ShaftLog extends SpeedConverter {
	
	@Override
	protected boolean isFast(double speed) {
		return (speed > 36);
	}

	@Override
	public Object convert(Object speed) {
		return (double)speed * 1000;
	}
}