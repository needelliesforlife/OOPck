package Tuan5_Toa_Do_Hinh_Tron;

public class Toado {
    private String ten;
    private float x;
    private float y;
    public Toado() {

    }
    public Toado(String ten, float x, float y) {
        this.ten = ten;
        this.x = x;
        this.y = y;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    @Override
    public String toString() {
        return String.format("Tọa độ(%s, %.1f, %.1f)", ten, x, y);
    }
}

