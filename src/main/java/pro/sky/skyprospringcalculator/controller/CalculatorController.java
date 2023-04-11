package pro.sky.skyprospringcalculator.controller;


import org.springframework.web.bind.annotation.*;
import pro.sky.skyprospringcalculator.service.CalculatorService;

@RestController
@RequestMapping(path = "/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String printHello() {
        return "<b>Добро пожаловать в калькулятор!</b>";
    }

    @GetMapping(path = "/plus")
    public String plusPage(@RequestParam(value = "num1", required = false) Float num1, @RequestParam(value = "num2", required = false) Float num2) {
        String err = numsCheck(num1, num2);
        if (!err.equals("200")) {
            return err;
        }
        return num1 + " + " + num2 + " = "  + calculatorService.calculatePlus(num1, num2);
    }

    @GetMapping(path = "/minus")
    public String minusPage(@RequestParam(value = "num1", required = false) Float num1, @RequestParam(value = "num2", required = false) Float num2) {
        String err = numsCheck(num1, num2);
        if (!err.equals("200")) {
            return err;
        }
        return num1 + " - " + num2 + " = "  + calculatorService.calculateMinus(num1, num2);
    }

    @GetMapping(path = "/multiply")
    public String multiplyPage(@RequestParam(value = "num1", required = false) Float num1, @RequestParam(value = "num2", required = false) Float num2) {
        String err = numsCheck(num1, num2);
        if (!err.equals("200")) {
            return err;
        }
        return num1 + " * " + num2 + " = "  + calculatorService.calculateMultiply(num1, num2);
    }

    @GetMapping(path = "/divide")
    public String dividePage(@RequestParam(value = "num1", required = false) Float num1, @RequestParam(value = "num2", required = false) Float num2) {
        String err = numsCheck(num1, num2);
        if (!err.equals("200")) {
            return err;
        }
        if(num2 == 0){
            return "Делить на ноль нельзя!";
        }
        return num1 + " / " + num2 + " = "  + calculatorService.calculateDivide(num1, num2);
    }

    public String numsCheck(Float num1, Float num2){
        if(num1 == null){
            return "Не передано первое число!";
        }else if(num2 == null){
            return "Не передано второе число!";
        }
        return "200";
    }
}


