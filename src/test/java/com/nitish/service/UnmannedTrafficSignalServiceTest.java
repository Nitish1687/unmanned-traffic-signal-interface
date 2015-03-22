package com.nitish.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by ns51815 on 3/21/2015.
 */

@RunWith(MockitoJUnitRunner.class)
public class UnmannedTrafficSignalServiceTest {

    private static final int THOUSAND_MILLI_SECOND = 1000;
    private static final int ADD_MILLI_SECONDS_FOR_FIRST_STATE = 2000;
    private static final int ADD_MILLI_SECONDS_FOR_SECOND_STATE = 21000;
    private static final int ADD_MILLI_SECONDS_FOR_THIRD_STATE = 41000;
    private static final int ADD_MILLI_SECONDS_FOR_FOURTH_STATE = 61000;
    private static final int ADD_MILLI_SECONDS_FOR_FIFTH_STATE = 81000;
    private static final int ADD_MILLI_SECONDS_FOR_SIXTH_STATE = 101000;

    @InjectMocks
    private UnmannedTrafficSignalService unmannedSignalService;

    @Test
    public void shouldReturnGreenSignalWhenVehicleIsTakingLeftTurn() {
        String direction = "N E";
        long startTime = System.currentTimeMillis() / THOUSAND_MILLI_SECOND;
        long inputTime = System.currentTimeMillis() / THOUSAND_MILLI_SECOND;

        String signal = unmannedSignalService.getSignal(direction, startTime, inputTime);
        assertEquals(signal, "GREEN");
    }

    @Test
    public void shouldReturnRedSignalWhenVehicleIsTakingUTurn() {
        String direction = "N N";
        long startTime = System.currentTimeMillis() / THOUSAND_MILLI_SECOND;
        long inputTime = System.currentTimeMillis() / THOUSAND_MILLI_SECOND;

        String signal = unmannedSignalService.getSignal(direction, startTime, inputTime);
        assertEquals(signal, "RED");
    }

    @Test
    public void shouldReturnGreenSignalIfVehicleIsComingFromNorthAndWantedToGoToSouthDirectionAtState1() {
        String direction = "N S";
        Long startTime = System.currentTimeMillis() / THOUSAND_MILLI_SECOND;
        Long inputTime = (System.currentTimeMillis() + ADD_MILLI_SECONDS_FOR_FIRST_STATE) / THOUSAND_MILLI_SECOND;

        String signal = unmannedSignalService.getSignal(direction, startTime, inputTime);
        assertEquals(signal, "GREEN");
    }

    @Test
    public void shouldReturnGreenSignalIfVehicleIsComingFromSouthAndWantedToGoNorthDirectionAtState1() {
        String direction = "S N";
        Long startTime = System.currentTimeMillis() / THOUSAND_MILLI_SECOND;
        Long inputTime = (System.currentTimeMillis() + ADD_MILLI_SECONDS_FOR_FIRST_STATE) / THOUSAND_MILLI_SECOND;

        String signal = unmannedSignalService.getSignal(direction, startTime, inputTime);
        assertEquals(signal, "GREEN");
    }

    @Test
    public void shouldReturnRedSignalIfVehicleIsComingFromNorthAndWantedToGoWestDirectionAtState1() {
        String direction = "N W";
        Long startTime = System.currentTimeMillis() / THOUSAND_MILLI_SECOND;
        Long inputTime = (System.currentTimeMillis() + ADD_MILLI_SECONDS_FOR_FIRST_STATE) / THOUSAND_MILLI_SECOND;

        String signal = unmannedSignalService.getSignal(direction, startTime, inputTime);
        assertEquals(signal, "RED");
    }

    @Test
    public void shouldReturnRedSignalIfVehicleIsComingFromSouthAndWantedToGoEastDirectionAtState1() {
        String direction = "S E";
        Long startTime = System.currentTimeMillis() / THOUSAND_MILLI_SECOND;
        Long inputTime = (System.currentTimeMillis() + ADD_MILLI_SECONDS_FOR_FIRST_STATE) / THOUSAND_MILLI_SECOND;

        String signal = unmannedSignalService.getSignal(direction, startTime, inputTime);
        assertEquals(signal, "RED");
    }

    @Test
    public void shouldReturnGreenSignalIfVehicleIsComingFromSouthAndWantedToGoEastDirectionAtState2() {
        String direction = "S E";
        Long startTime = System.currentTimeMillis() / THOUSAND_MILLI_SECOND;
        Long inputTime = (System.currentTimeMillis() + ADD_MILLI_SECONDS_FOR_SECOND_STATE) / THOUSAND_MILLI_SECOND;

        String signal = unmannedSignalService.getSignal(direction, startTime, inputTime);
        assertEquals(signal, "GREEN");
    }

