package ru.netology.java10.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class RadioTest {

    @ParameterizedTest
    @CsvSource({
            "10, -1, 0",
            "10, 10, 0",
            "30, 30, 0",
            "30, -1, 0",
            "6, 6, 0",
            "6, -1, 0"
    })
    public void setRadioStationOutOfRange(int radioStationsAmount, int newRadioStationNumber, int expected) {
        Radio radio = new Radio(radioStationsAmount);

        radio.setRadioStationNumber(newRadioStationNumber);

        int actual = radio.getCurrentRadioStationNumber();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "10, 0, 1",
            "10, 1, 2",
            "10, 8, 9",
            "10, 9, 0",
            "30, 0, 1",
            "30, 1, 2",
            "30, 29, 0",
            "30, 28, 29",
            "6, 0, 1",
            "6, 1, 2",
            "6, 5, 0",
            "6, 4, 5",
    })
    public void setNextRadioStation(int radioStationsAmount, int currentRadioStation, int expected) {
        Radio radio = new Radio(radioStationsAmount);

        radio.setRadioStationNumber(currentRadioStation);
        radio.nextRadioStationNumber();

        int actual = radio.getCurrentRadioStationNumber();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "10, 0, 9",
            "10, 1, 0",
            "10, 8, 7",
            "10, 9, 8",
            "30, 0, 29",
            "30, 1, 0",
            "30, 29, 28",
            "30, 28, 27",
            "6, 0, 5",
            "6, 1, 0",
            "6, 5, 4",
            "6, 4, 3",
    })
    public void setPrevRadioStation(int radioStationsAmount,int currentRadioStation, int expected) {
        Radio radio = new Radio(radioStationsAmount);

        radio.setRadioStationNumber(currentRadioStation);
        radio.prevRadioStationNumber();

        int actual = radio.getCurrentRadioStationNumber();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldSetDefaultRadioStation() {
        Radio radio = new Radio();

        int actual = radio.getRadioStationsAmount();

        assertEquals(10, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 1",
            "1, 2",
            "99, 100",
            "100, 100",
    })
    public void shouldIncreaseVolume(int currentVolume, int expected) {
        Radio radio = new Radio();

        radio.setCurrentVolume(currentVolume);
        radio.increaseVolume();

        int actual = radio.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1, 0",
            "100, 99",
            "99, 98"
    })
    public void shouldDecreaseVolume(int currentVolume, int expected) {
        Radio radio = new Radio();

        radio.setCurrentVolume(currentVolume);
        radio.decreaseVolume();

        int actual = radio.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "-1, 0",
            "101, 0"
    })
    public void setVolumeOutOfRange(int newVolume, int expected) {
        Radio radio = new Radio();

        radio.setCurrentVolume(newVolume);

        int actual = radio.getCurrentVolume();

        assertEquals(expected, actual);
    }
}
