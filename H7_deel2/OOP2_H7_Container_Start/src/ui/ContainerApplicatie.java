package ui;

import domein.Container;

import java.util.Arrays;
import java.util.Comparator;

public class ContainerApplicatie {

    public static void main(String[] args) {
        Container[] containers = new Container[4];
        
        containers[0] = new Container("Antwerpen", 60, 150, 1234);
        containers[1] = new Container("Rotterdam", 70, 110, 2568);
        containers[2] = new Container("Calais", 80, 90, 8569);
        containers[3] = new Container("Brugge", 70, 100, 8564);
         
        // Stap 1
        Arrays.sort(containers);
        System.out.println("Containers bij natuurlijk sorteren.");
        System.out.println(Arrays.toString(containers));
        
        // Stap 2
        Arrays.sort(containers, new Comparator<Container>() {

            @Override
            public int compare(Container o1, Container o2) {
                int res = o1.getMassa()-o2.getMassa();
                if (res == 0)
                    return o1.getVolume()-o2.getVolume();
                return res;
            }
        });
        System.out.println("Containers bij sorteren op massa.");
        System.out.println(Arrays.toString(containers));


        // Stap 3
        Arrays.sort(containers, new Comparator<Container>() {

            @Override
            public int compare(Container o1, Container o2) {
                int res = o1.getEigenaar().compareToIgnoreCase(o2.getEigenaar());
                if (res == 0)
                    return o1.getVolume()-o2.getVolume();
                return res;
            }
        });
        System.out.println("Containers bij sorteren op eigenaar.");
        System.out.println(Arrays.toString(containers));


        // Stap 4
        Container nieuweContainer = new Container("Antwerpen", 70, 75, 8564);
        // TODO: 22/04/2020
        System.out.println(Arrays.toString(containers));

    }
}