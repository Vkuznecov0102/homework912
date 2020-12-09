package ru.itsJava;

import java.io.*;

public class Files {

    public static void main(String[] args) {
        File file = new File("src/main/resources/first.txt");
        try (PrintWriter printWriter = new PrintWriter(file)) {
            printWriter.println("Генеральный директор российской части Евро-2020 Алексей Сорокин высказался о проблеме расизма на футбольных матчах на фоне вчерашнего инцидента в матче Лиги чемпионов между «ПСЖ» и «Истанбулом».\n" +
                    "\n" +
                    "«Нам давно задают вопросы по этой теме, но наш опыт больших матчей и больших турниров подсказывает, что в России не склонны так поступать уже давно. Тема в значительной степени потеряла градус по сравнению с периодом несколько лет назад.\n" +
                    "\n" +
                    "Нет, мы не боимся, [что такое может быть на матчах Евро]. Думаю, что таких идей ни у кого нет, вдобавок система Fan ID помогает.\n" +
                    "\n" +
                    "В значительной степени наше футбольное сообщество излечилось от этих глупостей. Исключения возможны, но они могут стать только исключениями», – сказал Сорокин. ");
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

        File secondFile = new File("src/main/resources/second.txt");
        try (PrintWriter printWriter = new PrintWriter(secondFile)) {
            printWriter.println("Главный тренер «Челси» Фрэнк Лэмпард рассказал о состоянии травмированных полузащитников Каллума Хадсона-Одои и Хакима Зиеша.\n" +
                    "\n" +
                    "«Как показало обследование, каждый из них пропустит около двух недель, и это успокаивает, особенно в свете опасений относительно повреждения Хакима.\n" +
                    "\n" +
                    "Что касается Каллума, то мы не знали, чего ожидать, поскольку он получил травму всего пару дней назад на тренировке», – сказал Лэмпард.\n" +
                    "\n" +
                    "Ранее стало известно, что у Зиеша диагностировано повреждение задней поверхности бедра.");
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

        File tmp = new File("src/main/resources/tmp.txt");
        try (FileReader fileReader = new FileReader(file);
             FileWriter fileWriter = new FileWriter(tmp)) {

            int input = fileReader.read();
            while (input != -1) {
                fileWriter.write(input);
                input = fileReader.read();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        try (FileReader fileReader = new FileReader(secondFile);
             FileWriter fileWriter = new FileWriter(file)) {

            int input = fileReader.read();
            while (input != -1) {
                fileWriter.write(input);
                input = fileReader.read();
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        }

        try (FileReader fileReader = new FileReader(tmp);
             FileWriter fileWriter = new FileWriter(secondFile)) {

            int input = fileReader.read();
            while (input != -1) {
                fileWriter.write(input);
                input = fileReader.read();
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        }

        try (PrintWriter writer = new PrintWriter(tmp)) {
            writer.print("");
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }


    }
}
