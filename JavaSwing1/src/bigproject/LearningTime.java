package bigproject;

public class LearningTime {
    
    public static long currentTime() {
        return System.currentTimeMillis();
    }
    
    public static boolean hasToLearnMin(int mins,long past) {
        long now = System.currentTimeMillis();
        return now - past >= mins*60*1000;
    }
    
    public static boolean hasToLearnHour(int hours,long past) {
        long now = System.currentTimeMillis();
        return now - past >= hours*60*60*1000;
    }
    
    public static boolean hasToLearnDay(int days,long past) {
        long now = System.currentTimeMillis();
        return now - past >= days*24*60*60*1000;
    }
    
}
