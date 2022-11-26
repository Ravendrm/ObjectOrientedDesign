package ru.netology.ObjectOrientedDesign;

public class Radio {

    private int currentRadioStationNumber;
    private int soundVolume;


    public int getCurrentRadioStationNumber() {
        return currentRadioStationNumber;
    }

    public void setCurrentRadioStationNumber(int CurrentRadioStationNumber) {
        if (CurrentRadioStationNumber < 0) {
            return;
        }
        if (CurrentRadioStationNumber > 9) {
            return;
        }
        currentRadioStationNumber = CurrentRadioStationNumber;
    }


    public void next() {
        if (currentRadioStationNumber < 9) {
            currentRadioStationNumber = currentRadioStationNumber + 1;
        } else {
            currentRadioStationNumber = 0;
        }
    }

    public void prev() {
        if (currentRadioStationNumber > 0) {
            currentRadioStationNumber = currentRadioStationNumber - 1;
        } else currentRadioStationNumber = 9;
    }

    public int getSoundVolume() {
        return soundVolume;
    }

    public void SetSoundVolume(int newSoundVolume) {
        if (newSoundVolume > 10) {
            return;
        } else if (newSoundVolume < 0) {
            return;
        } else {
            soundVolume = newSoundVolume;
        }
    }

    public void IncreaseVolume() {
        if (soundVolume < 10) {
            soundVolume = soundVolume + 1;
        }
    }

    public void turnDownVolume() {
        if (soundVolume > 0) {
            soundVolume = soundVolume - 1;
        }
    }
}
