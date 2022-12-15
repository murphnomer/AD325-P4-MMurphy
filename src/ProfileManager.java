import ADTPackage.*;
import GraphPackage.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProfileManager {

    // auxiliary data structure to track all profiles as they are added
    Map<Integer,Profile> profiles;
    // graph to track friend relationships
    UndirectedGraph<Profile> relationships;
    // variable to track the current user as selected by the user
    Profile currentUser;

    /**
     * Constructor to initialize variables to default values
     */
    public ProfileManager () {
        profiles = new HashMap<>();
        relationships = new UndirectedGraph<>();
    }

    /**
     * Create a new user in the network
     * @param name is the name of the user being created.
     * @return is the Profile object for the newly created user.
     */
    public Profile join(String name) {
        // create a new profile for the specified username
        Profile p = new Profile(name);

        // add the new profile to the main map
        profiles.put(p.getId(), p);

        // add the node to the graph
        relationships.addVertex(p);

        // set the current user to the new one if there is not already a current user
        if (currentUser == null) setCurrentUser(p.getId());

        return p;
    }

    /**
     * Sets the current user
     * @param id is the user id (hashcode of the name)
     * @return is the Profile of the account with the specified id
     */
    public Profile setCurrentUser(Integer id) {
        if (profiles.containsKey(id)) {
            currentUser = profiles.get(id);
        } else {
            System.out.println("Could not find a user with id " + id );
        }
        return currentUser;
    }

    /**
     * Prints out the profile of the current user
     */
    public void displayCurrentUser() {
        displayUser(currentUser);
    }

    /**
     * Prints out the profile of the specified user
     * @param user is the user profile to print out
     */
    public void displayUser(Profile user) {
        user.displayProfile();
    }

    /**
     * Prints out a list of user profiles currently in the system
     */
    public void listProfiles() {
        for (Integer k : profiles.keySet()) System.out.println(profiles.get(k).getName());
    }

    /**
     * Adds a friend to the profile of the current user
     * @param friendToAdd is the profile of the friend to add
     */
    public void addFriend(Profile friendToAdd) {
        addFriend(currentUser, friendToAdd);
    }

    /**
     * Adds a friend relationship between two specified user profiles
     * @param user1 is the first profile in the relationship
     * @param user2 is the second profile
     */
    public void addFriend(Profile user1, Profile user2) {
        if (user1 == user2) {
            System.out.println("Can't add yourself as a friend!");
            return;
        }

        relationships.addEdge(user1, user2);
        user1.addFriend(user2.getName());
        user2.addFriend(user1.getName());
    }

    /**
     * Prints out the user profile, the direct friends, and the friends of friends of the specified user
     * @param user is the profile to display the friend network for
     */
    public void displayFriendNetwork(Profile user) {
        QueueInterface<Profile> f;
        Profile cur;
        System.out.println("User: " + user.getName());
        System.out.println("Friends:");
        System.out.println();
        // traversal level 1 is the immediate neighbors of the specified profile
        f = relationships.getBreadthFirstTraversal(user, 1, 1);

        while (!f.isEmpty()) {
            cur = f.dequeue();
            System.out.println(cur.getName());
        }
        System.out.println();
        System.out.println("Friends of friends:");

        // traversal level 2 is the neighbors of neighbors of the specified profile
        f = relationships.getBreadthFirstTraversal(user,2, 2);

        while (!f.isEmpty()) {
            cur = f.dequeue();
            System.out.println(cur.getName());
        }

    }

    /**
     * Removes the specified user from the network
     * @param name is the name of the user to remove
     */
    public void leaveNetwork(String name) {
        // find the user profile based on the hash code
        Profile p = profiles.get(Math.abs(name.hashCode()));

        // remove the user from the master list
        profiles.remove(p);

        // and also from the friend network
        relationships.removeVertex(p);

        // also remove it from any of the direct friend tracking structures
        for (Profile prof : profiles.values()) {
            prof.removeFriend(prof.getName());
        }

    }

}
