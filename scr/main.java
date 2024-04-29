import family_tree.person.Gender;
import family_tree.person.Human;
import family_tree.service.Service;
import family_tree.tree.FamilyTree;
import family_tree.tree.HumanIterator;
import family_tree.writer.FileHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Human danya = new Human("Brizhaty Daniil Sergeevich", LocalDate.of(1894, 4, 15), Gender.Male);
        danya.setDeadDate(LocalDate.of(1971, 9, 11));
        Human egor = new Human("Brizhaty Egor Daniilovich", LocalDate.of(1935, 7, 2), Gender.Male);
        Human denis  = new Human("Brizhaty Denis Daniilovich", LocalDate.of(1917, 11, 10), Gender.Male);
        Human vika = new Human("Sofronova-Brizhataya Viktoria Sergeevna", LocalDate.of(1900, 4, 14), Gender.Female);
        vika.setDeadDate(LocalDate.of(1984, 8, 13));
        Human sonya = new Human("Orlova Sofia Alexeevna", LocalDate.of(1896, 1, 01), LocalDate.of(1919, 01, 01), Gender.Female, null, null);
        Human ari = new Human("Brizhataya Ariella Daniilovna", LocalDate.of(1916, 3, 04), LocalDate.of(1981, 4, 03), Gender.Female, danya, sonya);
        Human nina = new Human("Vladimirova-Brizhataya Nina Daniilovna", LocalDate.of(1929, 4, 04), LocalDate.of(2016, 8, 11), Gender.Female, danya, vika);
        /*
        1-st wife
         */
        System.out.println("1-st wife");
        danya.setPartner(sonya);
        danya.addChildFromThisPartner(sonya, denis);
        danya.addChildFromThisPartner(sonya, ari);

