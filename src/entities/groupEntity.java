package entities;

/**
 *
 * @author Marek
 */
public class groupEntity {
    int Id;
    String name;
    String nameShort;

    public groupEntity(int Id, String name, String nameShort) {
        this.Id = Id;
        this.name = name;
        this.nameShort = nameShort;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameShort() {
        return nameShort;
    }

    public void setNameShort(String nameShort) {
        this.nameShort = nameShort;
    }
    
}
