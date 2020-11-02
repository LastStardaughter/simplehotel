package hotel;

public class Hotel {
    final static int FLOORS=4;
    final static int ROOMS_PER_FLOOR=22;
    private String name;
    private Room[] rooms;

    //A hotel doesn't really gain or lose rooms so it's an array. A more involved constructor could take more data about floors and rooms on floors
    //and size the array appropriately -- likewise, getRoom could be rewritten with different logic to match.
    public Hotel(String name){
        this.name=name;
        rooms=new Room[FLOORS*ROOMS_PER_FLOOR];
    }

    public Room getRoom(String num){
        int n=(Character.getNumericValue(num.charAt(0))-1)*ROOMS_PER_FLOOR + Integer.parseInt(num.substring(1));
        if(rooms[n]==null){
            rooms[n]=new Room(num);
        }
        return rooms[n];
    }
}
