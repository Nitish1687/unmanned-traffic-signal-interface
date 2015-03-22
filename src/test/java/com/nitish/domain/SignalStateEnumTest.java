package com.nitish.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by ns51815 on 3/21/2015.
 */

@RunWith(MockitoJUnitRunner.class)
public class SignalStateEnumTest {

    @Test
    public void shouldCheckAllLeftTurnPossibility() {
        SignalStateEnum leftTurn = SignalStateEnum.LEFT_TURN;

        List<String> directions = leftTurn.getDirections();

        assertEquals("Left Turn State value ", -1, leftTurn.getState());
        assertTrue(directions.contains("N E"));
        assertTrue(directions.contains("W N"));
        assertTrue(directions.contains("S W"));
        assertTrue(directions.contains("E S"));

    }

    @Test
    public void shouldCheckAllUTurnPossibility() {
        SignalStateEnum uTurn = SignalStateEnum.U_TURN;

        List<String> directions = uTurn.getDirections();

        assertEquals("U Turn State value ", 0, uTurn.getState());
        assertTrue(directions.contains("N N"));
        assertTrue(directions.contains("W W"));
        assertTrue(directions.contains("S S"));
        assertTrue(directions.contains("E E"));
    }

    @Test
    public void shouldCheckAllAllowedPossibilityInState1() {
        SignalStateEnum state1 = SignalStateEnum.STATE_1_DIRECTION;
        SignalStateEnum leftTurn = SignalStateEnum.LEFT_TURN;

        List<String> directions = state1.getDirections();
        List<String> leftTurnDirections = leftTurn.getDirections();

        assertEquals("First State value ", 1, state1.getState());
        assertTrue(directions.contains("N S"));
        assertTrue(directions.contains("S N"));
        assertTrue(leftTurnDirections.contains("N E"));
        assertTrue(leftTurnDirections.contains("S W"));
    }

    @Test
    public void shouldCheckAllAllowedPossibilityInState2() {
        SignalStateEnum state2 = SignalStateEnum.STATE_2_DIRECTION;
        SignalStateEnum leftTurn = SignalStateEnum.LEFT_TURN;

        List<String> directions = state2.getDirections();
        List<String> leftTurnDirections = leftTurn.getDirections();

        assertEquals("Second State value ", 2, state2.getState());
        assertTrue(directions.contains("S E"));
        assertTrue(leftTurnDirections.contains("S W"));
    }

    @Test
    public void shouldCheckAllAllowedPossibilityInState3() {
        SignalStateEnum state3 = SignalStateEnum.STATE_3_DIRECTION;
        SignalStateEnum leftTurn = SignalStateEnum.LEFT_TURN;

        List<String> directions = state3.getDirections();
        List<String> leftTurnDirections = leftTurn.getDirections();

        assertEquals("Third State value ", 3, state3.getState());
        assertTrue(directions.contains("N W"));
        assertTrue(leftTurnDirections.contains("N E"));
    }

    @Test
    public void shouldCheckAllAllowedPossibilityInState4() {
        SignalStateEnum state4 = SignalStateEnum.STATE_4_DIRECTION;
        SignalStateEnum leftTurn = SignalStateEnum.LEFT_TURN;

        List<String> directions = state4.getDirections();
        List<String> leftTurnDirections = leftTurn.getDirections();

        assertEquals("Fourth State value ", 4, state4.getState());
        assertTrue(directions.contains("W E"));
        assertTrue(directions.contains("E W"));
        assertTrue(leftTurnDirections.contains("W N"));
        assertTrue(leftTurnDirections.contains("E S"));
    }

    @Test
    public void shouldCheckAllAllowedPossibilityInState5() {
        SignalStateEnum state5 = SignalStateEnum.STATE_5_DIRECTION;
        SignalStateEnum leftTurn = SignalStateEnum.LEFT_TURN;

        List<String> directions = state5.getDirections();
        List<String> leftTurnDirections = leftTurn.getDirections();

        assertEquals("Fifth State value ", 5, state5.getState());
        assertTrue(directions.contains("W S"));
        assertTrue(leftTurnDirections.contains("W N"));
    }

    @Test
    public void shouldCheckAllAllowedPossibilityInState6() {
        SignalStateEnum state6 = SignalStateEnum.STATE_6_DIRECTION;
        SignalStateEnum leftTurn = SignalStateEnum.LEFT_TURN;

        List<String> directions = state6.getDirections();
        List<String> leftTurnDirections = leftTurn.getDirections();

        assertEquals("Fifth State value ", 6, state6.getState());
        assertTrue(directions.contains("E N"));
        assertTrue(leftTurnDirections.contains("E S"));
    }

    @Test
    public void shouldGetAllTheStateInformationFromSignalStateMap() {
        Map<Integer, SignalStateEnum> signalStateEnumMap = SignalStateEnum.getSignalStateEnumMap();
        assertEquals("Total Number of State in Enum ", 8, signalStateEnumMap.size());
    }
}
