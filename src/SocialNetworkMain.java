public class SocialNetworkMain {
    public static void main(String[] args) {
        ProfileManager pm = new ProfileManager();
        Profile user1;
        Profile user2;

        user1 = pm.join("Mike");
        user1.setStatus("Having a great day!");

        user2 = pm.join("Marissa");
        user2.setStatus("Getting off of work!");

        pm.addFriend(user1,user2);
        pm.addFriend(user1,pm.join("ChiChi"));
        pm.addFriend(user1,pm.join("Heidi"));
        pm.addFriend(user1,pm.join("Reid"));
        pm.addFriend(user1,pm.join("Stephan"));
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

    }
}
