package tuan7_NhanVien_2;


abstract class NhanVien {
    protected String firstName;
    protected String lastName;
    protected int ssn;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public double getSalary(){
        return 0.0;
    }

    @Override
    public String toString() {
        return String.format("Nhan vien: %s %s (SSN: %d)", firstName, lastName, ssn);
    }
}

