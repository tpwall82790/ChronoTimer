

import java.text.DecimalFormat;

public class Chronometer {
	double startTime;
	double currentTime;
	double finishTime;
	
	/**
	 * Construcuts a default chornometer object with 
	 * start, current, and finish times initialized to 0.0
	 */
	public Chronometer() {
		startTime = 0.0;
		currentTime = 0.0;
		finishTime = 0.0;
	}
	
	/**
	 * Start chronometer to record initial time.
	 */
	public void start() {
		startTime = System.nanoTime();
	}
	
	/**
	 * Terminate chronometer to record final time.
	 */
	public void finish() {
		finishTime = System.nanoTime();
	}
	
	/**
	 * Returns the current elapsed time by calculating the difference
	 * between current time and start time.
	 * @return current time
	 */
	public String getCurrentTime() {
		double elapseTime;
		String elapseTimeString;
		
		// Decimal formats for displaying elapse time required by constraints.
		DecimalFormat df = new DecimalFormat("#.##");
		
		// Get current elapse time by finding difference between current and start times.
		currentTime = System.nanoTime();
		elapseTime = (currentTime - startTime) / 1000000000;	
		elapseTimeString = "" + df.format(elapseTime);
		elapseTime = Double.parseDouble(elapseTimeString);
		
		// Call helper method to format time.
		elapseTimeString = formatTime(elapseTime);
		
		return elapseTimeString;
	}
	
	/**
	 * Returns the elapsed time by calculating the difference
	 * between finish time and start time.
	 * @return elapse time
	 */
	public String getFinishTime() {
		double elapseTime;
		String elapseTimeString;
		
		// Decimal formats for displaying elapse time required by constraints.
		DecimalFormat df = new DecimalFormat("#.##");
		
		// Get elapse time by finding difference between finish and start times.
		elapseTime = (finishTime - startTime) / 1000000000;	
		elapseTimeString = "" + df.format(elapseTime);
		elapseTime = Double.parseDouble(elapseTimeString);
		
		// Call helper method to format time.
		elapseTimeString = formatTime(elapseTime);
		
		return elapseTimeString;
	}
	
	/**
	 * Formats a double (#.##) to fit constraints (<min>:<sec>.<hundreths>).
	 * @param time - a time in the format of (#.##)
	 * @return elapse time
	 */
	public String formatTime(double time) {
		double elapseTime = time;
		String elapseTimeString;
		
		// Format current elapse time required by constraints.
		DecimalFormat hundrethsFormat = new DecimalFormat(".00");
		DecimalFormat secondsFormat = new DecimalFormat("00");
			
		int minutes = (int) elapseTime / 60;
		double remainder = elapseTime - (minutes * 60);
		int seconds = (int) remainder;
		String hundreths = hundrethsFormat.format(remainder - seconds);
				
		String minutesString = secondsFormat.format(minutes);
		String secondsString = secondsFormat.format(seconds);
				
		elapseTimeString = minutesString + ":" + secondsString + hundreths;
		return elapseTimeString;
	}
	
}
