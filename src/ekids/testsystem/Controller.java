package ekids.testsystem;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Controller {

    @FXML
    private Text questionText;

    @FXML
    private RadioButton radioBtn4;

    @FXML
    private RadioButton radioBtn3;

    @FXML
    private RadioButton radioBtn2;

    @FXML
    private RadioButton radioBtn1;

    @FXML
    private ToggleGroup answers;

    @FXML
    private Button closeProgram;

    @FXML
    private Button answerBtn;

    private Questions[] questions = new Questions[]{
            new Questions("В каком из вариантов представлен корректный формат вывода информации на экран?", new String[]{"Console.Write()", "console.log()", "print()", "System.out.println()"}),
            new Questions("Какой тип данных отвечает за целые числа?", new String[]{"String", "Float", "Boolean", "Integer"}),
            new Questions("Где правильно присвоено новое значение к многомерному массиву?", new String[]{"a(0)(0) = 1;", "a[0 0] = 1;", "a{0}{0} = 1;", "a[0][0] = 1;"}),
            new Questions("Каждый файл должен называется...", new String[]{"по имени первой библиотеки в нём", "по имени названия пакета", "как вам захочется", "по имени класса в нём"}),
            new Questions("Сколько параметров может принимать функция?", new String[]{"5", "10", "20", "неограниченное количество"})
    };

    private int nowQuestion, correctAnswers;
    private String nowCorrectAnswer;

    @FXML
    public void initialize() {
        /* Объединение в     ToggleGroup в коде
        ToggleGroup group = new ToggleGroup();
        radioButton.setToggleGroup(group);
        radioButton2.setToggleGroup(group);*/

        nowCorrectAnswer = questions[nowQuestion].correctAnswer();

        answerBtn.setOnAction(action -> {
            System.out.println(nowCorrectAnswer);
            RadioButton selected = (RadioButton) answers.getSelectedToggle();

            if(selected != null) {
                if (nowCorrectAnswer.equals(selected.getText())) {
                    System.out.println("Верный ответ");
                    correctAnswers++;
                } else {
                    System.out.println("Не верный ответ");
                }

                if (nowQuestion + 1 == questions.length) {
                    radioBtn1.setVisible(false);
                    radioBtn2.setVisible(false);
                    radioBtn3.setVisible(false);
                    radioBtn4.setVisible(false);
                    answerBtn.setVisible(false);

                    questionText.setText("Вы ответили корректно на " + correctAnswers + " из " + questions.length + " вопросов!");
                } else {
                    nowQuestion++;
                    nowCorrectAnswer = questions[nowQuestion].correctAnswer();
                    questionText.setText(questions[nowQuestion].getQuestion());

                    //перемешивает варианты ответа
                    String[] answers = questions[nowQuestion].getAnswers();
                    List<String> answersList = Arrays.asList(answers);
                    Collections.shuffle(answersList);

                    radioBtn1.setText(answersList.get(0));
                    radioBtn2.setText(answersList.get(1));
                    radioBtn3.setText(answersList.get(2));
                    radioBtn4.setText(answersList.get(3));

                    selected.setSelected(false);
                }
            }

        });
    }
}

