import java.io.*;
import java.util.ArrayList;

public class Calculate extends GeneralInfo {
    static boolean duplicate = false;

    //Tidligere versjon brukte bare console commandoer, dette funker halvveis fortsatt men ble erstattet med GUI
    public static void main(String[] args) {
        GUI gui = new GUI("Macro Counter");
        gui.setVisible(true);
        boolean leggtilProdukter = false;
        boolean deleteList = false;
        System.out.println("Welcome");
        System.out.println("---Commands: 'add', 'exit', 'back', 'delete list'" + "\n");

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter loggWriter = new FileWriter(logg, true);) {

            String lestekst = "";
            while (!lestekst.equals("exit")) {
                if (deleteList) {
                    System.out.println("Are you sure you want to delete list?");
                    System.out.println("---'Yes'---'No'---");
                    lestekst = bufferedReader.readLine();
                    lestekst.toLowerCase();
                    if (lestekst.equals("yes")) {
                        produkt.delete();
                        System.out.println("Deleted list");
                        deleteList = false;
                    } else {
                        System.out.println("Command: 'delete list' cancelled.");
                        System.out.println();
                        deleteList = false;
                    }
                } else
                if (leggtilProdukter) {
                    System.out.println("Add products (format: name, calories, protein, fat, carbs, sugar) :");
                    System.out.print(": ");
                    lestekst = bufferedReader.readLine();
                    lestekst.toLowerCase();
                    loggWriter.append(lestekst + "\n");
                    if (lestekst.equals("delete list")) {
                        deleteList = true;
                    } else {
                        //AddProduct(lestekst);
                    }
                    System.out.println();
                } else {
                    if (!lestekst.equals("exit")) {
                        System.out.print(": ");
                        lestekst = bufferedReader.readLine();

                        if (lestekst.equals("add")) {
                            leggtilProdukter = true;
                            System.out.println();
                        } else {
                            loggWriter.append(lestekst + "\n");
                            //System.out.println("Saved.");
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static Integer AddProduct(String lestekst, String category) {
        try (FileWriter productWriter = new FileWriter(produkt, true);
            FileWriter productLogg = new FileWriter(produktLogg, true)) {
            ArrayList<Category> lists = GeneralInfo.getProductFileList();
            int state = 0;
            String[] items = lestekst.split(":"); //sorts value for product
            String fromFile = "";
            for (Category c : lists) {
                if (fromFile.length() < 2) {
                    fromFile = c.csvFormat() + "";
                } else {
                    fromFile = fromFile + "\n" + c.csvFormat();
                }
                if (c.products.equals(items[0])) {
                    duplicate = true;
                }
            }
            if (duplicate) {
                state = 3;
            } else
            if (items.length == 6) {
                Product p1 = new Product(items[0], Double.parseDouble(items[1]), Double.parseDouble(items[2]), Double.parseDouble(items[3]), Double.parseDouble(items[4]), Double.parseDouble(items[5]));
                Category cs = new Category(category, p1);
                boolean success = GeneralInfo.FileWipe(produkt);
                productWriter.write(fromFile + "\n" + cs.csvFormat() + "\n");
                productLogg.write(cs.csvFormat() + "\n");
                state = 1;
            } else {
                if (!lestekst.equals("exit")) {
                    state = 2;
                }
            }
            duplicate = false;
            return state;
        } catch (IOException io) {
            System.err.println(io.getMessage());
            return 0;
        }
    }

    public static int removeProduct(String productname) {
        int success = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(GeneralInfo.produkt))) {

            ArrayList<Category> lists = GeneralInfo.getProductFileList();
            Category cp = new Category("", null);
            //itemlist.clearSelection();
            if (!lists.isEmpty()) {
                boolean found = false;
                for (Category c : lists) {
                    //System.out.println(c.getProduct().getProductName() + " == " + productname); System.out.println(c.getProduct().getProductName() + ";" + productname + ";"); System.out.println(c.getProduct().getProductName().equals(productname));
                    if (c.getProduct().getProductName().equals(productname)) {
                        found = true;
                        cp = c;
                    }
                }
                if (found) {
                    ArrayList<String> lines = new ArrayList<>();
                    String read = "";
                    while ((read = bufferedReader.readLine()) != null) {
                        String[] array = read.split(";");
                        if (array[1].equals(cp.getProduct().getProductName())) {

                        } else {
                            lines.add(read);
                        }
                    }
                    GeneralInfo.WriteToFile(lines);
                    success = 1;
                }
            } else { success = 4;}
        } catch (FileNotFoundException e) {
            e.printStackTrace(); success = 2;
        } catch (IOException e) {
            e.printStackTrace(); success = 3;
        }
        return success;
    }
}
