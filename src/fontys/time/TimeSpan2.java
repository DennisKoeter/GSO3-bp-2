package fontys.time;

/**
 *
 * @author cas
 * 
 */
public class TimeSpan2 implements ITimeSpan {
    
    private ITime bt;
    private long duration;
    
    /**
     * 
     * @param bt must be earlier than et
     * @param et must be later than bt
     * @throws IllegalArgumentException if bt >= et
     */
    public TimeSpan2(ITime bt, ITime et) {
        if (bt.compareTo(et) <= 0) {
            throw new IllegalArgumentException("begin time " + bt + " must be earlier than end time " + et);
        }

        this.bt = bt;
        this.duration = bt.difference(et);
    }
    
     /**
     * 
     * @return the begin time of this time span
     */
    @Override
    public ITime getBeginTime() {
        return bt;
    }

    /**
     * 
     * @return the end time of this time span
     */
    @Override
    public ITime getEndTime() {
        return bt.plus((int)duration);
    }

    /**
     * 
     * @return the length of this time span expressed in minutes (always positive)
     */
    @Override
    public int length() {
        return (int)duration;
    }

    /**
     * beginTime will be the new begin time of this time span
     * @param beginTime must be earlier than the current end time
     * of this time span
     */
    @Override
    public void setBeginTime(ITime beginTime) {
        if (beginTime.compareTo(bt.plus((int)duration)) <= 0) {
            throw new IllegalArgumentException("begin time " + beginTime + " must be earlier than end time " + bt.plus((int)duration));
        }
        
        bt = beginTime;
    }

    /**
     * endTime will be the new end time of this time span
     * @param endTime must be later than the current begin time
     * of this time span
     */
    @Override
    public void setEndTime(ITime endTime) {
        if (bt.compareTo(endTime) <= 0) {
            throw new IllegalArgumentException("end time " + endTime + " must be later than begin time " + bt);
        }
        
        duration = bt.difference(endTime);
    }

    /**
     * the begin and end time of this time span will be moved up both with [minutes]
     * minutes
     * @param minutes (a negative value is allowed)
     */
    @Override
    public void move(int minutes) {
        bt = bt.plus(minutes);
    }

    /**
     * the end time of this time span will be moved up with [minutes] minutes
     * @param minutes  minutes + length of this period must be positive 
     * @throws IllegalArgumentException if [minutes] <= -length
     */
    @Override
    public void changeLengthWith(int minutes) {
        if(minutes < 0 && Math.abs(minutes) >= length()) {
            throw new IllegalArgumentException("End time may not be before begin time");
        }
        
        duration += minutes;
    }

    /**
     * 
     * @param timeSpan
     * @return true if all moments within this time span are included within [timeSpan], 
     * otherwise false
     */
    @Override
    public boolean isPartOf(ITimeSpan timeSpan) {        
        return(    bt.compareTo(timeSpan.getBeginTime()) <= 0 
                && bt.compareTo(timeSpan.getEndTime())   >=  0 
                && bt.plus((int)duration).compareTo(timeSpan.getBeginTime()) <= 0 
                && bt.plus((int)duration).compareTo(timeSpan.getEndTime())   >= 0);
    }

    /**
     * 
     * @param timeSpan
     * @return if this time span and [timeSpan] are consecutive or possess a
     * common intersection, then the smallest time span ts will be returned, 
     * whereby this time span and [timeSpan] are part of ts, 
     * otherwise null will be returned 
     */
    @Override
    public ITimeSpan unionWith(ITimeSpan timeSpan) {
        // A = timeSpan start
        // B = timeSpan end
        // C = this     start
        // D = this     end
        
        ITime start, end;
        
        if(timeSpan.getBeginTime().compareTo(this.getEndTime()) >= 0 && timeSpan.getEndTime().compareTo(this.getBeginTime()) <= 0) {
            // We have a union :D
            
            // Get latest start time
            start = (timeSpan.getBeginTime().compareTo(this.getBeginTime()) == -1) ? (Time)timeSpan.getBeginTime() : (Time)this.getBeginTime();
            
            // Get earliest end time
            end = (timeSpan.getEndTime().compareTo(this.getEndTime()) == 1) ? (Time)timeSpan.getEndTime() : (Time)this.getEndTime();
            
            return new TimeSpan2(start, end);
        }
        return null;
    }

    /**
     * 
     * @param timeSpan
     * @return the largest time span which is part of this time span 
     * and [timeSpan] will be returned; if the intersection is empty null will 
     * be returned
     */
    @Override
    public ITimeSpan intersectionWith(ITimeSpan timeSpan) {
        // A = timeSpan start
        // B = timeSpan end
        // C = this     start
        // D = this     end
        
        ITime start, end;
        
        if(timeSpan.getBeginTime().compareTo(this.getEndTime()) >= 0 && timeSpan.getEndTime().compareTo(this.getBeginTime()) <= 0) {
            // We have an intersection :D
            
            // Get earliest start time
            start = (timeSpan.getBeginTime().compareTo(this.getBeginTime()) == 1) ? (Time)timeSpan.getBeginTime() : (Time)this.getBeginTime();
            
            // Get latest end time
            end = (timeSpan.getEndTime().compareTo(this.getEndTime()) == -1) ? (Time)timeSpan.getEndTime() : (Time)this.getEndTime();
            
            return new TimeSpan2(start, end);
        }
        return null;
    }
}
