public class MusicCenter {
    private int id;
    private String name;
    public void setID(int n){
        this.id=n;
    }
    public void setName(String n){
        this.name=n;
    }
    public int getID(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public void Connect(MusicCarry one){
        if (this.getID() != one.getID()){
            System.out.println("MusicCenter cant play music from that carry!");
        }
        else{
            System.out.printf("Currently playing %s by %s",one.getTrack(),this.getName());
        }

    }



}