    @Test
    public void shouldReturnGreenSignalIfVehicleIsComingFromSouthAndWantedToTakeLeftTurnDirectionAtState2() {
        String direction = "S W";
        Long startTime = System.currentTimeMillis() / THOUSAND_MILLI_SECOND;
        Long inputTime = (System.currentTimeMillis() + ADD_MILLI_SECONDS_FOR_SECOND_STATE) / THOUSAND_MILLI_SECOND;

        String signal = unmannedSignalService.getSignal(direction, startTime, inputTime);
        assertEquals(signal, "GREEN");
    }

    @Test
    public void shouldReturnRedSignalIfVehicleIsComingFromSouthAndWantedToGoNorthDirectionAtState2() {
        String direction = "S N";
        Long startTime = System.currentTimeMillis() / THOUSAND_MILLI_SECOND;
        Long inputTime = (System.currentTimeMillis() + ADD_MILLI_SECONDS_FOR_SECOND_STATE) / THOUSAND_MILLI_SECOND;

        String signal = unmannedSignalService.getSignal(direction, startTime, inputTime);
        assertEquals(signal, "RED");
    }

    @Test
    public void shouldReturnGreenSignalIfVehicleIsComingFromNorthAndWantedToGoWestDirectionAtState3() {
        String direction = "N W";
        Long startTime = System.currentTimeMillis() / THOUSAND_MILLI_SECOND;
        Long inputTime = (System.currentTimeMillis() + ADD_MILLI_SECONDS_FOR_THIRD_STATE) / THOUSAND_MILLI_SECOND;

        String signal = unmannedSignalService.getSignal(direction, startTime, inputTime);
        assertEquals(signal, "GREEN");
    }

    @Test
    public void shouldReturnGreenSignalIfVehicleIsComingFromNorthAndWantedToGoEastDirectionAtState3() {
        String direction = "N E";
        Long startTime = System.currentTimeMillis() / THOUSAND_MILLI_SECOND;
        Long inputTime = (System.currentTimeMillis() + ADD_MILLI_SECONDS_FOR_THIRD_STATE) / THOUSAND_MILLI_SECOND;

        String signal = unmannedSignalService.getSignal(direction, startTime, inputTime);
        assertEquals(signal, "GREEN");
    }

    @Test
    public void shouldReturnRedSignalIfVehicleIsComingFromNorthAndWantedToGoSouthDirectionAtState3() {
        String direction = "N S";
        Long startTime = System.currentTimeMillis() / THOUSAND_MILLI_SECOND;
        Long inputTime = (System.currentTimeMillis() + ADD_MILLI_SECONDS_FOR_THIRD_STATE) / THOUSAND_MILLI_SECOND;

        String signal = unmannedSignalService.getSignal(direction, startTime, inputTime);
        assertEquals(signal, "RED");
    }

    @Test
    public void shouldReturnGreenSignalIfVehicleIsComingFromWestAndWantedToGoEastDirectionAtState4() {
        String direction = "W E";
        Long startTime = System.currentTimeMillis() / THOUSAND_MILLI_SECOND;
        Long inputTime = (System.currentTimeMillis() + ADD_MILLI_SECONDS_FOR_FOURTH_STATE) / THOUSAND_MILLI_SECOND;

        String signal = unmannedSignalService.getSignal(direction, startTime, inputTime);
        assertEquals(signal, "GREEN");
    }

    @Test
    public void shouldReturnGreenSignalIfVehicleIsComingFromEastAndWantedToGoWestDirectionAtState4() {
        String direction = "E W";
        Long startTime = System.currentTimeMillis() / THOUSAND_MILLI_SECOND;
        Long inputTime = (System.currentTimeMillis() + ADD_MILLI_SECONDS_FOR_FOURTH_STATE) / THOUSAND_MILLI_SECOND;

        String signal = unmannedSignalService.getSignal(direction, startTime, inputTime);
        assertEquals(signal, "GREEN");
    }

    @Test
    public void shouldReturnGreenSignalIfVehicleIsComingFromWestAndWantedToGoNorthDirectionAtState4() {
        String direction = "W N";
        Long startTime = System.currentTimeMillis() / THOUSAND_MILLI_SECOND;
        Long inputTime = (System.currentTimeMillis() + ADD_MILLI_SECONDS_FOR_FOURTH_STATE) / THOUSAND_MILLI_SECOND;

        String signal = unmannedSignalService.getSignal(direction, startTime, inputTime);
        assertEquals(signal, "GREEN");
    }

