import java.util.Scanner;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        /*1)	Найти корни квадратного уравнения и вывести их на экран, если они есть.
        Если корней нет, то вывести сообщение об этом. Конкретное квадратное
        уравнение определяется коэффициентами a, b, c, которые вводит пользователь.*/
        System.out.println("Введите коэффециенты квадратного уровнения вида ax^2+bx+c=0");
        System.out.print("а = "); float varA = in.nextFloat();
        System.out.print("b = "); float varB = in.nextFloat();
        System.out.print("c = "); float varC = in.nextFloat();
        float disc = (float)pow(varB, 2) - 4 * varA * varC; //float явно тут, т.к. метод pow возвращает double

        if ((varA * varB * varC) == 0)
            System.out.println("Ваше уравнение не имеет смысла, 0=0");
        else if ((varA * varB) == 0)
            System.out.println("Ваше уравнение не имеет решения: " + varC + "=0"); //только c != 0, ур-е вида 2=0
        else if ((varA * varC) == 0)
            System.out.println("Ваше уравнение линейное, его корень: 0"); //только b != 0, ур-е вида 2x=0, x=0
        else if ((varB * varC) == 0)
            System.out.println("Ваше уравнение линейное, его корень: 0"); //только a != 0, ax^2=0 > x^2=0 > x=0
        else if (varA == 0.0f && ((varB * varC) != 0))
            System.out.println("Ваше уравнение линейное, его корень: " + -1 * (varC/varB)); //а=0, b и c != 0
        else if (varB == 0.0f && ((varA * varC) != 0)) { //если b = 0, a и c != 0
            System.out.println(varC/varA < 0.0f ? "Ваше уравнение не имеет корней, т.к. x^2 всегда положительный" : // "x^2 = отрицательное число" не имеет решений
                    "Ваше уравнение имеет два корня: " + sqrt(-1 * (varC/varA)) + " и " + -1 * sqrt(-1 * (varC/varA))); //решением уравнения является модуль числа
        }
        else if (varC == 0.0f && ((varB * varA) != 0))
            System.out.println("Вашу уравнение имеет два корня: 0 и " + (-1 * (varB/varA)));
        else if (disc < 0)
            System.out.println ("Ваше уравнение не имеет решения, D < 0"); //Дискриминант < 0, корней нет
        else if (disc == 0)
            System.out.println ("У вашего уравнения один корень: " + (-1 * varB)/(2 * varA)); //D = 0, один корень
        else
            System.out.println ("Ваше уравнение имеет два корня: " + (((-1 * varB) + sqrt(disc)) / (2 * varA)) + " и " + (((-1 * varB) - sqrt(disc)) / (2 * varA))); //И наконец два обычных корня из дискриминанта

        /*2)	Вводятся два целых числа. Проверить делится ли первое на второе без остатка.
        Вывести на экран сообщение об этом, а также остаток (если он есть)
        и частное (в любом случае)*/
        System.out.print("Введите делимое: "); short num1 = in.nextShort();
        System.out.print("Введите делитель: "); short num2 = in.nextShort();
        System.out.println((num1%num2) == 0 ? "Ваши числа делятся нацело, результат деления " + num1/num2 :
                "Ваши числе не делятся нацело, результат деления " + num1/num2 + " остаток " + num1%num2);

        /*3)	Дана следующая функция y=f(x):
        y = 2x - 10, если x > 0
        y = 0, если x = 0
        y = 2 * |x| - 1, если x < 0*/
        System.out.print("Введите х = "); short x = in.nextShort();
        if (x > 0)
            System.out.println("Ваше уравнение y = 2* " + x + " -10, его решение y = " + (2 * x - 10));
        else if (x == 0)
            System.out.println("Ваше уравнение y = 0");
        else
            System.out.println("Ваше уравнение y = 2 * |x| - 1, его решение y = " + (2 * abs(x) - 1));

        /*4)	Создать меню выбора цвета (минимум 8 цветов).
        В зависимости от выбора вывести RGB координаты.*/
        System.out.print("Выберите цвет из списка и введите первую букву выбранного цвета: " +
                "\nкрасный, оранжевый, желтый, зеленый, голубой, синий, фиолетовый, черный, белый" +
                "\nВаш цвет: ");
