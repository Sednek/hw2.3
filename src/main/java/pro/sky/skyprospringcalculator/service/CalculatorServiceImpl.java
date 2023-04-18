package pro.sky.skyprospringcalculator.service;

import org.springframework.stereotype.Service;


@Service
public class CalculatorServiceImpl implements CalculatorService {
    public Float calculatePlus(Float num1, Float num2) {
        return num1 + num2;
    }

    public Float calculateMinus(Float num1, Float num2) {
        return num1 - num2;
    }

    public Float calculateMultiply(Float num1, Float num2) {
        return num1 * num2;
    }

    public Float calculateDivide(Float num1, Float num2) {
        return num1 / num2;
    }
}
