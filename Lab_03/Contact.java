public class Contact {
    private String Name;
    private String Phone;
    private String Email;
    private String Address;

    public Contact(String name, String phone) {
        this.Name = name;
        this.Phone = phone;
        this.Email = "";
        this.Address = "";
    }

    public Contact(String name, String phone, String email) {
        this.Name = name;
        this.Phone = phone;
        this.Email = email;
        this.Address = "";
    }

    public Contact(String name, String phone, String email, String address) {
        this.Name = name;
        this.Phone = phone;
        this.Email = email;
        this.Address = address;
    }

    public String getName() {
        return this.Name;
    }

    public String getPhone() {
        return this.Phone;
    }

    public String getEmail() {
        return this.Email;
    }

    public String getAddress() {
        return this.Address;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setPhone(String phone) {
        this.Phone = phone;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public void update(String name, String phone, String email, String address) {
        this.Name = name;
        this.Phone = phone;
        this.Email = email;
        this.Address = address;
    }
}