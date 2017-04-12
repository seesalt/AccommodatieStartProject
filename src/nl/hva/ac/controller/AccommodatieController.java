package nl.hva.ac.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import nl.hva.ac.data.DataProvider;
import nl.hva.ac.model.Accommodatie;
import nl.hva.ac.view.AccommodatiesPane;

import javax.xml.crypto.Data;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * De AccommodatieController.
 *
 * @author Folkert Boonstra <F.K.Boonstra@hva.nl>
 */
public class AccommodatieController {

    private final AccommodatiesPane accommodatiesPane;

    public AccommodatieController(Pane accommodatiesPane) {
        if (accommodatiesPane instanceof AccommodatiesPane) {
            this.accommodatiesPane = (AccommodatiesPane) accommodatiesPane;
        } else {
            this.accommodatiesPane = null;
        }

        init();

    }

    //Voeg hier de acties toe aan de buttons in accommodatiesPane.
    private void init() {
        DataProvider pew = new DataProvider();
        //TODO uncomment de code hieronder om je aangemaakte button te vinden
        Button btnSort = (Button) this.accommodatiesPane.lookup("#Sorteer");
        btnSort.setOnAction(event -> accommodatiesPane.setAccommodatieItems(getAccommodatieData().sorted()));


        //TODO uncomment de code hieronder om je aangemaakte button te vinden
        Button btnSave = (Button) this.accommodatiesPane.lookup("#Opslaan");
        String fileName = "accommodaties.dat";
        btnSave.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                try {
                    ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(fileName));
                    output.writeObject(pew.getDummyAccommodatieData());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

    }

   

    /**
     * Vraag de lijst met accommodaties op.
     * 
     * @return een observable lijst van accommodaties.
     */
    public ObservableList<Accommodatie> getAccommodatieData() {
        DataProvider dataProvider = new DataProvider();
        List accommList = dataProvider.getDummyAccommodatieData();
        ObservableList<Accommodatie> accommFXList = FXCollections.observableArrayList(accommList);
        return accommFXList;
    }

  
}
