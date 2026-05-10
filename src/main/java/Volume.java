public class Volume {
    private int volume;

    public Volume() {
        this.volume = 50; // Значение по умолчанию
    }

    public void up() {
        if (volume < 100) {
            volume++;
        }
    }

    public void down() {
        if (volume > 0) {
            volume--;
        }
    }

    public void setVolume(int volume) {
        if (volume >= 0 && volume <= 100) {
            this.volume = volume;
        }
    }

    public int getVolume() {
        return volume;
    }
}
