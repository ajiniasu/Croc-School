public class MusicCarry {
    private int id;
    private String name;
    private String[] ArrayOfTracks={"Singer 1 - Track 1",
            "Singer 1 - Track 2",
            "Singer 2 - Track 1",
            "Singer 2 - Track 2",
            "Singer 3 - Track 1"};
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
    public String getTrack(){
        double n = Math.random()*(ArrayOfTracks.length-1);
        int n1=(int)n;
        return this.ArrayOfTracks[n1];
    }

}