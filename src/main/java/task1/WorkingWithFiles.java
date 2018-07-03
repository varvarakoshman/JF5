package task1;

import java.io.*;
import java.util.Scanner;

public class WorkingWithFiles {

    public static void viewFile(File file) {
        System.out.printf("file %s :\n",file.getName());
        try {
            BufferedReader content = new BufferedReader(new FileReader(file));
            String s;
            while ((s = content.readLine()) != null) {
                System.out.println(s);
            }
            content.close();
        } catch (FileNotFoundException e) {
            System.out.println(">no such file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void viewDir(File dir) {
        System.out.printf("dir %s :\n",dir.getName());
        try {
            for (File item : dir.listFiles()) {
                if (item.isDirectory()) {
                    System.out.println("directory: " + item);
                } else {
                    System.out.println("file: " + item);
                }
            }
        } catch (NullPointerException e) {
            System.out.println(">no such directory");
        }
    }

    public static void viewDeeper() {
        System.out.println(">enter a file/directory to view");
        System.out.println(">enter exit to end");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.next();
            if (line.equals("exit")) break;
            File file = new File(line);
            if (file.exists()) {
                if (file.isDirectory()) {
                    viewDir(file);
                } else {
                    viewFile(file);
                }
            } else {
                System.out.println(">no such file/directory");
            }
        }
    }

    public static void createNewFile(String name) {
        File file = new File(name);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void rewriteFile(String name) {
        File file =  new File(name);
        System.out.println("Add new info to file " + file.getName());
        Scanner scanner = new Scanner(System.in);
        try {
            BufferedWriter newFile = new BufferedWriter(new FileWriter(file));
            if (scanner.hasNext()) {
                newFile.write(scanner.nextLine());
            }
            newFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFileDir(String name) {
        File file = new File(name);
        file.delete();
    }

}
