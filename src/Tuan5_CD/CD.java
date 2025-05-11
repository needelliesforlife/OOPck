package Tuan5_CD;

public class CD {
    private long maCD;
    private String tuaCD;
    private long soBaiHat;
    private double giaThanh;


    public CD() {
        this.maCD = 999999L;
        this.tuaCD = "chưa xác định";
        this.soBaiHat = 1;
        this.giaThanh = 10000.0;
    }

    public CD(long maCD, String tuaCD, long soBaiHat, double giaThanh) {
        if (maCD > 0) {
            this.maCD = maCD;
        }
        else{
            this.maCD = 999999L;
        }

        if (tuaCD.isEmpty()) {
            this.tuaCD = "chưa xác định";
        }
        else {
            this.tuaCD = tuaCD;
        }

        if (soBaiHat > 0) {
            this.soBaiHat = soBaiHat;
        }
        else {
            this.soBaiHat = 1;
        }

        if (giaThanh > 0) {
            this.giaThanh = giaThanh;
        }
        else {
            this.giaThanh = 10000;
        }

    }

    public long getMaCD() {
        return maCD;
    }

    public void setMaCD(long maCD) {
        this.maCD = maCD;
    }

    public String getTuaCD() {
        return tuaCD;
    }

    public void setTuaCD(String tuaCD) {
        this.tuaCD = tuaCD;
    }

    public long getSoBaiHat() {
        return soBaiHat;
    }

    public void setSoBaiHat(long soBaiHat) {
        this.soBaiHat = soBaiHat;
    }

    public double getGiaThanh() {
        return giaThanh;
    }

    public void setGiaThanh(double giaThanh) {
        this.giaThanh = giaThanh;
    }

    public CD(long maCD, String tuaCD) {this(maCD, tuaCD, 1L, 10000.0F);}


    @Override
    public String toString() {
        return String.format("%10l %20s %10l %10f", this.maCD, this.tuaCD, this.soBaiHat, this.giaThanh);
    }
}


