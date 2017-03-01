/**
 * Created by krist on 2017-02-28.
 */
public class EdgeOffset {

    public String fromTo;
    public int offset = 0;

    public EdgeOffset (String fromTo){
        this.fromTo = fromTo;
    }

    @Override
    public boolean equals( Object o){
        return this.fromTo.equals(((EdgeOffset)o).fromTo);
    }

}