    @Test
    public void shouldReturnGreenSignalIfVehicleIsComingFromEastAndWantedToGoSouthDirectionAtState4() {
        String direction = "E S";
        Long startTime = System.currentTimeMillis() / THOUSAND_MILLI_SECOND;
        Long inputTime = (System.currentTimeMillis() + ADD_MILLI_SECONDS_FOR_FOURTH_STATE) / THOUSAND_MILLI_SECOND;

        String signal = unmannedSignalService.getSignal(direction, startTime, inputTime);
        assertEquals(signal, "GREEN");
    }

    @Test
    public void shouldReturnRedSignalIfVehicleIsComingFromEastAndWantedToGoNorthDirectionAtState4() {
        String direction = "E N";
        Long startTime = System.currentTimeMillis() / THOUSAND_MILLI_SECOND;
        Long inputTime = (System.currentTimeMillis() + ADD_MILLI_SECONDS_FOR_FOURTH_STATE) / THOUSAND_MILLI_SECOND;

        String signal = unmannedSignalService.getSignal(direction, startTime, inputTime);
        assertEquals(signal, "RED");
    }

    @Test
    public void shouldReturnRedSignalIfVehicleIsComingFromWestAndWantedToGoSouthDirectionAtState4() {
        String direction = "W S";
        Long startTime = System.currentTimeMillis() / THOUSAND_MILLI_SECOND;
        Long inputTime = (System.currentTimeMillis() + ADD_MILLI_SECONDS_FOR_FOURTH_STATE) / THOUSAND_MILLI_SECOND;

        String signal = unmannedSignalService.getSignal(direction, startTime, inputTime);
        assertEquals(signal, "RED");
    }

    @Test
    public void shouldReturnGreenSignalIfVehicleIsComingFromWestAndWantedToGoSouthDirectionAtState5() {
        String direction = "W S";
        Long startTime = System.currentTimeMillis() / THOUSAND_MILLI_SECOND;
        Long inputTime = (System.currentTimeMillis() + ADD_MILLI_SECONDS_FOR_FIFTH_STATE) / THOUSAND_MILLI_SECOND;

        String signal = unmannedSignalService.getSignal(direction, startTime, inputTime);
        assertEquals(signal, "GREEN");
    }

    @Test
    public void shouldReturnGreenSignalIfVehicleIsComingFromWestAndWantedToGoNorthDirectionAtState5() {
        String direction = "W N";
        Long startTime = System.currentTimeMillis() / THOUSAND_MILLI_SECOND;
        Long inputTime = (System.currentTimeMillis() + ADD_MILLI_SECONDS_FOR_FIFTH_STATE) / THOUSAND_MILLI_SECOND;

        String signal = unmannedSignalService.getSignal(direction, startTime, inputTime);
        assertEquals(signal, "GREEN");
    }

    @Test
    public void shouldReturnRedSignalIfVehicleIsComingFromWestAndWantedToGoEastDirectionAtState5() {
        String direction = "W E";
        Long startTime = System.currentTimeMillis() / THOUSAND_MILLI_SECOND;
        Long inputTime = (System.currentTimeMillis() + ADD_MILLI_SECONDS_FOR_FIFTH_STATE) / THOUSAND_MILLI_SECOND;

        String signal = unmannedSignalService.getSignal(direction, startTime, inputTime);
        assertEquals(signal, "RED");
    }

    @Test
    public void shouldReturnGreenSignalIfVehicleIsComingFromEastAndWantedToGoNorthDirectionAtState6() {
        String direction = "E N";
        Long startTime = System.currentTimeMillis() / THOUSAND_MILLI_SECOND;
        Long inputTime = (System.currentTimeMillis() + ADD_MILLI_SECONDS_FOR_SIXTH_STATE) / THOUSAND_MILLI_SECOND;

        String signal = unmannedSignalService.getSignal(direction, startTime, inputTime);
        assertEquals(signal, "GREEN");
    }

    @Test
    public void shouldReturnGreenSignalIfVehicleIsComingFromEastAndWantedToGoSouthDirectionAtState6() {
        String direction = "E S";
        Long startTime = System.currentTimeMillis() / THOUSAND_MILLI_SECOND;
        Long inputTime = (System.currentTimeMillis() + ADD_MILLI_SECONDS_FOR_SIXTH_STATE) / THOUSAND_MILLI_SECOND;

        String signal = unmannedSignalService.getSignal(direction, startTime, inputTime);
        assertEquals(signal, "GREEN");
    }

    @Test
    public void shouldReturnRedSignalIfVehicleIsComingFromEastAndWantedToGoWestDirectionAtState6() {
        String direction = "E W";
        Long startTime = System.currentTimeMillis() / THOUSAND_MILLI_SECOND;
        Long inputTime = (System.currentTimeMillis() + ADD_MILLI_SECONDS_FOR_SIXTH_STATE) / THOUSAND_MILLI_SECOND;

        String signal = unmannedSignalService.getSignal(direction, startTime, inputTime);
        assertEquals(signal, "RED");
    }

}
