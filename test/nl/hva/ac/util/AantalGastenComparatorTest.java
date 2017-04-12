package nl.hva.ac.util;

import nl.hva.ac.model.Accommodatie;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by ralph on 12/04/2017.
 */
class AantalGastenComparatorTest {
    @Test
    public void test1() {
        AantalGastenComparator comperator =  new AantalGastenComparator();
        Accommodatie h1 =  new Accommodatie("Amstelhotel", 100, 10,2);
        Accommodatie h2 =  new Accommodatie("Amstelhotel", 100, 5,2);
        assertEquals("H1 heeft meer gasten", comperator.compare(h1, h2), 1);
    }

    @Test
    public void test2() {
        AantalGastenComparator comperator =  new AantalGastenComparator();
        Accommodatie h1 =  new Accommodatie("Amstelhotel", 100, 5,2);
        Accommodatie h2 =  new Accommodatie("Amstelhotel", 100, 10,2);
        assertEquals("H1 heeft meer gasten", comperator.compare(h1, h2), -1);
    }

    @Test
    public void test3() {
        AantalGastenComparator comperator =  new AantalGastenComparator();
        Accommodatie h1 =  new Accommodatie("Amstelhotel", 100, 10,2);
        Accommodatie h2 =  new Accommodatie("Amstelhotel", 100, 10,2);
        assertEquals("H1 heeft meer gasten", comperator.compare(h1, h2), 0);
    }


}