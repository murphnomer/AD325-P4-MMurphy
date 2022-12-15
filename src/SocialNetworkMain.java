import java.util.Scanner;

public class SocialNetworkMain {
    public static void main(String[] args) {
        ProfileManager pm = new ProfileManager();
        Scanner in = new Scanner(System.in);
        Profile p = null;

        String name;
        String status;

        int choice = 0;

        //test();

        while (choice != 9) {

            System.out.println("Welcome to Mikebook, the social network!");
            System.out.println("Please choose from the following options:");
            System.out.println();
            System.out.println("1. Join network (create a new profile)");
            System.out.println("2. Log in (view a user profile)");
            System.out.println("3. Display full user profile");
            System.out.println("4. Update status (modify the current user profile)");
            System.out.println("5. Display current user's friend network");
            System.out.println("6. Add friends");
            System.out.println("7. Leave the network (delete user profile)");
            System.out.println("9. Log out");
            System.out.println();

            choice = in.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Please enter your name:");
                    name = in.next();
                    pm.join(name);
                    break;
                case 2:
                    pm.listProfiles();
                    System.out.println("Enter the name of the user to log in:");
                    name = in.next();
                    pm.setCurrentUser(name);
                    break;
                case 3:
                    pm.displayCurrentUser();
                    break;
                case 4:
                    pm.displayCurrentUser();
                    System.out.println("Enter new status:");
                    status = in.next();
                    pm.currentUser.setStatus(status);
                    break;
                case 5:
                    pm.displayFriendNetwork();
                    break;
                case 6:
                    System.out.println("Here's a list of the profiles currently in the network:");
                    pm.listProfiles();
                    System.out.println();
                    System.out.println("Please enter a user to befriend:");
                    name = in.next();
                    p = pm.getUser(name);
                    if (p != null) {
                        pm.addFriend(pm.getUser(name));
                    } else {
                        System.out.println("Couldn't find a user named " + name);
                    }
                    break;
                case 7:
                    System.out.println("Goodbye! Thanks for using Mikebook!");
                    pm.leaveNetwork();
                    break;
                case 9:
                    System.out.println("Thanks for managing your future with Mikebook! See you next time!");
            }
        }
    }

    public static void test() {
        ProfileManager pm = new ProfileManager();
        Profile user1;
        Profile user2;
        Profile user3;

        user1 = pm.join("Mike");
        user1.setStatus("Having a great day!");

        user2 = pm.join("Marissa");
        user2.setStatus("Getting off of work!");

        user3 = pm.join("Stephan");

        pm.addFriend(user1,user2);
        pm.addFriend(user1,user3);
        pm.addFriend(user1,pm.join("ChiChi"));
        pm.addFriend(user1,pm.join("Heidi"));
        pm.addFriend(user1,pm.join("Reid"));
        pm.addFriend(user3,pm.join("Louis"));
        pm.addFriend(user2,pm.join("Michelle"));
        pm.addFriend(user2,pm.join("Cassady"));
        pm.addFriend(user2,pm.join("Morgan"));
        pm.addFriend(user2,pm.join("Emily"));

        user1.displayProfile();
        user2.displayProfile();

        System.out.println();

        pm.listProfiles();
        System.out.println();
        System.out.println(user1.getName() + "'s network:");
        pm.displayFriendNetwork(user1);

        System.out.println();
        System.out.println(user2.getName() + "'s network:");
        pm.displayFriendNetwork(user2);

        pm.leaveNetwork("Stephan");

        System.out.println("After removing user:");
        pm.displayFriendNetwork(user1);
        pm.displayFriendNetwork(user2);

    }
}
