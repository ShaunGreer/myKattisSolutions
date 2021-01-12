import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Friend> friendList = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            Friend f = new Friend(sc.next(), sc.nextInt(), sc.next());
            friendList.add(f);
        }

        for(int i = 0; i < friendList.size(); i++){
            if(noRepetition(friendList))
                break;
           Friend current = friendList.get(i);
           friendList.remove(current);
           int otherFriend = myIndexOf(friendList, current);
           //If there is someone else with the same birthday
           if(otherFriend != -1){
               i--;
               //Doesn't like them as much
               if (friendList.get(otherFriend).likeness < current.likeness){
                   friendList.remove(otherFriend);
                   friendList.add(current);
               }
           } else {
               friendList.add(current);
               i = -1;
           }
        }

        friendList.sort(new Comparator<Friend>() {
            @Override
            public int compare(Friend o1, Friend o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        System.out.println(friendList.size());
        for(Friend f : friendList)
            System.out.println(f.name);

        sc.close();
    }

    private static int myIndexOf(List<Friend> friendList, Friend toFind){
        for(int i = 0; i < friendList.size(); i++){
            if(friendList.get(i).birthday.equals(toFind.birthday))
                return i;
        }
        return -1;
    }

    private static boolean noRepetition(List<Friend> friendList){
        List<String> birthdays = new ArrayList<>();
        for(Friend f : friendList){
            birthdays.add(f.birthday);
        }
        Set<String> set = new HashSet<String>(birthdays);
        return set.size() == friendList.size();
    }

    static class Friend{
        String name;
        int likeness;
        String birthday;

        public Friend(String name, int likeness, String birthday){
            this.name = name;
            this.likeness = likeness;
            this.birthday = birthday;
        }
    }

}