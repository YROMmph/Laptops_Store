package OOp;

import OOp.family_tree.FamilyTree;
import OOp.human.Gender;
import OOp.human.Human;
import java.io.File;
import OOp.writer.FileHandler;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String filePath = "D:\\рабочий стол\\java_projects\\OOp\\writer";
        // FamilyTree tree = read(filePath);

        FamilyTree tree = testTree();
        System.out.println(tree);

        save(tree, filePath);
    }
    static FamilyTree read(String filePath){
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.read(filePath);
    }
    static void save(FamilyTree familyTree, String filePath){
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(familyTree, filePath);
    }

    static FamilyTree testTree(){
        FamilyTree tree = new FamilyTree();

        Human vasya = new Human("Василий", Gender.Male, LocalDate.of(1963, 12, 10));
        Human masha = new Human("Мария", Gender.Female, LocalDate.of(1965, 9, 15));
        tree.add(vasya);
        tree.add(masha);
        tree.setWedding(vasya, masha);

        Human christina = new Human("Кристина", Gender.Female, LocalDate.of(1988, 7, 5),
                vasya, masha);
        Human semyon = new Human("Семен", Gender.Male, LocalDate.of(1991, 1, 25),
                vasya, masha);
        tree.add(christina);
        tree.add(semyon);

        Human grandMother = new Human("Лариса", Gender.Female, LocalDate.of(1945, 9, 1));
        grandMother.addChild(vasya);
        tree.add(grandMother);

        return tree;
    }
}



