package com.project.thurnandtaxis;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Unit test for simple App.
 */
@RunWith(MockitoJUnitRunner.class)
public class MainTest {
    
    @InjectMocks
    private Main main;

    @Test
    public void testAjouterDeux() {

        // Act
        int retour = this.main.ajouterDeux(1);
        
        // Assert
        assertEquals(3, retour);

    }
    
}
