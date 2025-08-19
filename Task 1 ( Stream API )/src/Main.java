package Main;
import javax.swing.text.html.Option;
import java.util.*;
import java.util.Date ;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Ali", "IT", 85),
                new Student("Mona", "CS", 92),
                new Student("Ahmed", "IT", 60),
                new Student("Sara", "CS", 70),
                new Student("Omar", "IS", 45),
                new Student("Laila", "IS", 78));

        List<Employee> employees = Arrays.asList(
                new Employee("Ali", 30, "HR", 5000),
                new Employee("Mona", 25, "IT", 7000),
                new Employee("Ahmed", 30, "HR", 5500),
                new Employee("Sara", 27, "IT", 7200),
                new Employee("Omar", 40, "Finance", 8000),
                new Employee("Laila", 35, "Finance", 8200)
        );


        List<List<String>> nestedWords = Arrays.asList(
                Arrays.asList("Java", "Stream"),
                Arrays.asList("API", "Lambda"),
                Arrays.asList("FlatMap", "Map")
        );

        // A required list made by me
        List<Integer> list0 = Arrays.asList(12,-4 ,5 ,-67 , 19 , 0);

        //====================================================================


        // 🔹Basic Stream Operations
        System.out.println("Basic Stream Operations ");
        //Q1 =>        Filter even numbers from a list of integers.

        // First I will make a list of double data type and assign the grades of
        // the students into that list and since map returns any data type I need I
        // made type casting to make the list of type integer not double
        List<Integer> list1 = students.stream().map(st ->(int)st.getGrade()).toList();
        list1.stream().filter( x-> x % 2 == 0).forEach(System.out::println);


        System.out.println("=================== Q2 =======================");

        //Q2 =>      Find names starting with a specific letter from a list of strings.
         List<Employee> list2 = employees.stream().filter(s -> s.getName().startsWith("A")).collect(Collectors.toList());
         list2.forEach( e -> System.out.println(e.getName()));

         System.out.println("================== Q3 =========================");

        //Q3 =>        Convert all strings to uppercase using stream.
        List<String> list3 = students.stream().map( s -> s.getName().toUpperCase()).toList();
        list3.forEach(System.out::println);

        System.out.println("================= Q4 ==========================");

       //Q4 =>         Sort a list of integers in descending order using streams.
        // First I get the ages of the employees and put them in a list

        List<Integer> list4 = employees.stream().map(s-> s.getAge()).toList();
        list4.stream().sorted(Comparator.reverseOrder()).forEach(s-> System.out.println(s));



        System.out.println("=================== Q5 ========================");

       //Q5 =>         Remove duplicate elements from a list using distinct().
       // I will make it in 2 ways :
        List<String> list5 = students.stream().map(s-> s.getDepartment()).toList();
        list5.stream().distinct().sorted().forEach(s-> System.out.println(s));

        // or
        System.out.println("===========================================");
        list5.stream().collect(Collectors.toSet()).forEach(s-> System.out.println(s));


        // 🔹 Numeric Streams & Reductions
        System.out.println("Numeric Streams & Reductions\n\n");

        //Q6 =>        Calculate the sum of a list of integers using reduce.
        // let us consider the list of employees' salaries from the employees list
        System.out.println("================== Q6 =================");

        List<Double> list6 = employees.stream().map(s-> s.getSalary()).toList();
        Double sumSalary = list6.stream().reduce(0.0 ,(x , y) -> x+=y);
        System.out.println(sumSalary);


        System.out.println("================= Q7 ===================");

        //Find the maximum and minimum value in a list.
        // I make it 2 times one using reduce and one using the built in max & min functions
        // let us work on list6 salaries of employees
        Optional<Double> max1 = list6.stream().reduce((a , b) -> a > b ? a : b);
        System.out.println(max1.get());

        Optional<Double> min1 = list6.stream().reduce((a , b) -> a > b ? b : a);
        System.out.println(min1.get());

        System.out.println("Second Method :");
        System.out.println(list6.stream().max( Double::compare).get());
        System.out.println(list6.stream().min(Double::compare).get());



        //Calculate the average of a list of doubles.
        System.out.println("================= Q8 ===================");

        Optional<Double> sumAvg = list6.stream().reduce(Double::sum);
        System.out.printf("%.2f" , sumAvg.get()/list6.size());

        //Multiply all integers in a list together using reduce.
        // lets work on list1 (grades)
        System.out.println("\n================= Q9 ===================");

        // let us divide each number by 10 so that the number not to be too big
        List<Double> l = list1.stream().map(e->e/10.0).collect(Collectors.toList());
        Optional<Double> product = l.stream().reduce((x , y)-> x*y);
        System.out.printf("%.2f" , product.get());

        //Count how many numbers are positive in a list.
        System.out.println("\n================= Q10 ==================");
        System.out.println(list0.stream().filter(s-> (s > 0)).count());


        //        🔹 Intermediate Stream Tasks

        //Count the number of strings longer than 5 characters.
        // let us work on list3 but with 4 characters not 5
        System.out.println("================= Q11 ==================");
        System.out.println(list3.stream().filter(s -> s.length()>3).count());
        list3.stream().filter(s -> s.length()>4).forEach(System.out::println);


        //Find the first element in a stream that matches a given condition.
        // I will make the condition be to be of IS department
        System.out.println("================= Q12 ==================");
         List<Student> list7 = students.stream().dropWhile(e-> e.getDepartment()!="IS").toList();
         list7.stream().limit(1).forEach(System.out::println);

         // or maybe findfirst ====> GPT helped me in that but the above method is on my own
        // way of thinking
        Optional<Student> firstISStudent = students.stream()
                .filter(s -> s.getDepartment().equals("IS"))
                .findFirst();

        firstISStudent.ifPresent(System.out::println);



        //Check if any number is divisible by 5 in a list.
        System.out.println("================= Q13 ==================");
        Boolean d = list1.stream().anyMatch(e-> e%5==0);
        System.out.println(d);


        //Collect elements into a Set instead of a List.
        // Have been done in line 84


        //Skip the first 3 elements and return the rest.
        System.out.println("================= Q14 ==================");
        students.stream().skip(3).forEach(System.out::println);


        //🔹 Collectors & Grouping
        //Group a list of students by their department.
        System.out.println("================= Q15 ==================");

        Map<String, List<Student>> studentsByDept = students.stream()
                .collect(Collectors.groupingBy(Student::getDepartment));

        studentsByDept.forEach((dept, list) -> {
            System.out.println("Department: " + dept);
            list.forEach(System.out::println);
        });


        System.out.println("================= Q16 ==================");


        //Partition a list of numbers into even and odd using partitioningBy.
        Map  <Boolean,List<Integer>> ms = list4.stream().collect(Collectors.partitioningBy(x-> x%2==0));
        ms.forEach((x,y)->{
            System.out.println(x + " : ") ;
            System.out.println(y.stream().map(e->e.toString()).collect(Collectors.joining(" - ")));
        });


        //Create a comma-separated string from a list of strings.
        // made in line 196

        //Group employees by age and count how many per age.
        System.out.println("================= Q17 ==================");
        Map <Integer,Long> ms2 = employees.stream().collect(Collectors.groupingBy(Employee::getAge,Collectors.counting()));
        System.out.println(ms2);

        //Find the average salary per department in a list of employees
        System.out.println("================= Q18 ==================");
        Map<String , Double> ms3 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));

        ms3.forEach((x,y)-> {
            System.out.println(x + " : ");
            System.out.println(y);

        });



        // 🔹 Optional, Map, FlatMap
        System.out.println("================= Q19 ==================");
        //Flatten a list of lists into a single list.
        List <String>list9 = nestedWords.stream().flatMap(ls11->ls11.stream()).collect(Collectors.toList());
        System.out.println(list9);
        //Extract all unique characters from a list of words.
        System.out.println("================= Q20 ==================");
        LinkedHashSet<Character> cs = list5.stream()
                .flatMap(str -> str.chars().mapToObj(c -> (char) c))
                .collect(Collectors.toCollection(LinkedHashSet::new));
        cs.forEach(System.out::println);

        //Filter a list of Optionals and collect non-empty values.
        System.out.println("================= Q21 ==================");
        List<Optional<String>> optionals = Arrays.asList(
                Optional.of("apple"),
                Optional.empty(),
                Optional.of("banana"),
                Optional.empty(),
                Optional.of("kiwi")
        );


        List<String> result = optionals.stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        System.out.println(result);

        //Map a list of strings to their lengths.
        System.out.println("================= Q22 ==================");
        Map<String, Integer> mp = list3.stream()
                .collect(Collectors.toMap(str -> str, String::length));
        System.out.println(mp);

        //Return a list of uppercased words that start with “A”.
        System.out.println("================= Q23 ==================");
        List<String> re = list3.stream()
                .filter(w -> w.startsWith("A"))   // keep only words starting with "A"
                .map(String::toUpperCase)         // convert to uppercase
                .collect(Collectors.toList());    // collect into a list

        System.out.println(re);


        //🔹 Advanced Operations
        System.out.println("================= Q24 ==================");
        //Sort a list of employees by salary then by name.
        List<Employee> sorted = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary)
                        .thenComparing(Employee::getName))
                .collect(Collectors.toList());

        sorted.forEach(System.out::println);

        //Find the second highest number in a list.
        System.out.println("================= Q25 ==================");
        List<Integer> aq = list1.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(aq.get(1));

        //Find duplicate elements in a list of integers.
        System.out.println("================= Q26 ==================");
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = list4.stream()
                .filter(n -> !seen.add(n)) // add() returns false if already exists
                .collect(Collectors.toSet());

        System.out.println("Duplicates: " + duplicates);


        //Remove null or empty strings from a list using stream.
        System.out.println("================= Q27 ==================");
        List<String> cleaned = list3.stream()
                .filter(Objects::nonNull).filter(s -> !s.trim().isEmpty())
                .collect(Collectors.toList());

        System.out.println(cleaned);


        //Partition students into pass/fail groups based on grade.
        System.out.println("================= Q28 ==================");
        Map<Boolean, List<Student>> partitioned = students.stream()
                .collect(Collectors.partitioningBy(s -> s.getGrade() >= 50));
        System.out.println(partitioned.get(true));
        System.out.println(partitioned.get(false));


    }
}