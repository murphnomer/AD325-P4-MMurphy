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

        user1.displayProfile();
        user2.displayProfile();

    }
}
