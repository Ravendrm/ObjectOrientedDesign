package ru.netology.ObjectOrientedDesign;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {

    @Test
    public void ShouldSetRadio() {
        Radio radio = new Radio();

        radio.setCurrentRadioStationNumber(3);

        int expected = 3;
        int actual = radio.getCurrentRadioStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldNotSetMaxRadio() {
        Radio radio = new Radio();

        radio.setCurrentRadioStationNumber(15);

        int expected = 0;
        int actual = radio.getCurrentRadioStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldNotSetMinRadio() {
        Radio radio = new Radio();

        radio.setCurrentRadioStationNumber(-5);

        int expected = 0;
        int actual = radio.getCurrentRadioStationNumber();

        Assertions.assertEquals(expected, actual);
    } // Диапазон меньше

    @Test
    public void ShouldSetMaxRadio() {
        Radio radio = new Radio();

        radio.setCurrentRadioStationNumber(9);

        int expected = 9;
        int actual = radio.getCurrentRadioStationNumber();

        Assertions.assertEquals(expected, actual);
    } // верхнее граничное значение

    @Test
    public void ShouldNotSetRadioMax() {
        Radio radio = new Radio();

        radio.setCurrentRadioStationNumber(10);

        int expected = 0;
        int actual = radio.getCurrentRadioStationNumber();

        Assertions.assertEquals(expected, actual);
    } // Значение за пределами верхней границы

    @Test
    public void ShouldSetMinRadio() {
        Radio radio = new Radio();

        radio.setCurrentRadioStationNumber(0);

        int expected = 0;
        int actual = radio.getCurrentRadioStationNumber();

        Assertions.assertEquals(expected, actual);
    } // нижняя граница диапазона

    @Test
    public void ShouldNotSetRadioMin() {
        Radio radio = new Radio();

        radio.setCurrentRadioStationNumber(-1);

        int expected = 0;
        int actual = radio.getCurrentRadioStationNumber();

        Assertions.assertEquals(expected, actual);
    } // значение за пределами нижней границы

    @Test
    public void RadioNumberChangeUp() {
        Radio radio = new Radio();
        radio.setCurrentRadioStationNumber(2);

        radio.next();

        int expected = 3;
        int actual = radio.getCurrentRadioStationNumber();

        Assertions.assertEquals(expected, actual);
    } // проверка метода Next

    @Test
    public void RadioNumberChangeUpBeyond() {
        Radio radio = new Radio();
        radio.setCurrentRadioStationNumber(9);

        radio.next();

        int expected = 0;
        int actual = radio.getCurrentRadioStationNumber();

        Assertions.assertEquals(expected, actual);
    } // проверка что при выходе за диапазон станция не переключиться

    @Test
    public void RadioNumberChangeDown() {
        Radio radio = new Radio();
        radio.setCurrentRadioStationNumber(3);

        radio.prev();

        int expected = 2;
        int actual = radio.getCurrentRadioStationNumber();

        Assertions.assertEquals(expected, actual);
    } // проверка метода Previous

    @Test
    public void radioNumberChangeDownBeyond() {
        Radio radio = new Radio();
        radio.setCurrentRadioStationNumber(0);

        radio.prev();

        int expected = 9;
        int actual = radio.getCurrentRadioStationNumber();

        Assertions.assertEquals(expected, actual);
    } // проверка метода Previous при переходе с нулевой станции, переход будет на станцию 9

    @Test
    public void Volume() {
        Radio radio = new Radio();
        radio.SetSoundVolume(7);

        int expected = 7;
        int actual = radio.getSoundVolume();

        Assertions.assertEquals(expected, actual);
    } // уровень громкости


    @Test
    public void VolumeBeyondMin() {
        Radio radio = new Radio();
        radio.SetSoundVolume(-1);

        int expected = 0;
        int actual = radio.getSoundVolume();

        Assertions.assertEquals(expected, actual);
    } // переключение на диапазон меньше ни к чему не приводит


    @Test
    public void VolumeMax() {
        Radio radio = new Radio();
        radio.SetSoundVolume(10);

        int expected = 10;
        int actual = radio.getSoundVolume();

        Assertions.assertEquals(expected, actual);
    } // крайняя верхнаяя допустимая граница

    @Test
    public void VolumeBeyondMax() {
        Radio radio = new Radio();
        radio.SetSoundVolume(11);

        int expected = 0;
        int actual = radio.getSoundVolume();

        Assertions.assertEquals(expected, actual);
    } // переключение за верхний допустимый диапазон ни к чему не приводит


    @Test
    public void ShouldIncreaseVolumeWhenZero() {
        Radio radio = new Radio();
        radio.SetSoundVolume(0);

        radio.IncreaseVolume();

        int expected = 1;
        int actual = radio.getSoundVolume();

        Assertions.assertEquals(expected, actual);
    } // увеличение громкости при текущей громкости 0


    @Test
    public void shouldIncreaseVolumeToMaxLevel() {
        Radio radio = new Radio();
        radio.SetSoundVolume(9);

        radio.IncreaseVolume();

        int expected = 10;
        int actual = radio.getSoundVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldNotIncreaseVolumeBeyondMax() {
        Radio radio = new Radio();
        radio.SetSoundVolume(10);

        radio.IncreaseVolume();

        int expected = 10;
        int actual = radio.getSoundVolume();

        Assertions.assertEquals(expected, actual);
    } // проверка невозможности увеличения громкости за предел диапазона

    @Test
    public void ShouldReduceVolumeMin() {
        Radio radio = new Radio();
        radio.SetSoundVolume(0);

        radio.turnDownVolume();

        int expected = 0;
        int actual = radio.getSoundVolume();

        Assertions.assertEquals(expected, actual);
    } // уменьшение громкости на 1 при уровне громкости = 0

    @Test
    public void ShouldReduceVolumeMax() {
        Radio radio = new Radio();
        radio.SetSoundVolume(1);

        radio.turnDownVolume();

        int expected = 0;
        int actual = radio.getSoundVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldReduceVolume() {
        Radio radio = new Radio();
        radio.SetSoundVolume(6);

        radio.turnDownVolume();

        int expected = 5;
        int actual = radio.getSoundVolume();

        Assertions.assertEquals(expected, actual);
    } // уменьшение громкости работает

    @Test
    public void shouldReduceVolumeWhenMax10() {
        Radio radio = new Radio();
        radio.SetSoundVolume(10);

        radio.turnDownVolume();

        int expected = 9;
        int actual = radio.getSoundVolume();

        Assertions.assertEquals(expected, actual);
    } // при максимальном уровне громкости уменьшение работает
}
