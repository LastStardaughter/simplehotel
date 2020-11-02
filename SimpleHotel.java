import hotel.*;
import java.io.File;
import java.util.Scanner;
import java.time.LocalDate;

class SimpleHotel{
    public static void main(String[] args) {
        final String HOTEL_NAME="Test Hotel Please Ignore";
        Hotel hotel=new Hotel(HOTEL_NAME);
        String[] in;
        int[] ii;
        Scanner scanner = new Scanner(System.in);
        File file=new File("hotel.dat");
        if(file.exists()){
            loadReservations(hotel, file);
        }

        System.out.println("Welcome to "+HOTEL_NAME+"'s reservation system.");
        System.out.println("Enter command or ? for help.");
        while (true){
            System.out.print("> ");
            in=scanner.nextLine().split(" ");
            switch(in[0]){
                case "?":   help();
                            break;
                case "add": try{
                                ii = new int[6];
                                for(int i=2;i<8;i++){
                                    ii[i-2]=Integer.parseInt(in[i]);
                                }
                                if(hotel.getRoom(in[1]).addReservation(new Reservation(in[8], in[1], LocalDate.of(ii[0],ii[1],ii[2]), LocalDate.of(ii[3],ii[4],ii[5])))){
                                    System.out.println("Added reservation to room "+in[1]);
                                } else {
                                    System.out.println("Error: Reservation exists with overlapping time.");
                                }
                } catch(Exception e){System.out.println("Exception: "+e.toString());}
                                break;
                case "del": try{
                                ii = new int[3];
                                for(int i=2;i<5;i++){
                                    ii[i-2]=Integer.parseInt(in[i]);
                                }
                                if(hotel.getRoom(in[1]).delReservation(LocalDate.of(ii[0],ii[1],ii[2]))){
                                    System.out.println("Deleted reservation from room "+in[1]);
                                } else{
                                    System.out.println("Error: No reservation found at specified room and checkin date.");
                                }
                } catch(Exception e){System.out.println("Exception: "+e.toString());}
                                break;
                case "check": try{hotel.getRoom(in[1]).check();} catch(Exception e){System.out.println("Exception: "+e.toString());}
                                break;
                
            }


        }

    }

    private static void help(){
        System.out.println("?\t\t\t\t\t\t\tDisplay this message\radd <room> <yyyy mm dd> <yyyy mm dd> <lastname> add reservation\rdel <room> <yyyy mm dd>\t\t\t delete reservation with given checkin date\rcheck <room>\t\t\t\t\tlist reservations for <room>\rsave\t\t\t\t\t\tsave reservations\rload\t\t\t\t\t\tload reservations\rquit\t\t\t\t\t\tquit immediately");
        System.out.println("(This demo has 4 floors with 22 rooms each, thus valid room numbers are from 101-422)");
    }

    private static void loadReservations(Hotel hotel, File file){

    }
}