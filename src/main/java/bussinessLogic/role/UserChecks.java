package bussinessLogic.role;

import java.io.Serializable;
import java.util.ArrayList;

public class UserChecks implements Serializable {
    private ArrayList<String> codes = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    public UserChecks() {
        codes.add("admin");
        codes.add("employee1");
        codes.add("employee2");
        codes.add("employee3");
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public boolean existingUsername(String name) {
        for (User user : users) {
            if (user.getName().equals(name))
                return false;
        }
        return true;
    }

    public boolean existingUser(User user) {
        for (User user1 : users) {
            if (user1.getName().equals(user.getName()) && user1.getPassword().equals(user.getPassword())) {
                user.setRole(user1.getRole());
                return true;
            }
        }
        return false;
    }

    public void setUserRole(String code, User user) {
        if(code.equals("admin"))
            user.setRole(Roles.ADMIN);
        else if (codes.contains(code))
            user.setRole(Roles.EMPLOYEE);
        else
            user.setRole(Roles.CLIENT);
    }
}
