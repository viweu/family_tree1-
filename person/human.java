package family_tree.person;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Human implements Serializable, Comparable<Human> {
    private long id;
    private String name;
    private LocalDate dob, dod;
    private Gender gender;
    //private List<Human> allChildren = new ArrayList<>();
    private Human mother, father;
    private Human partner;
    private Map<Human, ArrayList<Human>> kids = new HashMap<>();
    private int countOfChildren;
    public Human(String name, LocalDate dob, Gender gender) {
        this(name, dob, null, gender, null, null);
    }
    public Human(String name, LocalDate dob, LocalDate dod, Gender gender) {
        this(name, dob, dod, gender, null, null);
    }
  
   public Human(String name, LocalDate dob, LocalDate dod, Gender gender,
                 Human father, Human mother) {
        id = -1;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.dod = dod;
        this.father = father;
        this.mother = mother;
      if (father != null) {
//            this.father.getKidsFromPartner(this.mother).add(this);
//        }
//        if (mother != null) {
//            this.mother.getKidsFromPartner(this.father).add(this);
//        }
    }

    public Human(String name, LocalDate dob, Gender gender, Human father, Human mother) {
        this(name, dob, null, gender, father, mother);
    }
    public void addChildFromUnknownPartner(Human child) {
        if (kids.isEmpty()) {
            kids = new HashMap<>();
        } else if (!kids.containsKey(null)) {
            kids.put(null, new ArrayList<>());
        }
        kids.get(null).add(child);
        child.setParent(this);
        countOfChildren++;
    }
    public boolean addChildFromThisPartner(Human partner, Human child) {
        ArrayList<Human> temp = getKidsFromPartner(partner);
       if (!temp.isEmpty()) {
            if (!temp.contains(child)) {
                getKidsFromPartner(partner).add(child);
                partner.getKidsFromPartner(this).add(child);
                child.setParent(partner);
                child.setParent(this);
                countOfChildren++;
                return true;
            } else {
                System.out.println("This child already recorded in this union");
                return false;
            }
        } else {
            kids.put(partner, new ArrayList<Human>());
            kids.get(partner).add(child);
            partner.addChildFromThisPartner(this, child);
            child.setParent(partner);
            child.setParent(this);
            countOfChildren++;
            return true;
        }
    }

    public ArrayList<Human> getKidsFromPartner(Human partner) {
           }
        }
        System.out.println("This partner and their kids is not found.");
        return null;
    }
    public Human findChildByName(String name) {
        if (kids.isEmpty()) {
            System.out.println("This man don't have children");
            return null;
        }
        for (ArrayList<Human> item : kids.values()) {
            for (Human children : item) {
                if (children.getName().equalsIgnoreCase(name)) {
                    return children;
                }
            }
        }
        System.out.println("Child with this name: " + name + " is not found");
        return null;
    }
    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    public void setParent(Human partner) {
        if (partner.getGender().equals(Gender.Male)) {
            this.father = partner;
        } else if (partner.getGender().equals(Gender.Female)) {
            this.mother = partner;
        }
    }

    public Human getFather() {
        return father;
    }
  public String getName() {
        return name;
    }
    public void setDeadDate(LocalDate dod) {
        if ((dod.isAfter(this.dob)) || (dod.isBefore(this.dob.plusYears(140)))) {
            this.dod = dod;
        } else {
            System.out.println("Date of dead incorrect!"); //некорктна
        }
    }
   public ArrayList<Human> getListOfChildren() {
        ArrayList<Human> temp = new ArrayList<>();
        for (ArrayList<Human> item : kids.values()) {
            temp.addAll(item);
        }
        return temp;
    }

    public LocalDate getDateOfBirth() {
        return this.dob;
    }
    /**
     * Not finished
     *
     * @param partner
     */
    public void setPartner(Human partner) {
        kids.put(partner, new ArrayList<Human>());
   partner.kids.put(this, new ArrayList<Human>());
        this.partner = partner;
        partner.partner = this;
    }

    public List<Human> getListOfPartner() {
        if (!kids.isEmpty()) {
            List<Human> partners = new ArrayList<Human>(kids.keySet().size());
            partners.addAll(kids.keySet());
            return partners;
        }
        System.out.println("This man: " + name + " don't have and had partners");
        return null;
    }
    public int getAge() {
        if (this.dod == null) {
            return getPeriod(dob, LocalDate.now());
        } else {
            return getPeriod(dob, dod);
        }
    }
    private int getPeriod(LocalDate birthDate, LocalDate deadDate) {
        Period diff = Period.between(birthDate, deadDate);
        return diff.getYears();
    }
    public Human getPartner() {
        return partner;
    }
    public Gender getGender() {
        return gender;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return getInfo();
    }
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(" , name: ");
        sb.append(name + "\n");
        sb.append("gender: ");
        sb.append(getGender() + "\n");
        sb.append("age: ");
        sb.append(getAge() + "\n");
        sb.append("partner: ");
        sb.append(getPartner() == null ? "no info\n" : getPartner().getName() + "\n");
        sb.append("mother: ");
        sb.append(getMother() == null ? "no info\n" : getMother().getName() + "\n");
        sb.append("father: ");
        sb.append(getFather() == null ? "no info\n" : getFather().getName() + "\n");
        sb.append("number of kids: ");
        sb.append(countOfChildren);
        sb.append(" ");
        //TODO need to add information: is the person alive?
        return sb.function toString() { [native code] }();
         }

    @Override
    public int compareTo(Human o) {
        int res = name.compareTo(o.name);
 if (res == 0) {
            return getAge() - o.getAge();
        } else return res;
    }
