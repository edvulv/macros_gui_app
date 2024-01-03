import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////<<<<<
public class GUI extends JFrame {

    private JOptionPane enWarning;
    private JPanel mainPanel;
    private JButton calcbutton;
    private JTextField itemfield;
    private JTextField amountfield;
    private JLabel error;
    private JButton addItemButton;
    private JLabel output;
    private JButton leftbutton;
    private JButton rightbutton;
    private JList<Product> itemlist;
    private JList<Product> addlist;
    private JList<Product> prodmadelist;
    private JList<Category> itemlist2;
    private JPanel tablayout;
    private JPanel calculatorcard;
    private JPanel addprodcard;
    private JPanel inputs;
    private JPanel outputandlist;
    private JButton removetemButton;
    private JPanel loggcard;
    private JPanel controllpanel;
    private JButton tab1;
    private JButton tab2;
    private JButton tab3;
    private JButton tab4;
    //card 2
    private JPanel toppanel;
    private JTextField productnamefield;
    private JTextField caloriefield;
    private JTextField proteinfield;
    private JTextField fatfield;
    private JTextField carbfield;
    private JTextField sugarfield;
    private JLabel error2;
    private JButton addProductButton;
    private JLabel output2;
    private JButton testProductButton;
    private JButton refreshListButton;
    private JPanel profilecard;
    private JLabel agetext;
    private JLabel nametext;
    private JPanel personalinfo;
    private JButton deleteProductlistButton;
    private JButton deleteLogButton;
    private JPanel calcweight;
    private JButton createGoalButton;
    private JScrollPane scrollpane;
    private JLabel scollpanetext;
    private JButton registerDraftButton;
    private JTextArea logoutput;
    private JScrollPane scrollpanelog;
    private JButton refreshlog;
    private JLabel profileerror;
    private JLabel profileoutput;
    private JButton emptyaddlist;
    private JButton removeitemfromlist;
    private JPanel userlayoutcard;
    private JPanel profilecardlayout;
    private JPanel createaccount;
    private JTextField createnamefield;
    private JTextField createagefield;
    private JTextField createpasswordfield;
    private JButton createUserButton;
    private JLabel errorcreateuser;
    private JLabel profilecalorietext;
    private JTextField calories;
    private JTextField protein;
    private JTextField fat;
    private JTextField carbohydrates;
    //FROM LAPTOP
    private JLabel errorgoal;
    private JLabel logintext;
    private JButton profiledate;
    private JList datelist;
    private JLabel todayeaten;
    private JButton registerButton;
    private JButton deleteUnregisteredIntakeButton;

    private JPanel createprodcard;
    private JButton addProductToRecipeButton;
    private JButton createAndAddToButton;
    private JLabel productcreatedfield;
    private JTextField prodamount;
    private JButton refreshListButton2;
    private JLabel errorcreprod;
    private JButton removerecipe;
    private JTextField recipename;
    private JPanel profleftbox;
    private JTextArea eatentextarea;
    private JLabel registeredIntakefield;
    private JLabel calcDataOBS;
    private JTabbedPane tabbedPane1;
    private JPanel nutritionprod;
    private JPanel productMaker;
    private JTextField sugarnutfield;
    private JTextField fatnutfield;
    private JTextField carbnutfield;
    private JTextField protnutfield;
    private JTextField calnutfield;
    private JTextField amountnutfield;
    private JTextField namenutfield;
    private JRadioButton gramRadio;
    private JRadioButton decilitreRadio;
    private JButton createProductButton;
    private JLabel prodselectedfield;
    private JLabel nutriAmount;
    private JLabel error3;
    private JLabel output3;
    private JPanel macrofield;
    private JList<Product> foodlist;
    private JList<Product> drinkslist;
    private JList<Product> sweetsSnackslist;
    private JList<Product> otherlist;
    private JCheckBox creatineCheckBox;
    private JRadioButton foodRadioButton;
    private JRadioButton drinksRadioButton;
    private JRadioButton sweetsAndSnacksRadioButton;
    private JRadioButton otherRadioButton;
    private JTabbedPane foodTab;
    private JPanel radiofield;
    private JRadioButton foodRadioButton2;
    private JRadioButton drinksRadioButton2;
    private JRadioButton sweetsAndSnacksRadioButton2;
    private JRadioButton otherRadioButton2;
    private JRadioButton foodRadioButton3;
    private JRadioButton drinksRadioButton3;
    private JRadioButton sweetsAndSnacksRadioButton3;
    private JRadioButton otherRadioButton3;
    private JRadioButton profileTakeCreatine;
    private DefaultListModel<Product> foodListModel = new DefaultListModel<>();
    private DefaultListModel<Product> drinksListModel = new DefaultListModel<>();
    private DefaultListModel<Product> sweetsSnacksListModel = new DefaultListModel<>();
    private DefaultListModel<Product> otherListModel = new DefaultListModel<>();
    //Other listmodels
    private DefaultListModel<Category> productModel = new DefaultListModel<>();
    private DefaultListModel<Product> addedprodlist = new DefaultListModel<>();
    private DefaultListModel<Product> prodmadeModel = new DefaultListModel<>();
    private DefaultListModel<Date> datemodellist = new DefaultListModel<>();

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public boolean userAccount = false;
    public boolean unregisteredData = false;
    double amount = 0;
    Product dailyGoal = new Product(null,0,0,0,0,0);
    ArrayList<Integer> dates = DateManager.GetDate();
    Date foodEatenToday = new Date(DateManager.getMonth(dates.get(1)), dates.get(0), dates.get(2), null);
    Product finalCalculation = new Product("final", 0, 0, 0, 0, 0);
    Product createprodCalculation = new Product("final", 0, 0, 0, 0, 0);
    String space = "    ";

