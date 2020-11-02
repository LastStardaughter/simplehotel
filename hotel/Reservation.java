package hotel;
import java.time.LocalDate;

public class Reservation {
    private String name, num;
    private LocalDate start, end;

    public Reservation(String name, String roomNum, LocalDate checkIn, LocalDate checkOut){
        this.name=name;
        this.num=roomNum;
        this.start=checkIn;
        this.end=checkOut;
    }

    public String getName(){
        return name;
    }

    public String getNum(){
        return num;
    }
    
    public LocalDate getStart(){
        return start;
    }

    public LocalDate getEnd(){
        return end;
    }

    public boolean overlaps(LocalDate checkIn, LocalDate checkOut){
        if(checkIn.equals(start) || (checkIn.isBefore(end) && checkIn.isAfter(start)) || checkOut.equals(end) || (checkOut.isBefore(end) && checkOut.isAfter(start))){
            return true;
        }
        return false;
    }

    public boolean overlaps(Reservation that){
        if(that.start.equals(start) || (that.start.isBefore(end) && that.start.isAfter(start)) || that.end.equals(end) || (that.end.isBefore(end) && that.end.isAfter(start))){
            return true;
        }
        return false;
    }
}
