import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @Test
    void testConstructorWithParameter() {
        // Тест на конструктор с параметром: 30 станций
        Radio radio = new Radio(30);

        // Проверяем, что можем дойти до 29
        radio.setCurrentStation(28);
        radio.next();
        assertEquals(29, radio.getCurrentStation());

        // Проверяем переход с 29 на 0 (цикличность)
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void testNextStationBoundary() {
        // Тест на границу next: при 10 станциях после 9 идет 0
        Radio radio = new Radio(10);
        radio.setCurrentStation(9);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void testPrevStationBoundary() {
        // Тест на границу prev: при 10 станциях с 0 идет 9
        Radio radio = new Radio(10);
        radio.setCurrentStation(0);
        radio.prev();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    void testSetStationValid() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(5);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    void testSetStationInvalid() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(5);
        radio.setCurrentStation(12); // Невалидный номер
        // Просто проверяем, что значение осталось 5
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    void testIncreaseVolumeUpperBoundary() {
        // Тест на громкость (верхняя граница)
        Volume volume = new Volume();
        volume.setVolume(99);
        volume.up();
        assertEquals(100, volume.getVolume());

        volume.up(); // Еще раз нажали на 100
        assertEquals(100, volume.getVolume()); // Не должно превысить 100
    }

    @Test
    void testDecreaseVolumeLowerBoundary() {
        // Тест на громкость (нижняя граница)
        Volume volume = new Volume();
        volume.setVolume(1);
        volume.down();
        assertEquals(0, volume.getVolume());

        volume.down(); // Еще раз нажали на 0
        assertEquals(0, volume.getVolume()); // Не должно уйти в минус
    }
}