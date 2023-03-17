package bussinessLogic.role;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String password;
    private Roles role;

    public User(String name, String password, Roles role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return name.equals(user.name);
    }

    public boolean isAdmin() {
        if(this.getRole().equals(Roles.ADMIN))
            return true;
        return false;
    }

    public boolean isEmployee() {
        if(this.getRole().equals(Roles.EMPLOYEE))
            return true;
        return false;
    }

    public boolean isClient() {
        if(this.getRole().equals(Roles.CLIENT))
            return true;
        return false;
    }

}
