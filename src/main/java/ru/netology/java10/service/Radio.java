package ru.netology.java10.service;
public class Radio {
    private int radioStationsAmount;
    private int maxRadioStationNumber;
    private int minRadioStationNumber = 0;
    private int currentRadioStationNumber;
    private int minVolume = 0;
    private int maxVolume = 100;
    private int currentVolume;

    public Radio (int radioStationsAmount) {
        this.radioStationsAmount = radioStationsAmount;
        this.maxRadioStationNumber = radioStationsAmount - 1;
    }

    public Radio () {
        this.radioStationsAmount = 10;
        this.maxRadioStationNumber = this.radioStationsAmount - 1;
    }

    public int getRadioStationsAmount() {
        return radioStationsAmount;
    }

    public int getCurrentRadioStationNumber() {
        return currentRadioStationNumber;
    }

    public void setRadioStationNumber(int newRadioStationNumber) {
        if (newRadioStationNumber < minRadioStationNumber) {
            return;
        }
        if (newRadioStationNumber > maxRadioStationNumber) {
            return;
        }
        currentRadioStationNumber = newRadioStationNumber;
    }

    public void nextRadioStationNumber() {
        if (currentRadioStationNumber == maxRadioStationNumber) {
            setRadioStationNumber(minRadioStationNumber);
        } else {
            int target = currentRadioStationNumber + 1;
            setRadioStationNumber(target);
        }
    }

    public void prevRadioStationNumber() {
        if (currentRadioStationNumber == minRadioStationNumber) {
            setRadioStationNumber(maxRadioStationNumber);
        } else {
            int target = currentRadioStationNumber - 1;
            setRadioStationNumber(target);
        }
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int newVolume) {
        if (newVolume < minVolume) {
            return;
        }
        if (newVolume > maxVolume) {
            return;
        }
        currentVolume = newVolume;
    }

    public void increaseVolume() {
        if (currentVolume < maxVolume) {
            int target = currentVolume + 1;
            setCurrentVolume(target);
        }
    }

    public void decreaseVolume() {
        if (currentVolume > minVolume) {
            int target = currentVolume - 1;
            setCurrentVolume(target);
        }
    }
}
