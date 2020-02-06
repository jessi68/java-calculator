/*
 * Copyright (c) 2019 by tiger,DDoring
 * All rights reserved.
 *
 * Main.java
 * 프로그램 시작을 담당하는 클래스
 *
 * @author      tiger,DDoring
 * @version     1.0
 * @date        06 Feb 2020
 *
 */

package main;

import validator.InputValidator;
import view.InputView;

public class Main {
    public static void main(String[] args){
        InputView input = new InputView();
        String inputString = input.inputStringFromUser();
        //트루 반환하면 계산 시작~~
        new InputValidator(inputString).checkInput();
    }
}
