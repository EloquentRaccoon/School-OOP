package com.JeffDev.P3a;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class P3aTest {

    @Test
    void voetbalclubAanmaken(){
        Voetbalclub club1 = new Voetbalclub("");
        if(club1.getNaam().isEmpty()){
            assertEquals(club1.getNaam(), "FC");
        }
    }

    @Test
    void testVerwerkResultaat() throws Exception {
        Voetbalclub club2 = new Voetbalclub("Ajax");
        club2.verwerkResultaat('w'); //3 punten
        club2.verwerkResultaat('g'); //1 punt
        club2.verwerkResultaat('v'); //0 punten
    }

    @Test
    void testAantalPunten() throws Exception {
        Voetbalclub club3 = new Voetbalclub("Ajax");
        club3.verwerkResultaat('w'); //3 punten
        club3.verwerkResultaat('g'); //1 punt
        club3.verwerkResultaat('v'); //0 punten
        assertEquals(4, club3.getAantalPunten());

    }

    @Test
    void testAantalGespeeld() throws Exception {
        Voetbalclub club4 = new Voetbalclub("PSV");
        club4.verwerkResultaat('g'); //1
        club4.verwerkResultaat('g'); //2
        club4.verwerkResultaat('w'); //3
        club4.verwerkResultaat('w'); //4
        club4.verwerkResultaat('v'); //5
        club4.verwerkResultaat('v'); //6
        club4.verwerkResultaat('g'); //7
        assertEquals(7,club4.aantalGespeeld());
    }
}