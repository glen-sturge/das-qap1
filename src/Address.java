public class Address {
    private String street;
    private String city;
    private String province;
    private String postalCode;

    public Address(String street, String city, String province, String postalCode) {
        this.street = street;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
    }

    public String toString() {
        return String.format("%s, %s, %s, %s", street, city, province, postalCode);
    }
}
