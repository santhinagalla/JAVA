import java.util.*;

public class Person {
    int age;
    public String toString() {
        return ("age = " + age);
    }
    public boolean equals(Person k) {
        return (age == k.age);
    }
    public Person(int age1){
        age = age1;
    }

    // swap_list which swaps the elements of two objects of a List
    public static void swap_list(List<Person> vector){
        Collections.swap(vector, 0, 1);
    }

    //swap_set which swaps the elements of two objects of a Set
    public static void swap_set(Set<Person> set){
        // Works only with LinkedHashSet as it only maintains order of insertion
        Person[] arr = set.toArray(new Person[0]);
        set.clear();
        for(int i= arr.length-1;i>=0; i--){
            set.add(arr[i]);
        }
    }

    //swap_map which swaps the elements of two values of a Map
    public static void swap_Map(Object key1, Object key2, Map map)
    {
        Object temp = map.get(key1);
        map.put(key1, map.get(key2));
        map.put(key2, temp);
    }

    public static void list_Iterator(List<Person> vector){
        Iterator<Person> iter = vector.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
    }

    public static void set_Iterator(Set<Person> set){
        Iterator<Person> it = set.iterator();
        // Show HashSet elements
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static void map_Iterator(Map vector){
        Set set = vector.entrySet();
        Iterator i = set.iterator();
        // Display elements
        while(i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next();
            System.out.print(me.getKey()+ " ");
            System.out.println(me.getValue());
        }
    }


    public static void main(String[] argv) throws Exception
    {
        Person bruce = new Person(35);
        Person jackie = new Person(45);
        try {
            // creating object of List<String>
            List<Person> vector = new ArrayList<Person>();
            // populate the vector
            vector.add(bruce);
            vector.add(jackie);
            // Displaying the values after iterating through the list
            System.out.println("*** The iterator values Before swap of list are: *** ");
            list_Iterator(vector);
            // swap the elements
            swap_list(vector);
            // printing the vector after swap
            System.out.println("\n*** The iterator values After swap of list are: *** \n" + vector + "\n");

            // Works only with LinkedHashSet as it only maintains order of insertion
            Set<Person> hashset = new LinkedHashSet<>();
            hashset.add(bruce);
            hashset.add(jackie);
            // Displaying the values using Iterator
            System.out.println("*** The iterator values Before Swap of HashSet contains : *** ");
            set_Iterator(hashset);
            // swap the elements
            swap_set(hashset);
            System.out.println("*** The iterator values After Swap of HashSet contains : ***");
            // printing the hashset after swap
            set_Iterator(hashset);


            Map map = new HashMap();
            map.put("Bruce", bruce);
            map.put("Jackie",jackie);
            // Displaying the values using Iterator
            System.out.println("\n*** The iterator values Before Swap of Map contains : *** ");
            map_Iterator(map);
            // swap the values
            swap_Map("Bruce","Jackie",map);
            System.out.println("*** The iterator values After Swap of Map contains : ***");
            // printing the map after swap
            map_Iterator(map);

        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("\nException thrown : " + e);
        }
    }
}
