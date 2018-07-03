/*
Задание 1
Разработать приложение, позволяющее просматривать файлы и каталоги файловой
системы, а также создавать и удалять текстовые файлы. Для работы с текстовыми файлами
необходимо реализовать функциональность записи (дозаписи) в файл. Требуется определить
исключения для каждого слоя приложения и корректно их обработать.

*/
package task1;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file1 = new File("Files\\dir2\\createNewFileText.txt");
        WorkingWithFiles.viewFile(file1);
        File file2 = new File("Files");
        WorkingWithFiles.viewDir(file2);
        WorkingWithFiles.viewDeeper();
        WorkingWithFiles.createNewFile("Files\\createdFile.txt");
        WorkingWithFiles.rewriteFile("Files\\createdFile.txt");
        WorkingWithFiles.deleteFileDir("Files\\viewFileText.txt");
    }
}
