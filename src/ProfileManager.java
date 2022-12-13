import ADTPackage.*;
import GraphPackage.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProfileManager {

    Map<Integer,Profile> profiles;
    UndirectedGraph<Profile> relationships;
    Profile currentUser;

    public ProfileManager () {
        profiles = new HashMap<>();
        relationships = new UndirectedGraph<>();
    }

    public Profile join(String name) {
        Profile p = new Profile(name);
        profiles.put(p.getId(), p);
        relationships.addVertex(p);
        if (currentUser == null) setCurrentUser(p.getId());

        return p;
    }

    public Profile setCurrentUser(Integer id) {
        if (profiles.containsKey(id)) {
            currentUser = profiles.get(id);
        } else {
            System.out.println("Could not find a user with id " + id );
        }
        return currentUser;
    }

    public void displayCurrentUser() {
        displayUser(currentUser);
    }

    public void displayUser(Profile user) {
        user.displayProfile();
    }

    public void listProfiles() {

    }

    public void addFriend(Profile friendToAdd) {
        addFriend(currentUser, friendToAdd);
    }

    public void addFriend(Profile user1, Profile user2) {
        if (user1 == user2) {
            System.out.println("Can't add yourself as a friend!");
            return;
        }

        relationships.addEdge(user1, user2);
        user1.addFriend(user2.getName());
        user2.addFriend(user1.getName());
    }

    public void displayFriendNetwork(Profile user) {

    }

    public void leaveNetwork(String name) {

    }

    /*
    public List<Profile> getFriends(Profile user) {
        List<Profile> l = new ArrayList<>();
        relationships.
    }

     */

}
