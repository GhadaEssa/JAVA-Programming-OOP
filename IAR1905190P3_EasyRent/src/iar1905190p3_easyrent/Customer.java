 
package iar1905190p3_easyrent;


public class Customer {
    
private int id;
private String name;
private String nationality;
private char gender;
private int phone;
private int rental_days; 

    public Customer(int id, String name, String nationality, char gender, int phone) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.gender = gender;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public char getGender() {
        return gender;
    }

    public int getPhone() {
        return phone;
    }

    public int getRental_days() {
        return rental_days;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setRental_days(int rental_days) {
        this.rental_days = rental_days;
    }

    @Override
    public String toString() {
        return "\tID: " + id + "\n\tName: " + name + "\n\tNationality: " + nationality + "\n\tGender: " + gender + "\n\tPhone: "+phone   ;
    }
    
    
    
    
    
}
