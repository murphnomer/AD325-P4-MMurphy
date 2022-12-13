import java.util.ArrayList;
import java.util.List;

public class Profile {
    // user's ID number
    private int id;
    // user's name
    private String name;
    // user's current status
    private String status;
    // auxiliary list of friends for easy access
    private List<String> friends;

    /**
     * Contructor to create a new Profile when a user enters their name
     * @param name is the user's provided name
     */
    public Profile(String name) {
        this.name = name;
        this.status = "";
        this.friends = new ArrayList<>();
        // we'll use the hash code to generate a (likely) unique ID
        this.id = Math.abs(name.hashCode());
    }

    /**
     * Adds another user to the auxiliary list of friends
     * @param name is the name of the friend to add
     */
    public void addFriend(String name) {
        friends.add(name);
    }

    /**
     * Removes a friend from the list of friends.
     * @param name is the friend to remove
     */
    public void removeFriend(String name) {
        if (friends.contains(name)) friends.remove(name);
    }

    /**
     * Getter for the ID
     * @return is the ID of the user
     */
    public int getId() {
        return id;
    }

    /**
     * Getter for the user's name
     * @return is the user's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the user's name
     * @param name is the new name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the user's current status.
     * @return is the user's status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Set the user's status
     * @param status is the new status provided by the user
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Prints out the user's profile.
     */
    public void displayProfile() {
        System.out.println("Name:    " + name);
        System.out.println("User ID: " + id);
        System.out.println("Status:  " + status);
        System.out.println("Friends: ");
        for (String f : friends) System.out.println(f);
    }
}
