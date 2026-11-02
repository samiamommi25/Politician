package cse213.questionsolvingmidterm;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class politicianController
{
    @javafx.fxml.FXML
    private DatePicker dateOfjoinningD;
    @javafx.fxml.FXML
    private CheckBox hasownanyelectionCHK;
    @javafx.fxml.FXML
    private TextField annualMembershipTF;
    @javafx.fxml.FXML
    private TextField partyNameTF;
    @javafx.fxml.FXML
    private TableView<Politician> tableview;
    @javafx.fxml.FXML
    private ComboBox<String> memberTypeFilterCB;
    @javafx.fxml.FXML
    private TextField memberIdTF;
    @javafx.fxml.FXML
    private CheckBox isGovtPositionCHK;
    @javafx.fxml.FXML
    private CheckBox hasownanyelectionFilterCHK;
    ArrayList<Politician> politicianList = new ArrayList<>();
    @javafx.fxml.FXML
    private ComboBox<String> memberTypeCB;
    @javafx.fxml.FXML
    private TableColumn<Politician,String>memberTypeTC;
    @javafx.fxml.FXML
    private TableColumn<Politician,Boolean> isgovernmentTC;
    @javafx.fxml.FXML
    private TableColumn<Politician,Integer> memberIdTC;
    @javafx.fxml.FXML
    private TableColumn<Politician, LocalDate> dateOFjoiningTC;
    @javafx.fxml.FXML
    private TableColumn<Politician,Boolean> hasownTC;

    @javafx.fxml.FXML
    public void initialize() {
        memberTypeCB.getItems().setAll("president","gensecretary","treasure","genmember");
        memberTypeFilterCB.getItems().setAll("president","gensecretary","treasure","genmember");

        memberIdTC.setCellValueFactory(new PropertyValueFactory<Politician,Integer>("memberId"));
        memberTypeTC.setCellValueFactory(new PropertyValueFactory<Politician,String>("memberType"));
        isgovernmentTC.setCellValueFactory(new PropertyValueFactory<Politician,Boolean>("isGovtPosition"));
        hasownTC.setCellValueFactory(new PropertyValueFactory<Politician,Boolean>("hasOwnElection"));
        dateOFjoiningTC.setCellValueFactory(new PropertyValueFactory<Politician,LocalDate>("dateOfJoining"));


        


    }



    @javafx.fxml.FXML
    public void validateBUTTON(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        String memberType = memberTypeCB.getValue();

        float annualMembership = Float.parseFloat(annualMembershipTF.getText());
        boolean isGovtPosition = isGovtPositionCHK.isSelected();
        int memberID = Integer.parseInt(memberIdTF.getText());
        String partyName = partyNameTF.getText();
        boolean hasOwnElection = hasownanyelectionCHK.isSelected();
        LocalDate dateOFjoining = dateOfjoinningD.getValue() ;




        if (memberType.equals("genmember")){
            if (annualMembership<500 || annualMembership > 5000){
                alert.setContentText("you  must need to give value higher than 500 and Lower than 5000");
                alert.showAndWait();
                return;
            }
        }
        if(!memberType.equals("genmember")){
            if(annualMembership<10000){
                alert.setContentText("For non general member anual fee must need to higher than 10000 tk");
                alert.showAndWait();
                return;
            }
        }
        if(isGovtPosition && memberType.equals("genmember")){
            alert.setContentText("Can't be higher than genmember.");
            alert.showAndWait();
            return;

        }

        Politician p = new Politician(memberID,memberType,partyName,isGovtPosition,hasOwnElection,annualMembership,dateOFjoining);
        politicianList.add(p);

    }

    @javafx.fxml.FXML
    public void averageButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void FilterButton(ActionEvent actionEvent) {
        String memberTypeFilter = memberTypeFilterCB.getValue();
        boolean hasOwnElection = hasownanyelectionFilterCHK.isSelected();
        for (Politician p  : politicianList){
            if(p.getMemberType().equals(" memberTypeFilter") && p.isHasOwnElection()== hasOwnElection ){
                tableview.getItems().add(p);

            }

        }
    }

}