import Model.Student;
import Model.Subjects;

import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
       Thread t =new Thread();
       LinkedHashMap<String,Double> hashMap=new LinkedHashMap<>(50);
       hashMap.put("sandeep", 25.0);
       hashMap.put("irjeeoee",(545.55));
       hashMap.put("joey",23.32);
       hashMap.put("schrader",211.32);
       Double ms=hashMap.get("schrader");
       hashMap.put("schrader",ms+100);

       TreeMap<String,Double> ts=new TreeMap<>(hashMap);


       Set<Map.Entry<String,Double>> set=ts.entrySet();
        Set<Map.Entry<String,Double>> get=hashMap.entrySet();
        for (Map.Entry<String,Double> me:set
             ) {
            System.out.print(me.getKey()+":");
            System.out.println(me.getValue());
             }
        System.out.println("********************");
        for (Map.Entry<String,Double> me:get
        ) {
            System.out.print(me.getKey()+":");
            System.out.println(me.getValue());
        }
       Double sandeep = hashMap.get("irjeeoee");

        System.out.println(hashMap.size());
        System.out.println(sandeep);
//
       LinkedList<String> arrayList=new LinkedList<>();
        var z=32.423;
        System.out.println(z);
       arrayList.add("onner");
       arrayList.add("erfff");
       arrayList.add("htgrt");
       arrayList.add("assd");
       arrayList.add("frwvvq");
       arrayList.add("onner");
        for (String x:arrayList
             ) {
            System.out.println(x);
        }
        TreeSet<String> ts1=new TreeSet<>(arrayList);
        LinkedHashSet<String> lhs=new LinkedHashSet<>(arrayList);
        lhs.add("owner");
        System.out.println("ArrayList:     "+arrayList);
        HashSet<String> hs=new HashSet<>(arrayList);
        ArrayDeque<String> ad=new ArrayDeque<>(arrayList);
        ad.offerFirst("bolla");
        ad.push("push");
        System.out.println("Hashset:       "+hs);
        System.out.println("Linked HashSet:"+lhs);
        System.out.println("TreeSet:       "+ts);
        System.out.println("ArrayDequeSet: "+ad);
        ListIterator<String> it= arrayList.listIterator();
        boolean b = it.hasNext();
        System.out.println(b);
        //it.set("hjtdh");
        System.out.println(it.next());
        System.out.println(ts1.subSet("erfff","htgrt"));
              System.out.println("***************************8");
        arrayList.remove(1);
        for (String y:arrayList
             ) {
            System.out.println(y);
        }
        System.out.println("*************");

arrayList.add(String.valueOf(2344));
        //System.out.println(arrayList.get(0));
//        arrayList.addFirst("refef");
        System.out.println("IA foreach******************");
        String ia[]=new String[arrayList.size()];
        ia=arrayList.toArray(ia);
        for (String e:ia
             ) {
            System.out.println(e);
        }

        System.out.println("*****************");

        for (String z1:arrayList
             ) {
            System.out.println(z1);
        }
        System.out.println(arrayList.getClass());
        System.out.println(arrayList.get(4));
        PriorityQueue<String> priorityQueue=new PriorityQueue<>();
        priorityQueue.addAll(arrayList);
        System.out.println();
        System.out.println("Displaying priorityQueue");
        for (String q:priorityQueue
             ) {
            System.out.println(q);
        }
        System.out.println("*************");

      //  System.out.println(priorityQueue.contains("onne"));
       // priorityQueue.remove("2344");
        System.out.println(priorityQueue.peek());
        System.out.println("**********");
        for (String q:priorityQueue
             ) {
            System.out.println(q);
        }

       Student student=new Student(3,"sandeep",23,new Subjects(23,54,67,56));
       Student student1=new Student(4,"walt",67,new Subjects(43,54,65,83));
       Student student2=new Student(5,"jesse pink-man",31,new Subjects(43,87,20,56));
       Student student3=new Student(0,"dude",14,new Subjects(59,0,65,22));


       ArrayList<Student> students = new ArrayList<>();
       students.add(student1);
       students.add(student);
       students.add(student2);
       students.add(student3);
       //System.out.println(student1.getName());

       Collection<Student> collection=new LinkedList<>();
        boolean b1 = collection.addAll(students);
        System.out.println(b1);
        System.out.println();

        for (Student x:students
             ) {
            //Thread.sleep(400);
            System.out.println(x.toString());
            System.out.println();
            System.out.println("Details of the student" +"\n"+
                            "Name: "+x.getName()+"\n"
                    +"Age: "+x.getAge()+"\n"
                    +"Roll no: "+x.getRoll()+"\n"
                    +"Marks in subjects: \n"
                    +"     "+"english:  "+x.getSubjects().getEnglish()+"\n"
                    +"     "+"Maths:  "+x.getSubjects().getMaths()+"\n"
                    +"     "+"Science:  "+x.getSubjects().getScience()+"\n"
                    +"     "+"Computer Science:  "+x.getSubjects().getComputers()+"\n"
//                    +"     "+"internals:  "
//                    +"                 \n"
//                    +"                 Maths: "+x.getSubjects().getInterns().getMth()+"\n"
//                    +"                 Science:"+x.getSubjects().getInterns().getSci()+"\n"
                    +"****************************"

            );
        }
    }
}