package family_tree.tree;

import family_tree.person.Human;

import java.util.ArrayList;
import java.util.Iterator;

public class HumanIterator implements Iterator<Human> {
    private ArrayList<Human> humanList;
    private int index;

    public HumanIterator(FamilyTree tree) {
        this.humanList = tree.convertToList();
    }

    @Override
    public boolean hasNext() {
        return index < humanList.size();
    }

    @Override
    public Human next() {
        return humanList.get(index++);
    }
}
