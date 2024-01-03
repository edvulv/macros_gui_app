import java.io.*;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class GeneralInfo {

    private static final DecimalFormat df = new DecimalFormat("0.00");

    static File produkt = new File("src/produkter.csv");
    static File logg = new File("src/Logg.txt");
    static File produktLogg = new File("src/produktlogg.csv");
    static File userInformation = new File("src/usernameinformation.csv");
    static File macrodraft = new File("src/macrodraft.csv");

    public static File getProdukt() {        return produkt;    }

    public static void setProdukt(File produkt) {
        GeneralInfo.produkt = produkt;
    }

    public static File getLogg() {
        return logg;
    }

    public static void setLogg(File logg) {
        GeneralInfo.logg = logg;
    }

    public static File getProduktLogg() {
        return produktLogg;
    }

    public static void setProduktLogg(File produktLogg) {
        GeneralInfo.produktLogg = produktLogg;
    }

    public static Product CreateProductFromString(String s, String cal, String pro, String fat, String carb, String sug) {
        Product p = new Product(s, Double.parseDouble(cal), Double.parseDouble(pro), Double.parseDouble(fat), Double.parseDouble(carb), Double.parseDouble(sug));
        return p;
    }
    public static Product CeilProduct(Product product) {
        product.setCalories(Math.round(product.getCalories()));
        product.setProtein(Math.round(product.getProtein()));
        product.setFat(Math.round(product.getFat()));
        product.setCarbs(Math.round(product.getCarbs()));
        product.setSugar(Math.round(product.getSugar()));
        return product;
    }

    public static String DecimalFormat(String withComma) {
        String[] array = withComma.split(",");
        String newstring = array[0] + "." + array[1];
        return newstring;
    }

    public static Product ProductDecimalFormated(Product p) {
        try {
            String csv = p.csvFormat();
            String[] array = csv.split(";");
            String newCsv = p.getProductName() + ";" + df.format(Double.parseDouble(array[1])) + ";" + df.format(Double.parseDouble(array[2])) + ";" + df.format(Double.parseDouble(array[3])) + ";" + df.format(Double.parseDouble(array[4])) + ";" + df.format(Double.parseDouble(array[5]));
            String[] removeCommas = newCsv.split(","); //6 items
            csv = removeCommas[0] + "." + removeCommas[1] + "." + removeCommas[2] + "." + removeCommas[3] + "." + removeCommas[4] + "." + removeCommas[5];
            String[] array2 = csv.split(";");
            p.setCalories(Double.parseDouble(array2[1]));
            p.setProtein(Double.parseDouble(array2[2]));
            p.setFat(Double.parseDouble(array2[3]));
            p.setCarbs(Double.parseDouble(array2[4]));
            p.setSugar(Double.parseDouble(array2[5]));
        }
        catch (NumberFormatException n) {
            System.out.println(n.getMessage());
        }
        return p;
    }

    static public ArrayList<Category> getProductFileList() {
        BufferedReader fileReader = null;
        ArrayList<Category> arrayList = new ArrayList<>();
        try {
            fileReader = new BufferedReader(new FileReader(Calculate.getProdukt()));
            String ob = "";
            while ((ob = fileReader.readLine()) != null) {
                String[] th = ob.split(";");
                try {
                    //System.out.println(th[0]);
                    Product ps = new Product(th[1], Double.parseDouble(th[2]), Double.parseDouble(th[3]), Double.parseDouble(th[4]), Double.parseDouble(th[5]), Double.parseDouble(th[6]));
                    Category cs = new Category(th[0], ps);
                    arrayList.add(cs);
                }
                catch (NumberFormatException nbr) {
                    Product p = new Product("Item formatting error",0,0,0,0,0);
                    Category cs = new Category("Error:", p);
                    arrayList.add(cs);
                }
                catch (ArrayIndexOutOfBoundsException a)  {
                    System.out.println("List out of bounds");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException");
        }
        return arrayList;
    }

    public static void WriteToLog(String whatToWrite, boolean unregisteredData, Date todayDate) {

        String fromLog = GetLog();
        String date = "";
        date = LocalDateTime.now().toString();
        String[] format = date.split("-");
        String month = DateManager.getMonth(Integer.parseInt(format[1]));
        String year = format[0];
        String[] findday = format[2].split("T");
        String day = findday[0];
        String time = "Time: " + findday[1];
        if (unregisteredData) {
            String draft = GetDraftLine();
            String[] g = draft.split(";");
            month = g[0];
            day = g[1];
            year = g[2];
        }

        try (FileWriter fileWriter = new FileWriter(logg)) {
            fileWriter.write(todayDate.getMonth() + " " + todayDate.getDay() + ". " + todayDate.getYear() + "\n   " + time + "\n");
            if (fromLog.equals("") || fromLog.equals(null)) {
                fileWriter.write(whatToWrite);
            } else {
                fileWriter.write(whatToWrite + "\n" + fromLog);
            }
            System.out.println("Wrote to file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String GetLog() {
        String fromLog = "";
        String ob = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(GeneralInfo.logg));
            while ((fromLog = bufferedReader.readLine()) != null) {
                ob = ob + "\n" + fromLog;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ob;
    }

    public static boolean FileWipe(File file) {
        boolean success = false;
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write("");
            success = true;
        } catch (IOException e) {
            success = false;
        }
        return success;
    }

    public static String GetDraftLine() {
        String line = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(macrodraft))) {
            line = bufferedReader.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    public static String GetAllFromDraft() {
        String readline = "";
        String line = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(macrodraft))) {
            while ((readline = bufferedReader.readLine()) != null) {
                if (line == null) { line = readline + "\n"; }
                else { line = line + readline + "\n"; }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    public static void WriteToFile(ArrayList<String> stringList) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(produkt))){
            for (String s : stringList) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
