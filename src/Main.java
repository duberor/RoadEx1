import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
class ТестоваПрограма {
    private String текстПитання;
    private String правильнаВідповідь;
    private List<String> варіантиВідповідей;
    public String getТекстПитання() {
        return текстПитання;
    }
    public String getПравильнаВідповідь() {
        return правильнаВідповідь;
    }
    public List<String> getВаріантиВідповідей() {
        return варіантиВідповідей;
    }
    public void addВаріантВідповіді(String варіант) {
        варіантиВідповідей.add(варіант);
    }
    public void Питання(String текстПитання, String правильнаВідповідь, ArrayList<String> варіантиВідповідей) {
        this.текстПитання = текстПитання;
        this.правильнаВідповідь = правильнаВідповідь;
        this.варіантиВідповідей = варіантиВідповідей;
    }
    public boolean isCorrectAnswer(String вибранаВідповідь) {
        return вибранаВідповідь.equals(правильнаВідповідь);
    }
    public static Питання випадковеПитання(List<Питання> питання) {
        if (!питання.isEmpty()) {
            Collections.shuffle(питання);
            return питання.get(0);
        }
        return null;
    }
}

class ДодатокТестування extends JFrame {
    private JFrame головне_вікно;
    private JFrame вікноАвторизації;
    private ArrayList<Питання> питання;
    private int кількістьПравильних; // Removed unused variable
    private static final int КІЛЬКІСТЬ_ВІДПОВІДЕЙ = 4; // Added constant for the number of answers
    public ДодатокТестування() {
        питання = new ArrayList<>();

        Питання питання1 = new Питання("Який попереджувальний сигнал вмикається на транспортних засобах колони під час зупинки на дорозі?", "Аварійна сигналізація.", new ArrayList<>(Arrays.asList("Аварійна сигналізація.", "Габаритні ліхтарі.", "Ближнє світло фар.", "Варіант4")));
        Питання питання2 = new Питання("Чи може водій виконати обгін після проїзду цих знаків?", "Може за умови, що обгін буде завершено за 100 м до переїзду.", new ArrayList<>(Arrays.asList("Може за умови, що обгін буде завершено за 100 м до переїзду.", "Може в будь-якому випадку.", "Не може.", "Не знаю.")));
        Питання питання3 = new Питання("У яких місцях заборонено стоянку транспортних засобів?", "Всі відповіді правильні.", new ArrayList<>(Arrays.asList("Всі відповіді правильні.", "У місцях, де транспортний засіб, що стоїть, унеможливить рух інших транспортних засобів.", "У місцях, де транспортний засіб, що стоїть, створить перешкоду для руху пішоходів.", "На газонах.")));
        Питання питання4 = new Питання("Гальмівним шляхом вважається:", "Відстань, що проходить транспортний засіб під час екстреного гальмування з початку впливу на органи керування гальмовою системою до повної зупинки.", new ArrayList<>(Arrays.asList("Відстань, що проходить транспортний засіб під час екстреного гальмування з початку впливу на органи керування гальмовою системою до повної зупинки.", "Відстань, що проходить транспортний засіб, з місця, де починаються чітко виражені сліди гальмування до повної зупинки.", "Немає правильної відповіді.", "Варіант4")));
        Питання питання5 = new Питання("Що необхідно зробити перед тим, як вийти з автомобіля після зупинки на дорозі?", "Виконати все, перелічене вище.", new ArrayList<>(Arrays.asList("Виконати все, перелічене вище.", "Через дзеркало заднього виду або поворотом голови назад переконатися в безпеці виходу і потім лише виходити.", "У темну пору доби на неосвітленій ділянці дороги (крім житлових зон) ввімкнути габаритні чи стоянкові вогні.", "Вжити заходів, які виключають мимовільний рух транспортного засобу.")));
        Питання питання6 = new Питання("Чи можна скласти спільне повідомлення про дорожньо-транспортну пригоду (Європротокол) у разі завдання шкоди об'єктам крім транспортного засобу?", "Так.", new ArrayList<>(Arrays.asList("Так.", "Ні.", "Так, якщо власник пошкодженого майна не має претензій до учасників події.", "Жодне з тверджень не вірне.")));
        Питання питання7 = new Питання("Як повинен діяти водій автомобіля, якого обганяють і який рухається з увімкненим дальнім світлом фар у темну пору доби?", "Включити світло фар, як тільки автомобіль, що обганяє, виявився попереду, та рухатися з ввімкненими габаритними вогнями до моменту, поки автомобіль, що рухається попереду, не віддалився на значну відстань.", new ArrayList<>(Arrays.asList("Включити світло фар, як тільки автомобіль, що обганяє, виявився попереду, та рухатися з ввімкненими габаритними вогнями до моменту, поки автомобіль, що рухається попереду, не віддалився на значну відстань.", "Відразу перемикнутися на ближнє світло, як тільки водій наступного за ним автомобіля почав виїжджати на зустрічну смугу руху.", "Перемикнути фари на ближнє світло у момент, коли автомобілі порівнялися, рухаючись по суміжних смугах.", "Варіант4")));
        Питання питання8 = new Питання("Відносно якої лінії дорожньої розмітки найбільш безпечно контролювати положення свого автомобіля при зустрічному роз’їзді в темний час доби?", "Відносно лінії, що позначає правий край проїзної частини дороги.", new ArrayList<>(Arrays.asList("Відносно лінії, що позначає правий край проїзної частини дороги.", "Відносно лінії, що позначає лівий край проїзної частини дороги.", "Відносно лінії, що розділяє транспортні потоки протилежних напрямків.", "Всі варіанти правильні.")));
        Питання питання9 = new Питання("При наявності стороннього тіла в рані необхідно:", "Накласти пов’язку, не виймаючи стороннього тіла.", new ArrayList<>(Arrays.asList("Накласти пов’язку, не виймаючи стороннього тіла.", "Зафіксувати стороннє тіло тільки якщо воно виступає над раною не менше ніж на 5 см.", "Вийняти стороннє тіло після чого накласти пов’язку.", "Варіант4")));
        Питання питання10 = new Питання("Адміністративне затримання Національною поліцією проводиться:", "Проводиться в разі вчинення правопорушень, зазначених у відповідях 1 і 2 з обов'язковим складанням протоколу про затримання.", new ArrayList<>(Arrays.asList("Проводиться в разі вчинення правопорушень, зазначених у відповідях 1 і 2 з обов'язковим складанням протоколу про затримання.", "Тільки в разі порушення Правил дорожнього руху.", "Тільки в разі вчинення дрібного хуліганства.", "Варіант4")));

        питання.add(питання1);
        питання.add(питання2);
        питання.add(питання3);
        питання.add(питання4);
        питання.add(питання5);
        питання.add(питання6);
        питання.add(питання7);
        питання.add(питання8);
        питання.add(питання9);
        питання.add(питання10);

        Collections.shuffle(питання);

        вікноАвторизації = new JFrame("Авторизація");
        JFrame вікноРеєстрації = new JFrame("Реєстрація");
    }
    private void додатиПитання(String текстПитання, String правильнаВідповідь, ArrayList<String> варіантиВідповідей) {
        Питання новеПитання = new Питання(текстПитання, правильнаВідповідь, варіантиВідповідей);
        питання.add(новеПитання);
    }
    private void показатиВікноАвторизації(boolean startTest) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame вікноАвторизації = new JFrame("Авторизація");

