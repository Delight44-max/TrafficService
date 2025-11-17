package data.repositories.models;

public class Owner {
    private int id;
    private String name;
    private String phone;

    public Owner(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }



    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Override
    public String toString() {
        return name + " (" + id + ", " + phone + ")";
    }
}
