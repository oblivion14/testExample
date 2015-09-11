package test;

/**
 * Created by Melvin on 15. 8. 17..
 */
public class Person {
    /**
     * name
     */
    private String name;

    /**
     * goal result
     */

    private String goals;


    private boolean isSelected;

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getGoals() { return goals; }

    public void setGoals(String goals) { this.goals = goals; }


    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
}
