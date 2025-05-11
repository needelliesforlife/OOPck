package Tuan5_CD;
import java.util.Arrays;
public class CD_List {
    private CD[] CD_lists;
    private int count;
    private int capacity;
    public CD_List() {
        this.capacity = 100;
        this.count = 0;
        this.CD_lists = new CD[this.capacity];
    }
    public CD_List(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.CD_lists = new CD[capacity];
    }

    public boolean kiemTraTrungMa(CD cd) {
        for (int i = 0; i < this.count; i++) {
            if (this.CD_lists[i].equals(cd)) {
                return true;
            }
        }
        return false;
    }
    public boolean themCD(CD cd){
        if (this.count < this.capacity) {
            if (!kiemTraTrungMa(cd)) {
                this.CD_lists[this.count++] = cd;
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < this.count; ++i) {
            sb.append(this.CD_lists[i]).append("\n");
        }

        return sb.toString();
    }
    public long soCD() {
        return this.count;
    }

    public CD timCD(long find_cd)  throws Exception{
        for (int i = 0; i < this.count; ++i) {
            if (this.CD_lists[i].getMaCD() == find_cd) {
                return this.CD_lists[i];
            }
        }
        throw new Exception("CD không tồn tại");
    }

    public boolean xoaCD(long find_cd) {
        int index = -1;
        for (int i = 0; i < this.count; ++i) {
            if (this.CD_lists[i].getMaCD() == find_cd) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        }
        else {
            for (int i = index ; i < this.count -1; ++i) {
                this.CD_lists[i] = this.CD_lists[i+1];
            }
            --this.count;
            return true;
        }
    }
    public double  tongTienCD() {
        double tong = 0;
        for (int i = 0; i < this.count; ++i) {
            tong += this.CD_lists[i].getGiaThanh();
        }
        return tong;
    }
    public void giamTheoGia() {
        Arrays.sort(CD_lists, 0, count, (cd1, cd2) -> Double.compare(cd2.getGiaThanh(), cd1.getGiaThanh()));
    }

    public void tangTheoTua() {
        Arrays.sort(CD_lists, 0, count, (cd1, cd2) -> cd1.getTuaCD().compareTo(cd2.getTuaCD()));
    }

}