                JTextField полеЛогіну = new JTextField();
                JPasswordField полеПароля = new JPasswordField();
                JButton кнопкаУвійти = new JButton("Увійти");               //Button
                кнопкаУвійти.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        String введенийЛогін = полеЛогіну.getText();
                        String введенийПароль = new String(полеПароля.getPassword());

                        boolean знайденийЛогін = false;
                        boolean знайденийПароль = false;

                        try (BufferedReader loginReader = new BufferedReader(new FileReader("login.txt"))) {
                            String log;
                            while ((log = loginReader.readLine()) != null) {
                                System.out.println(log);

                                if (введенийЛогін.equals(log)) {
                                    знайденийЛогін = true;
                                    break;
                                }
                            }
                        } catch (IOException fL) {
                            System.out.println("Не вдалося прочитати файл з логіном!!!");
                        }

                        try (BufferedReader passwordReader = new BufferedReader(new FileReader("password.txt"))) {
                            String pswrd;
                            while ((pswrd = passwordReader.readLine()) != null) {
                                System.out.println(pswrd);

                                if (введенийПароль.equals(pswrd)) {
                                    знайденийПароль = true;
                                    break;
                                }
                            }
                        } catch (IOException fP) {
                            System.out.println("Не вдалося прочитати файл з паролем!!!");
                        }
                        if (знайденийЛогін && знайденийПароль) {
                            показатиГоловнеМеню(startTest);
                            вікноАвторизації.dispose();
                        } else {
                            JOptionPane.showMessageDialog(вікноАвторизації, "Невірний логін або пароль. Спробуйте ще раз.");
                        }
                    }
                });

                вікноАвторизації.setLayout(new GridLayout(3, 2));
                вікноАвторизації.add(new JLabel("Логін:"));
                вікноАвторизації.add(полеЛогіну);
                вікноАвторизації.add(new JLabel("Пароль:"));
                вікноАвторизації.add(полеПароля);
                вікноАвторизації.add(кнопкаУвійти);

                вікноАвторизації.setSize(300, 150);
                вікноАвторизації.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                вікноАвторизації.setLocationRelativeTo(null);
                вікноАвторизації.setVisible(true);
            }
        });
    }
    private void показатиВікноРеєстрації() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame вікноРеєстрації = new JFrame("Реєстрація");

                JTextField полеНовогоЛогіну = new JTextField();
                JPasswordField полеНовогоПароля = new JPasswordField();
                JButton кнопкаЗареєструватися = new JButton("Зареєструватися");
                кнопкаЗареєструватися.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        String новийЛогін = полеНовогоЛогіну.getText();
                        String новийПароль = new String(полеНовогоПароля.getPassword());

                        зберегтиВФайл(новийЛогін, новийПароль);

                        boolean реєстраціяУспішна = true;
                        if (реєстраціяУспішна) {
                            вікноРеєстрації.dispose();
                        } else {
                            JOptionPane.showMessageDialog(вікноРеєстрації, "Не вдалося зареєструвати. Спробуйте ще раз.");
                        }
                    }
                });

                вікноРеєстрації.setLayout(new GridLayout(3, 2));
                вікноРеєстрації.add(new JLabel("Новий логін:"));
                вікноРеєстрації.add(полеНовогоЛогіну);
                вікноРеєстрації.add(new JLabel("Новий пароль:"));
                вікноРеєстрації.add(полеНовогоПароля);
                вікноРеєстрації.add(кнопкаЗареєструватися);

                вікноРеєстрації.setSize(300, 150);
                вікноРеєстрації.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Закрити вікно при закритті
                вікноРеєстрації.setLocationRelativeTo(null);
                вікноРеєстрації.setVisible(true);
            }
        });
    }
    private void зберегтиВФайл(String логін, String пароль) {
        try (BufferedWriter loginWriter = new BufferedWriter(new FileWriter("login.txt"));
             BufferedWriter passwordWriter = new BufferedWriter(new FileWriter("password.txt"))) {

            System.out.println(логін + "   " + пароль);
            loginWriter.write(логін);
            loginWriter.newLine();
            passwordWriter.write(пароль);
            passwordWriter.newLine();

            System.out.println("Логін та пароль збережені у файли login.txt та password.txt");
        } catch (IOException ex) {
            ex.printStackTrace();
            //JOptionPane.showMessageDialog(вікноРеєстрації, "Помилка при збереженні логіна та пароля.");
        }
    }
    public void showStartWindow() {

        boolean startTest = false;
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame startWindow = new JFrame("A_or_R");

                JButton reg = new JButton("Register");
                reg.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        показатиВікноРеєстрації();
                        startWindow.dispose();
                    }
                });

                JButton aut = new JButton("Aut");               //Button
                aut.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        показатиВікноАвторизації(startTest);
                        startWindow.dispose();
                    }
                });
                startWindow.setLayout(new GridLayout(3, 5));
                startWindow.add(reg);
                startWindow.add(aut);

                startWindow.setSize(500, 250);
                startWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                startWindow.setLocationRelativeTo(null);
                startWindow.setVisible(true);
            };
        });
    }
    private void показатиГоловнеМеню(boolean startTest) {
        JFrame головне_вікно = new JFrame("Головне меню");

        JTabbedPane вкладки = new JTabbedPane();
        вкладки.addTab("Тест", створитиТестовуВкладку());
        вкладки.addTab("Правила", створитиВкладкуПравил());

        головне_вікно.add(вкладки);

        JMenuBar menuBar = new JMenuBar();
        JMenu файлMenu = new JMenu("Файл");
        JMenuItem вийтиItem = new JMenuItem("Вийти");
        вийтиItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                завершитиРоботуДодатку();
            }
        });

        файлMenu.add(вийтиItem);
        menuBar.add(файлMenu);

        головне_вікно.setJMenuBar(menuBar);

        головне_вікно.setSize(400, 700);
        головне_вікно.setResizable(false);
        головне_вікно.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        головне_вікно.setLocationRelativeTo(null);
        головне_вікно.setVisible(true);
    }
    private Component створитиВкладкуПравил() {

        JTextArea текстПравил = new JTextArea("Текст Правил Дорожнього Руху України. 3.1 Водії оперативних транспортних засобів, виконуючи невідкладне службове завдання, можуть відступати від вимог наступних розділів: 8 (крім сигналів регулювальника), 10, 11, 12, 13, 14, 15, 16, 17, 18, 26, 27 та пункту  цих Правил за умови увімкнення проблискового маячка синього або червоного кольору і спеціального звукового сигналу та забезпечення безпеки дорожнього руху. За відсутності необхідності додаткового привертання уваги учасників дорожнього руху спеціальний звуковий сигнал може бути вимкнений.\n" +
                "\n" +
                "Навчальне відео по темі \"Рух транспортних засобів із спеціальними сигналами\"\n" +
                "\n" +
                "3.2 У разі наближення транспортного засобу з увімкненим синім проблисковим маячком та (або) спеціальним звуковим сигналом водії інших транспортних засобів, які можуть створювати йому перешкоду для руху, зобов’язані дати йому дорогу і забезпечити безперешкодний проїзд зазначеного транспортного засобу (і супроводжуваних ним транспортних засобів).\n" +
                "\n" +
                "На транспортних засобах, які рухаються в супроводжуваній колоні, повинне бути ввімкнено ближнє світло фар.\n" +
                "\n" +
                "Якщо на такому транспортному засобі увімкнено проблискові маячки синього і червоного або лише червоного кольору, водії інших транспортних засобів зобов’язані зупинитися біля правого краю проїзної частини (на правому узбіччі). На дорозі з розділювальною смугою цю вимогу зобов’язані виконати водії транспортних засобів, що рухаються в попутному напрямку.\n" +
                "\n" +
                "3.3 Якщо під час супроводження колони транспортних засобів на транспортному засобі, що рухається попереду колони, увімкнено проблискові маячки синього і червоного або лише червоного кольору, колону повинен замикати транспортний засіб з увімкненим зеленим або синім і зеленим проблисковими маячками, після проїзду якого скасовуються обмеження на рух інших транспортних засобів.");
        текстПравил.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(текстПравил);
        scrollPane.setPreferredSize(new Dimension(400, 300)); // Set the preferred size here

        // Create a panel with a layout manager (e.g., GridLayout)
        JPanel вкладка = new JPanel(new GridLayout(1, 1));

        вкладка.setLayout(new GridLayout(5, 1));
        вкладка.add(scrollPane);

        return вкладка;
    }
    private Component створитиТестовуВкладку() {

        JPanel вкладка = new JPanel(new GridLayout(5, 2));

        JLabel label1 = new JLabel("Test1");
        JLabel label2 = new JLabel("Test2");
        JLabel label3 = new JLabel("Test3");
        JLabel label4 = new JLabel("Test4");

        JButton поч1 = new JButton("Почати тест1");
        JButton поч2 = new JButton("Почати тест2");
        JButton поч3 = new JButton("Почати тест3");
        JButton поч4 = new JButton("Почати тест4");

        поч1.addActionListener(e -> початиТест());
        поч2.addActionListener(e -> початиТест());
        поч3.addActionListener(e -> початиТест());
        поч4.addActionListener(e -> початиТест());

        вкладка.add(label1,0,0);
        вкладка.add(поч1,0,1);

        вкладка.add(label2,1,0);
        вкладка.add(поч2,1,1);

        вкладка.add(label3,2,0);
        вкладка.add(поч3,2,1);

        вкладка.add(label4,3,0);
        вкладка.add(поч4,3,1);

        return вкладка;
    }
    private void завершитиРоботуДодатку() {

        System.exit(0);
    }
    public void початиТест() {
        відобразитиНаступнеПитання();

        вивестиРезультатиТесту();
    }
    private void вивестиРезультатиТесту() {
    }
    private void відобразитиНаступнеПитання() {
        if (!питання.isEmpty()) {
            Питання поточне = питання.remove(0);

            JTextArea областьПитання = new JTextArea(поточне.getТекстПитання());
            областьПитання.setEditable(false);
            JPanel панельВідповідей = new JPanel(new GridLayout(КІЛЬКІСТЬ_ВІДПОВІДЕЙ, 1));

            List<String> відповіді = new ArrayList<>(Arrays.asList(поточне.getПравильнаВідповідь(), "Варіант2", "Варіант3", "Варіант4"));
            Collections.shuffle(відповіді);

            ButtonGroup групаКнопок = new ButtonGroup();

            for (int i = 0; i < відповіді.size(); i++) {
                JRadioButton радіоКнопка = new JRadioButton((i + 1) + ". " + відповіді.get(i));
                панельВідповідей.add(радіоКнопка);
                групаКнопок.add(радіоКнопка);
            }

            getContentPane().removeAll();
            getContentPane().add(областьПитання, BorderLayout.CENTER);
            getContentPane().add(панельВідповідей            , BorderLayout.SOUTH);
            revalidate();
            repaint();
            Timer таймер = new Timer(30000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    обробитиВідповідь(областьПитання, панельВідповідей, поточне);
                }
            });
            таймер.setRepeats(false);
            таймер.start();
        } else {
            відобразитиРезультат();
        }
    }
    private void обробитиВідповідь(JTextArea областьПитання, JPanel панельВідповідей, Питання поточне) {
        for (Component компонент : панельВідповідей.getComponents()) {
            if (компонент instanceof JRadioButton) {
                JRadioButton радіоКнопка = (JRadioButton) компонент;
                if (радіоКнопка.isSelected()) {
                    String текстКнопки = радіоКнопка.getText();

                    if (текстКнопки.contains(поточне.getПравильнаВідповідь())) {
                        кількістьПравильних++;
                        JOptionPane.showMessageDialog(this, "Ваша відповідь правильна!");
                    } else {
                        JOptionPane.showMessageDialog(this, "Ваша відповідь неправильна!");
                    }
                }
            }
        }

        getContentPane().removeAll();
        revalidate();
        repaint();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        відобразитиНаступнеПитання();
    }
    private void відобразитиРезультат() {
        JOptionPane.showMessageDialog(this, "Правильні відповіді: " + кількістьПравильних);

        int вибір = JOptionPane.showConfirmDialog(this, "Бажаєте розпочати тест знову?", "Повторити тест", JOptionPane.YES_NO_OPTION);

        if (вибір == JOptionPane.YES_OPTION) {
            кількістьПравильних = 0;
            Collections.shuffle(питання);
            відобразитиВікноАвторизації();
        } else {
            System.exit(0);
        }
        показатиВікноРезультатів();
    }
    private void показатиВікноРезультатів() {
        JFrame вікноРезультатів = new JFrame("Результати тесту");
        JLabel мітка = new JLabel("Тут може бути текст з результатами тесту");

        вікноРезультатів.add(мітка);

        вікноРезультатів.setSize(400, 300);
        вікноРезультатів.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        вікноРезультатів.setLocationRelativeTo(null);
        вікноРезультатів.setVisible(true);
    }
    private void відобразитиВікноАвторизації() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame вікноАвторизації = new JFrame("Авторизація");

                JTextField полеЛогіну = new JTextField();
                JPasswordField полеПароля = new JPasswordField();
                JButton кнопкаУвійти = new JButton("Увійти");
                кнопкаУвійти.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        String введенийЛогін = полеЛогіну.getText();
                        String введенийПароль = new String(полеПароля.getPassword());

                        if (введенийЛогін.equals("користувач") && введенийПароль.equals("пароль")) {
                            вікноАвторизації.dispose();
                        } else {
                            JOptionPane.showMessageDialog(вікноАвторизації, "Невірний логін або пароль. Спробуйте ще раз.");
                        }
                        boolean авторизаціяУспішна = false;
                        if (авторизаціяУспішна) {
                            вікноАвторизації.dispose();
                        } else {
                            JOptionPane.showMessageDialog(вікноАвторизації, "Невірний логін або пароль. Спробуйте ще раз.");
                        }
                        AbstractButton кнопкаРеєстрації = null;
                        кнопкаРеєстрації.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                показатиВікноРеєстрації();
                                вікноАвторизації.dispose();
                            }
                        });
                    }
                });

                вікноАвторизації.setLayout(new GridLayout(3, 2));
                вікноАвторизації.add(new JLabel("Логін:"));
                вікноАвторизації.add(полеЛогіну);
                вікноАвторизації.add(new JLabel("Пароль:"));
                вікноАвторизації.add(полеПароля);
                вікноАвторизації.add(кнопкаУвійти);

                вікноАвторизації.setSize(300, 150);
                вікноАвторизації.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                вікноАвторизації.setLocationRelativeTo(null);
                вікноАвторизації.setVisible(true);
            }
        });
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ДодатокТестування();

                ДодатокТестування тестовеДодаток = new ДодатокТестування();
                тестовеДодаток.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                тестовеДодаток.pack(); // Автоматично підганяє розмір вікна до його вмісту
                тестовеДодаток.setLocationRelativeTo(null);

                тестовеДодаток.setVisible(true);

                тестовеДодаток.showStartWindow();
            }
        });
    }
}