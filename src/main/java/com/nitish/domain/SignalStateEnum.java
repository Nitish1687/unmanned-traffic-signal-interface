package com.nitish.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.EnumSet.allOf;
import static org.apache.commons.lang3.ArrayUtils.isNotEmpty;

public enum SignalStateEnum {

    LEFT_TURN(-1, "N E", "W N", "S W", "E S"),
    U_TURN(0, "N N", "W W", "S S", "E E"),
    STATE_1_DIRECTION(1, "N S", "S N"),
    STATE_2_DIRECTION(2, "S E"),
    STATE_3_DIRECTION(3, "N W"),
    STATE_4_DIRECTION(4, "W E", "E W"),
    STATE_5_DIRECTION(5, "W S"),
    STATE_6_DIRECTION(6, "E N");

    private final int state;
    private List<String> directions;
    private static final Map<Integer, SignalStateEnum> signalStateEnumMap = new HashMap();

    static {
        for (SignalStateEnum signalState : allOf(SignalStateEnum.class)) {
            signalStateEnumMap.put(signalState.getState(), signalState);
        }
    }

    SignalStateEnum(int state, String... directionsVarArgs) {
        this.state = state;
        if (isNotEmpty(directionsVarArgs)) {
            directions = new ArrayList();
            for (String direction : directionsVarArgs) {
                directions.add(direction);
            }
        }
    }

    public int getState() {
        return state;
    }

    public List<String> getDirections() {
        return directions;
    }

    public static Map<Integer, SignalStateEnum> getSignalStateEnumMap() {
        return signalStateEnumMap;
    }
}
