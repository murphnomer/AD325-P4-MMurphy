public class SocialNetworkMain {
    public static void main(String[] args) {
        ProfileManager pm = new ProfileManager();

        int choice = 0;

        test();

        while (choice != 9) {

            System.out.println("Welcome to Mikebook, the social network!");
            System.out.println("Please choose from the following options:");
            System.out.println();
            System.out.println("1. Join network (create a new profile)");
            System.out.println("2. Log in (view a user profile)");
            System.out.println("3. Update status (modify the current user profile)");
            System.out.println("4. Add friends");
            System.out.println("5. Leave the network (delete user profile)");
            System.out.println("9. Log out");

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
