package ru.netology.java10.service;
public class Radio {
    public int currentRadioStationNumber;
    public int currentVolume;

    public int getCurrentRadioStationNumber() {
        return currentRadioStationNumber;
    }

    public void setRadioStationNumber(int newRadioStationNumber) {
        if (newRadioStationNumber < 0) {
            return;
        }
        if (newRadioStationNumber > 9) {
            return;
        }
        currentRadioStationNumber = newRadioStationNumber;
    }

    public void nextRadioStationNumber() {
        if (currentRadioStationNumber == 9) {
            setRadioStationNumber(0);
        } else {
            int target = currentRadioStationNumber + 1;
            setRadioStationNumber(target);
        }
    }

    public void prevRadioStationNumber() {
        if (currentRadioStationNumber == 0) {
            setRadioStationNumber(9);
        } else {
            int target = currentRadioStationNumber - 1;
            setRadioStationNumber(target);
        }
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int newVolume) {
        if (newVolume < 0) {
            return;
        }
        if (newVolume > 10) {
            return;
        }
        currentVolume = newVolume;
    }

    public void increaseVolume() {
        if (currentVolume < 10) {
            int target = currentVolume + 1;
            setCurrentVolume(target);
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 0) {
            int target = currentVolume - 1;
            setCurrentVolume(target);
        }
    }
}
