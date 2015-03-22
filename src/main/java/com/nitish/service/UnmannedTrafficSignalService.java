package com.nitish.service;

import com.nitish.domain.SignalStateEnum;

import java.math.BigDecimal;

import static com.nitish.domain.SignalStateEnum.*;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class UnmannedTrafficSignalService {

    private final static double STATE_CHANGE_INTERVAL = 20;
    public static final int COUNT_OF_LEFT_TURN_PLUS_U_TURN_STATE = 2;

    public String getSignal(String direction, Long startTime, Long inputTime) {
        boolean isVehicleAllowedFor = isVehicleAllowedFor(direction, startTime, inputTime);
        return isVehicleAllowedFor == true ? "GREEN" : "RED";
    }

    private boolean isVehicleAllowedFor(String direction, Long startTime, Long inputTime) {
        boolean isVehicleAllowedToGo;
        if (LEFT_TURN.getDirections().contains(direction)) {
            isVehicleAllowedToGo = true;
        } else if (U_TURN.getDirections().contains(direction)) {
            isVehicleAllowedToGo = false;
        } else {
            isVehicleAllowedToGo = isVehicleAllowedToGoByState(direction, startTime, inputTime);
        }
        return isVehicleAllowedToGo;
    }

    private boolean isVehicleAllowedToGoByState(String direction, Long startTime, Long inputTime) {
        int signalState = calculateStateByTimeStamp(startTime, inputTime);
        SignalStateEnum signalStateEnum = signalState == 0 ? STATE_6_DIRECTION : getSignalStateEnumMap().get(signalState);
        return signalStateEnum.getDirections().contains(direction) ? TRUE : FALSE;
    }

    private int calculateStateByTimeStamp(Long startTime, Long inputTime) {
        BigDecimal bigDecimal = new BigDecimal((inputTime - startTime) / STATE_CHANGE_INTERVAL).setScale(0, BigDecimal.ROUND_UP);
        return bigDecimal.intValue() % (SignalStateEnum.values().length - COUNT_OF_LEFT_TURN_PLUS_U_TURN_STATE);
    }

}
