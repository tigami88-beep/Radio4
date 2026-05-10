public class Radio {
    private int currentStation;
    private int stationsCount;

    // Конструктор по умолчанию (10 станций)
    public Radio() {
        this.stationsCount = 10;
        this.currentStation = 0;
    }

    // Конструктор с параметром (произвольное количество станций)
    public Radio(int stationsCount) {
        this.stationsCount = stationsCount;
        this.currentStation = 0;
    }

    public void next() {
        if (currentStation == stationsCount - 1) {
            currentStation = 0; // Переход на нулевую, если достигли максимума
        } else {
            currentStation++;
        }
    }

    public void prev() {
        if (currentStation == 0) {
            currentStation = stationsCount - 1; // Переход на последнюю, если мы на нуле
        } else {
            currentStation--;
        }
    }

    public void setCurrentStation(int station) {
        // Проверка, чтобы не установить станцию вне диапазона [0, stationsCount)
        if (station >= 0 && station < stationsCount) {
            this.currentStation = station;
        }
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public int getStationCount() {
        return stationsCount;
    }
}