    public GUI(String title) {
        super(title);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setSize(1000, 800);


        foodlist.setModel(foodListModel);
        drinkslist.setModel(drinksListModel);
        sweetsSnackslist.setModel(sweetsSnacksListModel);
        otherlist.setModel(otherListModel);

        addlist.setModel(addedprodlist);
        itemlist2.setModel(productModel);
        prodmadelist.setModel(prodmadeModel);
        datelist.setModel(datemodellist);
        tablayout.removeAll();
        tablayout.add(calculatorcard);
        registerDraftButton.setEnabled(false);
        tablayout.repaint();
        tablayout.revalidate();
        refreshLog();

        amount = 1;
        updateAmount();

        error2.setText("");
        errorcreprod.setText("");
        profileerror.setText("");
        profileoutput.setText("");
        registeredIntakefield.setText("");
        eatentextarea.setText("BABA");
        calcDataOBS.setText("");
        error.setText("");
        errorgoal.setText("");
        prodselectedfield.setText("");
        error3.setText("");


        ArrayList<Product> prodfileList = new ArrayList<>();

        Product eatenToday = checkDraft();

        foodEatenToday.setProduct(eatenToday);

        String currentDateTime = DateManager.GetDateString();
        profiledate.setText(foodEatenToday.getMonth() + " " + foodEatenToday.getDay() + " " + foodEatenToday.getYear());

        refreshProductlist(prodfileList);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(GeneralInfo.userInformation))) {
            String get = bufferedReader.readLine();
            if (get == null) {
                profilecardlayout.removeAll();
                profilecardlayout.add(createaccount);
                profilecardlayout.repaint();
                profilecardlayout.revalidate();
                errorcreateuser.setText("");
                userAccount = false;
                logintext.setText("Log in" + space);
            } else {
                profilecardlayout.removeAll();
                profilecardlayout.add(userlayoutcard);
                profilecardlayout.repaint();
                profilecardlayout.revalidate();
                String[] array = get.split(";");
                logintext.setText("Welcome " + array[0] + space);
                nametext.setText(array[0]);
                agetext.setText(array[1]);
                userAccount = true;
                try {
                    dailyGoal = getDailyGoal();
                    if (!unregisteredData)
                    {updateWhatEaten(false);}
                    else
                    { updateWhatEaten(true);}
                    profilecalorietext.setText("You need to intake " + dailyGoal.getCalories() + " calories, "  + dailyGoal.getProtein() + "g protein, " + dailyGoal.getFat() + "g fat, "  + dailyGoal.getCarbs() + "g carbohydrates. Keep sugar intake minimal");
                }
                catch (ArrayIndexOutOfBoundsException ary) {
                }
                catch (NullPointerException npe) {

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        addItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                error.setText("");
                boolean foundItem = false;
                int count = 0;
                try {
                    String itemf = itemfield.getText();
                    if (itemf.equals("") || itemf.equals(null)) {
                        error.setText("You need to enter an item!");
                    } else if(amount == 0) {
                        error.setText("You need to enter an amount!");
                    } else if (amountfield.getText().contains(",")) {
                        error.setText("Cannot add product");
                    }
                    else {
                        for (Product p : prodfileList) {
                            if (p.getProductName().equals(itemf) && !foundItem) {
                                Product b = new Product("",0,0,0,0,0);
                                b.setProductName(p.getProductName());b.setCalories(p.getCalories() * amount);b.setProtein(p.getProtein() * amount);
                                b.setFat(p.getFat() * amount);b.setCarbs(p.getCarbs() * amount);b.setSugar(p.getSugar() * amount);
                                b = GeneralInfo.ProductDecimalFormated(b);
                                foundItem = true;
                                finalCalculation.setCalories(finalCalculation.getCalories() + b.getCalories());
                                finalCalculation.setProtein(finalCalculation.getProtein() + b.getProtein());
                                finalCalculation.setFat(finalCalculation.getFat() + b.getFat());
                                finalCalculation.setCarbs(finalCalculation.getCarbs() + b.getCarbs());
                                finalCalculation.setSugar(finalCalculation.getSugar() + b.getSugar());
                                finalCalculation = GeneralInfo.ProductDecimalFormated(finalCalculation);
                                b.setProductName(b.getProductName() + " x" + amountfield.getText());
                                addedprodlist.addElement(b);
                                updateCalculation();
                            }
                        }
                        registerDraftButton.setEnabled(true);
                        amount = 1;
                        updateAmount();
                        addlist.updateUI();
                        if (!foundItem) {
                            error.setText("Item was not found!");
                        } else {
                            amount = 1;
                            updateAmount();
                        }
                    }
                }
                catch (NumberFormatException nfe) {
                    error.setText("Error: NumberFormatException");
                    nfe.getMessage();
                }
            }
        });
        removetemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int index = addlist.getSelectedIndex();
                    Product g = addlist.getSelectedValue();
                    g = GeneralInfo.ProductDecimalFormated(g);
                    finalCalculation.setCalories(finalCalculation.getCalories() - g.getCalories());
                    finalCalculation.setProtein(finalCalculation.getProtein() - g.getProtein());
                    finalCalculation.setFat(finalCalculation.getFat() - g.getFat());
                    finalCalculation.setCarbs(finalCalculation.getCarbs() - g.getCarbs());
                    finalCalculation.setSugar(finalCalculation.getSugar() - g.getSugar());
                    finalCalculation = GeneralInfo.ProductDecimalFormated(finalCalculation);
                    if (finalCalculation.getCalories() == 0) { registerDraftButton.setEnabled(false); }
                    addedprodlist.remove(index);
                    updateCalculation();
                    addlist.updateUI();
                }
                catch (ArrayIndexOutOfBoundsException ary) {
                    error.setText("List is empty");
                }
                catch (NullPointerException npe) {
                    error.setText("There is no items to remove");
                }
            }
        });
        calcbutton.addActionListener(new ActionListener() { ////////////////////////////////////////////////////////////////////////////////////300
            @Override
            public void actionPerformed(ActionEvent e) {
                updateCalculation();
            }
        });
        registerDraftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!unregisteredData) {
                    Product b = foodEatenToday.getProduct();
                    b.setCalories(Math.floor(b.getCalories() + finalCalculation.getCalories()));
                    b.setProtein(Math.floor(b.getProtein() + finalCalculation.getProtein()));
                    b.setFat(Math.floor(b.getFat() + finalCalculation.getFat()));
                    b.setCarbs(Math.floor(b.getCarbs() + finalCalculation.getCarbs()));
                    b.setSugar(Math.floor(b.getSugar() + finalCalculation.getSugar()));
                    foodEatenToday.setProduct(b);
                    registerButton.setEnabled(true);
                    deleteUnregisteredIntakeButton.setEnabled(true);
                    emptyCalculationPage();
                    UpdateMacroDraft();
                    updateWhatEaten(false);
                }
            }
        }); /*
        itemlist.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    Product ps = itemlist.getSelectedValue();
                    itemfield.setText(ps.getProductName());
                }
                catch (NullPointerException npl) {
                }
            }
        }); */
        foodlist.addListSelectionListener(new ListSelectionListener() { @Override
            public void valueChanged(ListSelectionEvent e) { try {
                    Product ps = foodlist.getSelectedValue();
                    itemfield.setText(ps.getProductName());System.out.println("1"); }
                catch (NullPointerException npl) { error.setText("Nullpointer");  } } });
        drinkslist.addListSelectionListener(new ListSelectionListener() { @Override
            public void valueChanged(ListSelectionEvent e) { try {
                Product ps = drinkslist.getSelectedValue();
                itemfield.setText(ps.getProductName());System.out.println("2"); }
            catch (NullPointerException npl) { error.setText("Nullpointer");  } } });
        sweetsSnackslist.addListSelectionListener(new ListSelectionListener() { @Override
            public void valueChanged(ListSelectionEvent e) { try {
                Product ps = sweetsSnackslist.getSelectedValue();
                itemfield.setText(ps.getProductName());System.out.println("3"); }
            catch (NullPointerException npl) { error.setText("Nullpointer");  } } });
        otherlist.addListSelectionListener(new ListSelectionListener() { @Override
            public void valueChanged(ListSelectionEvent e) { try {
                Product ps = otherlist.getSelectedValue();
                itemfield.setText(ps.getProductName());System.out.println("4"); }
            catch (NullPointerException npl) { error.setText("Nullpointer");  } } });

        itemlist2.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    Category cs = itemlist2.getSelectedValue();
                    errorcreprod.setText("");
                    prodselectedfield.setText(cs.getProduct().getProductName());
                }
                catch (NullPointerException npl) {
                    errorcreprod.setText("No item selected");
                }
            }
        });
        createGoalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                errorgoal.setText("");
                if (calories.getText().length() < 2) {
                    errorgoal.setText("You need to input calorie goal");
                } else if (protein.getText().length() < 2) {
                    errorgoal.setText("You need to input protein goal");
                } else if (fat.getText().length() < 2) {
                    errorgoal.setText("You need to input fat goal");
                } else if (carbohydrates.getText().length() < 2) {
                    errorgoal.setText("You need to input carb goal");
                } else {
                    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(GeneralInfo.userInformation))) {
                        String get = bufferedReader.readLine();
                        String[] array = get.split(";");

                        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(GeneralInfo.userInformation)) {
                        }) {
                            Product p = new Product("goal", Double.parseDouble(calories.getText()), Double.parseDouble(protein.getText()), Double.parseDouble(fat.getText()), Double.parseDouble(carbohydrates.getText()), 0);
                            //dailyGoal = p;
                            bufferedWriter.write(get + "\n" + "dailyGoal;" + calories.getText() + ";" + protein.getText() + ";" + fat.getText() + ";" + carbohydrates.getText());
                            profilecalorietext.setText("You need to intake " + calories.getText() + " calories, "  + protein.getText() + "g protein, " + fat.getText() + "g fat, "  + carbohydrates.getText() + "g carbohydrates. Keep sugar intake minimal");
                            dailyGoal = GeneralInfo.CreateProductFromString("daily", calories.getText(), protein.getText(), fat.getText(), carbohydrates.getText(), "0");
                            updateWhatEaten(false);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }

                    } catch (FileNotFoundException fle) {} catch (IOException io) {}
                }
            }
        });
        rightbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    error.setText("");
                    if (amount >= 1) {
                        amount = amount + 1;
                        updateAmount();
                    } else {
                        amount = amount + 0.1;
                        updateAmount();
                    }
                }
                catch (NumberFormatException nfe) {
                    error.setText("The value has to be a number");
                }
            }
        });
        leftbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    error.setText("");
                    if (amount > 1) {
                        amount = amount - 1;
                        updateAmount();
                    } else if (amount > 0.1) {
                        amount = amount - 0.1;
                        updateAmount();
                    } else {
                        error.setText("Amount cannot be lower than 0");
                    }
                }
                catch (NumberFormatException nfe) {
                    error.setText("The value has to be a number");
                }
            }
        });

        //---------Card layout
        tab1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablayout.removeAll();
                tablayout.add(calculatorcard);
                tablayout.repaint();
                tablayout.revalidate();
            }
        });
        tab2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablayout.removeAll();
                tablayout.add(productMaker);
                tablayout.repaint();
                tablayout.revalidate();
            }
        });
        tab3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablayout.removeAll();
                tablayout.add(loggcard);
                tablayout.repaint();
                tablayout.revalidate();
            }
        });
        tab4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablayout.removeAll();
                tablayout.add(profilecard);
                tablayout.repaint();
                tablayout.revalidate();
            }
        });
        refreshListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                foodlist.clearSelection();
                drinkslist.clearSelection();
                sweetsSnackslist.clearSelection();
                otherlist.clearSelection();
                refreshProductlist(prodfileList);
            }
        });
        refreshListButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshProductlist(prodfileList);
            }
        });

        testProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String macrotekst = "Name: " + productnamefield.getText() + ", Calories: " + caloriefield.getText() + ", Protein: " + proteinfield.getText() + ", Fat: " + fatfield.getText() + ", Carbs: " + carbfield.getText() + ", Sugar: " + sugarfield.getText();
                output2.setText(macrotekst);
            }
        });
        addlist.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                foodlist.clearSelection();
                drinkslist.clearSelection();
                sweetsSnackslist.clearSelection();
                otherlist.clearSelection();
            }
        });
        refreshlog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshLog();
            }
        });

        deleteLogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int deleteAnswer = enWarning.showConfirmDialog(
                        mainPanel,
                        "Are you sure you want to delete your Log?",
                        "Delete Log?",
                        JOptionPane.WARNING_MESSAGE,
                        JOptionPane.YES_NO_OPTION);
                if (deleteAnswer == 0) {
                    boolean didIt = GeneralInfo.FileWipe(GeneralInfo.logg);
                    if (didIt) {
                        profileoutput.setText("Succesfully deleted the log");
                    } else {
                        profileerror.setText("Failed to delete log");
                    }
                }
            }
        });
        deleteProductlistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int deleteAnswer = enWarning.showConfirmDialog(
                        mainPanel,
                        "Are you sure you want to delete the product list?",
                        "Delete Product List?",
                        JOptionPane.WARNING_MESSAGE,
                        JOptionPane.YES_NO_OPTION);
                if (deleteAnswer == 0) {
                    boolean didIt = GeneralInfo.FileWipe(GeneralInfo.produkt);
                    if (didIt) {
                        profileoutput.setText("Succesfully deleted the product catalouge");
                    } else {
                        profileerror.setText("Failed to delete product");
                    }
                }
            }
        });
        emptyaddlist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                emptyCalculationPage();
            }
        });

        removeitemfromlist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Product p = new Product("",0,0,0,0,0);
                try {
                    if (foodTab.getSelectedIndex() == 0) { p = foodlist.getSelectedValue(); }
                    else if (foodTab.getSelectedIndex() == 1) { p = drinkslist.getSelectedValue(); }
                    else if (foodTab.getSelectedIndex() == 2) { p = sweetsSnackslist.getSelectedValue(); }
                    else if (foodTab.getSelectedIndex() == 3) { p = otherlist.getSelectedValue(); }
                    System.out.println("Item to remove:" + p.getProductName() + ";");
                    removeItemFromCatalouge(p);
                    refreshProductlist(prodfileList);
                }
                catch (NullPointerException n) {
                    error.setText("Error");
                    System.out.println("BOINK");
                }
            }
        });
        createUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (createnamefield.getText().length() < 5) {
                    errorcreateuser.setText("Name is too short!");
                } else if(createpasswordfield.getText().length() < 7) {
                    errorcreateuser.setText("Password needs to be atleast 7 digits long");
                } else {
                    try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(GeneralInfo.userInformation))) {
                        bufferedWriter.write(createnamefield.getText() + ";" + createagefield.getText() + ";" + createpasswordfield.getText() + "\ncreatine;" + "false"); ///////////////////////////////////////
                        profilecardlayout.removeAll();
                        profilecardlayout.add(userlayoutcard);
                        profilecardlayout.repaint();
                        profilecardlayout.revalidate();
                        nametext.setText(createnamefield.getText());
                        logintext.setText("Welcome " + createnamefield.getText());
                        agetext.setText(createagefield.getText());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    catch (NumberFormatException nfe) {
                        errorcreateuser.setText("Age must be a number");
                    }
                }
            }
        });

        //----------------------------------------------------
        addProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                error2.setText("");
                try {
                    if (productnamefield.getText().contains(";") || productnamefield.getText().contains(",") || productnamefield.getText().contains("*")) {
                        error2.setText("Product name cannot contain any of these symbols: ';' ',' '*'");
                        output2.setText("Output");
                    } else {
                        if (!foodRadioButton.isSelected() && !drinksRadioButton.isSelected() && !sweetsAndSnacksRadioButton.isSelected() && !otherRadioButton.isSelected()) {
                            error2.setText("Product needs a tag");
                            output2.setText("Output");
                        } else
                        if (productnamefield.getText().length() > 3) {
                            Product p = GeneralInfo.CreateProductFromString(productnamefield.getText(), caloriefield.getText(), proteinfield.getText(), fatfield.getText(), carbfield.getText(), sugarfield.getText());
                            String categorytag = "";
                            if (foodRadioButton.isSelected()) { categorytag = "Food"; }
                            else if (drinksRadioButton.isSelected()) { categorytag = "Drinks"; }
                            else if (sweetsAndSnacksRadioButton.isSelected()) { categorytag = "SweetsSnacks"; }
                            else if (otherRadioButton.isSelected()) { categorytag = "Others"; }
                            int answer = Calculate.AddProduct(p.addFormat(), categorytag);
                            if (answer == 1) {
                                output2.setText("Successfully added product");
                                productnamefield.setText(""); caloriefield.setText("0");
                                proteinfield.setText("0"); fatfield.setText("0");
                                carbfield.setText("0"); sugarfield.setText("0");
                            } else if (answer == 2) {
                                error2.setText("Something went wrong");
                                output2.setText("Output");
                            } else if (answer == 0) {
                                error2.setText("Error");
                                output2.setText("Output");
                            } else if (answer == 3) {
                                error2.setText("This product already exists");
                                output2.setText("Output");
                            }
                        } else {
                            error2.setText("Productname needs to be at least 3 characters long");
                            output2.setText("Output");
                        }
                    }
                }
                catch (NumberFormatException nfe) {
                    error2.setText("Formatting error, please check for any discrepancies");
                    output2.setText("Output");
                }
            }
        });
        addProductToRecipeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (Float.parseFloat(prodamount.getText()) == 0) {
                        errorcreprod.setText("You need to add an amount of the product");
                    } else if (Float.parseFloat(prodamount.getText()) < 0) {
                        errorcreprod.setText("The amount cannot be 0 or less");
                    } else {
                        Category c = itemlist2.getSelectedValue();
                        Product b = new Product(null, 0,0, 0, 0, 0);
                        b.setCalories(c.getProduct().getCalories() * Double.parseDouble(prodamount.getText()));
                        b.setProtein(c.getProduct().getProtein() * Double.parseDouble(prodamount.getText()));
                        b.setFat(c.getProduct().getFat() * Double.parseDouble(prodamount.getText()));
                        b.setCarbs(c.getProduct().getCarbs() * Double.parseDouble(prodamount.getText()));
                        b.setSugar(c.getProduct().getSugar() * Double.parseDouble(prodamount.getText()));
                        b.setProductName(c.getProduct().getProductName() + "     x" + prodamount.getText());
                        b = GeneralInfo.ProductDecimalFormated(b);
                        createprodCalculation.setCalories(createprodCalculation.getCalories() + b.getCalories());
                        createprodCalculation.setProtein(createprodCalculation.getProtein() + b.getProtein());
                        createprodCalculation.setFat(createprodCalculation.getFat() + b.getFat());
                        createprodCalculation.setCarbs(createprodCalculation.getCarbs() + b.getCarbs());
                        createprodCalculation.setSugar(createprodCalculation.getSugar() + b.getSugar());
                        createprodCalculation = GeneralInfo.ProductDecimalFormated(createprodCalculation);
                        prodmadeModel.addElement(b);
                        updateRecipeMacros();
                        createAndAddToButton.setEnabled(true);
                    }
                }
                catch (NullPointerException n) {
                    errorcreprod.setText("No value input");
                }
                catch (NumberFormatException nr) {
                    errorcreprod.setText("Error in the formating, avoid using letters and commas");
                }
            }
        });
        removerecipe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Product p = prodmadelist.getSelectedValue();
                    p = GeneralInfo.ProductDecimalFormated(p);
                    createprodCalculation.setCalories(createprodCalculation.getCalories() - p.getCalories());
                    createprodCalculation.setProtein(createprodCalculation.getProtein() - p.getProtein());
                    createprodCalculation.setFat(createprodCalculation.getFat() - p.getFat());
                    createprodCalculation.setCarbs(createprodCalculation.getCarbs() - p.getCarbs());
                    createprodCalculation.setSugar(createprodCalculation.getSugar() - p.getSugar());
                    createprodCalculation = GeneralInfo.ProductDecimalFormated(createprodCalculation);
                    prodmadeModel.removeElement(p);
                    prodmadelist.updateUI();
                    updateRecipeMacros();
                    if (prodmadeModel.isEmpty()) {
                        createAndAddToButton.setEnabled(false);
                    }
                } catch (NullPointerException n) {
                    errorcreprod.setText("No item selected to remove");
                }
            }
        });
        createAndAddToButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (recipename.getText().contains(";") || recipename.getText().contains(",") || recipename.getText().contains("*")) {
                        errorcreprod.setText("Product name cannot contain any of these symbols: ';' ',' '*'");
                        productcreatedfield.setText("Output");
                    } else
                    if (!foodRadioButton2.isSelected() && !drinksRadioButton2.isSelected() && !sweetsAndSnacksRadioButton2.isSelected() && !otherRadioButton2.isSelected()) {
                        errorcreprod.setText("Product needs a tag");
                        productcreatedfield.setText("Output");
                    } else
                    if (recipename.getText().length() > 3) {
                        Product p = new Product(recipename.getText(), createprodCalculation.getCalories(), createprodCalculation.getProtein(), createprodCalculation.getFat(), createprodCalculation.getCarbs(), createprodCalculation.getSugar());
                        String categorytag = "";
                        if (foodRadioButton2.isSelected()) { categorytag = "Food"; }
                        else if (drinksRadioButton2.isSelected()) { categorytag = "Drinks"; }
                        else if (sweetsAndSnacksRadioButton2.isSelected()) { categorytag = "SweetsSnacks"; }
                        else if (otherRadioButton2.isSelected()) { categorytag = "Others"; }
                        int answer = Calculate.AddProduct(p.addFormat(), categorytag);
                        if (answer == 1) {
                            productcreatedfield.setText("Added Product to catalogue");
                            emptyRecipePage();
                            errorcreprod.setText("");
                        } else if (answer == 2) {
                            errorcreprod.setText("Something went wrong");
                            productcreatedfield.setText("Output");
                        } else if (answer == 0) {
                            errorcreprod.setText("Error");
                            productcreatedfield.setText("Output");
                        } else if (answer == 3) {
                            errorcreprod.setText("This product already exists");
                            productcreatedfield.setText("Output");
                        }
                    } else {
                        errorcreprod.setText("Product name needs to contain 3 characters");
                    }
                }
                catch (NumberFormatException n) {
                    errorcreprod.setText("Error in the formating");
                }
                catch (NullPointerException n) {
                    errorcreprod.setText("List is empty");
                }
            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int noError = AddToFinalLog();
                if (noError == 3) {
                    GeneralInfo.FileWipe(GeneralInfo.macrodraft);
                    foodEatenToday.setProduct("final", 0, 0, 0, 0, 0);
                    updateWhatEaten(false);
                    registerButton.setEnabled(false);
                    registeredIntakefield.setText("");
                    calcDataOBS.setText("");
                    registerDraftButton.setEnabled(true);
                    deleteUnregisteredIntakeButton.setEnabled(false);
                    System.out.println(unregisteredData);
                }
            }
        });
        deleteUnregisteredIntakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (unregisteredData) {
                    int deleteAnswer = enWarning.showConfirmDialog(
                            mainPanel,
                            "Are you sure you want to delete past unregistered data? This action cannot be undone and will not be added to log",
                            "Delete Draft?",
                            JOptionPane.WARNING_MESSAGE,
                            JOptionPane.YES_NO_OPTION);
                    if (deleteAnswer == 0) {
                        DeleteUnregistered();
                    }
                } else {
                    int deleteAnswer = enWarning.showConfirmDialog(
                            mainPanel,
                            "Are you sure you want to delete unregistered data?",
                            "Delete unregistered data?",
                            JOptionPane.WARNING_MESSAGE,
                            JOptionPane.YES_NO_OPTION);
                    if (deleteAnswer == 0) {
                        DeleteUnregistered();
                    }
                }
            }
        });
        //Create Product from nutrients
        gramRadio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gramRadio.setSelected(true);
                decilitreRadio.setSelected(false);
                nutriAmount.setText("Amount (in g)");
            } });
        decilitreRadio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gramRadio.setSelected(false);
                decilitreRadio.setSelected(true);
                nutriAmount.setText("Amount (in ml)");
            } });
        createProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (namenutfield.getText().contains(";") || namenutfield.getText().contains(",") || namenutfield.getText().contains("*")) {
                        error3.setText("Product name cannot contain any of these symbols: ';' ',' '*'");
                        output3.setText("Output");
                    } else
                    if (namenutfield.getText().length() < 3) {
                        error3.setText("Productname needs to be at least 3 characters long");
                    }
                    else if (amountnutfield.getText() == null || amountnutfield.getText().length() < 1) {
                        error3.setText("You need an amount");
                    }
                    if (!foodRadioButton3.isSelected() && !drinksRadioButton3.isSelected() && !sweetsAndSnacksRadioButton3.isSelected() && !otherRadioButton3.isSelected()) {
                        error3.setText("Product needs a tag");
                        output3.setText("Output");
                    } else {
                        double diff = Double.parseDouble(amountnutfield.getText()) / 100;
                        Product p = new Product(namenutfield.getText(), Double.parseDouble(calnutfield.getText()) * diff, Double.parseDouble(protnutfield.getText()) * diff,
                                Double.parseDouble(fatnutfield.getText()) * diff, Double.parseDouble(carbnutfield.getText()) * diff, Double.parseDouble(sugarnutfield.getText()) * diff);
                        p = GeneralInfo.CeilProduct(p);
                        String categorytag = "";
                        if (foodRadioButton3.isSelected()) { categorytag = "Food"; }
                        else if (drinksRadioButton3.isSelected()) { categorytag = "Drinks"; }
                        else if (sweetsAndSnacksRadioButton3.isSelected()) { categorytag = "SweetsSnacks"; }
                        else if (otherRadioButton3.isSelected()) { categorytag = "Others"; }
                        int b = Calculate.AddProduct(p.addFormat(), categorytag);
                        if (b == 1) {
                            output3.setText("Product was saved");
                            emptyNutritionPage();
                            error3.setText("");
                        } else if (b == 2) {
                            output3.setText("Product name too short!");
                        } else if (b == 3) {
                            output3.setText("Duplicate detected, please change the name");
                        }
                    }
                } catch (NumberFormatException n) {
                    error3.setText("Formatting error, make sure numberfields doesn't contain letters");
                }
            }
        });
        amountfield.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                try {
                    amount = Double.parseDouble(amountfield.getText());
                    error.setText("");
                }
                catch (NumberFormatException n) {
                    if (amountfield.getText().length() < 1) {
                        error.setText("Field cannot be empty");
                    } else {
                        error.setText("Field can only contain numbers");
                    }
                }
            }
        });
        foodTab.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println("GetSelectedIndex:");
                System.out.println(foodTab.getSelectedIndex());
            }
        });
        profileTakeCreatine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("START SERVICE");

                boolean state = profileTakeCreatine.isSelected();
                ArrayList<String> USERDRAFT = new ArrayList<>();
                ArrayList<String> toMacFile = new ArrayList<>();
                try(BufferedReader b = new BufferedReader(new FileReader(GeneralInfo.userInformation))) {
                    String read = "";
                    boolean dce = false;
                    while ((read = b.readLine()) != null) {
                        USERDRAFT.add(read);
                        if (read.contains("creatine")) {
                            toMacFile.add("creatine;" + state); dce = true;
                        } else {toMacFile.add(read);}
                        System.out.println(read);
                    }
                    if (!dce) { toMacFile.add("creatine;" + state);}
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                    profileerror.setText("SERVICE FAILED");
                } catch (IOException ex) {
                    ex.printStackTrace();
                    profileerror.setText("SERVICE FAILED");
                }
                try (BufferedWriter b2 = new BufferedWriter(new FileWriter(GeneralInfo.userInformation))) {
                    creatineCheckBox.setEnabled(state);
                    if (!toMacFile.isEmpty()) {
                        for (String s : toMacFile) {
                            b2.write(s);
                            b2.newLine();
                        }
                    } else { System.out.println("EMPTY");
                        profileerror.setText("SERVICE FAILED");}
                    System.out.println("END SERVICE");
                } catch (FileNotFoundException ex) {
                    profileerror.setText("SERVICE FAILED");
                } catch (IOException ex) {
                    profileerror.setText("SERVICE FAILED");
                }
            }
        });
        foodRadioButton.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) { RadioButtonsAddproduct(foodRadioButton); } });
        drinksRadioButton.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) { RadioButtonsAddproduct(drinksRadioButton); } });
        sweetsAndSnacksRadioButton.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) { RadioButtonsAddproduct(sweetsAndSnacksRadioButton); } });
        otherRadioButton.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) { RadioButtonsAddproduct(otherRadioButton); } });
        foodRadioButton2.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) { RadioButtonsAddproduct(foodRadioButton2); } });
        drinksRadioButton2.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) { RadioButtonsAddproduct(drinksRadioButton2); } });
        sweetsAndSnacksRadioButton2.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) { RadioButtonsAddproduct(sweetsAndSnacksRadioButton2); } });
        otherRadioButton2.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) { RadioButtonsAddproduct(otherRadioButton2); } });
        foodRadioButton3.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) { RadioButtonsAddproduct(foodRadioButton3); } });
        drinksRadioButton3.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) { RadioButtonsAddproduct(drinksRadioButton3); } });
        sweetsAndSnacksRadioButton3.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) { RadioButtonsAddproduct(sweetsAndSnacksRadioButton3); } });
        otherRadioButton3.addActionListener(new ActionListener() { @Override public void actionPerformed(ActionEvent e) { RadioButtonsAddproduct(otherRadioButton3); } });
    }

    void DeleteUnregistered() {
        GeneralInfo.FileWipe(GeneralInfo.macrodraft);
        foodEatenToday.setProduct("final", 0, 0, 0, 0, 0);
        updateWhatEaten(false);
        registerButton.setEnabled(false);
        registeredIntakefield.setText("");
        calcDataOBS.setText("");
        registerDraftButton.setEnabled(true);
        unregisteredData = false;
        deleteUnregisteredIntakeButton.setEnabled(false);
    }

    void updateCalculation() {
        error.setText("");
        output.setText("You have eaten " + finalCalculation.getCalories() + " calories and " + finalCalculation.getProtein() + "g of protein, " + finalCalculation.getFat() + "g of fat, " + finalCalculation.getCarbs() + "g of carbs, " + finalCalculation.getSugar() + "g of sugar.");

    }

    void emptyCalculationPage() {
        addedprodlist.removeAllElements();
        finalCalculation = new Product(finalCalculation.getProductName(),0,0,0,0,0);
        registerDraftButton.setEnabled(false);
        updateCalculation();
        amount = 1;
        updateAmount();
        addlist.updateUI();
    }

    void emptyRecipePage() {
        recipename.setText("");
        prodamount.setText("1");
        prodselectedfield.setText("Product Selected");
        errorcreprod.setText("");
        prodmadeModel.removeAllElements();
        prodmadelist.updateUI();
        createprodCalculation = new Product(createprodCalculation.getProductName(), 0, 0, 0, 0, 0);
    }

    void emptyNutritionPage() {
        calnutfield.setText("0");
        protnutfield.setText("0");
        fatnutfield.setText("0");
        carbnutfield.setText("0");
        sugarnutfield.setText("0");
        namenutfield.setText("");
        amountnutfield.setText("");
        error3.setText("");
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    void refreshProductlist(ArrayList<Product> prodfileList) {
        ArrayList<Category> lists = GeneralInfo.getProductFileList();
        itemlist2.clearSelection();
        foodListModel.clear();
        drinksListModel.clear();
        sweetsSnacksListModel.clear();
        otherListModel.clear();

        for (Category c : lists) {
            productModel.addElement(c);

            if (c.getCategoryName().equals("Food")) {
                foodListModel.addElement(c.products);
            } else
            if (c.getCategoryName().equals("Drinks")) {
                drinksListModel.addElement(c.products);
            } else
            if (c.getCategoryName().equals("SweetsSnacks")) {
                sweetsSnacksListModel.addElement(c.products);
            } else
            if (c.getCategoryName().equals("Others")) {
                otherListModel.addElement(c.products);
            }
            prodfileList.add(c.products);
        }
        foodlist.updateUI();
        drinkslist.updateUI();
        sweetsSnackslist.updateUI();
        otherlist.updateUI();
        itemlist2.updateUI();
    }

    void updateRecipeMacros() {
        productcreatedfield.setText("Productname: " + recipename.getText() + ", Calories: " + createprodCalculation.getCalories()
                + ", Protein: " + createprodCalculation.getProtein() + ", Fat: " + createprodCalculation.getFat() + ", Carbs: "
                + createprodCalculation.getCarbs() + ", Sugar: " + createprodCalculation.getSugar());
    }

    void removeItemFromCatalouge(Product item) {
        String readline = "";
        String FromFile = "";
        System.out.println("Start method:");
        int success = Calculate.removeProduct(item.getProductName());
        System.out.println("Successcode: " + success);
        if (success == 0) {
            error.setText("Did not find item to remove"); }
        else if (success == 1) {
            output.setText("Item removed"); error.setText(""); }
        else if (success == 2) {
            error.setText("Product list not found"); }
        else if (success == 3) {
            error.setText("Error removing item"); }
        else if (success == 4) {
            error.setText("List Empty"); }
    }

    int AddToFinalLog() { /////////////////////////////////////////////////////////////////////////////////////////////////////////////////<<<<<
        System.out.println("START SERVICE");
        int valueState = 0;
        profileerror.setText("");
        if (dailyGoal.getCalories() == 0) {
            profileerror.setText("You need to set nutrition goals first");
            System.out.println("1");
            valueState = 1;
        } else if (!userAccount) {
            profileerror.setText("You need to create a user first");
            System.out.println("2");
            valueState = 2;
        } else {
            System.out.println("3");
            String addtext = "";
            if (profileTakeCreatine.isSelected()) {
                boolean state = creatineCheckBox.isSelected();
                System.out.println("Creatine: " + state);
                if (state) { addtext = "Creatine is active and was taken"; }
                else { addtext = "Creatine NOT taken"; }
            }
            GeneralInfo.WriteToLog( "You ate " + foodEatenToday.getProduct().getCalories() + " out of your daily " + dailyGoal.getCalories() +
                    " calorie intake \n You ate " + foodEatenToday.getProduct().getProtein() + "g of protein out of your daily " + dailyGoal.getProtein() + "g\nYou ate " + foodEatenToday.getProduct().getFat() +
                    "g of fat out of your daily " + dailyGoal.getFat() + "g\nYou ate " + foodEatenToday.getProduct().getCarbs() + "g of carbs of your daily " + dailyGoal.getCarbs() + "g\nYou ate " + foodEatenToday.getProduct().getSugar() + "g of sugar."  + "\n" + addtext,
                    unregisteredData, foodEatenToday);
            foodlist.updateUI(); drinkslist.updateUI(); sweetsSnackslist.updateUI(); otherlist.updateUI();
            valueState = 3;
        }

        System.out.println("END SERVICE");
        return valueState;
    }

    Product checkDraft() {
        Product returned = new Product(null, 0,0,0,0,0);
        String getdate = GeneralInfo.GetDraftLine();
        if (getdate == null) {
            returned.setProductName("noDraft");
            registerButton.setEnabled(false);
        } else {
            String[] dateArray = getdate.split(";");
            if (foodEatenToday.getMonth().equals(dateArray[0]) && foodEatenToday.getDay() == Integer.parseInt(dateArray[1]) && foodEatenToday.getYear() == Integer.parseInt(dateArray[2])) {
                returned = new Product(dateArray[3], Double.parseDouble(dateArray[4]), Double.parseDouble(dateArray[5]), Double.parseDouble(dateArray[6]), Double.parseDouble(dateArray[7]), Double.parseDouble(dateArray[8]));
                returned.setProductName("sameDate");
                registerButton.setEnabled(true);
                deleteUnregisteredIntakeButton.setEnabled(true);
            } else {
                String line = GeneralInfo.GetDraftLine();
                String[] array = line.split(";");
                returned = new Product("", Double.parseDouble(array[4]), Double.parseDouble(array[5]), Double.parseDouble(array[6]), Double.parseDouble(array[7]), Double.parseDouble(array[8]));
                returned.setProductName("notSameDate");
                registeredIntakefield.setText("OBS! Last intake not registered");
                deleteUnregisteredIntakeButton.setEnabled(true);
                unregisteredData = true;
                calcDataOBS.setText("OBS you have unregistered data, handle this before adding new");
                registerButton.setEnabled(true);
                registerDraftButton.setEnabled(false);
            }
        }
        return returned;
    }

    void updateWhatEaten(boolean oldDate) {
        if (oldDate) {
            String[] fromDraft = GeneralInfo.GetDraftLine().split(";");
            eatentextarea.setText("Today's Food intake" + "\n" + "Calories: " + fromDraft[4] + "/" + dailyGoal.getCalories()  + "\n" + "Protein: " + fromDraft[5] + "/" + dailyGoal.getProtein()  + "\n" + "Fat: " + fromDraft[6] + "/" + dailyGoal.getFat()  + "\n" + "Carbs: " + fromDraft[7] + "/" + dailyGoal.getCarbs()  + "\n" + "Sugar: " + fromDraft[8] + "g");
            eatentextarea.updateUI();
        } else {
            eatentextarea.setText("Today's Food intake" + "\n" + "Calories: " + foodEatenToday.getProduct().getCalories() + "/" + dailyGoal.getCalories()  + "\n" + "Protein: " + foodEatenToday.getProduct().getProtein() + "/" + dailyGoal.getProtein()  + "\n" + "Fat: " + foodEatenToday.getProduct().getFat() + "/" + dailyGoal.getFat()  + "\n" + "Carbs: " + foodEatenToday.getProduct().getCarbs() + "/" + dailyGoal.getCarbs()  + "\n" + "Sugar: " + foodEatenToday.getProduct().getSugar() + "g");
            eatentextarea.updateUI();
        }
    }

    void RadioButtonsAddproduct(JRadioButton j) {
        foodRadioButton.setSelected(false);
        drinksRadioButton.setSelected(false);
        sweetsAndSnacksRadioButton.setSelected(false);
        otherRadioButton.setSelected(false);

        foodRadioButton2.setSelected(false);
        drinksRadioButton2.setSelected(false);
        sweetsAndSnacksRadioButton2.setSelected(false);
        otherRadioButton2.setSelected(false);

        foodRadioButton3.setSelected(false);
        drinksRadioButton3.setSelected(false);
        sweetsAndSnacksRadioButton3.setSelected(false);
        otherRadioButton3.setSelected(false);

        j.setSelected(true);
    }

    Product getDailyGoal() {
        creatineCheckBox.setEnabled(false);
        Product p = new Product(null, 0, 0,0,0,0);
        if (userAccount) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(GeneralInfo.userInformation))) {
                String read = "";
                while ((read = bufferedReader.readLine()) != null) {
                    if (read.contains("dailyGoal")) {
                        String[] array = read.split(";");
                        p = new Product("goal", Double.parseDouble(array[1]), Double.parseDouble(array[2]), Double.parseDouble(array[3]), Double.parseDouble(array[4]), 0);
                    }
                    if (read.contains("creatine")) {
                        String[] array = read.split(";");
                        if (array[1].equals("true")) {
                            profileTakeCreatine.setSelected(true);
                            creatineCheckBox.setEnabled(true);
                        }
                    }
                }
            } catch (FileNotFoundException fle) {} catch (IOException io) {}
        }
        return p;
    }

    void UpdateMacroDraft() {
        String lineToChange = foodEatenToday.toString();
        String fromfile = GeneralInfo.GetAllFromDraft();
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(GeneralInfo.macrodraft))) {
            boolean success = GeneralInfo.FileWipe(GeneralInfo.macrodraft);
            bufferedWriter.write(lineToChange);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void updateAmount() {
        //df.format(amount);
        amountfield.setText("" + GeneralInfo.DecimalFormat(df.format(amount)));
    }

    void refreshLog() {
        logoutput.setText(GeneralInfo.GetLog());
    }
}