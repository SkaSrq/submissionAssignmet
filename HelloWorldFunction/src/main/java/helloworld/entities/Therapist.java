package helloworld.entities;

public class Therapist {
    private int therapist_id;
    private String name;
    private String email;
    private String password;
    private boolean is_available;

    public Therapist(int therapist_id, String name, String email, String password, boolean is_available) {
        this.therapist_id = therapist_id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.is_available = is_available;
    }

    public Therapist() {
    }

    @Override
    public String toString() {
        return "Therapist{" +
                "therapist_id=" + therapist_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", is_available=" + is_available +
                '}';
    }

    public int getTherapist_id() {
        return therapist_id;
    }

    public void setTherapist_id(int therapist_id) {
        this.therapist_id = therapist_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIs_available() {
        return is_available;
    }

    public void setIs_available(boolean is_available) {
        this.is_available = is_available;
    }
}
