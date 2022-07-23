package ru.netology.java10.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class RadioTest {

    @ParameterizedTest
    @CsvSource({
            "-1, 0",
            "10, 0"
    })
    public void setRadioStationOutOfRange(int newRadioStationNumber, int expected) {
        Radio radio = new Radio();

        radio.setRadioStationNumber(newRadioStationNumber);

        int actual = radio.getCurrentRadioStationNumber();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 1",
            "5, 6",
            "9, 0"
    })
    public void setNextRadioStation(int currentRadioStation, int expected) {
        Radio radio = new Radio();

        radio.setRadioStationNumber(currentRadioStation);
        radio.nextRadioStationNumber();

        int actual = radio.getCurrentRadioStationNumber();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 9",
            "7, 6",
            "9, 8"
    })
    public void setPrevRadioStation(int currentRadioStation, int expected) {
        Radio radio = new Radio();

        radio.setRadioStationNumber(currentRadioStation);
        radio.prevRadioStationNumber();

        int actual = radio.getCurrentRadioStationNumber();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 1",
            "3, 4",
            "10, 10"
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
            "5, 4",
            "10, 9"
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
            "11, 0"
    })
    public void setVolumeOutOfRange(int newVolume, int expected) {
        Radio radio = new Radio();

        radio.setCurrentVolume(newVolume);

        int actual = radio.getCurrentVolume();

        assertEquals(expected, actual);
    }
}
