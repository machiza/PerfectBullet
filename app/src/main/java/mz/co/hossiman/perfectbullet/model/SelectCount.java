package mz.co.hossiman.perfectbullet.model;

/**
 * Created by secreto on 3/11/18.
 */

public class SelectCount {

    private int thumbial;
    private int count;

    public SelectCount() {
    }

    public SelectCount(int thumbial, int count) {
        this.thumbial = thumbial;
        this.count = count;
    }

    public int getThumbial() {
        return thumbial;
    }

    public void setThumbial(int thumbial) {
        this.thumbial = thumbial;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
