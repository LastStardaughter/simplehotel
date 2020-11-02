package hotel;
import java.util.ArrayList;
import java.time.LocalDate;

public class Room {
    static int rate=99; //There can be special types of rooms that override this on inheritance.
    //We never use room number for math operations anyway. This way we can also have special named rooms if we want.
    //That said, this particular program assumes a three-digit name with the first digit as floor and the last two as number-on-floor.
    private String number;
    private ArrayList<Reservation> reservations;

    public Room(String roomNum){
        number=roomNum;
    }

    /*For a real hotel that's booked all the time we'd probably want to store reservations in such a way that we don't have to compare against
    all reservations for that room. Reservations could be moved to archival after checkout, and bucketed into months
    so we only check the same, previous, and next month. Maybe there's some trick we could do with hashmaps?
    */
    public boolean addReservation(Reservation newRes){
        if (reservations==null){
            reservations=new ArrayList<Reservation>();
            reservations.add(newRes);
            return true;
        }
        boolean overlap=false;
        for(Reservation res : reservations){
            if(res.overlaps(newRes)){overlap=true;}
        }
        if(overlap){return false;}
        reservations.add(newRes);
        return true;
    }

    public boolean delReservation(LocalDate checkIn){
        if(reservations==null){return false;}
        //not using forin because we stop as soon as we find one. There can't be two reservations with the same checkin date.
        for(int i=0;i<reservations.size();i++){
            if(checkIn.equals(reservations.get(i).getStart())){
                reservations.remove(i);
                if(reservations.size()==0){reservations=null;}
                return true;
            }
        }
        return false;
    }

    public void check(){
        if(reservations==null){
            System.out.println("None found.");
            return;
        }
        for (Reservation res : reservations){
            System.out.println(res.getStart().toString()+":"+res.getEnd().toString()+" "+res.getName());
        }
    }
}
