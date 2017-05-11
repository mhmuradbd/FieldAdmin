package murad.md.field_admin;

/**
 * Created by muradhussain on 4/9/17.
 */
public class Contact {


    public String name = "";
    public String hint = "";

    public Contact(String name, String hint) {

        this.name = name;
        this.hint = hint;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getHint() {
        return hint;
    }
    public void setHint(String hint) {
        this.hint = hint;
    }
}