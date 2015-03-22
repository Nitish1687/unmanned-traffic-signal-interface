package com.nitish;

import com.nitish.service.UnmannedTrafficSignalService;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class UnmannedVehicleMainTest {

    private static final int THOUSAND_MILLI_SECONDS = 1000;

    public static void main(String[] args) {
        Long startTime = System.currentTimeMillis() / THOUSAND_MILLI_SECONDS;
        Long inputTime;
        String direction;
        guidelineAndWelcomeMessage();
        UnmannedTrafficSignalService unmannedTrafficSignalService = new UnmannedTrafficSignalService();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            direction = scanner.nextLine();
            if (direction.equals("stop")) {
                break;
            }
            getSignalByInputDirection(startTime, direction, unmannedTrafficSignalService);
        }
        exitMessage();
    }

    private static void guidelineAndWelcomeMessage() {
        System.out.println(" ********Welcome To Unmanned Vehicle********** ");
        System.out.println("For your Information, type stop to exit the program:-> ");
        System.out.println("Enter Direction:-> ");
    }

    private static void getSignalByInputDirection(Long startTime, String direction, UnmannedTrafficSignalService unmannedTrafficSignalService) {
        if (StringUtils.isNotEmpty(direction)) {
            String signal = unmannedTrafficSignalService.getSignal(direction, startTime, System.currentTimeMillis() / THOUSAND_MILLI_SECONDS);
            System.out.println(" For you Signal is :-> " + signal);
        }
    }

    private static void exitMessage() {
        System.out.println("End of Program");
        System.out.println("Thanks for using it");
    }
}