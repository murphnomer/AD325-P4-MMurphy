import java.util.ArrayList;
import java.util.List;

public class Profile {

    private int id;
    private String name;
    private String status;
    private List<String> friends;

    public Profile(String name) {
        this.name = name;
        this.status = "";
        this.friends = new ArrayList<>();
        this.id = Math.abs(name.hashCode());
    }

    public void addFriend(String name) {
        friends.add(name);
    }

    public void removeFriend(String name) {
        if (friends.contains(name)) friends.remove(name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void displayProfile() {
        System.out.println("Name:    " + name);
        System.out.println("User ID: " + id);
        System.out.println("Status:  " + status);
        System.out.println("Friends: ");
        for (String f : friends) System.out.println(f);
    }
}