//        String color = in.nextLine(); я бы так сделал и заставил фул слово вводить
        char color = in.next().charAt(0);
        switch (color) {
            case 'к': System.out.println("Ваш цвет красный! Его RGB код FF0000"); break;
            case 'о': System.out.println("Ваш цвет оранжевый! Его RGB код FF8000"); break;
            case 'ж': System.out.println("Ваш цвет желтый! Его RGB код FFFF00"); break;
            case 'з': System.out.println("Ваш цвет зеленый! Его RGB код 00FF00"); break;
            case 'г': System.out.println("Ваш цвет голубой! Его RGB код 00FFFF"); break;
            case 'с': System.out.println("Ваш цвет синий! Его RGB код 0000FF"); break;
            case 'ф': System.out.println("Ваш цвет фиолетовый! Его RGB код FF00FF"); break;
            case 'ч': System.out.println("Ваш цвет черный! Его RGB код 000000"); break;
            case 'б': System.out.println("Ваш цвет белый! Его RGB код FFFFFF"); break;
            default: System.out.println("Вы ввели не один из вариантов :-("); break;
        }

        /*6)  Вводятся координаты (x;y) точки и радиус круга (r).
                Определить принадлежит ли данная точка кругу,
                если его центр находится в начале координат.*/
        System.out.println("Введите координаты точки x и y, а также радиус окружности r");
        System.out.print("х = "); short sixX = in.nextShort();
        System.out.print("y = "); short sixY = in.nextShort();
        System.out.print("r = "); short sixR = in.nextShort();
        System.out.println(sixR <= (sqrt(pow(sixX,2) + pow(sixY,2))) ? "Точка находится внутри или на окружности" : "Точка находится за пределами окружности");
        //Тут я проверил, sqrt возвращает нам double, сравнивается с short корректно

        /*7)  Пользователь вводит стороны треугольника.
        Определить существование треугольника и его тип.
        Треугольник существует только тогда, когда сумма длин любых его двух сторон больше третьей стороны.
        Иначе две стороны просто «укладываются» на третьей.
        Треугольник является разносторонним, если все его стороны имеют разную длину;
        треугольник будет равнобедренным, если любые две его стороны равны между собой, но отличны от третьей;
        и треугольник является равносторонним, когда все его стороны равны.*/
        System.out.print("Введите длинну трёх сторон треугольника.");
        System.out.print("1я сторона равна "); short sev1 = in.nextShort();
        System.out.print("2я сторона равна "); short sev2 = in.nextShort();
        System.out.print("3я сторона равна "); short sev3 = in.nextShort();

        if ((sev1 > sev2 + sev3) || (sev2 > sev1 + sev3) || (sev3 > sev1 + sev2))
            System.out.println("Ваш треугольник не может существовать, т.к. сумма двух его сторон меньше третьей стороны");
        else if ((sev1 != sev2) && (sev1 != sev3) && (sev2 != sev3))
            System.out.println("Ваш треугольник является разносторонним");
        else if (sev1 == sev2 && sev1 == sev3)
            System.out.println("Ваш треугольник является равносторонним");
        else System.out.println("Ваш треугольник является равнобедренным");

        /*8) Определить високосный год или нет вводит пользователь.*/
        System.out.print("Введите любой год "); int eigYear = in.nextShort();
        System.out.println((abs(eigYear-1992)%4) == 0 ? "Вы ввели високосный год" : "Вы ввели не високосный год");

        /*9) Заглавная буква английского языка или иной символ введён пользователем?*/
        System.out.print("Введите любой символ "); char nineSymb = in.next().charAt(0);
        System.out.println( (((int)nineSymb >= 65) && ((int)nineSymb <= 90)) ?
                "Ваш символ - заглавная буква латинского алфавита" :
                "Ваш символ - не заглавная буква латинского алфавита");

        /*10) Среди трех введённых пользователем чисел найти среднее.*/
        System.out.println("Введите три числа (short)");
        System.out.print("Введите первое число "); short ten1 = in.nextShort();
        System.out.print("Введите второе число "); short ten2 = in.nextShort();
        System.out.print("Введите третье число "); short ten3 = in.nextShort();

        if (((ten1 > ten2) && (ten1 < ten3)) || ((ten1 < ten2) && (ten1 > ten3)))
            System.out.println("Среднее число первое: " + ten1);
        else if (((ten2 > ten1) && (ten2 < ten3)) || ((ten2 < ten1) && (ten2 > ten3)))
            System.out.println("Среднее число второе: " + ten2);
        else if (((ten3 > ten2) && (ten3 < ten1)) || ((ten3 < ten2) && (ten3 > ten1)))
            System.out.println("Среднее число третье: " + ten3);
        else if (ten1 == ten2)
            System.out.println("Среднего числа не существует, первое и второе введеные числа равны");
        else if  (ten2 == ten3)
            System.out.println("Среднего числа не существует, второе и третье введеные числа равны");
        else
            System.out.println("Среднего числа не существует, первое и третье введеные числа равны");

        /*11) Ракета запускается с Земли со скоростью V(км.час) в направлении движения Земли по орбите вокруг Солнца.
        Составьте программу, определяющую результат запуска ракеты в зависимости от скорости V.
        Известно, что при V<7,8 ракета упадет на Землю; при 7,8<V<11,2 ракета станет спутником Земли;
        при 11,2<V<16,4 ракета станет спутником Солнца; при V>16,4 ракета покинет солнечную систему.*/
        System.out.print("Введите скорость ракеты (км/ч) "); float elevenSpeed = in.nextFloat();
        elevenSpeed *= 3.6f; //переводим км/ч в м/с

        if (elevenSpeed < 7.8f)
            System.out.println("Ракета упадет");
        else if (elevenSpeed > 16.4f)
            System.out.println("Ракета покинет солнечную систему");
        else if ((7.8f <= elevenSpeed) && (elevenSpeed < 11.2))
            System.out.println("Ракета станет спутником Земли");
        else
            System.out.println("Ракета станет спутником Солнца");

        /*12) Определелить количество знаков в натуральном числе от 0 до 1000, не прибегая к строковым переменным.*/
        System.out.print("Введите число от 0 до 1000: "); int twelveNum = in.nextInt();
        if ((twelveNum < 0) || (twelveNum > 1000))
            System.out.println("Вы ввели число за рамками допустимого диапазона");
        else if (twelveNum > 999)
            System.out.println("Ваше число четырехзначное");
        else if (twelveNum > 99)
            System.out.println("Ваше число трехзначное");
        else if (twelveNum > 9)
            System.out.println("Ваше число двухзначное");
        else
            System.out.println("Ваше число однозначное");

        /*1*) К финалу конкурса лучшего по профессии «Специалист электронного офиса» были допущены трое: Иванов, Петров, Сидоров.
        Соревнования проходили в три тура. Иванов в первом туре набрал M1 баллов, во втором – N1, в третьем – P1.
        Петров – соответственно M2, N2, P2. Сидоров – M3, N3, P3.
        Составьте программу, определяющую, сколько баллов набрал победитель, все данные считтываются с клавиатуры.
        Победитель определяется по победам в турах, общей сумме баллов, в противном случае место делится.*/
        System.out.println("Введите баллы, которые набрал Иванов в первом, втором и третьем туре соответственно: ");
        short ivan1 = in.nextShort(); short ivan2 = in.nextShort(); short ivan3 = in.nextShort();
        System.out.println("Введите баллы, которые набрал Петров в первом, втором и третьем туре соответственно: ");
        short petr1 = in.nextShort(); short petr2 = in.nextShort(); short petr3 = in.nextShort();
        System.out.println("Введите баллы, которые набрал Сидоров в первом, втором и третьем туре соответственно: ");
        short sid1 = in.nextShort(); short sid2 = in.nextShort(); short sid3 = in.nextShort();
        int ivanSumm = ivan1 + ivan2 + ivan3; int petrSumm = petr1 + petr2 + petr3; int sidSumm = sid1 + sid2 + sid3; //сумма балов каждого участника
        short ivanWins = 0, petrWins = 0, sidWins = 0; //кол-во победв раундах каждого участника

        //Определяем победителя(-ей) 1го раунда
        if ((ivan1 == petr1) && (ivan1 == sid1))
            System.out.println("Участники набрали равное кол-во баллов");
        else if ((ivan1 == petr1) && (ivan1 > sid1)) {
            ivanWins++; petrWins++;
            System.out.println("В первом раунде победили Иванов и Петров!");
        }
        else if ((ivan1 == sid1) && (ivan1 > petr1)) {
            ivanWins++; sidWins++;
            System.out.println("В первом раунде победили Иванов и Сидоров!");
        }
        else if ((petr1 == sid1) && (petr1 > ivan1)) {
            petrWins++; sidWins++;
            System.out.println("В первом раунде победили Петров и Сидоров!");
        }
        else if ((ivan1 > petr1) && (ivan1 > sid1)) {
            ivanWins++;
            System.out.println("В первом раунде победил Иванов!");
        }
        else if (petr1 > sid1) {
            petrWins++;
            System.out.println("В первом раунде победил Петров!");
        }
        else {
            sidWins++;
            System.out.println("В первом раунде победил Сидоров!");
        }

        //Определяем победителя(-ей) 2го раунда
        if ((ivan2 == petr2) && (ivan2 == sid2))
            System.out.println("Участники набрали равное кол-во баллов");
        else if ((ivan2 == petr2) && (ivan2 > sid2)) {
            ivanWins++;
            petrWins++;
            System.out.println("В первом раунде победили Иванов и Петров!");
        }
        else if ((ivan2 == sid2) && (ivan2 > petr2)) {
            ivanWins++;
            sidWins++;
            System.out.println("В первом раунде победили Иванов и Сидоров!");
        }
        else if ((petr2 == sid2) && (petr2 > ivan2)) {
            petrWins++;
            sidWins++;
            System.out.println("В первом раунде победили Петров и Сидоров!");
        }
        else if ((ivan2 > petr2) && (ivan2 > sid2)) {
            ivanWins++;
            System.out.println("Во втором раунде победил Иванов!");
        }
        else if (petr2 > sid2) {
            petrWins++;
            System.out.println("Во втором раунде победил Петров!");
        }
        else {
            sidWins++;
            System.out.println("Во втором раунде победил Сидоров!");
        }

        //Определяем победителя(-ей) 3го раунда
        if ((ivan3 == petr3) && (ivan3 == sid3))
            System.out.println("Участники набрали равное кол-во баллов");
        else if ((ivan3 == petr3) && (ivan3 > sid3)) {
            ivanWins++;
            petrWins++;
            System.out.println("В первом раунде победили Иванов и Петров!");
        }
        else if ((ivan3 == sid3) && (ivan3 > petr3)) {
            ivanWins++;
            sidWins++;
            System.out.println("В первом раунде победили Иванов и Сидоров!");
        }
        else if ((petr3 == sid3) && (petr3 > ivan3)) {
            petrWins++;
            sidWins++;
            System.out.println("В первом раунде победили Петров и Сидоров!");
        }
        else if ((ivan3 > petr3) && (ivan3 > sid3)) {
            ivanWins++;
            System.out.println("В третьем раунде победил Иванов!");
        }
        else if (petr3 > sid3) {
            petrWins++;
            System.out.println("В третьем раунде победил Петров!");
        }
        else {
            sidWins++;
            System.out.println("В третьем раунде победил Сидоров!");
        }

        //Определяем победителя. Приоритет победам в раундах, в случае равенства - по кол-ву баллов
        if ((ivanWins == petrWins) && (ivanWins == sidWins)) { //У всех участников равное кол-во побед, определяем победителя по сумме баллов
            if ((ivanSumm == petrSumm) && (ivanSumm == sidSumm))
                System.out.println("У нас ничья, участники победили в равном кол-ве раундов и набрали равное кол-во баллов!");
            else if ((ivanSumm == petrSumm) && (ivanSumm > sidSumm))
                System.out.println("Победили Иванов и Петров!");
            else if ((ivanSumm == sidSumm) && (ivanSumm > petrSumm))
                System.out.println("Победили Иванов и Сидоров!");
            else if ((petrSumm == sidSumm) && (petrSumm > ivanSumm))
                System.out.println("Победили Петров и Сидоров!");
            else if ((ivanSumm > petrSumm) && (ivanSumm > sidSumm))
                System.out.println("Победил Иванов!");
            else if (petrSumm > sidSumm)
                System.out.println("Победил Петров!");
            else
                System.out.println("Победил Сидоров!");
        } else if ((ivanWins == petrWins) && (ivanWins > sidWins)) { //У Иванова и Петрова равное кол-во побед, определяем победителя по сумме баллов
            if (ivanSumm == petrSumm)
                System.out.println("Победили Иванов и Петров!");
            else if (ivanSumm > petrSumm)
                System.out.println("Победил Иванов!");
            else
                System.out.println("Победил Петров!");
        } else if ((ivanWins == sidWins) && (ivanWins > petrWins)) { //У Иванова и Сидорова равное кол-во побед, определяем победителя по сумме баллов
            if (ivanSumm == sidSumm)
                System.out.println("Победили Иванов и Сидоров!");
            else if (ivanSumm > sidSumm)
                System.out.println("Победил Иванов!");
            else
                System.out.println("Победил Сидоров!");
        } else if ((petrWins == sidWins) && (petrWins > ivanWins)) { //У Петрова и Сидорова равное кол-во побед, определяем победителя по сумме баллов
            if (petrSumm == sidSumm)
                System.out.println("Победили Петров и Сидоров!");
            else if (petrSumm > sidSumm)
                System.out.println("Победил Петров!");
            else
                System.out.println("Победил Сидоров!");
        } else if ((ivanWins > petrWins) && (ivanWins > sidWins))
            System.out.println("Победил Иванов!");
        else if (petrWins > sidWins)
            System.out.println("Победил Петров!");
        else
            System.out.println("Победил Сидоров!");

        /*2*) Даны действительные числа a, b, c, d. Если a<=b<=c<=d, то каждое число заменить наибольшим из них;
        если a>b>c>d, то числа оставить без изменения;
        в противном случае все числа заменяются их квадратами.*/
        System.out.println("Введите введите четыре действительных числа:");
        float numA = in.nextFloat(); float numB = in.nextFloat(); float numC = in.nextFloat(); float numD = in.nextFloat();

        if ((numA <= numB) && (numB <= numC) && (numC <= numD)) {
            numA = Math.max(Math.max(numA, numB), Math.max(numC, numD));
            numB = numA; numC = numA; numD = numA;
            System.out.println("Условие a<=b<=c<=d, все числа приравнены к наибольшему: " + numA);
        } else if (!((numA > numB) && (numB > numC) && (numC > numD))) {
            numA = (float)pow(numA, 2);
            numB *= numB;
            numC = numC * numC;
            numD = (float)pow(numD, 2); //Не знаю 4го способа написать возведение в квадрат =)
            System.out.println("Условия не выполнены, все числа возведены в квадрат: A=" + numA + " B=" + numB + " C=" + numC + " D=" + numD);
        } else System.out.println("Условие a>b>c>d, числа остались без изменения"); //Тут вывод ради вывода, можно просто не писать else

        /*5)	САДИСТСКАЯ!!!!!
        Пользователь вводит число от 1 до 9999 (сумму выдачи в банкомате).
        Необходимо вывести на экран словами введенную сумму
        и в конце написать название валюты с правильным окончанием.
        Например: 7431 – семь тысяч четыреста тридцать один доллар,
        2149 – две тысячи сто сорок девять долларов,
        15 – пятнадцать долларов, 3 – три доллара.*/
        System.out.print("Введите сумму выдачи от 1 до 9999: "); int summMoney = in.nextInt();

        int thousends = summMoney/1000;
        int houndrets = thousends > 0 ? ((summMoney/100)%10) : (summMoney/100);
        int dozens = houndrets > 0 ? ((summMoney/10)%10) : (summMoney/10);
        int units = dozens > 0 ? (summMoney%10) : (summMoney);
        String currency = "долларов";

        System.out.print("Ваша сумма ");
        switch (thousends) {
            case 9: System.out.print("девять тысяч "); break;
            case 8: System.out.print("восемь тысяч "); break;
            case 7: System.out.print("семь тысяч "); break;
            case 6: System.out.print("шесть тысяч "); break;
            case 5: System.out.print("пять тысяч "); break;
            case 4: System.out.print("четыре тысячи "); break;
            case 3: System.out.print("три тысячи "); break;
            case 2: System.out.print("две тысячи "); break;
            case 1: System.out.print("одна тысяча "); break;
        }

        switch (houndrets) {
            case 9: System.out.print("девятьсот "); break;
            case 8: System.out.print("восемьсот "); break;
            case 7: System.out.print("семьсот "); break;
            case 6: System.out.print("шестьсот "); break;
            case 5: System.out.print("пятьсот "); break;
            case 4: System.out.print("четыреста "); break;
            case 3: System.out.print("триста "); break;
            case 2: System.out.print("двести "); break;
            case 1: System.out.print("сто "); break;
        }

        if (dozens == 1) {
            switch (units) {
                case 9: System.out.print("девятнадцать "); break;
                case 8: System.out.print("восемнадцать "); break;
                case 7: System.out.print("семнадцать "); break;
                case 6: System.out.print("шестнадцать "); break;
                case 5: System.out.print("пятнадцать "); break;
                case 4: System.out.print("четырнадцать "); break;
                case 3: System.out.print("тринадцать "); break;
                case 2: System.out.print("двенадцать "); break;
                case 1: System.out.print("одиннадцать "); break;
                default: System.out.print("десять "); break;
            }
        } else {
            switch (dozens) {
                case 9: System.out.print("девяносто "); break;
                case 8: System.out.print("восемьдесят "); break;
                case 7: System.out.print("семьдесят "); break;
                case 6: System.out.print("шестьдесят "); break;
                case 5: System.out.print("пятьдесят "); break;
                case 4: System.out.print("сорок "); break;
                case 3: System.out.print("тридцать "); break;
                case 2: System.out.print("двадцать "); break;
            }
            switch (units) {
                case 9: System.out.print("девять "); break;
                case 8: System.out.print("восемь "); break;
                case 7: System.out.print("семь "); break;
                case 6: System.out.print("шесть "); break;
                case 5: System.out.print("пять "); break;
                case 4: {System.out.print("четыре "); currency = "доллара";} break;
                case 3: {System.out.print("три "); currency = "доллара";} break;
                case 2: {System.out.print("два "); currency = "доллара";} break;
                case 1: {System.out.print("один "); currency = "доллара";} break;
            }
        }
        System.out.print(currency + "\n");
    }
}