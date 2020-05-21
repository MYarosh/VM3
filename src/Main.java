import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    int a,b;


    public static void main(String[] args){
        try {
            Scanner scanner = new Scanner(System.in);
            PrintWriter printWriter = new PrintWriter(System.out);
            scanner.useLocale(new Locale("Russian"));
            Equation func = new Equation();
            String[] line = new String[5];
            boolean cycle = true;
            while(cycle) {
                System.out.println("Выберите тип ввода(0 - из файла, 1 - с клавиатуры): ");

                switch (scanner.next()) {
                    case ("0"): {
                        System.out.println("Введите полный путь к файлу: ");
                        String path = scanner.next();
                        FileReader fr = new FileReader(path);
                        BufferedReader reader = new BufferedReader(fr);
                        line = reader.readLine().split(" ");
                        cycle = false;
                        break;
                    }
                    case ("1"): {
                        System.out.println("Введите левую границу:");
                        line[0] = scanner.next();
                        System.out.println("Введите правую границу:");
                        line[1] = scanner.next();
                        System.out.println("Введите погрешность:");
                        line[3] = scanner.next();
                        cycle = false;
                        break;
                    }
                    default: {
                        System.out.println("Wrong answer. Try again.");
                        break;
                    }
                }
            }
            cycle = true;
            String answer = "";
            while (cycle) {
                System.out.println("Выберите метод:\n" +
                        "Метод половинного деления – 1,\n" +
                        "Метод хорд – 2,\n" +
                        "Метод Ньютона – 3,\n" +
                        "Метод секущих – 4,\n" +
                        "Метод простой итерации – 5");
                switch (scanner.next()) {
                    case ("1"): {
                        answer = HalfDel.run(Double.parseDouble(line[0]), Double.parseDouble(line[1]), Double.parseDouble(line[3]), func);
                        cycle = false;
                        break;
                    }
                    case ("2"): {
                        answer = Hord.run(Double.parseDouble(line[0]), Double.parseDouble(line[1]), Double.parseDouble(line[3]), func);
                        cycle = false;
                        break;
                    }
                    case ("3"): {
                        answer = Newton.run(Double.parseDouble(line[0]), Double.parseDouble(line[1]), Double.parseDouble(line[3]), func);
                        cycle = false;
                        break;
                    }
                    case ("4"): {
                        answer = Secant.run(Double.parseDouble(line[0]), Double.parseDouble(line[1]), Double.parseDouble(line[3]), func);
                        cycle = false;
                        break;
                    }
                    case ("5"): {
                        answer = Iterat.run(Double.parseDouble(line[0]), Double.parseDouble(line[1]), Double.parseDouble(line[3]), func);
                        cycle = false;
                        break;
                    }
                    default: {
                        System.out.println("Wrong answer. Try again.");
                        break;
                    }
                }
                cycle = true;
                while(cycle) {
                    System.out.println("Выберите тип вывода(0 - в файла, 1 - на экран): ");

                    switch (scanner.next()) {
                        case ("0"): {
                            System.out.println("Введите полный путь к файлу: ");
                            String path = scanner.next();
                            FileWriter fw = new FileWriter(path, false);
                            fw.write(answer);
                            fw.flush();
                            cycle = false;
                            break;
                        }
                        case ("1"): {
                            System.out.println(answer);
                            cycle = false;
                            break;
                        }
                        default: {
                            System.out.println("Wrong answer. Try again.");
                            break;
                        }
                    }
                }
                Graphic graphic = new Graphic();
                graphic.draw(Double.parseDouble(line[0]), Double.parseDouble(line[1]),func);
            }
        }catch (FileNotFoundException e){
            System.out.println("Файл не найден.");
        }catch (IOException e){
            System.out.println("Ошибка ввода-вывода.");
        }catch (NumberFormatException e){
            System.out.println("Введено не число.");
        }
    }
}
