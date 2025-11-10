public class Officer {
    private int id;
    private String name;
    private String rank;

    public Officer(int id, String name, String rank) {
        this.id = id;
        this.name = name;
        this.rank = rank;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRank() {
        return rank;
    }
}
